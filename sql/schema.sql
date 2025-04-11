CREATE TABLE Workout (
    id INT IDENTITY(1,1) PRIMARY KEY,
    date DATE NOT NULL,
    exercise NVARCHAR(100) NOT NULL,
    reps INT,
    weight INT
);
