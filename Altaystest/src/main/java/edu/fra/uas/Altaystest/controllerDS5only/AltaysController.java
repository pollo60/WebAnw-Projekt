package edu.fra.uas.Altaystest.controllerDS5only;

/** ╔══════════════════════════════════════════════════════════════════════════╗
 *  ║  📘 SPRING FRAMEWORK & WEB-MVC (Übung 2)                                 ║
 *  ║                                                                          ║
 *  ║  Web‑MVC‑Typen sind die Komponenten des Model‑View‑Controller‑Musters:   ║
 *  ║  • DispatcherServlet: Empfängt alle HTTP-Requests                        ║
 *  ║  • HandlerMapping: Sucht den richtigen Controller für die URL            ║
 *  ║  • Controller: Verarbeitet die Anfrage (diese Datei!)                    ║
 *  ║  • Model: Daten (GradeRequest/GradeResponse)                             ║
 *  ║  • ViewResolver: Sucht die passende View (bei REST: JSON)                ║
 *  ╚══════════════════════════════════════════════════════════════════════════╝ */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import edu.fra.uas.Altaystest.model.GradeRequest;
import edu.fra.uas.Altaystest.model.GradeResponse;
import edu.fra.uas.Altaystest.model.QuizRequest;
import edu.fra.uas.Altaystest.model.QuizResponse;

import java.util.List;

/** ╔══════════════════════════════════════════════════════════════════════════╗
 *  ║  DATEI: AltaysController.java                                            ║
 *  ║  ZWECK: HTTP-Endpunkte (URLs) definieren und Anfragen bearbeiten         ║
 *  ║                                                                          ║
 *  ║  📘 BEZUG ZU DEN ÜBUNGSBLÄTTERN:                                         ║
 *  ║                                                                          ║
 *  ║  ÜBUNG 2 (MVC) — CONTROLLER IM MVC-DATENFLUSS:                          ║
 *  ║  1. Client sendet HTTP-Request → DispatcherServlet                      ║
 *  ║  2. DispatcherServlet fragt HandlerMapping: Welcher Controller?         ║
 *  ║  3. HandlerMapping antwortet: AltaysController.calculateAverage()       ║
 *  ║  4. Controller verarbeitet Logik (DIESE DATEI!)                         ║
 *  ║  5. Controller befüllt Model (GradeResponse)                            ║
 *  ║  6. ViewResolver rendert Response (JSON via Jackson)                    ║
 *  ║  7. Response geht zurück an Client                                      ║
 *  ║                                                                          ║
 *  ║  ÜBUNG 3 (Exception Handling):                                           ║
 *  ║  → Bei fehlenden Parametern/Validierungsfehlern werfen wir Exceptions   ║
 *  ║  → Diese könnten zentral mit @ControllerAdvice abgefangen werden        ║
 *  ║                                                                          ║
 *  ║  ÜBUNG 4 (REST API):                                                     ║
 *  ║  → Endpunkte folgen REST-Prinzipien (keine Verben in URL!)              ║
 *  ║  → HTTP-Methoden: POST für Berechnungen (erstellt Ressource)            ║
 *  ║  → Statuscodes: 200 OK (Erfolg), 400 Bad Request (Fehler)               ║
 *  ║  → JSON als Repräsentation (via @ResponseBody + Jackson)                ║
 *  ║                                                                          ║
 *  ║  WARUM BRAUCHST DU DIESE DATEI?                                          ║
 *  ║  Der Controller ist das "Gehirn" der Web-Anwendung. Er empfängt         ║
 *  ║  HTTP-Requests, führt Berechnungen durch und sendet Antworten zurück.   ║
 *  ╚══════════════════════════════════════════════════════════════════════════╝ */

@Controller // Stereotype-Annotation: Spring registriert diese Klasse als MVC-Controller
public class AltaysController {

    // ════════════════════════════════════════════════════════════════════════
    //  ENDPUNKT 1: Test-Endpunkt (schon vorhanden, zum Testen)
    // ════════════════════════════════════════════════════════════════════════

