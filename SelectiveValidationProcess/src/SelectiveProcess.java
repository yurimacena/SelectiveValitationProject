import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SelectiveProcess {
    public static void main(String[] args) throws Exception {
        String [] candidates = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for(String candidate: candidates) {
            enteringInContact(candidate);
        } 
    }

    static void enteringInContact (String candidate) {
        int attemptsRealized = 1;
        boolean keepTrying = true;
        boolean answered = false;
        do {
            answered = answer();
            keepTrying = !answered;
            if (keepTrying)
                attemptsRealized++;
            else
                System.out.println("Contact made successfully.");
        } while (keepTrying && attemptsRealized < 3);

        if (answered)
            System.out.println("We did contact with " + candidate + " in " + attemptsRealized + " attempt");
        else
            System.out.println("We don't did contact with " + candidate + ", maximum number attempts " + attemptsRealized);
        
    }

    static boolean answer() {
        return new Random().nextInt(3) == 1;
    }

    static void printSelected() {
        String [] candidates = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Printing the candidates list, informing the element index");

        for (int index=0 ; index < candidates.length ; index++) {
            System.out.println("The candidate of number " + (index+1) + " is " + candidates[index]);
        }

        System.out.println("Abbreviated form of for each interaction");

        for (String candidate: candidates) {
            System.out.println("The selected candidate was: " + candidate);
        }
    }

    static void candidatesSelection() {
        String [] candidates = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "ALBERTO", "JOÃO", "GUSTAVO", "VAGNER"};
        int selectedCandidates = 0;
        int actualCandidates = 0;
        double baseSalary = 2000.0;
        while (selectedCandidates < 5 && actualCandidates < candidates.length) {
            String candidate = candidates[actualCandidates];
            double desiredSalary = desiredValue();

            System.out.println("The candidate " + candidate + " solicited these salary value: " + desiredSalary);
            if(baseSalary >= desiredSalary) {
                System.out.println("The candidate " + candidate + " was selected for the job.");
                selectedCandidates++;
            }
            actualCandidates++;
        }
    }

    static double desiredValue() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analyzeCandidate(double desiredSalary) {
        double baseSalary = 2000.0;
        if (baseSalary > desiredSalary) {
            System.out.println("Call to candidate");
        } else if (baseSalary == desiredSalary) {
            System.out.println("Call to candidate with another offer");
        } else {
            System.out.println("Waiting the result of others candidates");
        }
    }
}
