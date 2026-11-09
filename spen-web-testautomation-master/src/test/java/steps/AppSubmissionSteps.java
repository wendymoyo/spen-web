/**
 * Author: Wendy Moyo
 */

package steps;

import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AppSubmissionPage;
import tests.OracleDbConnectionTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static org.junit.Assert.*;

public class AppSubmissionSteps {

    AppSubmissionPage appSubmissionPage;

    private static final Logger log = LoggerFactory.getLogger(AppSubmissionSteps.class);
    private String sql;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    @Step
    public void getApplicationId() {
        String url = Serenity.getDriver().getCurrentUrl();
        String appId = url.split("applicationId=")[1];
        Serenity.setSessionVariable("appId").to(appId);
    }

    @Step
    @And("I am taken to the {string} Formal quote app submission page")
    public void iAmTakenToTheFormalQuoteAppSubmissionPage(String appName) {
        getApplicationId();
        assertTrue("Application name '"+ appName+ "' is not displayed!", appSubmissionPage.getPageHeaderText().contains(appName));
        assertTrue("Success alert is not displayed!", appSubmissionPage.isSuccessAlertDisplayed());
        assertTrue("'What happens next info' is not displayed!", appSubmissionPage.isWhatHappensNextInfoDisplayed());
        assertTrue("Online Payment header is not displayed!", appSubmissionPage.isOnlinePaymentHeaderDisplayed());
        assertTrue("'Did you know info' is not displayed!", appSubmissionPage.isDidYouKnowInfoDisplayed());
        assertTrue("Done button is not displayed!", appSubmissionPage.isDoneButtonDisplayed());
    }

    @Step
    @And("I am taken to the {string} Informal quote app submission page")
    public void iAmTakenToTheInformalQuoteAppSubmissionPage(String appName) {
        getApplicationId();
        assertTrue("Application name '"+ appName + "' is not displayed!", appSubmissionPage.getPageHeaderText().contains(appName));
        assertTrue("Success alert is not displayed!", appSubmissionPage.isSuccessAlertDisplayed());
        assertTrue("'What happens next info' is not displayed!", appSubmissionPage.isWhatHappensNextInfoDisplayed());
        assertTrue("'Did you know info' is not displayed!", appSubmissionPage.isDidYouKnowInfoDisplayed());
        assertTrue("Done button is not displayed!", appSubmissionPage.isDoneButtonDisplayed());
    }

    @Step
    public void goToSpenHomepage() {
        appSubmissionPage.clickDoneButton();
        String expectedUrl = "https://www.spenergynetworks.co.uk/";
        String actualUrl = appSubmissionPage.getDriver().getCurrentUrl();
        assertEquals("Wrong page displayed! Expected: " +expectedUrl+ ", Actual: " +actualUrl,
                expectedUrl, actualUrl);
    }

    @And("My application is submitted successfully in the database")
    public void myApplicationIsSubmittedSuccessfullyInTheDatabase() throws IOException, ClassNotFoundException, SQLException {
        String appId = Serenity.sessionVariableCalled("appId");

        //Connect to DB
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        FileInputStream fileInput = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInput);
        Class.forName("oracle.jdbc.OracleDriver");

        try {
            con = DriverManager.getConnection(prop.getProperty("DB_Url"), prop.getProperty("DB_User"), prop.getProperty("DB_Pwd"));
            if (con != null) {
                stmt = con.createStatement();
                System.out.println("Connected to the Database");

                // Run sql query to get app by application ID
                get_application_by_app_id(appId);

                // Run sql query to check app submission status
                get_application_submission_status();
            } else {
                System.out.println("Database connection failed! ");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: " + e.getSQLState(), e.getMessage());
        } catch (Exception ex) {
            log.error("Error: ", ex);
        } finally {
            // assert connection is not null before closing
            assert con != null;
            con.close();
        }
        goToSpenHomepage();
    }

