import java.text.NumberFormat;
import java.util.Locale;

public class Volunteer implements Comparable<Volunteer> {

    String name;
    int test_kits;
    boolean isLeader;

    public Volunteer(String name, int test_kits, boolean isLeader) {
        this.name = name;
        this.test_kits = test_kits;
        this.isLeader = isLeader;
    }

    public static String formattedCurrency(double amount) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
        return currency.format(amount);
    }

    // Getter methods to get these values from another class in same package
    public String getName() {
        return name;
    }

    public int getTest_kit() {
        return test_kits;
    }

    public boolean getisLeader() {
        return isLeader;
    }

    public void extraKits(int extra_kits) throws Exception {
        if (extra_kits <= 0) {
            throw new Exception("You can't deliver less than 0 kits!");
        } else {
            test_kits += extra_kits;
        }
    }

    // Calculate Volunteers(Objects) wages based off their given constructor values.
    public double calculateWages() {
        double volunteer_wages = 0;

        // This calculates price if test kit amount is over 50.
        if (test_kits > 50) {
            volunteer_wages = volunteer_wages + 50 * 0.15;
            int minusFiftyKits = test_kits - 50;

            volunteer_wages += minusFiftyKits * 0.20;
        } else {
            // This calculates price if test kit amount is less than 50.
            volunteer_wages = test_kits * 0.15;
        }
        // Adds 20% leader bonus if the employee is a leader
        if (isLeader) {
            volunteer_wages *= 1.2;
        }
        return volunteer_wages;
    }

    public static void main(String[] args) {
        // Initialise currency object to format any double to UK currency (GBP)
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);

        Volunteer bob = new Volunteer("Bob", 123, false);
        System.out.println(bob.name + "s wages are: " + currency.format(bob.calculateWages()));

        Volunteer cal = new Volunteer("Cal", 53, false);
        System.out.println(cal.name + "s wages are: " + currency.format(cal.calculateWages()));

    }

    @Override
    public int compareTo(Volunteer v) {
        return Integer.compare(v.getTest_kit(), this.test_kits);
    }
}
