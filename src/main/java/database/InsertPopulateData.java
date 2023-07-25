package database;

import java.sql.Connection;
import java.sql.SQLException;

import static database.NewDatabasePopulateService.*;

public class InsertPopulateData {
    public static void main(String[] args) {

        try (Connection conn = Database.getInstance().getConnection()) {

            insertWorker(conn, "John Doe", "1990-05-15", "Trainee", 800);
            insertWorker(conn, "Jane Smith", "1985-08-22", "Junior", 1200);
            insertWorker(conn, "Michael Johnson", "1982-02-10", "Middle", 3000);
            insertWorker(conn, "Emily Davis", "1978-11-05", "Senior", 6000);
            insertWorker(conn, "David Brown", "1992-07-30", "Middle", 2500);
            insertWorker(conn, "Jennifer Wilson", "1987-04-12", "Junior", 1100);
            insertWorker(conn, "Christopher Anderson", "1995-09-18", "Trainee", 900);
            insertWorker(conn, "Jessica Taylor", "1989-01-25", "Middle", 2800);
            insertWorker(conn, "Daniel Martinez", "1984-06-08", "Senior", 5500);
            insertWorker(conn, "Olivia Thomas", "1991-03-02", "Junior", 1300);

            insertClient(conn, "ABC Company");
            insertClient(conn, "XYZ Corporation");
            insertClient(conn, "123 Industries");
            insertClient(conn, "Best Solutions Inc.");
            insertClient(conn, "Global Tech");

            insertProject(conn, 1, "2023-01-01", "2023-04-30");
            insertProject(conn, 2, "2022-11-15", "2023-03-15");
            insertProject(conn, 4, "2023-02-01", "2024-01-31");
            insertProject(conn, 4, "2022-09-01", "2023-06-30");
            insertProject(conn, 5, "2023-05-01", "2023-06-30");
            insertProject(conn, 1, "2023-03-15", "2024-02-29");
            insertProject(conn, 2, "2022-12-01", "2023-06-30");
            insertProject(conn, 5, "2023-01-01", "2023-05-31");
            insertProject(conn, 4, "2023-02-15", "2023-08-15");
            insertProject(conn, 5, "2022-10-01", "2023-01-31");

            insertProjectWorker(conn, 1, 1);
            insertProjectWorker(conn, 1, 2);
            insertProjectWorker(conn, 1, 3);
            insertProjectWorker(conn, 2, 4);
            insertProjectWorker(conn, 2, 5);
            insertProjectWorker(conn, 3, 6);
            insertProjectWorker(conn, 3, 7);
            insertProjectWorker(conn, 4, 8);
            insertProjectWorker(conn, 4, 9);
            insertProjectWorker(conn, 5, 10);
            insertProjectWorker(conn, 6, 1);
            insertProjectWorker(conn, 6, 2);
            insertProjectWorker(conn, 6, 4);
            insertProjectWorker(conn, 7, 6);
            insertProjectWorker(conn, 7, 8);
            insertProjectWorker(conn, 7, 10);
            insertProjectWorker(conn, 8, 3);
            insertProjectWorker(conn, 8, 5);
            insertProjectWorker(conn, 9, 1);
            insertProjectWorker(conn, 9, 6);
            insertProjectWorker(conn, 9, 9);
            insertProjectWorker(conn, 10, 2);
            insertProjectWorker(conn, 10, 4);
            insertProjectWorker(conn, 10, 8);

            System.out.println("Tables fielded successfully.");

        } catch (SQLException e) {
            System.err.println("Request execution error: " + e.getMessage());
        }
    }
}
