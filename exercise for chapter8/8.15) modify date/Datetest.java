public class Datetest {
    public static void main(String[] args) {
        Date date = new Date(12, 31, 2023);

        for (int i = 1; i <= 10; i++) {
            System.out.println("Current date: " + date.toString());
            date.nextDay();
        }
    }
}
