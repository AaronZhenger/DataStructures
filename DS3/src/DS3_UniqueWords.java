import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class DS3_UniqueWords {
    public static void main(String[] args) throws Exception {
        Scanner k = new Scanner(System.in);
        MySet<String> unique = new MySet<>();

        System.out.print("Enter the file name: ");
        File file = new File(k.nextLine());

        Scanner fSc = new Scanner(file);
        while (fSc.hasNextLine()) {
            Scanner lSc = new Scanner(fSc.nextLine()).useDelimiter("[()–.,!?;:\" ]+");
            while (lSc.hasNext()) unique.add(lSc.next().toLowerCase());
        }

        System.out.println();

        Iterator<String> iterator = unique.iterator();

        while (iterator.hasNext()) {
            String c = iterator.next();
            if (c.contains("’")) c = c.substring(0, c.indexOf("’"))+c.substring(c.indexOf("’")+1);
            System.out.println(c);
        }
    }
}
