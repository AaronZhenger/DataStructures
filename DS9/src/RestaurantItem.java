public class RestaurantItem {
    private String n;
    private double c;
    private int q;

    public RestaurantItem(String n, double c, int q) {
        this.n = n;
        this.c = c;
        this.q = q;
    }

    public String getN() {
        return n;
    }

    public double getC() {
        return c;
    }

    public int getQ() {
        return q;
    }

    public void setN(String n) {
        this.n = n;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setQ(int q) {
        this.q = q;
    }
}