    @RequestMapping(value = "/altaystest", method = RequestMethod.GET)
    @ResponseBody
    public String getHelloWorld() {
        return "<h1> Hello World from AltaysTestApplication </h1>";
    }

    // ════════════════════════════════════════════════════════════════════════
    //  ENDPUNKT 2: Notendurchschnitt berechnen (DEINE AUFGABE)
    // ════════════════════════════════════════════════════════════════════════

    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ 📘 ÜBUNG 4 — AUFGABE: REST-API ENTWERFEN                            │
    // │                                                                     │
    // │ a) Ressourcen identifizieren:                                      │
    // │    → "grades/average" ist die Ressource (Substantiv!)              │
    // │    → Nicht: "/calculate-average" (Verb ist verboten in REST!)      │
    // │                                                                     │
    // │ b) HTTP-Methoden zuordnen:                                         │
    // │    → POST: Berechnung erstellen (erzeugt eine neue Ressource)      │
    // │    → Nicht GET: GET sollte keine Daten verändern/berechnen         │
    // │                                                                     │
    // │ c) Darstellung definieren:                                         │
    // │    → Request: {"grades": [1.0, 2.3, 1.7]}                          │
    // │    → Response: {"average": 1.67, "count": 3, ...}                  │
    // │                                                                     │
    // │ d) Statuscodes:                                                    │
    // │    → 200 OK: Berechnung erfolgreich                                │
    // │    → 400 Bad Request: Keine Noten oder ungültige Daten            │
    // └─────────────────────────────────────────────────────────────────────┘

    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 1: Erstelle einen POST-Endpunkt /grades/average             │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 2 (MVC):                                       │
    // │ → Diese Methode ist der "Handler" für die URL /grades/average      │
    // │ → HandlerMapping findet diese Methode basierend auf @PostMapping   │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 4 (REST):                                      │
    // │ → POST-Methode für Operationen, die eine Ressource erstellen       │
    // │ → @RequestBody: Spring konvertiert JSON → GradeRequest-Objekt      │
    // │ → @ResponseBody: Spring konvertiert GradeResponse → JSON           │
    // │                                                                     │
    // │ SCHRITTE:                                                           │
    // │ 1. Schreibe: @PostMapping("/grades/average")                       │
    // │ 2. Schreibe: @ResponseBody                                         │
    // │ 3. Erstelle Methode: public GradeResponse calculateAverage(...)    │
    // │ 4. Parameter: @RequestBody GradeRequest request                    │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ @PostMapping("/grades/average")                                     │
    // │ @ResponseBody                                                       │
    // │ public GradeResponse calculateAverage(                              │
    // │         @RequestBody GradeRequest request) {                        │
    // │     // hier kommt dein Code (Aufgaben 2-7)                          │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN ENDPUNKT (Zeile ca. 133):

