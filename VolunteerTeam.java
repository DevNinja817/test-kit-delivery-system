import java.util.ArrayList;
import java.util.Collections;

public class VolunteerTeam {

    // Initialise VolunteerTeam array list. Volunteers will be added to this team.
    ArrayList<Volunteer> team = new ArrayList<>();

    // Volunteer v is object with all Volunteers in it. Add Volunteers to ArrayList
    // team
    public void addVolunteers(Volunteer v) {
        team.add(v);
    }

    public double getTotal_wage() {
        // Initialise currency object to format any double to UK currency (GBP)

        double wage_total = 0;
        for (Volunteer v : team) {
            wage_total += v.calculateWages();
        }
        return wage_total;
    }

    // This method prints a table with details from the team
    public String teamTable() {
        StringBuilder table_build = new StringBuilder();

        System.out.printf("%10s   |   %8s|   %-10s", "Name: ", "Test Kits: ", "Wage: ");
        System.out.println();
        System.out.println("-----------------------------------------");

        for (Volunteer v : team) {
            table_build.append(String.format("%10s   |   %8s   |   %-10s", v.getName(), v.getTest_kit(), v.formattedCurrency(v.calculateWages())));
            table_build.append("\n");
        }
        return table_build.toString();
    }

    public static void main(String[] args) {

        VolunteerTeam v2 = new VolunteerTeam();

        // Creating the volunteers ready to add to the team (the ArrayList we
        // have already created)
        Volunteer Sofya = new Volunteer("Sofya", 127, false);
        Volunteer Steve = new Volunteer("Steve", 46, false);
        Volunteer Muhammed = new Volunteer("Muhammed", 273, false);
        Volunteer Amara = new Volunteer("Amara", 12, false);
        Volunteer Ayub = new Volunteer("Ayub", 129, false);
        Volunteer Tony = new Volunteer("Tony", 17, true);

        try {
            Sofya.extraKits(13);
            Steve.extraKits(9);
            Muhammed.extraKits(27);
            Amara.extraKits(33);
            Ayub.extraKits(39);
            Tony.extraKits(106);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Now we are adding all the volunteers to the team.
        v2.addVolunteers(Sofya);
        v2.addVolunteers(Steve);
        v2.addVolunteers(Muhammed);
        v2.addVolunteers(Amara);
        v2.addVolunteers(Ayub);
        v2.addVolunteers(Tony);

        System.out.println("This is the unsorted table: ");
        System.out.println(v2.teamTable());

        System.out.println("This is the sorted table including extra kits delivered: ");
        Collections.sort(v2.team);
        System.out.println(v2.teamTable());

        System.out.println("The total wages for the entire team is: " + Volunteer.formattedCurrency(v2.getTotal_wage()));
        // Loops through team of volunteers adding the amount of v2 kits sold.
        int total_kits = 0;
        for (Volunteer v : v2.team) {
            total_kits += v.getTest_kit();
        }
        System.out.println("The total test kits sold by the entire team are: " + total_kits);
    }
}
