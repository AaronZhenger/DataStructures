import java.io.File;
import java.util.Scanner;

public class DS3_Bank {
    public static void main(String[] args) throws Exception {
        DS3_Map<String, Double> data = new DS3_Map<>();
        Scanner k = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        File file = new File(k.nextLine());
        Scanner fSc = new Scanner(file);
        System.out.println();

        while (fSc.hasNextLine()) {
            Scanner lSc = new Scanner(fSc.nextLine());
            String action = lSc.next();
            String acc = lSc.next();
            double val = 0.0;
            if (lSc.hasNext()) {
                val = lSc.nextDouble();
                System.out.printf("%s %s %.0f\n", action, acc, val);
            }
            else System.out.printf("%s %s\n", action, acc);

            switch (action) {
                case "OPEN" : {
                    if (data.containsKey(acc))
                        System.out.println("\tAccount "+acc+" already exists");
                    else {
                        data.put(acc, 0.0);
                        System.out.println("\tAccount "+acc+" opened with balance "+data.get(acc));
                    }
                    break;
                }
                case "WITHDRAW" : {
                    if (!data.containsKey(acc))
                        System.out.println("\tAccount not found for withdrawal from "+acc);
                    else if (data.get(acc)<val)
                        System.out.println("\tInsufficient funds for withdrawal from "+acc);
                    else {
                        data.put(acc, data.get(acc)-val);
                        System.out.println("\tWithdrew "+val+" from "+acc+", new balance "+data.get(acc));
                    }
                    break;
                }
                case "DEPOSIT" : {
                    if (!data.containsKey(acc))
                        System.out.println("\tAccount not found for deposit into "+acc);
                    else {
                        data.put(acc, data.get(acc)+val);
                        System.out.println("\tDeposited "+val+" into "+acc+", new balance "+data.get(acc));
                    }
                    break;
                }
                case "CLOSE" : {
                    if (!data.containsKey(acc))
                        System.out.println("\tAccount not found for closing "+acc);
                    else {
                        data.remove(acc);
                        System.out.println("\tAccount "+acc+" closed");
                    }
                    break;
                }
            }
        }
    }
}
