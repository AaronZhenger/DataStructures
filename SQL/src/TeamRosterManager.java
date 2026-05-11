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
                    case 2 -> {
                        System.out.print("Enter team ID: ");
                        int t = sc.nextInt();
                        System.out.print("Enter first name: ");
                        sc.nextLine();
                        String f = sc.nextLine();
                        System.out.print("Enter last name: ");
                        String l = sc.nextLine();
                        System.out.println("\nPlayer added.\n");
                        statement.executeUpdate("INSERT INTO player(team_id, first_name, last_name)" +
                                "VALUES" +
                                "("+t+", '" +f+"', '"+l+"');");
                    }
                    case 3 -> {
                        System.out.print("Enter team 1 ID: ");
                        int i = sc.nextInt();
                        System.out.print("Enter team 2 ID: ");
                        int d = sc.nextInt();
                        System.out.print("Enter team 1 score: ");
                        int x = sc.nextInt();
                        System.out.print("Enter team 2 score: ");
                        int y = sc.nextInt();
                        System.out.println("\nGame added.\n");
                        statement.executeUpdate("INSERT INTO game(team1_id, team2_id, team1_score, team2_score)" +
                                "VALUES" +
                                "("+i+", " +d+", "+x+", "+y+");");
                    }
                    case 4 -> {
                        System.out.print("Enter player ID: ");
                        int i = sc.nextInt();
                        System.out.print("Enter new jersey number: ");
                        int n = sc.nextInt();
                        System.out.println("\nPlayer updated.\n");
                        statement.executeUpdate("UPDATE player SET jersey_number = "+n +
                                " WHERE player_id = "+i+";");
                    }
                    case 5 -> {
                        System.out.print("Enter player ID: ");
                        int i = sc.nextInt();
                        System.out.println("\nPlayer removed.\n");
                        statement.executeUpdate("DELETE FROM player " +
                                "WHERE player_id = "+i+";");
                    }
                    case 6 -> {
                        ResultSet rs = statement.executeQuery("SELECT * FROM team");
                        System.out.println("\nTeams:");
                        System.out.println("ID   Team Name   Coach");
                        while (rs.next()) {
                            System.out.printf("%-5d%-12s%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
                        }
                        System.out.println();
                    }
                    case 7 -> {
                        ResultSet rs = statement.executeQuery(
                                "SELECT p.player_id, p.first_name, p.last_name, p.jersey_number, t.team_name FROM player p\n" +
                                        "LEFT JOIN team t\n" +
                                        "ON p.team_id = t.team_id;");
                        System.out.println("\nPlayers:");
                        System.out.println("ID   Player Name       Jersey   Team");
                        while (rs.next()) {
                            System.out.printf("%-5d%-18s%-9d%s\n", rs.getInt(1), rs.getString(2)+" "+rs.getString(3), rs.getInt(4), rs.getString(5));
                        }
                        System.out.println();
                    }
                    case 8 -> {
                        ResultSet rs = statement.executeQuery(
                                "SELECT g.game_id, a.team_name, b.team_name, g.team1_score, g.team2_score FROM game g\n" +
                                        "LEFT JOIN team a\n" +
                                        "ON g.team1_id = a.team_id\n" +
                                        "LEFT JOIN team b\n" +
                                        "ON g.team2_id = b.team_id;");
                        System.out.println("\nGames:");
                        System.out.println("ID   Game");
                        while (rs.next()) {
                            System.out.printf("%-5d%s\n", rs.getInt(1), rs.getString(2)+"-"+rs.getInt(4)+" vs "+rs.getString(3)+"-"+rs.getInt(5));
                        }
                        System.out.println();
                    }
                    case 9 -> {
                        System.out.print("Enter team ID: ");
                        int i = sc.nextInt();
                        ResultSet rs = statement.executeQuery(
                                "SELECT t.team_name, t.coach_name, p.jersey_number, p.first_name, p.last_name FROM player p\n" +
                                        "RIGHT JOIN team t\n" +
                                        "ON t.team_id = p.team_id\n" +
                                        "WHERE t.team_id = "+i+";");
                        rs.next();
                        System.out.println("\nTeam Report: "+rs.getString(1));
                        System.out.println("Coach: "+rs.getString(2));
                        System.out.println("\nPlayers: ");
                        do {
                            System.out.printf("%-5d%s %s\n", rs.getInt(3), rs.getString(4), rs.getString(5));
                        } while (rs.next());
                        System.out.println("\nGame Results: ");
                        rs = statement.executeQuery(
                                "SELECT a.team_id, b.team_id, a.team_name, b.team_name, g.team1_score, g.team2_score FROM game g\n" +
                                        "LEFT JOIN team a\n" +
                                        "ON g.team1_id = a.team_id\n" +
                                        "LEFT JOIN team b\n" +
                                        "ON g.team2_id = b.team_id\n" +
                                        "WHERE g.team1_id = "+i+" OR g.team2_id = "+i+";");
                        double tot = 0;
                        double gp = 0;
                        int wins = 0;
                        int losses = 0;
                        while (rs.next()) {
                            int aId = rs.getInt(1);
                            gp++;
                            boolean won;
                            if (aId == i) {
                                tot += rs.getInt(5);
                                won = rs.getInt(5)>rs.getInt(6);
                                String result = won ? "W" : "L";
                                System.out.printf("vs %-9s%s   %d-%d\n", rs.getString(4), result, rs.getInt(5), rs.getInt(6));
                            } else {
                                tot += rs.getInt(6);
                                won = rs.getInt(6)>rs.getInt(5);
                                String result = won ? "W" : "L";
                                System.out.printf("vs %-9s%s   %d-%d\n", rs.getString(3), result, rs.getInt(6), rs.getInt(5));
                            }
                            switch (won) {
                                case true : wins++;
                                case false : losses++;
                            }
                        }
                        System.out.printf("Record: %d-%d\nAverage Points Scored: %.2f\n\n", wins, losses, tot/gp);
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
