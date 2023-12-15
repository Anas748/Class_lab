package javaapplication19;

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