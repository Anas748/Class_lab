/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab;

/**
 *
 * @author Muhammad Anas Baig
 */
public class Player {
    
    private String name;
    private int number;
    private String birth;
    private String position;
    private int goalsScored;
    private String background;

    public Player(String name, int number, String birth, String position, int goalsScored, String background) {
        this.name = name;
        this.number = number;
        this.birth = birth;
        this.position = position;
        this.goalsScored = goalsScored;
        this.background = background;
    }
    
    //Getter and setters 
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
    public static Player createPlayer() {
        String name;
        int number = 0;
        String birth;
        String position;
        int goalsScored = 0;
        String background;
        System.out.println("Please enter the player's name: ");
        name = sc.nextLine();
        System.out.println("Please enter the player's number: ");
        do {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < 1) {
                    System.out.println("Please enter a positive integer");
                } else {
                    validPlayer = true;
                }

            } catch (Exception e) {
                System.out.println("That is not a number. please try again!");
            }
        } while (!validPlayer);
        System.out.println("Please enter the player's date of birth: ");
        birth = sc.nextLine();
        System.out.println("Please enter the player's position: ");
        position = sc.nextLine();
        System.out.println("Please enter the number of goals the player has scored: ");
        validPlayer = false;
        do {
            try {
                goalsScored = Integer.parseInt(sc.nextLine());
                if (goalsScored < 1) {
                    System.out.println("Please enter a positive integer");
                } else {
                    validPlayer = true;
                }

            } catch (Exception e) {
                System.out.println("That is not a number. please try again!");
            }
            while (!validPlayer);
            System.out.println("Please enter the player's background: ");
            background = sc.nextLine();
            System.out.println("Thank you for entering a player");

             return new Player(name, number, birth, position, goalsScored, background);

        }
    }
}
   