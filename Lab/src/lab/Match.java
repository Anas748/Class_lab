/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab;

/**
 *
 * @author PC
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
}
