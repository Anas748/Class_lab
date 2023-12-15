/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab;

import java.util.Random;

/**
 *
 * @author Haider
 */
public class Match {
    // team 1 an 2 represents the two teams
     private Team team1;
    private Team team2;
  //  team1 and 2 score int represents the score of team
    private int team1Score;
    private int team2Score;
    
    
    // contructor to initialize the team1,2 variables
     public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        
    }
     
     //Geters methods for team1,2
    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }
    
    // use simulate method for match to print random score for team
      public void simulateMatch() {
        Random random = new Random();
        team1Score = random.nextInt(6); // Random score between 0 and 5
        team2Score = random.nextInt(6);

        System.out.println("Simulation Result:");
        System.out.println(team1.getName() + " " + team1Score + " - " + team2Score + " " + team2.getName());
        
        updatePlayersWithMatchResult(team1, team1Score);
        updatePlayersWithMatchResult(team2, team2Score);
    }
      
      //update each player in team base on goal score
        private void updatePlayersWithMatchResult(Team team, int goalsScored) {
        for (Player player : team.getPlayers()) {
            player.setGoalsScored(player.getGoalsScored() + goalsScored);
            // You can add more logic here to update other player statistics
        }
    }
      
      
}
