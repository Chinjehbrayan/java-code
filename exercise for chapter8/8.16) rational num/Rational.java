public class Rational {
    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        int gcd = findGCD(numerator, denominator); // find the greatest common divisor
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public static Rational add(Rational r1, Rational r2) {
        int numerator = (r1.numerator * r2.denominator) + (r2.numerator * r1.denominator);
        int denominator = r1.denominator * r2.denominator;
        return new Rational(numerator, denominator);
    }

    public static Rational subtract(Rational r1, Rational r2) {
        int numerator = (r1.numerator * r2.denominator) - (r2.numerator * r1.denominator);
        int denominator = r1.denominator * r2.denominator;
        return new Rational(numerator, denominator);
    }

    public static Rational multiply(Rational r1, Rational r2) {
        int numerator = r1.numerator * r2.numerator;
        int denominator = r1.denominator * r2.denominator;
        return new Rational(numerator, denominator);
    }

    public static Rational divide(Rational r1, Rational r2) {
        int numerator = r1.numerator * r2.denominator;
        int denominator = r1.denominator * r2.numerator;
        return new Rational(numerator, denominator);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public String toFloatingPointString(int precision) {
        double value = (double) numerator / denominator;
        return String.format("%." + precision + "f", value);
    }

    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b); //GCD Stands for greatest common divisor
    }
}
