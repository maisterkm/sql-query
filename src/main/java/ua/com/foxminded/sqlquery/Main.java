package ua.com.foxminded.sqlquery;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        PostgreSQL postgreSQL = new PostgreSQL();
        try {
            postgreSQL.createTables();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
