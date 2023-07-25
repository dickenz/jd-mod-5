package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class NewDatabasePopulateService {
        public NewDatabasePopulateService() {
            String sqlFilePath = "sql/new_populate_db.sql";

            try (Connection conn = Database.getInstance().getConnection();
                 Statement stmt = conn.createStatement();
                 BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath))) {

                StringBuilder queryBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                queryBuilder.append(line);

                if (line.trim().endsWith(";")) {
                    String query = queryBuilder.toString();
                    stmt.execute(query);

                    queryBuilder.setLength(0);
                }
            }

        } catch (IOException | SQLException e) {
                e.printStackTrace();
        }
    }

    static void insertWorker(Connection connection, String name, String birthday, String level, int salary) throws SQLException {
        String sql = "INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, birthday);
            pstmt.setString(3, level);
            pstmt.setInt(4, salary);
            pstmt.executeUpdate();
        }
    }

    static void insertClient(Connection connection, String name) throws SQLException {
        String sql = "INSERT INTO client (NAME) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    static void insertProject(Connection connection, int clientId, String startDate, String finishDate) throws SQLException {
        String sql = "INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, clientId);
            pstmt.setString(2, startDate);
            pstmt.setString(3, finishDate);
            pstmt.executeUpdate();
        }
    }

    static void insertProjectWorker(Connection connection, int projectId, int workerId) throws SQLException {
        String sql = "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, projectId);
            pstmt.setInt(2, workerId);
            pstmt.executeUpdate();
        }
    }
}