    @PostMapping("/grades/average")
    @ResponseBody
    public GradeResponse calculateAverage(
        @RequestBody GradeRequest request) {



        // ┌─────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 2: Hole die Notenliste aus dem Request-Objekt           │
        // │                                                                 │
        // │ 📘 KONZEPT AUS ÜBUNG 2 (MVC — Model):                           │
        // │ → Das Request-Objekt ist das "Model", das Daten vom Client     │
        // │   zum Controller transportiert                                 │
        // │                                                                 │
        // │ HINWEIS:                                                        │
        // │ Das request-Objekt hat eine Methode getGrades(), die eine      │
        // │ Liste von Noten zurückgibt (hast du in GradeRequest erstellt). │
        // │                                                                 │
        // │ BEISPIEL:                                                       │
        // │ List<Double> grades = request.getGrades();                     │
        // └─────────────────────────────────────────────────────────────────┘

        // SCHREIBE HIER DEN CODE ZUM HOLEN DER NOTEN (Zeile ca. 158):

         List<Double> grades = request.getGrades();



        // ┌─────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 3: Prüfe, ob die Liste leer oder null ist               │
        // │                                                                 │
        // │ 📘 KONZEPT AUS ÜBUNG 3 (Exception Handling):                    │
        // │ → Validierung von Request-Parametern                           │
        // │ → Bei fehlendem/ungültigem Input: Fehler zurückgeben           │
        // │ → Später könntest du hier eine Exception werfen, die mit       │
        // │   @ControllerAdvice zentral abgefangen wird                    │
        // │                                                                 │
        // │ 📘 KONZEPT AUS ÜBUNG 4 (REST — Statuscodes):                    │
        // │ → Bei Validierungsfehler sollte HTTP 400 Bad Request kommen    │
        // │ → Wir geben hier ein Response-Objekt mit Fehlermeldung zurück  │
        // │   (Spring setzt automatisch Status 200, aber Nachricht zeigt   │
        // │    den Fehler)                                                 │
        // │                                                                 │
        // │ BEISPIEL:                                                       │
        // │ if (grades == null || grades.isEmpty()) {                      │
        // │     return new GradeResponse(0.0, 0, "Keine Noten vorhanden"); │
        // │ }                                                               │
        // │                                                                 │
        // │ HINWEIS FÜR SPÄTER (Übung 3 Hausaufgabe):                      │
        // │ Bessere Lösung wäre:                                           │
        // │ throw new MissingServletRequestParameterException(...);        │
        // │ → Wird von @ControllerAdvice abgefangen                        │
        // │ → Gibt automatisch HTTP 400 zurück                             │
        // └─────────────────────────────────────────────────────────────────┘

        // SCHREIBE HIER DIE VALIDIERUNG (Zeile ca. 192):

        if (grades == null || grades.isEmpty()) {
            return new GradeResponse(0.0, 0, "Keine Noten vorhanden");
        }


        // ┌─────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 4: Berechne die Summe aller Noten                       │
        // │                                                                 │
        // │ 📘 KONZEPT AUS ÜBUNG 1 (JavaScript/Logik):                      │
        // │ → Dies ist die Business-Logik (ähnlich wie JS im Browser)      │
        // │ → Unterschied: Hier läuft sie auf dem Server (Java)            │
        // │                                                                 │
        // │ SCHRITTE:                                                       │
        // │ 1. Erstelle Variable "sum" (Typ: double) mit Wert 0.0          │
        // │ 2. Schreibe eine for-Schleife über alle Noten                  │
        // │ 3. Addiere jede Note zur Summe                                 │
        // │                                                                 │
        // │ BEISPIEL:                                                       │
        // │ double sum = 0.0;                                               │
        // │ for (Double grade : grades) {                                  │
        // │     if (grade != null) {                                       │
        // │         sum += grade;  // sum = sum + grade                   │
        // │     }                                                           │
        // │ }                                                               │
        // └─────────────────────────────────────────────────────────────────┘

        // SCHREIBE HIER DIE SUMMENBERECHNUNG (Zeile ca. 223):

        double sum = 0.0;
        for (Double grade : grades) {
            if (grade != null) {
                sum += grade;
            }
        }


        // ┌─────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 5: Berechne den Durchschnitt                            │
        // │                                                                 │
        // │ FORMEL:                                                         │
        // │ Durchschnitt = Summe / Anzahl der Noten                        │
        // │                                                                 │
        // │ BEISPIEL:                                                       │
        // │ double average = sum / grades.size();                          │
        // │                                                                 │
        // │ BONUS: Runde auf 2 Nachkommastellen (optional):                │
        // │ average = Math.round(average * 100.0) / 100.0;                 │
        // └─────────────────────────────────────────────────────────────────┘

        // SCHREIBE HIER DIE DURCHSCHNITTSBERECHNUNG (Zeile ca. 243):

        double average = sum / grades.size();
        average = Math.round(average * 100.0) / 100.0;


        // ┌──────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 6: Interpretiere die Note (rufe Hilfsmethode auf)       │
        // │                                                                  │
        // │ HINWEIS:                                                         │
        // │ Unten gibt es eine Methode interpretGermanGrade(double avg),    │
        // │ die eine Durchschnittsnote als Text zurückgibt (z. B. "Gut").   │
        // │                                                                  │
        // │ BEISPIEL:                                                        │
        // │ String interpretation = interpretGermanGrade(average);          │
        // └──────────────────────────────────────────────────────────────────┘

        // SCHREIBE HIER DEN AUFRUF DER HILFSMETHODE (Zeile ca. 259):

        String interpretation = interpretGermanGrade(average);


        // ┌──────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 7: Erstelle und gib das Response-Objekt zurück          │
        // │                                                                  │
        // │ 📘 KONZEPT AUS ÜBUNG 2 (MVC — Model):                            │
        // │ → Das Response-Objekt ist das "Model", das vom Controller an    │
        // │   den View übergeben wird                                       │
        // │ → Bei REST: View = JSON (via Jackson-Serialisierung)            │
        // │                                                                  │
        // │ 📘 KONZEPT AUS ÜBUNG 4 (REST — Darstellung):                     │
        // │ → GradeResponse definiert die Struktur der JSON-Antwort         │
        // │ → Jackson ruft Getter auf → baut JSON                           │
        // │                                                                  │
        // │ SCHRITTE:                                                        │
        // │ 1. Erstelle neues GradeResponse-Objekt                          │
        // │ 2. Übergebe: average, grades.size(), interpretation             │
        // │ 3. Gib es mit "return" zurück                                   │
        // │                                                                  │
        // │ BEISPIEL:                                                        │
        // │ return new GradeResponse(average, grades.size(),                │
        // │                          interpretation);                       │
        // │                                                                  │
        // │ WAS PASSIERT DANACH? (MVC-Datenfluss aus Übung 2):              │
        // │ 1. Controller gibt GradeResponse zurück                         │
        // │ 2. Spring/Jackson serialisiert zu JSON                          │
        // │ 3. HTTP-Response mit Status 200 OK + JSON-Body                  │
        // │ 4. Browser empfängt JSON                                        │
        // └──────────────────────────────────────────────────────────────────┘

        // SCHREIBE HIER DAS RETURN-STATEMENT (Zeile ca. 293):

        return new GradeResponse(average, grades.size(), interpretation);


    } // Ende calculateAverage (schließende Klammer der Methode)


