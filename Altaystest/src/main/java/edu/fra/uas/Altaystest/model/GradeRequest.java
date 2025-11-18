package edu.fra.uas.Altaystest.model;

import java.util.List;

/** ╔══════════════════════════════════════════════════════════════════════════╗
 *  ║  DATEI: GradeRequest.java                                                ║
 *  ║  ZWECK: DTO (Data Transfer Object) für eingehende HTTP-Requests          ║
 *  ║                                                                          ║
 *  ║  📘 BEZUG ZU DEN ÜBUNGSBLÄTTERN:                                         ║
 *  ║                                                                          ║
 *  ║  ÜBUNG 4 (RESTful API):                                                  ║
 *  ║  → DTOs sind Teil der "Darstellung" (Representation) einer Ressource    ║
 *  ║  → JSON-Serialisierung: Java-Objekt ↔ JSON (via Jackson)                ║
 *  ║  → Request-Body bei POST/PUT-Requests enthält dieses Objekt             ║
 *  ║                                                                          ║
 *  ║  ÜBUNG 2 (MVC):                                                          ║
 *  ║  → Dies ist das "Model" im MVC-Pattern                                   ║
 *  ║  → Controller empfängt Request → konvertiert zu GradeRequest-Objekt     ║
 *  ║                                                                          ║
 *  ║  WARUM BRAUCHST DU DIESE DATEI?                                          ║
 *  ║  Wenn der Browser JSON-Daten sendet (z. B. {"grades": [1.0, 2.3]}),    ║
 *  ║  muss Spring Boot wissen, wie diese Daten strukturiert sind. Diese      ║
 *  ║  Klasse ist die "Form", in die Spring die eingehenden JSON-Daten        ║
 *  ║  automatisch gießt (Deserialisierung via Jackson).                      ║
 *  ║                                                                          ║
 *  ║  BEISPIEL-ABLAUF:                                                        ║
 *  ║  Browser sendet: {"grades": [1.0, 2.3, 1.7]}                            ║
 *  ║       ↓                                                                  ║
 *  ║  Spring deserialisiert (JSON → Java)                                    ║
 *  ║       ↓                                                                  ║
 *  ║  GradeRequest-Objekt mit List<Double> grades = [1.0, 2.3, 1.7]         ║
 *  ╚══════════════════════════════════════════════════════════════════════════╝ */

public class GradeRequest {

    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 1: Erstelle ein privates Feld (Variable) für die Notenliste │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 1 (Web Basics):                                │
    // │ → Trennung von Struktur (HTML), Darstellung (CSS) und Logik (Java) │
    // │ → Dieses Feld repräsentiert die DATEN-Struktur                     │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 4 (REST):                                      │
    // │ → JSON-Property "grades" wird auf dieses Feld gemappt              │
    // │ → Jackson sucht automatisch nach getGrades()/setGrades()           │
    // │                                                                     │
    // │ HINWEISE:                                                           │
    // │ - Typ: List<Double> (importiere java.util.List oben)               │
    // │ - Name: grades (englisch für "Noten")                              │
    // │ - Sichtbarkeit: private (Kapselung, Zugriff nur über Getter/Setter)│
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ private List<Double> grades;                                        │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEIN FELD (Zeile ca. 58):




    // ════════════════════════════════════════════════════════════════════════
    //  AB HIER: AUFGABEN FÜR NOTENDURCHSCHNITT-BERECHNUNG
    // ════════════════════════════════════════════════════════════════════════

    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 2: Erstelle einen leeren Konstruktor                        │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 4 (REST/JSON):                                 │
    // │ → Jackson (JSON-Bibliothek) braucht einen parameterlosen           │
    // │   Konstruktor, um beim Deserialisieren eine Instanz zu erstellen   │
    // │ → Danach ruft Jackson setGrades(...) auf, um Werte zu setzen       │
    // │                                                                     │
    // │ WARUM?                                                              │
    // │ Ohne diesen Konstruktor kann Spring das JSON nicht in ein          │
    // │ Java-Objekt umwandeln → Fehler beim Request                        │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public GradeRequest() {                                             │
    // │     // leer lassen (Jackson erstellt das Objekt selbst)            │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN KONSTRUKTOR (Zeile ca. 83):


    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 3: Erstelle einen Getter für das Feld "grades"              │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 2 (MVC):                                       │
    // │ → Der Controller braucht Zugriff auf die Daten                     │
    // │ → In Java greifen wir nicht direkt auf private Felder zu,          │
    // │   sondern über Getter-Methoden (Kapselung/Encapsulation)           │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 4 (REST):                                      │
    // │ → Jackson nutzt Getter auch für Serialisierung (falls nötig)       │
    // │ → Naming-Convention: getXXX() → JSON-Property "xxx"                │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public List<Double> getGrades() {                                   │
    // │     return grades;                                                  │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN GETTER (Zeile ca. 108):


    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 4: Erstelle einen Setter für das Feld "grades"              │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 4 (REST/JSON):                                 │
    // │ → Jackson ruft diesen Setter auf, um Werte aus dem JSON zu setzen  │
    // │ → Naming-Convention: setXXX() → JSON-Property "xxx"                │
    // │                                                                     │
    // │ ABLAUF DER DESERIALISIERUNG:                                        │
    // │ 1. Jackson erstellt Objekt: new GradeRequest()                     │
    // │ 2. Jackson liest JSON: {"grades": [1.0, 2.3]}                      │
    // │ 3. Jackson ruft auf: setGrades(Arrays.asList(1.0, 2.3))            │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public void setGrades(List<Double> grades) {                        │
    // │     this.grades = grades;                                           │
    // │ }                                                                   │
    // │                                                                     │
    // │ HINWEIS: "this.grades" = Feld der Klasse                           │
    // │          "grades" (ohne this) = Parameter der Methode              │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN SETTER (Zeile ca. 137):


} // Ende GradeRequest

