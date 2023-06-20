import java.text.NumberFormat;
import java.util.Locale;

public class Volunteer implements Comparable<Volunteer>{

    String name;
    int test_kits;

    public Volunteer(String name, int test_kits) {
        this.name = name;
        this.test_kits = test_kits;
    }

    public static String formattedCurrency(double amount){
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
        return currency.format(amount);
    }

    //Getter methods to get these values from another class in same package
    public String getName(){return name;}
    public int getTest_kit(){return test_kits;}

    public void extraKits(int extra_kits) throws Exception {
        if(extra_kits <= 0) {
            throw new Exception("You can't deliver less than 0 kits!");
        }
        else{
            test_kits += extra_kits;
        }
    }

    //Calculate Volunteers(Objects) wages based off their given constructor values.
    public double calculateWages() {
        double volunteer_wages = 0;

        //This calculates price if test kit amount is over 50.
        if (test_kits > 50){
            volunteer_wages = volunteer_wages + 50 * 0.15;
            int minusFiftyKits = test_kits - 50;

            volunteer_wages += minusFiftyKits * 0.20;
        }
        else
        {
            //This calculates price if test kit amount is less than 50.
            volunteer_wages = test_kits * 0.15;
        }
        return volunteer_wages;
    }

    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);

        Volunteer bob = new Volunteer("Bob", 123);
        System.out.println(bob.name + "s wages are: " + currency.format(bob.calculateWages()));

        Volunteer cal = new Volunteer("Cal", 53);
        System.out.println(cal.name + "s wages are: " + currency.format(cal.calculateWages()));

    }

    @Override
    public int compareTo(Volunteer v) {
        return Integer.compare(v.getTest_kit(), this.test_kits);
    }
}
