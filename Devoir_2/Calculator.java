package Devoir_2;

public class Calculator {
    // Main accumumlator, general purpose accumulator
    public double acc, gpa = 0;
    private String op = "";

    public void pushNumber(double num) {
        if (this.op.isEmpty()) {
            this.acc = num;
        } else {
            this.gpa = num;
        }
    }

    public void operation(String str) {

        if (this.op.isEmpty()) { // Prepare operation
            this.op = str;
        } else {
            // We kinda can't do two operations at a time
            // so we just calculate the previous one first
            this.compute();
            this.op = str;
        }
    }

    public void add() {
        operation("+");
    }

    public void subtract() {
        operation("-");
    }

    public void multiply() {
        operation("*");
    }

    public void divide() {
        operation("/");
    }

    public void factorial() {
        if (this.acc == 0) {
            this.acc = 1;
            return;
        }
        var n = this.acc;
        this.acc = Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n) * (1 + 1 / (12 * n));

        // operation("!"); factorial is an immediate operation
    }

    public void pow() {
        operation("^");
    }

    public void rootSquare() {
        operation("sqrt");
    }

    public void nepLog() {
        operation("ln");
    }

    public void compute() {
        // calculate operation and store on acc
        switch (this.op) {
            case "-":
                this.gpa *= -1;
            case "+":
                this.acc += this.gpa;
                break;
            case "/":
                this.gpa = 1 / this.gpa;
            case "*":
                this.acc *= this.gpa;
                break;
            case "!":

                break;
            case "ln":
                if (this.acc == 0) {
                    this.acc = Math.log(gpa);
                } else {
                    this.acc *= Math.log(gpa);
                }
                break;
            case "^":
                this.acc = Math.pow(this.acc, this.gpa);
                break;
            case "sqrt":
                if (this.acc == 0) {
                    this.acc = Math.sqrt(gpa);
                } else {
                    this.acc *= Math.sqrt(gpa);
                }
            default:
                break;
        }
        this.op = "";
        this.gpa = 0;
    }

    public void clear() {
        this.op = "";
        this.gpa = 0;
        this.acc = 0;
    }

    public String toString() {
        if (this.op.isEmpty()) {
            if (this.acc == 0)
                return Double.toString(this.gpa);
            return Double.toString(this.acc);
        }

        if (this.op.equals("ln") || this.op.equals("sqrt")) {
            if (this.acc == 0) {
                return this.op + "(" + this.gpa + ")";
            } else {
                return this.acc + " * " + this.op + "(" + this.gpa + ")";
            }
        }
        return this.acc + " " + this.op + " " + this.gpa;

    }
}