    // ════════════════════════════════════════════════════════════════════════
    //  HILFSMETHODE: Note interpretieren (schon implementiert)
    // ════════════════════════════════════════════════════════════════════════

    /**
     * Interpretiert eine Durchschnittsnote nach deutschem Notensystem.
     * 
     * @param avg Durchschnittsnote (z. B. 1.67)
     * @return Textuelle Einschätzung (z. B. "Sehr gut")
     */
    private String interpretGermanGrade(double avg) {
        if (avg <= 1.5) return "Sehr gut";
        if (avg <= 2.5) return "Gut";
        if (avg <= 3.5) return "Befriedigend";
        if (avg <= 4.5) return "Ausreichend";
        return "Nicht bestanden / Mangelhaft";
    }


    // ════════════════════════════════════════════════════════════════════════
    //  ENDPUNKT 3: QUIZ-BONUS BERECHNEN (DEINE NEUE AUFGABE!)
    // ════════════════════════════════════════════════════════════════════════

    /*
     * ==========================================================================================
     * AUFGABE 8: ERSTELLE EINEN ZWEITEN REST-ENDPUNKT FÜR QUIZ-BONUS-BERECHNUNG
     * ==========================================================================================
     * 
     * 📘 KONTEXT (Übung 4: REST API Design):
     * Du hast bereits einen Endpunkt für Notendurchschnitte. Jetzt erweiterst du die API
     * um eine zweite, unabhängige Ressource: Quiz-Bonuspunkte.
     * 
     * Dies demonstriert:
     * - Eine API kann mehrere Endpunkte/Ressourcen haben
     * - Jeder Endpunkt folgt denselben REST-Prinzipien
     * - Wiederverwendung des Controller-Patterns
     * 
     * --------------------------------------------------------------------------------
     * DEINE AUFGABE:
     * --------------------------------------------------------------------------------
     * Erstelle eine neue Methode mit folgenden Spezifikationen:
     * 
     * 1. METHODEN-SIGNATUR:
     *    @PostMapping("/quizzes/bonus")
     *    @ResponseBody
     *    public QuizResponse calculateQuizBonus(@RequestBody QuizRequest request)
     * 
     * 2. VALIDIERUNG (analog zu calculateAverage):
     *    - Prüfe: request == null → Fehler werfen
     *    - Prüfe: request.getQuizPercentages() == null → Fehler werfen
     *    - Prüfe: Liste ist leer → Fehler werfen
     *    
     *    Beispiel:
     *    if (request == null || request.getQuizPercentages() == null 
     *        || request.getQuizPercentages().isEmpty()) {
     *        throw new IllegalArgumentException("Keine Quiz-Daten vorhanden!");
     *    }
     * 
     * 3. DURCHSCHNITTSBERECHNUNG:
     *    - Hole Liste: List<Double> percentages = request.getQuizPercentages();
     *    - Berechne Durchschnitt (analog zu Notenberechnung):
     *      double sum = 0.0;
     *      for (Double p : percentages) {
     *          sum += p;
     *      }
     *      double average = sum / percentages.size();
     * 
     * 4. BONUSPUNKTE-LOGIK:
     *    double bonusPoints;
     *    String interpretation;
     *    
     *    if (average >= 80.0) {
     *        bonusPoints = 0.7;
     *        interpretation = "Exzellent! Du bekommst 0.7 Bonuspunkte. " +
     *                         "Deine Note verbessert sich um 0.7 (z.B. von 2.0 auf 1.3).";
     *    } else if (average >= 50.0) {
     *        bonusPoints = 0.3;
     *        interpretation = "Gut! Du bekommst 0.3 Bonuspunkte. " +
     *                         "Deine Note verbessert sich um 0.3 (z.B. von 2.0 auf 1.7).";
     *    } else {
     *        bonusPoints = 0.0;
     *        interpretation = "Leider kein Bonus. Versuche mindestens 50% zu erreichen.";
     *    }
     * 
     *    WICHTIG: Bonuspunkte werden von der Note ABGEZOGEN (kleinere Zahl = besser)!
     *    Die Berechnung im Frontend erfolgt dann: endNote = ursprünglicheNote - bonusPoints
     * 
     * 5. RESPONSE ERSTELLEN UND ZURÜCKGEBEN:
     *    return new QuizResponse(average, bonusPoints, percentages.size(), interpretation);
     * 
     * --------------------------------------------------------------------------------
     * BEISPIEL REQUEST (von Frontend gesendet):
     * --------------------------------------------------------------------------------
     * POST http://localhost:8080/quizzes/bonus
     * Content-Type: application/json
     * 
     * {
     *   "quizPercentages": [85.0, 90.5, 78.0, 88.0, 92.0, 75.0, 80.0, 87.5, 83.0]
     * }
     * 
     * --------------------------------------------------------------------------------
     * BEISPIEL RESPONSE (von Server zurückgegeben):
     * --------------------------------------------------------------------------------
     * HTTP/1.1 200 OK
     * Content-Type: application/json
     * 
     * {
     *   "averagePercentage": 84.3,
     *   "bonusPoints": 0.7,
     *   "quizCount": 9,
     *   "interpretation": "Exzellent! Du bekommst 0.7 Bonuspunkte auf deine Gesamtnote."
     * }
     * 
     * --------------------------------------------------------------------------------
     * 📘 LEARNING GOALS (Bezug zu Übungen):
     * --------------------------------------------------------------------------------
     * ✓ Übung 2 (MVC): Controller verarbeitet zweite Ressource mit gleichem Pattern
     * ✓ Übung 3 (Exception Handling): Validierung mit IllegalArgumentException
     * ✓ Übung 4 (REST): 
     *   - Zweiter POST-Endpunkt mit eigenem URL-Pfad
     *   - Separate Request/Response-DTOs pro Ressource
     *   - Konsistente API-Struktur
     * ✓ Übung 4 (REST - Statuscodes):
     *   - 200 OK bei erfolgreicher Berechnung
     *   - 400 Bad Request bei fehlenden/ungültigen Daten
     * 
     * ==========================================================================================
     */

