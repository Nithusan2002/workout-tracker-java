package src;

import java.time.LocalDate;
import java.util.List;

public class TestDAO {
    public static void main(String[] args) {
        WorkoutDAO dao = new WorkoutDAO();

        // Legg til en økt
        Workout workout = new Workout(LocalDate.now(), "Markløft", 5, 120);
        dao.insertWorkout(workout);

        // Hent og skriv ut alle økter
        List<Workout> økter = dao.getAllWorkouts();
        for (Workout w : økter) {
            System.out.println(w);
        }
    }
}
