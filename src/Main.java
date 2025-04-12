package src;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final WorkoutDAO dao = new WorkoutDAO();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String valg = scanner.nextLine();

            switch (valg) {
                case "1" -> leggTilØkt();
                case "2" -> visAlleØkter();
                case "0" -> {
                    System.out.println("Avslutter...");
                    System.exit(0);
                }
                default -> System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Workout Tracker ===");
        System.out.println("1. Legg til ny treningsøkt");
        System.out.println("2. Vis alle treningsøkter");
        System.out.println("0. Avslutt");
        System.out.print("Ditt valg: ");
    }

    private static void leggTilØkt() {
        System.out.print("Dato (YYYY-MM-DD): ");
        LocalDate dato = LocalDate.parse(scanner.nextLine());

        System.out.print("Øvelse: ");
        String øvelse = scanner.nextLine();

        System.out.print("Antall reps: ");
        int reps = Integer.parseInt(scanner.nextLine());

        System.out.print("Vekt (kg): ");
        int vekt = Integer.parseInt(scanner.nextLine());

        Workout workout = new Workout(dato, øvelse, reps, vekt);
        dao.insertWorkout(workout);
    }

    private static void visAlleØkter() {
        List<Workout> økter = dao.getAllWorkouts();
        if (økter.isEmpty()) {
            System.out.println("Ingen økter funnet.");
        } else {
            for (Workout w : økter) {
                System.out.println(w);
            }
        }
    }
}
