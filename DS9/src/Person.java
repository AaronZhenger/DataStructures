public class Person {
    private String f;
    private String l;
    private long n;
    private String a;

    public Person(String f, String l) {
        this.f = f;
        this.l = l;
    }

    public Person(String f, String l, long n) {
        this.f = f;
        this.l = l;
        this.n = n;
    }

    public Person(String f, String l, String a) {
        this.f = f;
        this.l = l;
        this.a = a;
    }

    public Person(String f, String l, long n, String a) {
        this.f = f;
        this.l = l;
        this.n = n;
        this.a = a;
    }

    public void setF(String f) {
        this.f = f;
    }

    public void setL(String l) {
        this.l = l;
    }

    public void setN(long n) {
        this.n = n;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getF() {
        return f;
    }

    public String getL() {
        return l;
    }

    public long getN() {
        return n;
    }

    public String getA() {
        return a;
    }

    @Override
    public String toString() {
        return l+", "+f;
    }
}
