public class RationalTest {
    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(3, 4);

        Rational sum = Rational.add(r1, r2);
        System.out.println("Sum: " + sum);

        Rational difference = Rational.subtract(r1, r2);
        System.out.println("Difference: " + difference);

        Rational product = Rational.multiply(r1, r2);
        System.out.println("Product: " + product);

        Rational quotient = Rational.divide(r1, r2);
        System.out.println("Quotient: " + quotient);

        System.out.println("Rational number in fraction form: " + r1);
        System.out.println("Rational number in floating-point form: " + r1.toFloatingPointString(2));
    }

}
