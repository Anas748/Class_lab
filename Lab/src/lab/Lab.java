/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Sam Please put the names and student numbers of the team here:
 *
 * Name 1: Muhammad Ahmad Number 1: 2021385
 *
 * Name 2: Sajjad Haider Number 2: 2021384
 *
 * Name 3: Muhammad Anas Baig Number 3: 2021387
 *
 * Name 4: Abdul Rehman Number 4 2021333
 *
 */
public class Lab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
          String[] teams = {"Ireland", "Brazil", "Argentina", "Japan", "Mexico", "Senegal", "Tunisia", "Qatar"};
        DatabaseManager.createTables(teams);

        int option;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Welcome! What would you like to do today? Please enter the number corresponding to your choice.");
            System.out.println("1. Enter a new player to a team.");
            System.out.println("2. See the players on a team.");
            System.out.println("3. Simulate a number of matches.");
            System.out.println("4. Exit the programme.");

            try {
                option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1:
                        addPlayerToTeam(teams, sc);
                        break;
                    case 2:
                        displayPlayersOnTeam(teams, sc);
                        break;
                    case 3:
                        simulateMatches(teams, sc);
                        break;
                    case 4:
                        System.out.println("Goodbye, and thank you for using the SoccerSimulator!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }

        } while (!exit);
    }
    private static void addPlayerToTeam(String[] teams, Scanner sc) {
        boolean validTeam = false;
        String teamName;

        System.out.println("Please follow the instructions to enter player data.");
        do {
            System.out.println("For which team would you like to enter data?");
            teamName = sc.nextLine();
            for (String team : teams) {
                if (teamName.toLowerCase().equals(team.toLowerCase())) {
                    validTeam = true;
                    break;
                }
            }
            if (teamName.toLowerCase().equals("exit")) break;
            if (!validTeam) System.out.println("That is not one of the teams. Please try again!");
        } while (!validTeam);

        if (!teamName.toLowerCase().equals("exit")) {
            Player player = Player.createPlayer(sc);
            Team team = new Team(teamName);
            team.addPlayer(player);
            player.saveToDatabase(teamName, "jdbc:mysql://localhost/world_cup", "football", "Java is almost as good as football");
            System.out.println("Player added to the team.");
        }
    }

    private static void displayPlayersOnTeam(String[] teams, Scanner sc) {
       boolean validTeam = false;
    String teamName;
    System.out.println("Please follow the instructions to get player data.");
    do {
        System.out.println("For which team would you like to get player data?");
        teamName = sc.nextLine();
        for (String team : teams) {
            if (teamName.toLowerCase().equals(team.toLowerCase())) {
                validTeam = true;
                break;
            }
        }
        if (teamName.toLowerCase().equals("exit")) break;
        if (!validTeam) System.out.println("That is not one of the teams. Please try again!");
    } while (!validTeam);

    if (!teamName.toLowerCase().equals("exit")) {
        DatabaseManager.displayPlayersOnTeam(teamName);
    }
    }
    private static void simulateMatches(String[] teams, Scanner sc) {
        System.out.println("How many matches would you like to simulate?");
        int numMatches = Integer.parseInt(sc.nextLine());

        for (int matchNum = 1; matchNum <= numMatches; matchNum++) {
            String team1 = teams[(int) (Math.floor(Math.random() * teams.length))];
            String team2;
            do {
                team2 = teams[(int) (Math.floor(Math.random() * teams.length))];
            } while (team1.equals(team2));

            Match match = new Match(new Team(team1), new Team(team2));
            match.simulateMatch();

            System.out.println("Time for match: " + matchNum);
            System.out.println(match.getResult());
        }
    }

}

    