    // SCHREIBE HIER DEINE calculateQuizBonus-METHODE:

    @PostMapping("/quizzes/bonus")
    @ResponseBody
    public QuizResponse calculateQuizBonus(@RequestBody QuizRequest request) {
        
        List<Double> percentages = request.getQuizPercentages();

        if (request == null || percentages == null || percentages.isEmpty()) {
            throw new IllegalArgumentException("Keine Quiz-Daten vorhanden!");
        }

        double sum = 0.0;
        for (Double p : percentages) {
            sum += p;
        }
        double average = sum / percentages.size();

        double bonusPoints;
        String interpretation;

        if (average >= 80.0) {
            bonusPoints = 0.7;
            interpretation = "Exzellent! Du bekommst 0.7 Bonuspunkte. " +
                             "Deine Note verbessert sich um 0.7 (z.B. von 2.0 auf 1.3).";
        } else if (average >= 50.0) {
            bonusPoints = 0.3;
            interpretation = "Gut! Du bekommst 0.3 Bonuspunkte. " +
                             "Deine Note verbessert sich um 0.3 (z.B. von 2.0 auf 1.7).";
        } else {
            bonusPoints = 0.0;
            interpretation = "Leider kein Bonus. Versuche mindestens 50% zu erreichen.";
        }

        return new QuizResponse(average, bonusPoints, percentages.size(), interpretation);
    }


} // Ende AltaysController

