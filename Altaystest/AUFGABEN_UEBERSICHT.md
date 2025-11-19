# 📚 Notendurchschnitt-Rechner — Aufgaben-Übersicht

Diese Anleitung führt dich Schritt für Schritt durch die Implementierung eines Notendurchschnitt-Rechners mit Spring Boot.

---

## 🎯 Was du lernen wirst

- **Backend (Java/Spring Boot)**: REST-API, Controller, DTOs
- **Frontend (HTML/CSS/JavaScript)**: Benutzeroberfläche, HTTP-Anfragen
- **Architektur**: Wie Frontend und Backend zusammenarbeiten

---

## 📁 Dateien im Projekt

### ✅ Fertig (keine Änderungen nötig)
- `AltaystestApplication.java` — Startet die Anwendung

### ✏️ Zu bearbeiten (enthalten Aufgaben)
1. `GradeRequest.java` — DTO für eingehende Noten
2. `GradeResponse.java` — DTO für Berechnungsergebnis
3. `AltaysController.java` — REST-Endpunkt für Berechnung
4. `index.html` — Benutzeroberfläche
5. `styles.css` — Design/Layout

---

## 🗓️ Empfohlene Reihenfolge

### Phase 1: Backend (Java) — 30-45 Min.

#### Schritt 1: GradeRequest.java (4 Aufgaben)
**Warum zuerst?** Der Controller braucht diese Klasse, um Daten zu empfangen.

- [ x] Aufgabe 1: Feld `grades` (List<Double>)
- [ x] Aufgabe 2: Leerer Konstruktor
- [ x] Aufgabe 3: Getter `getGrades()`
- [ x] Aufgabe 4: Setter `setGrades(List<Double>)`

#### Schritt 2: GradeResponse.java (5 Aufgaben)
**Warum jetzt?** Der Controller braucht diese Klasse, um Ergebnisse zurückzugeben.

- [ x] Aufgabe 1: Felder (average, count, interpretation)
- [ x] Aufgabe 2: Leerer Konstruktor
- [ x] Aufgabe 3: Konstruktor mit Parametern
- [ x] Aufgabe 4: Drei Getter
- [ x] Aufgabe 5: Drei Setter

#### Schritt 3: AltaysController.java (7 Aufgaben)
**Warum zuletzt (Backend)?** Hier kommt alles zusammen: DTOs werden genutzt, Logik wird implementiert.

- [ ] Aufgabe 1: Endpunkt-Annotation (@PostMapping, @ResponseBody)
- [ ] Aufgabe 2: Noten aus Request holen
- [ ] Aufgabe 3: Validierung (leere Liste prüfen)
- [ ] Aufgabe 4: Summe berechnen (for-Schleife)
- [ ] Aufgabe 5: Durchschnitt berechnen
- [ ] Aufgabe 6: Interpretation aufrufen (interpretGermanGrade)
- [ ] Aufgabe 7: Response zurückgeben

**✅ TEST:** Nach Schritt 3 kannst du das Backend testen:
```bash
cd Altaystest
./mvnw spring-boot:run
```
Dann mit curl testen (in neuem Terminal-Tab):
```bash
curl -X POST http://localhost:8080/grades/average \
  -H "Content-Type: application/json" \
  -d '{"grades": [1.0, 2.3, 1.7]}'
```
Erwartete Antwort: `{"average":1.67,"count":3,"interpretation":"Sehr gut"}`

---

### Phase 2: Frontend (HTML/CSS/JS) — 30-45 Min.

#### Schritt 4: styles.css (9 Aufgaben)
**Warum zuerst?** Styling ist unabhängig von Logik, du siehst sofort visuelle Ergebnisse.

- [ ] Aufgabe 1: CSS-Variablen (Farben)
- [ ] Aufgabe 2: Box-sizing
- [ ] Aufgabe 3: Body-Styling
- [ ] Aufgabe 4: Container
- [ ] Aufgabe 5: h1-Überschrift
- [ ] Aufgabe 6: Input-Feld
- [ ] Aufgabe 7: Button
- [ ] Aufgabe 8: Ergebnis-Bereich
- [ ] Aufgabe 9: Hidden-Klasse

**💡 TIPP:** Öffne `http://localhost:8080/` im Browser und aktualisiere nach jeder CSS-Änderung mit F5.

#### Schritt 5: index.html (6 Aufgaben im JavaScript-Teil)
**Warum zuletzt?** Hier verbindest du Frontend mit Backend (fetch-API).

- [ ] Aufgabe 1: Click-Listener hinzufügen
- [ ] Aufgabe 2: fetch() zum Server senden
- [ ] Aufgabe 3: Fehlerprüfung (response.ok)
- [ ] Aufgabe 4: JSON-Antwort parsen
- [ ] Aufgabe 5: Ergebnis anzeigen
- [ ] Aufgabe 6: Fehler im catch-Block behandeln

**✅ FINAL-TEST:** Nach Schritt 5:
1. Öffne `http://localhost:8080/`
2. Gib Noten ein: `1.0, 2.3, 1.7`
3. Klicke "Durchschnitt berechnen"
4. Ergebnis sollte erscheinen: "Durchschnitt: 1.67, Einschätzung: Sehr gut"

