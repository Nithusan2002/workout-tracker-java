# 🏋️ Workout Tracker Java

Et enkelt backend-prosjekt i Java som lar deg registrere og hente treningsøkter direkte fra en **Azure SQL Database**. Perfekt for å lære deg sky, databaser og Java backend.

---

## 🚀 Funksjoner
- Legg til nye treningsøkter
- Vis alle registrerte økter
- Lagret i skyen (Azure SQL Database)
- Bruker objektorientert design med DAO

---

## 🧱 Teknologi

| Del | Teknologi |
|-----|-----------|
| ☕ Backend | Java + JDBC |
| ☁️ Database | Azure SQL |
| 🛠️ Bygging | Kommandolinje / Gradle (valgfritt) |
| 📦 Driver | Microsoft JDBC for SQL Server |

---

## 🗂️ Prosjektstruktur

```
workout-tracker-java/
├── src/
│   ├── Main.java               # Meny og brukergrensesnitt i terminalen
│   ├── Workout.java            # Treningsøkt-modellen
│   ├── WorkoutDAO.java         # Snakker med databasen (insert + select)
│   ├── DatabaseConnector.java  # JDBC-tilkobling til Azure SQL
│   └── TestDAO.java            # Tidlig testfil for DAO-funksjoner
├── sql/
│   └── schema.sql              # SQL for å opprette Workout-tabellen
├── lib/
│   └── mssql-jdbc-12.10.0.jre11.jar # Microsoft JDBC-driver
├── out/                        # Kompilerte .class-filer
├── .gitignore
├── LICENSE
└── README.md (denne)
```

---

## ☁️ Oppsett i Azure SQL

1. Opprett Azure SQL Database (`workoutdb`) og SQL-server (`nithusan-server`)
2. Aktiver SQL Authentication (ikke kun Entra ID)
3. Lag bruker/passord som du setter inn i `DatabaseConnector.java`
4. Kjør `sql/schema.sql` i Azure Portal → Query Editor:
```sql
CREATE TABLE Workout (
  id INT IDENTITY(1,1) PRIMARY KEY,
  date DATE NOT NULL,
  exercise NVARCHAR(100) NOT NULL,
  reps INT,
  weight INT
);
```

---

## ⚙️ Kjøre prosjektet (manuelt)

### 🔹 Kompiler:
```bash
javac -cp "lib/mssql-jdbc-12.10.0.jre11.jar" -d out src/*.java
```

### 🔹 Kjør programmet:
```bash
java -cp "out:lib/mssql-jdbc-12.10.0.jre11.jar" src.Main
```

---

## 📋 Eksempel på bruk
```
=== Workout Tracker ===
1. Legg til ny treningsøkt
2. Vis alle treningsøkter
0. Avslutt
Ditt valg: 1

Dato (YYYY-MM-DD): 2025-04-12
Øvelse: Knebøy
Antall reps: 8
Vekt (kg): 90
✅ Treningsøkt lagt til!
```

---

## 📌 Videre ideer
- Statistikk: Total vekt løftet per øvelse
- Lagre brukere og innlogging
- Lag REST-API eller enkel web-app med frontend

---

[📎 LinkedIn-profil](https://www.linkedin.com/in/nithusan-k/)

---

## 🪪 Lisens
MIT License – fritt å bruke, endre og dele ✌️
