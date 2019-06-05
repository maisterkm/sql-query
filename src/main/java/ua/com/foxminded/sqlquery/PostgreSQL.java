package ua.com.foxminded.sqlquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQL {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/university";
    private static final String USER = "username";
    private static final String PASS = "password";

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_URL,USER, PASS);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public static void createTables() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createCoursesTable = "CREATE TABLE COURSES (\n" +
                "  course_id SERIAL PRIMARY KEY,\n" +
                "  name VARCHAR(255) UNIQUE NOT NULL,\n" +
                "  description VARCHAR(255)\n" +
                ");";

        String createGroupsTable = "CREATE TABLE GROUPS (\n" +
                "  group_id SERIAL PRIMARY KEY,\n" +
                "  name VARCHAR(255) UNIQUE NOT NULL\n" +
                ");";

        String createStudentsTable = "CREATE TABLE STUDENTS (\n" +
                "  student_id SERIAL PRIMARY KEY,\n" +
                "  group_id INTEGER REFERENCES GROUPS (group_id),\n" +
                "  first_name VARCHAR(255) NOT NULL,\n" +
                "  last_name VARCHAR(255) NOT NULL\n" +
                ");";

        String createAttendanceOfCoursesTable = "CREATE TABLE ATTENDANCEOFCOURSES (\n" +
                "  student_id INTEGER NOT NULL,\n" +
                "  course_id INTEGER NOT NULL,\n" +
                "  PRIMARY KEY (student_id, course_id),\n" +
                "  FOREIGN KEY (student_id) REFERENCES STUDENTS (student_id),\n" +
                "  FOREIGN KEY (course_id) REFERENCES COURSES (course_id)\n" +
                ");";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // Execute SQL query
            statement.execute(createCoursesTable);
            statement.execute(createGroupsTable);
            statement.execute(createStudentsTable);
            statement.execute(createAttendanceOfCoursesTable);
            System.out.println("Tables \"COURSES\", \"GROUPS\", \"STUDENTS\", \"ATTENDANCEOFCOURSES\" are created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }


}
