package Devoir_1;

public class Couple {
    private int p;
    private int q;

    public Couple(int p, int q) {
        this.p = p;
        this.q = q;
    }

    public Couple() {
        this(0, 0);
    }

    public Couple(Couple c) {
        this(c.p, c.q);
    }

    public int getP() {
        return this.p;
    }

    public int getQ() {
        return this.q;
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public void display() {
        System.out.println(this);
    }

    public boolean compare(Couple other) {
        return (this.p < other.p || (this.p == other.p && this.q < other.q));
    }

    @Override
    public String toString() {
        return "(" + this.p + ", " + this.q + ")";
    }
}
