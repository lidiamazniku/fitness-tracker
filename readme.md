# Fitness-Tracker-App

## Übersicht

Die **Fitness-Tracker-App** ist ein Java-App.  
Mit diesem Programm können Benutzer ihre **Trainingseinheiten speichern, anzeigen und filtern**.  
Das App hat eine **grafische Oberfläche (GUI)**, die mit **Java Swing** erstellt wurde.

---

## Funktionen

- **Neues Training hinzufügen**  
  Trainingsart, Kalorien, Dauer und Intensität eingeben und speichern.

- **Alle Trainings anzeigen**  
  Alle gespeicherten Trainings werden in einer Tabelle angezeigt.

- **Trainings filtern**  
  Trainings können nach der Trainingsart gefiltert werden (z. B. Laufen, Schwimmen).

- **Fehlerbehandlung**  
  Wenn falsche Eingaben gemacht werden (z. B. Buchstaben statt Zahlen), wird eine Fehlermeldung angezeigt.

- **Vordefinierte Trainings**  
  Beim Start werden bereits 3 Objekte automatisch erstellt.

---

## Technologien

- **Java**  
  Programmiersprache für Logik und Datenverarbeitung.

- **Java Swing**  
  Bibliothek für die grafische Benutzeroberfläche (Buttons, Felder, Tabellen).

- **XML (.form-Datei)**  
  Beschreibt das Layout der Oberfläche (erstellt durch die IDE).

- **Java Collections (ArrayList)**  
  Wird benutzt, um Trainings in einer Liste zu speichern.

---

## Projektstruktur
```
FitnessTracker/ 
├── src/ 
│ ├── FitnessTracker.java # Hauptklasse mit GUI und Logik 
│ ├── Training.java # Klasse für eine Trainingseinheit 
│ └── FitnessTracker.form # GUI-Layout 
└── README.md # Projektbeschreibung
```
---


## Benutzung

1. **Programm starten**
- Die Klasse `FitnessTracker` ausführen.

2. **Neues Training hinzufügen**
- Trainingsart auswählen
- Kalorien und Dauer eingeben
- Intensität auswählen
- Auf **Speichern** klicken

3. **Alle Trainings anzeigen**
- Auf **Alle Anzeigen** klicken

4. **Trainings filtern**
- Trainingsart im Filter auswählen
- Auf **Filter** klicken

5. **Fehlermeldungen**
- Bei falschen Eingaben erscheint eine Warnung (z. B. bei Text statt Zahlen)

---

## Code-Erklärung

### `FitnessTracker.java`

**Aufgaben:**

- Erstellt und verwaltet die grafische Oberfläche (GUI)
- Reagiert auf Benutzeraktionen (Button-Klicks)
- Speichert Trainings in einer `ArrayList`
- Zeigt Trainings in einer Tabelle an

**Wichtige Methoden:**

- `trainingSpeichern()`  
  Speichert ein neues Training aus den GUI-Eingaben.

- `initObjekte()`  
  Erstellt beim Start einige Trainingsobjekte.

- `updateTable(List<Training> data)`  
  Aktualisiert die Tabelle mit Trainingsdaten.

- `filterTabelle()`  
  Filtert Trainings nach Trainingsart.

- `showAll(List<Training> data)`  
  Zeigt alle Trainings in der Tabelle an.

---

### `Training.java`

**Aufgaben:**

- Repräsentiert eine einzelne Trainingseinheit
- Enthält Attribute:
- Trainingsart
- Kalorien
- Dauer
- Intensität
- Stellt Getter-Methoden zur Verfügung

---

### `FitnessTracker.form`

**Aufgaben:**

- Beschreibt das Layout der GUI
- Enthält Positionen und Eigenschaften der GUI-Komponenten
- Wird automatisch von der IDE erstellt

---

## App testen

1. **Unit-Tests**
- Getter der Klasse `Training` testen

2. **Manuelles Testen**
- Buttons ausprobieren
- Filter testen
- Falsche Eingaben prüfen

