package ua.com.foxminded.sqlquery;

public class Main {

    public static void main(String[] args) {
        PostgreSQL postgreSQL = new PostgreSQL();

       /* try {
            postgreSQL.createTables();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        postgreSQL.insertIntoCoursesTable(); */
        postgreSQL.insertIntoGroupsTable();
        postgreSQL.insertIntoStudentsTable();
        postgreSQL.insertIntoAttandanceOfCoursesTable();
    }

}
