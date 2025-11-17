package edu.fra.uas.Altaystest.controllerDS5only;

/** ╔══════════════════════════════════════════════════════════════════════════╗
 *  ║  Spring Framework Annotationen und Web-MVC Typen:                       ║
 *  ║                                                                          ║
 *  ║  Web‑MVC‑Typen sind die Komponenten des                                 ║
 *  ║  Model‑View‑Controller‑Musters (z. B. Dispatcher/Router,                ║
 *  ║  Controller, Model, View, HandlerMapping, ViewResolver), die zusammen   ║
 *  ║  HTTP‑Anfragen routen, Daten bereitstellen und Antworten rendern.       ║
 *  ╚══════════════════════════════════════════════════════════════════════════╝ */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import edu.fra.uas.Altaystest.model.GradeRequest;
import edu.fra.uas.Altaystest.model.GradeResponse;

import java.util.List;

/** ╔══════════════════════════════════════════════════════════════════════════╗
 *  ║  DATEI: AltaysController.java                                            ║
 *  ║  ZWECK: HTTP-Endpunkte (URLs) definieren und Anfragen bearbeiten         ║
 *  ║                                                                          ║
 *  ║  WARUM BRAUCHST DU DIESE DATEI?                                          ║
 *  ║  Der Controller ist das "Gehirn" deiner Web-Anwendung. Er empfängt      ║
 *  ║  HTTP-Requests vom Browser, führt Berechnungen durch und sendet         ║
 *  ║  Antworten zurück. Ohne Controller kann der Browser nicht mit dem       ║
 *  ║  Server kommunizieren.                                                   ║
 *  ║                                                                          ║
 *  ║  ARCHITEKTUR (MVC - Model-View-Controller):                              ║
 *  ║  ┌─────────┐      ┌────────────┐      ┌───────┐                         ║
 *  ║  │ Browser │ ───> │ Controller │ ───> │ Model │ (GradeRequest/Response) ║
 *  ║  │ (View)  │ <─── │  (diese    │ <─── │       │                         ║
 *  ║  └─────────┘      │   Datei)   │      └───────┘                         ║
 *  ║                   └────────────┘                                         ║
 *  ╚══════════════════════════════════════════════════════════════════════════╝ */

@Controller // Spring registriert diese Klasse als MVC-Controller
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
    // │ AUFGABE 1: Erstelle einen POST-Endpunkt /calculate-average          │
    // │                                                                     │
    // │ SCHRITTE:                                                           │
    // │ 1. Schreibe die Annotation @PostMapping("/calculate-average")      │
    // │ 2. Schreibe die Annotation @ResponseBody (damit JSON zurückkommt)  │
    // │ 3. Erstelle eine Methode mit dem Namen "calculateAverage"          │
    // │ 4. Die Methode hat einen Parameter: @RequestBody GradeRequest req  │
    // │ 5. Die Methode gibt zurück: GradeResponse                          │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ @PostMapping("/calculate-average")                                  │
    // │ @ResponseBody                                                       │
    // │ public GradeResponse calculateAverage(                              │
    // │         @RequestBody GradeRequest request) {                        │
    // │     // hier kommt dein Code                                         │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN ENDPUNKT (Zeile ca. 84):


        // ┌─────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 2: Hole die Notenliste aus dem Request-Objekt           │
        // │                                                                 │
        // │ HINWEIS:                                                        │
        // │ Das request-Objekt hat eine Methode getGrades(), die eine      │
        // │ Liste von Noten zurückgibt.                                    │
        // │                                                                 │
        // │ BEISPIEL:                                                       │
        // │ List<Double> grades = request.getGrades();                     │
        // └─────────────────────────────────────────────────────────────────┘

        // SCHREIBE HIER DEN CODE ZUM HOLEN DER NOTEN (Zeile ca. 100):


        // ┌─────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 3: Prüfe, ob die Liste leer oder null ist               │
        // │                                                                 │
        // │ WARUM?                                                          │
        // │ Wenn keine Noten vorhanden sind, können wir keinen Durchschnitt│
        // │ berechnen. Wir müssen eine Fehlermeldung zurückgeben.          │
        // │                                                                 │
        // │ BEISPIEL:                                                       │
        // │ if (grades == null || grades.isEmpty()) {                      │
        // │     return new GradeResponse(0.0, 0, "Keine Noten vorhanden"); │
        // │ }                                                               │
        // └─────────────────────────────────────────────────────────────────┘

        // SCHREIBE HIER DIE VALIDIERUNG (Zeile ca. 117):


        // ┌─────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 4: Berechne die Summe aller Noten                       │
        // │                                                                 │
        // │ SCHRITTE:                                                       │
        // │ 1. Erstelle eine Variable "sum" (Typ: double) mit Wert 0.0     │
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

        // SCHREIBE HIER DIE SUMMENBERECHNUNG (Zeile ca. 139):


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

        // SCHREIBE HIER DIE DURCHSCHNITTSBERECHNUNG (Zeile ca. 158):


        // ┌─────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 6: Interpretiere die Note (rufe Hilfsmethode auf)       │
        // │                                                                 │
        // │ HINWEIS:                                                        │
        // │ Unten gibt es eine Methode interpretGermanGrade(double avg),   │
        // │ die eine Durchschnittsnote als Text zurückgibt (z. B. "Gut").  │
        // │                                                                 │
        // │ BEISPIEL:                                                       │
        // │ String interpretation = interpretGermanGrade(average);         │
        // └─────────────────────────────────────────────────────────────────┘

        // SCHREIBE HIER DEN AUFRUF DER HILFSMETHODE (Zeile ca. 173):


        // ┌─────────────────────────────────────────────────────────────────┐
        // │ AUFGABE 7: Erstelle und gib das Response-Objekt zurück          │
        // │                                                                 │
        // │ SCHRITTE:                                                       │
        // │ 1. Erstelle ein neues GradeResponse-Objekt                     │
        // │ 2. Übergebe: average, grades.size(), interpretation            │
        // │ 3. Gib es mit "return" zurück                                  │
        // │                                                                 │
        // │ BEISPIEL:                                                       │
        // │ return new GradeResponse(average, grades.size(),               │
        // │                          interpretation);                      │
        // └─────────────────────────────────────────────────────────────────┘

        // SCHREIBE HIER DAS RETURN-STATEMENT (Zeile ca. 189):


    // } // Ende calculateAverage (schließende Klammer der Methode)


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

} // Ende AltaysController
