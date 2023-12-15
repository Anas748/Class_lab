package lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class DatabaseManager {
    private static final String DB_NAME = "world_cup";
    private static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
    private static final String USER = "football";
    private static final String PASS = "Java is almost as good as football"; 

     static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
          }

     public static void createTables(String[] teams) {
    Connection conn = null;
    Statement stmt = null;
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/", USER, PASS);
        stmt = conn.createStatement();

        // Create 'world_cup' database if not exists
        stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
        stmt.execute("USE " + DB_NAME + ";");

        for (String team : teams) {
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS " + team + " ("
                            + "name VARCHAR(30) NOT NULL,"
                            + "number INT NOT NULL PRIMARY KEY,"
                            + "birth VARCHAR(30),"
                            + "position VARCHAR(30),"
                            + "goalsScored INT,"
                            + "background TEXT(1000));"
            );
        }
        } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public static void displayPlayersOnTeam(String teamName) {
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery("SELECT * from " + teamName + ";");
        while (rs.next()) {
            String name = rs.getString("name");
            int number = rs.getInt("number");
            String birth = rs.getString("birth");
            String position = rs.getString("position");
            int goalsScored = rs.getInt("goalsScored");
            String background = rs.getString("background");

            System.out.println(String.format("Name: %s -- Number: %d -- DoB: %s -- Position: %s -- Number of goals scored: %d", name, number, birth, position, goalsScored));
            System.out.println("Background:");
            System.out.println(background);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}