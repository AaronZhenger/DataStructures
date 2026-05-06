import java.sql.*;
import java.util.Scanner;

public class TeamRosterManager {
    private static Connection connection;
    private static int s = 0;

    public static void main(String args[]){
        try{
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/team_manager_3","root","password");
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS team(" +
                    "team_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                    "team_name VARCHAR(50) NOT NULL, " +
                    "coach_name VARCHAR(50) NOT NULL);");

            statement.execute("CREATE TABLE IF NOT EXISTS player(" +
                    "player_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                    "team_id INT NOT NULL, " +
                    "first_name VARCHAR(50) NOT NULL, " +
                    "last_name VARCHAR(50) NOT NULL, " +
                    "jersey_number INT NOT NULL, " +
                    "FOREIGN KEY (team_id)" +
                    "REFERENCES team(team_id));");

            statement.execute("CREATE TABLE IF NOT EXISTS game(" +
                    "game_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                    "team1_id INT NOT NULL, " +
                    "team2_id INT NOT NULL, " +
                    "team1_score INT NOT NULL, " +
                    "team2_score INT NOT NULL, " +
                    "FOREIGN KEY (team1_id)" +
                    "REFERENCES team(team_id), " +
                    "FOREIGN KEY (team2_id)" +
                    "REFERENCES team(team_id));");

            Scanner sc = new Scanner(System.in);

            while (s!=10) {
                switch (s) {
                    case 1 -> {
                        System.out.print("Enter team name: ");
                        sc.nextLine();
                        String t = sc.nextLine();
                        System.out.print("Enter coach name: ");
                        String c = sc.nextLine();
                        System.out.println("\nTeam added.\n");
                        statement.executeUpdate("INSERT INTO team(team_name, coach_name)" +
                                "VALUES" +
                                "('" +t+"', '"+c+"');");
                    }
                    default -> {

                    }
                }
                System.out.print("Team Roster Manager\n" +
                        "\n" +
                        "1. Add Team\n" +
                        "2. Add Player\n" +
                        "3. Add Game Result\n" +
                        "4. Edit Player Jersey Number\n" +
                        "5. Remove Player\n" +
                        "6. Display Teams\n" +
                        "7. Display Players\n" +
                        "8. Display Games\n" +
                        "9. Print Team Report\n" +
                        "10. Exit\n" +
                        "\n" +
                        "Enter choice: ");
                s = sc.nextInt();
            };

            connection.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
