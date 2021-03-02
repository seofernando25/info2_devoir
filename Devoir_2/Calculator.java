package Devoir_2;

public class Calculator {
    public static final String STR_ANS = "Ans";
    public static final String STR_CPT = "=";
    public static final String STR_CLR = "C";
    public static final String STR_ADD = "+";
    public static final String STR_SUB = "-";
    public static final String STR_MUL = "*";
    public static final String STR_DIV = "/";
    public static final String STR_FAC = "!";
    public static final String STR_SQR = "sqrt";
    public static final String STR_LOG = "ln";
    public static final String STR_POW = "^";

    // This class have a lot of "special cases" due
    // to the requirements imposed by the question           (passive agressive I see)
    // We are only allowed to use 3 variables in the class

    // Main accumumlator, general purpose accumulator
    public double acc, gpa = 0;
    public String op = "";

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
            // If we try to do more than one operation at a time
            // we precompute it and push to the accumulator
            this.compute();
            this.op = str;
        }
    }

    public void add() {
        operation(STR_ADD);
    }

    public void subtract() {
        if (this.op.equals(STR_SUB) && this.gpa == 0.0) {
            this.op = STR_ADD;
        } else {
            operation(STR_SUB);
        }
    }

    public void multiply() {
        operation(STR_MUL);
        this.gpa = 1.0;
    }

    public void divide() {
        operation(STR_DIV);
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
        operation(STR_POW);
    }

    public void rootSquare() {
        operation(STR_SQR);
    }

    public void nepLog() {
        operation(STR_LOG);
    }

    public void compute() {
        // calculate operation and store on acc
        switch (this.op) {
            case STR_SUB:
                this.gpa *= -1;
            case STR_ADD:
                this.acc += this.gpa;
                break;
            case STR_DIV:
                this.gpa = 1 / this.gpa;
            case STR_MUL:
                this.acc *= this.gpa;
                break;
            case STR_LOG:
                if (this.acc == 0) {
                    this.acc = Math.log(gpa);
                } else {
                    this.acc *= Math.log(gpa);
                }
                break;
            case STR_POW:
                this.acc = Math.pow(this.acc, this.gpa);
                break;
            case STR_SQR:
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

        if (this.op.equals(STR_LOG) || this.op.equals(STR_SQR)) {
            if (this.acc == 0) {
                return this.op + "(" + this.gpa + ")";
            } else {
                return this.acc + " " + STR_MUL + " " + this.op + "(" + this.gpa + ")";
            }
        }
        return this.acc + " " + this.op + " " + this.gpa;

    }
}
