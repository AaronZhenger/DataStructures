import java.io.File;
import java.util.*;

public class DS3_SetJoins {
    public static void main(String[] args) throws Exception {
        Scanner k = new Scanner(System.in);
        MySet<Integer> setA = new MySet<>();
        MySet<Integer> setB = new MySet<>();

        System.out.print("Enter the file name: ");
        File file = new File(k.nextLine());

        Scanner fSc = new Scanner(file);
        for (int i = 0; i<2; i++) {
            Scanner lSc = new Scanner(fSc.nextLine());
            switch (i) {
                case 0 : {
                    while (lSc.hasNextInt()) setA.add(lSc.nextInt());
                    break;
                }
                case 1 : {
                    while (lSc.hasNextInt()) setB.add(lSc.nextInt());
                    break;
                }
            }
        }
        System.out.println("\nSet A: "+setA);
        System.out.println("Set B: "+setB);

        MySet<Integer> union = new MySet<>();
        Iterator<Integer> iteratorA = setA.iterator();
        ArrayList<Integer> arrA = new ArrayList<>();
        while (iteratorA.hasNext()) {
            int i = iteratorA.next();
            union.add(i);
            arrA.add(i);
        }
        Iterator<Integer> iteratorB = setB.iterator();
        ArrayList<Integer> arrB = new ArrayList<>();
        while (iteratorB.hasNext()) {
            int i = iteratorB.next();
            union.add(i);
            arrB.add(i);
        }

        ArrayList<Integer> unionArr = new ArrayList<>();
        Iterator<Integer> iteratorU = union.iterator();
        while (iteratorU.hasNext()) unionArr.add(iteratorU.next());
        Collections.sort(unionArr);

        System.out.println("\nUnion: "+unionArr);

        MySet<Integer> inter = new MySet<>();
        for (int i : arrA)
            for (int j : arrB)
                if (i == j)
                    inter.add(i);
        System.out.println("Intersection: "+inter);

        MySet<Integer> subA = new MySet<>();
        MySet<Integer> subB = new MySet<>();
        for (int i : arrA) if (!inter.contains(i)) subA.add(i);
        for (int i : arrB) if (!inter.contains(i)) subB.add(i);
        System.out.println("A - B (Elements in A not in B): "+subA);
        System.out.println("B - A (Elements in B not in A): "+subB);
    }
}
