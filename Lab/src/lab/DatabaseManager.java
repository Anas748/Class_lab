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
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
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