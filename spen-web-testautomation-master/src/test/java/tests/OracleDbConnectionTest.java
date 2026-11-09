/**
 * Author: Wendy Moyo
 */

package tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.AppSubmissionSteps;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import static org.junit.Assert.*;

@RunWith(SerenityRunner.class)
public class OracleDbConnectionTest {

    // This test checks the application status in the database using application ID

    @Managed()
    WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(OracleDbConnectionTest.class);
    private String sql;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    @Before
    public void initialTestSetup() throws IOException, ClassNotFoundException {
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
            } else {
                System.out.println("Database connection failed! ");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: " + e.getSQLState(), e.getMessage());
        } catch (Exception ex) {
            log.error("Error: ", ex);
        }
    }

    @Test
    public void get_application_by_application_id() throws SQLException {
        String appId = "3ee4c935-0013-486d-9065-92f4118c896c";
        sql = String.format("SELECT a.id, a.REF AS APP_ID, u.username, cat.application_type, cas.application_state, a.application_data, TO_CHAR(a.submitted_on, 'dd-mm-yyyy hh24:mi:ss') submitted_on, TO_CHAR(a.created_on, 'dd-mm-yyyy hh24:mi:ss') created_on, TO_CHAR(a.last_updated, 'dd-mm-yyyy hh24:mi:ss') last_updated FROM t_connections_application a INNER JOIN t_users u ON a.userid = u.id INNER JOIN t_connections_application_type cat ON a.application_type = cat.id INNER JOIN t_connections_application_state cas ON a.application_state = cas.id WHERE a.REF = '%s'", appId);

        System.out.println("SQL Query to execute: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            assertEquals("Incorrect Application ID! Expected: "+ appId,
                    appId, rs.getString("APP_ID"));
//            assertEquals("Incorrect Application Name! Expected: "+ appName,
//                    appName, rs.getString("APPLICATION_TYPE"));
            assertEquals("Incorrect Application State! Expected: SUBMITTED",
                    "SUBMITTED", rs.getString("APPLICATION_STATE"));
            assertEquals("Incorrect Application Name! Expected: DIVERSION",
                    "DIVERSION", rs.getString("APPLICATION_TYPE"));

            // Display values
            System.out.println("Application ID: " + rs.getString("APP_ID"));
            System.out.println("Application Name: " + rs.getString("APPLICATION_TYPE"));
            System.out.println("Application State: " + rs.getString("APPLICATION_STATE"));
        }
    }

    @Test
    public void get_application_submission_status() throws SQLException {
        int id = 33326;
        sql = String.format("SELECT s.application_id, ss.status, s.detail, TO_CHAR(s.submitted_on, 'dd-mm-yyyy hh24:mi:ss') submitted_on FROM t_connections_application_submission s INNER JOIN t_connections_application_submission_status ss ON s.status = ss.id WHERE s.application_id = %dORDER BY s.submitted_on", id);

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
        }
    }

    @After
    public void closeConnection() throws SQLException {
        // assert connection is not null before closing
        assert con != null;
        con.close();
    }


}
