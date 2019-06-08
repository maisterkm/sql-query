package ua.com.foxminded.sqlquery;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DBhandlerTest {
    DBhandler dbHandler = new DBhandler();

    @Test
    public void findGroupWithLessThanNStudentsShouldReturnCorrectValue() {
        String result = null;
        try {
            result = dbHandler.findGroupWithLessThanNStudents(10);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String expected = "group SR-02 has 7 students";
        assertEquals(expected, result);
    }

    @Test
    public void findStudentsByNameOfCourseShouldReturnCorrectValue() {
        String result = null;
        try {
            result = dbHandler.findStudentsByNameOfCourse();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String expected = "--------------------------------------------------------\n" +
                "Name of course          | First name      | Last name      \r\n" +
                "--------------------------------------------------------\n" +
                "Mathematical analysis   | first_name_13   | last_name_13   \r\n" +
                "Mathematical analysis   | first_name_14   | last_name_14   \r\n" +
                "Mathematical analysis   | first_name_15   | last_name_15   \r\n" +
                "Mathematical analysis   | first_name_16   | last_name_16   \r\n" +
                "Mathematical analysis   | first_name_17   | last_name_17   \r\n" +
                "Mathematical analysis   | first_name_18   | last_name_18   \r\n" +
                "Mathematical analysis   | first_name_19   | last_name_19   \r\n" +
                "Statistic               | first_name_20   | last_name_20   \r\n" +
                "Statistic               | first_name_21   | last_name_21   \r\n" +
                "Statistic               | first_name_22   | last_name_22   \r\n" +
                "Statistic               | first_name_23   | last_name_23   \r\n" +
                "Statistic               | first_name_24   | last_name_24   \r\n" +
                "Statistic               | first_name_25   | last_name_25   \r\n" +
                "Statistic               | first_name_26   | last_name_26   \r\n" +
                "Statistic               | first_name_27   | last_name_27   \r\n" +
                "Statistic               | first_name_28   | last_name_28   \r\n" +
                "Statistic               | first_name_29   | last_name_29   \r\n";
        assertEquals(expected, result);
    }
}
