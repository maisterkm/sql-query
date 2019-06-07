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

        System.out.println("\n1. SQL query should find if any of the groups has less than 10 students.");
        postgreSQL.findGroupWithLessThan10Students();

        System.out.println("\n2. SQL query should delete all students from group with name \"SR-01\"");
        postgreSQL.deleteStudentFromGroup("SR-01");

        System.out.println("\n3. Write SQL query that finds name of course and related students");
        System.out.println(postgreSQL.findStudentsByNameOfCourse());
    }

}