---

## 🔗 Wie die Dateien zusammenhängen

```
┌─────────────────────────────────────────────────────────────────┐
│ BROWSER (http://localhost:8080/)                                │
│ ┌─────────────┐     ┌──────────────┐                            │
│ │ index.html  │────>│ styles.css   │ (Aussehen)                 │
│ │ (Struktur)  │     └──────────────┘                            │
│ └─────────────┘                                                 │
│       │ fetch('/calculate-average', { grades: [1.0, 2.3] })     │
└───────┼─────────────────────────────────────────────────────────┘
        │
        ▼ HTTP POST
┌─────────────────────────────────────────────────────────────────┐
│ SPRING BOOT SERVER (Port 8080)                                  │
│ ┌─────────────────────────┐                                     │
│ │ AltaystestApplication   │ (startet Server)                    │
│ └─────────────────────────┘                                     │
│           │                                                      │
│           ▼                                                      │
│ ┌─────────────────────────┐                                     │
│ │ AltaysController        │ (empfängt Anfrage)                  │
│ │ @PostMapping            │                                     │
│ └─────────────────────────┘                                     │
│     │               │                                            │
│     ▼               ▼                                            │
│ ┌──────────┐  ┌──────────┐                                      │
│ │GradeReq  │  │GradeResp │ (Datenstruktur)                     │
│ └──────────┘  └──────────┘                                      │
│                     │                                            │
│                     ▼ JSON: {"average": 1.67, ...}              │
└─────────────────────┼─────────────────────────────────────────┘
                      │
                      ▼ HTTP Response
              Browser zeigt Ergebnis an
```

---

## 🚀 Starten der Anwendung

### ⚠️ WICHTIG: Repository erst klonen!
Wenn du das Projekt in VS Code als Remote-Repository geöffnet hast:
1. Öffne Terminal in VS Code (`Strg+ö` oder `View → Terminal`)
2. Klone das Repository lokal:
   ```bash
   cd ~/Desktop  # oder ein anderes Verzeichnis
   git clone https://github.com/pollo60/WebAnw-Projekt.git
   cd WebAnw-Projekt
   ```
3. Öffne den geklonten Ordner in VS Code: `File → Open Folder → WebAnw-Projekt`

### Option 1: Mit Maven Wrapper (Terminal)
```bash
cd Altaystest
./mvnw spring-boot:run
```
**Auf macOS/Linux:** Falls "Permission denied":
```bash
chmod +x mvnw
./mvnw spring-boot:run
```

### Option 2: Mit IDE (z. B. VS Code mit Java Extension Pack)
1. Öffne `AltaystestApplication.java`
2. Klicke auf "Run" über der `main`-Methode

### Anwendung öffnen
- Hauptseite: http://localhost:8080/
- Test-Endpunkt: http://localhost:8080/altaystest (sollte "Hello World" zeigen)

---

## 💡 Tipps zum Lernen

### Wenn du nicht weiterkommst
1. Lies die Kommentare in der Datei nochmal genau
2. Schau dir die Beispiele in den Kommentaren an
3. Versuche, den Code Zeile für Zeile zu verstehen
4. Teste nach jeder Aufgabe (z. B. mit curl oder im Browser)

### Debugging
- **Java-Fehler:** Schau in die Konsole (Terminal), dort stehen Fehlermeldungen
- **JavaScript-Fehler:** Öffne Browser-DevTools (F12) → Console
- **CSS wirkt nicht:** Prüfe, ob Syntax korrekt ist (z. B. Semikolon am Ende)

### Erweiterungsideen (nach Fertigstellung)
- Gewichtete Noten (z. B. Klausur zählt doppelt)
- Speicherung in Datenbank (Spring Data JPA)
- Login-System für mehrere Benutzer
- Responsive Design verbessern
- Tests schreiben (JUnit, Spring Boot Test)

---

## ✅ Checkliste: Bin ich fertig?

- [ ] Backend kompiliert ohne Fehler
- [ ] Server startet auf Port 8080
- [ ] `/altaystest` zeigt "Hello World"
- [ ] `/calculate-average` antwortet auf POST-Requests
- [ ] Frontend lädt unter `http://localhost:8080/`
- [ ] CSS wird angewendet (Seite sieht gestylt aus)
- [ ] Noten können eingegeben werden
- [ ] Button "Durchschnitt berechnen" funktioniert
- [ ] Ergebnis wird korrekt angezeigt
- [ ] Fehlerfälle werden behandelt (z. B. keine Noten eingegeben)

---

## 📖 Weiterführende Ressourcen

- **Spring Boot Docs:** https://spring.io/projects/spring-boot
- **MDN Web Docs (HTML/CSS/JS):** https://developer.mozilla.org/
- **fetch API:** https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API
- **CSS Flexbox:** https://css-tricks.com/snippets/css/a-guide-to-flexbox/

---

**Viel Erfolg! 🎓**
