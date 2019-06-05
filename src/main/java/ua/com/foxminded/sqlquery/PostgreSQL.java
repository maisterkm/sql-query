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

            dbConnection.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertIntoCoursesTable() {

        Connection dbConnection = null;
        Statement statement = null;

        String insertIntoCoursesTable = "INSERT INTO COURSES (name, description)\n" +
                "VALUES\n" +
                "  ('Discrete Math', 'Prof. Cristian, 80 hours'),\n" +
                "  ('Mathematical analysis', 'Prof. Markus, 120 hours'),\n" +
                "  ('Statistic', 'Prof. Rey, 70 hours');";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(insertIntoCoursesTable);
            System.out.println("Datas has been inserted into table COURSES");

            dbConnection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoGroupsTable() {

        Connection dbConnection = null;
        Statement statement = null;

        String insertIntoGroupsTable = "INSERT INTO GROUPS (name)\n" +
                "VALUES\n" +
                "  ('SR-01'),\n" +
                "  ('SR-02'),\n" +
                "  ('SR-03');";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(insertIntoGroupsTable);
            System.out.println("Datas has been inserted into table GROUPS");

            dbConnection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoStudentsTable() {

        Connection dbConnection = null;
        Statement statement = null;

        String insertIntoStudentsTable = "INSERT INTO STUDENTS (group_id, first_name, last_name)\n" +
                "VALUES\n" +
                "  (1, 'first_name_1', 'last_name_1'),\n" +
                "  (1, 'first_name_2', 'last_name_2'),\n" +
                "  (1, 'first_name_3', 'last_name_3'),\n" +
                "  (1, 'first_name_4', 'last_name_4'),\n" +
                "  (1, 'first_name_5', 'last_name_5'),\n" +
                "  (1, 'first_name_6', 'last_name_6'),\n" +
                "  (1, 'first_name_7', 'last_name_7'),\n" +
                "  (1, 'first_name_8', 'last_name_8'),\n" +
                "  (1, 'first_name_9', 'last_name_9'),\n" +
                "  (1, 'first_name_10', 'last_name_10'),\n" +
                "  (1, 'first_name_11', 'last_name_11'),\n" +
                "  (1, 'first_name_12', 'last_name_12'),\n" +
                "  (2, 'first_name_13', 'last_name_13'),\n" +
                "  (2, 'first_name_14', 'last_name_14'),\n" +
                "  (2, 'first_name_15', 'last_name_15'),\n" +
                "  (2, 'first_name_16', 'last_name_16'),\n" +
                "  (2, 'first_name_17', 'last_name_17'),\n" +
                "  (2, 'first_name_18', 'last_name_18'),\n" +
                "  (2, 'first_name_19', 'last_name_19'),\n" +
                "  (3, 'first_name_20', 'last_name_20'),\n" +
                "  (3, 'first_name_21', 'last_name_21'),\n" +
                "  (3, 'first_name_22', 'last_name_22'),\n" +
                "  (3, 'first_name_23', 'last_name_23'),\n" +
                "  (3, 'first_name_24', 'last_name_24'),\n" +
                "  (3, 'first_name_25', 'last_name_25'),\n" +
                "  (3, 'first_name_26', 'last_name_26'),\n" +
                "  (3, 'first_name_27', 'last_name_27'),\n" +
                "  (3, 'first_name_28', 'last_name_28'),\n" +
                "  (3, 'first_name_29', 'last_name_29');";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(insertIntoStudentsTable);
            System.out.println("Datas has been inserted into table STUDENTS");

            dbConnection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoAttandanceOfCoursesTable() {

        Connection dbConnection = null;
        Statement statement = null;

        String insertIntoAttandanceOfCoursesTable = "INSERT INTO ATTENDANCEOFCOURSES (student_id, course_id)\n" +
                "VALUES\n" +
                "  (1, 1),\n" +
                "  (2, 1),\n" +
                "  (3, 1),\n" +
                "  (4, 1),\n" +
                "  (5, 1),\n" +
                "  (6, 1),\n" +
                "  (7, 1),\n" +
                "  (8, 1),\n" +
                "  (9, 1),\n" +
                "  (10, 1),\n" +
                "  (11, 1),\n" +
                "  (12, 1),\n" +
                "  (13, 2),\n" +
                "  (14, 2),\n" +
                "  (15, 2),\n" +
                "  (16, 2),\n" +
                "  (17, 2),\n" +
                "  (18, 2),\n" +
                "  (19, 2),\n" +
                "  (20, 3),\n" +
                "  (21, 3),\n" +
                "  (22, 3),\n" +
                "  (23, 3),\n" +
                "  (24, 3),\n" +
                "  (25, 3),\n" +
                "  (26, 3),\n" +
                "  (27, 3),\n" +
                "  (28, 3),\n" +
                "  (29, 3);";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(insertIntoAttandanceOfCoursesTable);
            System.out.println("Datas has been inserted into table ATTENDANCEOFCOURSES");

            dbConnection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
