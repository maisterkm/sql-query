package ua.com.foxminded.sqlquery;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        PostgreSQL postgreSQL = new PostgreSQL();

        postgreSQL.dropTables();

        postgreSQL.createTables();

        postgreSQL.insertIntoCoursesTable();
        postgreSQL.insertIntoGroupsTable();
        postgreSQL.insertIntoStudentsTable();
        postgreSQL.insertIntoAttandanceOfCoursesTable();

        System.out.println("\nSQL query should find if any of the groups has less than 10 students.");
        postgreSQL.findGroupWithLessThan10Students();

        //SQL query should delete all students from group with name "SR-01"
        postgreSQL.deleteStudentFromGroup("SR-01");
    }

}