// ════════════════════════════════════════════════════════════════════════════
//  ZWEITE KLASSE: QUIZ-BONUS-BERECHNUNG
// ════════════════════════════════════════════════════════════════════════════

/*
 * ==========================================================================================
 * AUFGABE 5: ERSTELLE EINE ZWEITE REQUEST-KLASSE FÜR QUIZ-DATEN
 * ==========================================================================================
 * 
 * Kontext (Übung 4: REST API Design):
 * In einer RESTful API repräsentieren verschiedene Ressourcen unterschiedliche Entitäten.
 * Du hast bereits 'GradeRequest' für Notendurchschnitte. Nun erstelle eine separate Klasse
 * für eine zweite Ressource: wöchentliche Quiz-Ergebnisse.
 * 
 * Dies demonstriert das REST-Prinzip 4a: "Identifiziere Ressourcen als Substantive"
 * - Ressource 1: /calculate-average (Notendurchschnitt)
 * - Ressource 2: /calculate-quiz-bonus (Quiz-Bonuspunkte)
 * 
 * --------------------------------------------------------------------------------
 * DEINE AUFGABE:
 * --------------------------------------------------------------------------------
 * Erstelle direkt unter GradeRequest (im selben File!) eine neue Klasse namens QuizRequest
 * mit folgenden Anforderungen:
 * 
 * 1. Klassenstruktur (analog zu GradeRequest):
 *    - Name: QuizRequest
 *    - Package: bleib im selben Package (edu.fra.uas.Altaystest.model)
 *    - Visibility: public class
 *    - Keine Annotations nötig (POJO)
 * 
 * 2. Datenfeld (Übung 1: Datenstrukturen):
 *    - Ein privates Feld: List<Double> quizPercentages
 *    - Speichert die Prozentwerte der 9 wöchentlichen Quizze (z.B. 85.5, 90.0, 78.3, ...)
 *    - Typ Double für präzise Prozent-Werte mit Nachkommastellen
 * 
 * 3. Konstruktoren (JavaBean-Konvention):
 *    - Ein Default-Constructor (leer, parameterlos) → für Jackson Deserialisierung
 *    - OPTIONAL: Ein Constructor mit Parameter List<Double> quizPercentages
 * 
 * 4. Getter & Setter (Jackson Mapping):
 *    - getQuizPercentages(): List<Double>
 *    - setQuizPercentages(List<Double> quizPercentages): void
 * 
 * --------------------------------------------------------------------------------
 * QUIZ-BERECHNUNGSLOGIK (wird später im Controller implementiert):
 * --------------------------------------------------------------------------------
 * - Gesamtdurchschnitt aller Quiz-Prozentsätze berechnen
 * - Bonuspunkte-Formel:
 *   * Durchschnitt >= 80% → 0.7 Notenpunkte Bonus (von 2.0 wird 1.3)
 *   * Durchschnitt >= 50% → 0.3 Notenpunkte Bonus (von 2.0 wird 1.7)
 *   * Durchschnitt < 50%  → 0.0 Bonus
 * 
 * WICHTIG: Bonuspunkte verbessern die Note (kleinere Zahl = bessere Note)!
 * Beispiel: Note 2.0 mit 0.7 Bonus → 2.0 - 0.7 = 1.3 (besser!)
 * 
 * --------------------------------------------------------------------------------
 * BEISPIEL JSON (wird von Frontend gesendet):
 * --------------------------------------------------------------------------------
 * POST /calculate-quiz-bonus
 * Content-Type: application/json
 * 
 * {
 *   "quizPercentages": [85.0, 90.5, 78.0, 88.0, 92.0, 75.0, 80.0, 87.5, 83.0]
 * }
 * 
 * --------------------------------------------------------------------------------
 * LEARNING GOALS:
 * --------------------------------------------------------------------------------
 * ✓ Wiederverwendung des DTO-Patterns für eine zweite REST-Ressource
 * ✓ Verständnis, warum man separate Klassen für unterschiedliche Entities nutzt
 * ✓ Praktische Anwendung: Eine API kann mehrere unabhängige Endpunkte haben
 * ✓ Code-Strukturierung: Mehrere verwandte Klassen im selben File (bei kleinen DTOs üblich)
 * 
 * ==========================================================================================
 */

// SCHREIBE HIER DEINE QuizRequest-KLASSE:


/** ════════════════════════════════════════════════════════════════════════
 *  💡 LERNZIEL DIESER DATEI (Bezug zu Hausaufgaben):
 *  ════════════════════════════════════════════════════════════════════════
 *  
 *  📘 ÜBUNG 1 (Web Basics) — TRENNUNG VON SCHICHTEN:
 *     Du lernst, dass Datenstrukturen (Java) getrennt von der 
 *     Präsentation (HTML/CSS) und Logik (Controller) sind.
 *  
 *  📘 ÜBUNG 2 (MVC) — MODEL:
 *     Dieses DTO ist das "Model" im MVC-Pattern.
 *     Es transportiert Daten zwischen View und Controller.
 *  
 *  📘 ÜBUNG 4 (REST) — DARSTELLUNG (REPRESENTATION):
 *     JSON ist die "Repräsentation" dieser Ressource.
 *     GradeRequest definiert die Struktur dieser Repräsentation.
 *  
 *  📘 ÜBUNG 5 (GraphQL) — VERGLEICH:
 *     Bei GraphQL würdest du einen @Input-Type im Schema definieren.
 *     Hier (REST) nutzen wir Java-Klassen mit Jackson-Serialisierung.
 *  ════════════════════════════════════════════════════════════════════════ */
