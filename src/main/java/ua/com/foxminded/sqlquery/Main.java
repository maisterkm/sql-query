package ua.com.foxminded.sqlquery;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DBhandler dbHandler = new DBhandler();

//        dbHandler.dropTables();

        dbHandler.createTables();

        dbHandler.insertIntoCoursesTable();
        dbHandler.insertIntoGroupsTable();
        dbHandler.insertIntoStudentsTable();
        dbHandler.insertIntoAttandanceOfCoursesTable();

        System.out.println("\n1. SQL query should find if any of the groups has less than 10 students.");
        dbHandler.findGroupWithLessThanNStudents(10);

        System.out.println("\n2. SQL query should delete all students from group with name \"SR-01\"");
        dbHandler.deleteStudentFromGroup("SR-01");

        System.out.println("\n3. Write SQL query that finds name of course and related students");
        System.out.println(dbHandler.findStudentsByNameOfCourse());
    }

}
