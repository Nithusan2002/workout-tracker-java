package src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDAO {

    // Legg til ny treningsøkt i databasen
    public void insertWorkout(Workout workout) {
        String sql = "INSERT INTO Workout (date, exercise, reps, weight) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(workout.getDate()));
            stmt.setString(2, workout.getExercise());
            stmt.setInt(3, workout.getReps());
            stmt.setInt(4, workout.getWeight());

            stmt.executeUpdate();
            System.out.println("✅ Treningsøkt lagt til!");

        } catch (SQLException e) {
            System.out.println("❌ Klarte ikke å legge til treningsøkt:");
            e.printStackTrace();
        }
    }

    // Hent alle treningsøkter fra databasen
    public List<Workout> getAllWorkouts() {
        List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT * FROM Workout ORDER BY date DESC";

        try (Connection conn = DatabaseConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Workout workout = new Workout(
                    rs.getDate("date").toLocalDate(),
                    rs.getString("exercise"),
                    rs.getInt("reps"),
                    rs.getInt("weight")
                );
                workouts.add(workout);
            }

        } catch (SQLException e) {
            System.out.println("❌ Klarte ikke å hente treningsøkter:");
            e.printStackTrace();
        }

        return workouts;
    }
}