/** ════════════════════════════════════════════════════════════════════════
 *  💡 LERNZIEL DIESER DATEI (Bezug zu Hausaufgaben):
 *  ════════════════════════════════════════════════════════════════════════
 *  
 *  📘 ÜBUNG 2 (MVC) — HAUSAUFGABE: SEQUENZDIAGRAMM ZEICHNEN
 *     Du sollst den kompletten MVC-Datenfluss verstehen:
 *     1. Client → HTTP-Request → DispatcherServlet
 *     2. DispatcherServlet → HandlerMapping (sucht Controller)
 *     3. HandlerMapping → AltaysController.calculateAverage()
 *     4. Controller verarbeitet Logik (DEIN CODE HIER!)
 *     5. Controller → Model (GradeResponse)
 *     6. ViewResolver → rendert JSON (via Jackson)
 *     7. HTTP-Response → Client
 *  
 *  📘 ÜBUNG 3 (Exception Handling) — HAUSAUFGABE: FEHLERBEHANDLUNG
 *     Du sollst Validierung verbessern:
 *     - Bei fehlenden Parametern: Exception werfen
 *     - Zentral mit @ControllerAdvice abfangen
 *     - Benutzerfreundliche Fehlermeldung anzeigen
 *  
 *  📘 ÜBUNG 4 (REST) — HAUSAUFGABE: REST-API ENTWERFEN
 *     Du sollst zeigen, dass du REST-Prinzipien verstanden hast:
 *     a) Ressourcen: /grades/average, /quizzes/bonus (NUR Substantive!)
 *     b) HTTP-Methoden: POST (erstellt Berechnung)
 *     c) Darstellung: JSON (Request + Response)
 *     d) Statuscodes: 200 OK, 400 Bad Request
 *  
 *  📘 ÜBUNG 5 (GraphQL) — VERGLEICH:
 *     REST: Fixer Endpunkt + feste Struktur
 *     GraphQL: Flexibles Schema + Client wählt Felder
 *     Hier (REST): Alle Felder werden immer zurückgegeben
 *  ════════════════════════════════════════════════════════════════════════ */