    @Step
    public void get_application_by_app_id(String appId) throws SQLException {
        String appName = Serenity.sessionVariableCalled("appName");

        sql = String.format("SELECT a.id, a.REF AS APP_ID, u.username, cat.application_type, cas.application_state, a.application_data, TO_CHAR(a.submitted_on, 'dd-mm-yyyy hh24:mi:ss') submitted_on, TO_CHAR(a.created_on, 'dd-mm-yyyy hh24:mi:ss') created_on, TO_CHAR(a.last_updated, 'dd-mm-yyyy hh24:mi:ss') last_updated FROM t_connections_application a INNER JOIN t_users u ON a.userid = u.id INNER JOIN t_connections_application_type cat ON a.application_type = cat.id INNER JOIN t_connections_application_state cas ON a.application_state = cas.id WHERE a.REF = '%s'", appId);

        System.out.println("SQL Query to execute: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            assertEquals("Incorrect Application ID! Expected: "+ appId,
                    appId, rs.getString("APP_ID"));
            assertEquals("Incorrect Application State! Expected: SUBMITTED",
                    "SUBMITTED", rs.getString("APPLICATION_STATE"));

            switch(appName) {
                case "Additional Load":
                    assertEquals("Incorrect Application Name! Expected: Al",
                            "Al", rs.getString("APPLICATION_TYPE"));
                    break;
                case "New Connection":
                    assertEquals("Incorrect Application Name! Expected: NewSupply",
                            "NewSupply", rs.getString("APPLICATION_TYPE"));
                    break;
                case "Diversion":
                    assertEquals("Incorrect Application Name! Expected: DIVERSION",
                            "DIVERSION", rs.getString("APPLICATION_TYPE"));
                    break;
                case "Disconnection":
                    assertEquals("Incorrect Application Name! Expected: DISCONNECTION",
                            "DISCONNECTION", rs.getString("APPLICATION_TYPE"));
                    break;
                case "Move Meter":
                    assertEquals("Incorrect Application Name! Expected: APOS",
                            "APOS", rs.getString("APPLICATION_TYPE"));
                    break;
                case "Unmetered Connection":
                    assertEquals("Incorrect Application Name! Expected: UNMETEREDCONNECTION",
                            "UNMETEREDCONNECTION", rs.getString("APPLICATION_TYPE"));
                    break;
                default:
                    System.out.println("Unknown Application Name: " + appName);
                    break;
            }
            
            // Display values
            System.out.println("Application ID: " + rs.getString("APP_ID"));
            System.out.println("Application Name: " + rs.getString("APPLICATION_TYPE"));
            System.out.println("Application State: " + rs.getString("APPLICATION_STATE"));
            System.out.println("Last Updated: " + rs.getString("last_updated"));

            // get the ID
            Serenity.setSessionVariable("id").to(rs.getInt("id"));
        }
    }

    @Step
    public void get_application_submission_status() throws SQLException {
        int id = Serenity.sessionVariableCalled("id");
        sql = String.format("SELECT s.application_id, ss.status, s.detail, TO_CHAR(s.submitted_on, 'dd-mm-yyyy hh24:mi:ss') submitted_on FROM t_connections_application_submission s INNER JOIN t_connections_application_submission_status ss ON s.status = ss.id WHERE s.application_id = %d ORDER BY s.submitted_on", id);

        System.out.println("SQL Query to execute: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            assertEquals("Incorrect Application ID! Expected: " +id,
                    id, rs.getInt("APPLICATION_ID"));
            assertEquals("Incorrect Application State! Expected: SUCCESS",
                    "SUCCESS", rs.getString("DETAIL"));

            // Display values
            System.out.println("ID: " + rs.getInt("APPLICATION_ID"));
            System.out.println("Status: " + rs.getString("STATUS"));
            System.out.println("Detail: " + rs.getString("DETAIL"));
            System.out.println("Submitted on: " + rs.getString("SUBMITTED_ON"));
        }
    }
}
