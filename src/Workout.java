package src;

import java.time.LocalDate;

public class Workout {
    private LocalDate date; 
    private String excercise;
    private int reps;
    private int weight;

    public Workout(LocalDate date, String exercise, int reps, int weight) {
          this.date = date;
          this.exercise = exercise;
          this.reps = reps;
          this.weight = weight;
      }
  
    public LocalDate getDate() {
        return date;
    }

    public String getExercise() {
        return exercise;
    }

    public int getReps() {
        return reps;
    }

    public int getWeight() {
        return weight;
    }

    // Settere (hvis du trenger det senere)
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "date=" + date +
                ", exercise='" + exercise + '\'' +
                ", reps=" + reps +
                ", weight=" + weight +
                '}';
    }
  
}
