import java.util.ArrayList;

public class IceCream {
//    public static final int BOWL = 0;
//    public static final int WAFFLE_BOWL = 1;
//    public static final int WAFFLE_CONE = 2;
//    public static final int CHOCOLATE_WAFFLE_CONE = 3;
//
//    public static final int COOKIES_AND_CREAM = 0;
//    public static final int CHOCOLATE = 1;
//    public static final int VANILLA = 2;
//    public static final int BUTTER_PECAN = 3;
//    public static final int STRAWBERRY = 4;
//    public static final int CHOCOLATE_CHIP_COOKIE_DOUGH = 5;
//    public static final int COFFEE = 6;
//    public static final int CINNAMON = 7;

//    public static final int CHOCOLATE_SYRUP = 10;
//    public static final int CARMEL_SYRUP = 11;
//    public static final int M_AND_MS = 12;
//    public static final int OREOS = 13;
//    public static final int PEANUT_BUTTER_CUP = 14;
//    public static final int CHOCOLATE_CHIP = 15;
//    public static final int SPRINKLES = 16;

    private String c;
    private String f;
    private String n;
    private ArrayList<String> t;

    public IceCream(String c, String f, String n, ArrayList<String> t) {
        this.c = c;
        this.f = f;
        this.n = n;
        this.t = t;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public ArrayList<String> getT() {
        return t;
    }

    public void setT(ArrayList<String> t) {
        this.t = t;
    }
}
