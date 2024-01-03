public class Date {
    private int month;
    private int day;
    private int year;

    private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException("Invalid month value");
        }
        
        if (year <= 0) {
            throw new IllegalArgumentException("Invalid year value");
        }

        if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29 && isLeapYear(year)))) {
            throw new IllegalArgumentException("Invalid day value");
        }

        this.month = month;
        this.day = day;
        this.year = year;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public void nextDay() {
        if (day < daysPerMonth[month] || (month == 2 && day == 28 && isLeapYear(year))) {
            day++;
        } else {
            day = 1;
            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
        }
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }
}
