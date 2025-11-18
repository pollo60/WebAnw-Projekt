package edu.fra.uas.Altaystest.model;

/** ╔══════════════════════════════════════════════════════════════════════════╗
 *  ║  DATEI: GradeResponse.java                                               ║
 *  ║  ZWECK: DTO (Data Transfer Object) für ausgehende HTTP-Responses         ║
 *  ║                                                                          ║
 *  ║  📘 BEZUG ZU DEN ÜBUNGSBLÄTTERN:                                         ║
 *  ║                                                                          ║
 *  ║  ÜBUNG 4 (RESTful API):                                                  ║
 *  ║  → Dies ist die "Darstellung" (Representation) der Antwort-Ressource    ║
 *  ║  → JSON-Serialisierung: Java-Objekt → JSON (via Jackson)                ║
 *  ║  → Controller gibt dieses Objekt zurück → Spring konvertiert zu JSON    ║
 *  ║  → Statuscodes: 200 OK (Erfolg), 400 Bad Request (Validierungsfehler)   ║
 *  ║                                                                          ║
 *  ║  ÜBUNG 4 — DARSTELLUNGEN FÜR EINZELRESSOURCE:                            ║
 *  ║  → Einzelobjekt enthält vollständige Infos (average, count,              ║
 *  ║     interpretation)                                                      ║
 *  ║  → Im Gegensatz zu Sammlungen (z. B. Liste aller Berechnungen)          ║
 *  ║                                                                          ║
 *  ║  ÜBUNG 2 (MVC):                                                          ║
 *  ║  → Dies ist das "Model", das vom Controller an den View übergeben wird  ║
 *  ║  → Bei REST: View = JSON-Response (kein HTML-Template)                  ║
 *  ║                                                                          ║
 *  ║  WARUM BRAUCHST DU DIESE DATEI?                                          ║
 *  ║  Nachdem der Server die Noten berechnet hat, muss er das Ergebnis       ║
 *  ║  zurück an den Browser schicken. Diese Klasse definiert die Struktur    ║
 *  ║  der Antwort. Spring konvertiert das Objekt automatisch in JSON.        ║
 *  ║                                                                          ║
 *  ║  BEISPIEL-ABLAUF (REST):                                                 ║
 *  ║  Controller erstellt: new GradeResponse(1.67, 3, "Sehr gut")            ║
 *  ║       ↓                                                                  ║
 *  ║  Spring serialisiert (Java → JSON)                                      ║
 *  ║       ↓                                                                  ║
 *  ║  Browser empfängt: {"average": 1.67, "count": 3,                        ║
 *  ║                     "interpretation": "Sehr gut"}                        ║
 *  ║  Statuscode: HTTP 200 OK                                                 ║
 *  ╚══════════════════════════════════════════════════════════════════════════╝ */

public class GradeResponse {

    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 1: Erstelle drei private Felder für die Antwortdaten        │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 4 (REST — Darstellungen definieren):          │
    // │ → Diese Felder definieren die Struktur der JSON-Response           │
    // │ → Jedes Feld wird zu einer JSON-Property                           │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 1 (Web Basics):                                │
    // │ → Datenstruktur (Java) ist getrennt von Präsentation (JSON/HTML)   │
    // │                                                                     │
    // │ FELDER:                                                             │
    // │ 1. average (Typ: double) → Durchschnittsnote, z. B. 1.67           │
    // │ 2. count (Typ: int) → Anzahl der Noten, z. B. 3                    │
    // │ 3. interpretation (Typ: String) → Einschätzung, z. B. "Sehr gut"   │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ private double average;                                             │
    // │ private int count;                                                  │
    // │ private String interpretation;                                      │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINE FELDER (Zeile ca. 68):




    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 2: Erstelle einen leeren Konstruktor                        │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 4 (REST/JSON):                                 │
    // │ → Jackson braucht ihn zur Serialisierung (Java → JSON)             │
    // │ → Auch wenn wir ihn hier nicht direkt nutzen, gehört er zum        │
    // │   JavaBean-Standard (wichtig für Frameworks)                       │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public GradeResponse() {                                            │
    // │     // leer lassen                                                  │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN LEEREN KONSTRUKTOR (Zeile ca. 89):


    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 3: Erstelle einen Konstruktor mit allen drei Parametern     │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 2 (MVC):                                       │
    // │ → Der Controller erstellt das Model-Objekt und übergibt es         │
    // │ → Dieser Konstruktor ermöglicht eine saubere, kompakte Erstellung  │
    // │                                                                     │
    // │ WARUM?                                                              │
    // │ Im Controller willst du bequem schreiben können:                   │
    // │ return new GradeResponse(1.67, 3, "Sehr gut");                     │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public GradeResponse(double average, int count,                     │
    // │                      String interpretation) {                       │
    // │     this.average = average;                                         │
    // │     this.count = count;                                             │
    // │     this.interpretation = interpretation;                           │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN KONSTRUKTOR MIT PARAMETERN (Zeile ca. 116):


    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 4: Erstelle Getter für alle drei Felder                     │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 4 (REST/JSON):                                 │
    // │ → Jackson liest die Werte über Getter aus, um JSON zu bauen        │
    // │ → Naming-Convention: getXXX() → JSON-Property "xxx"                │
    // │ → Beispiel: getAverage() → JSON: "average": 1.67                   │
    // │                                                                     │
    // │ SERIALISIERUNG:                                                     │
    // │ 1. Controller gibt GradeResponse-Objekt zurück                     │
    // │ 2. Jackson ruft getAverage(), getCount(), getInterpretation()      │
    // │ 3. Jackson baut JSON: {"average": ..., "count": ..., ...}          │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public double getAverage() {                                        │
    // │     return average;                                                 │
    // │ }                                                                   │
    // │                                                                     │
    // │ public int getCount() {                                             │
    // │     return count;                                                   │
    // │ }                                                                   │
    // │                                                                     │
    // │ public String getInterpretation() {                                 │
    // │     return interpretation;                                          │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINE DREI GETTER (Zeile ca. 152):




    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 5: Erstelle Setter für alle drei Felder                     │
    // │                                                                     │
    // │ 📘 KONZEPT AUS ÜBUNG 4 (REST):                                      │
    // │ → Auch wenn wir sie hier nicht direkt brauchen, gehören Setter zum │
    // │   JavaBean-Standard und machen die Klasse flexibler für Frameworks │
    // │ → Falls später z. B. ein GraphQL-Resolver diese Klasse nutzt       │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public void setAverage(double average) {                            │
    // │     this.average = average;                                         │
    // │ }                                                                   │
    // │                                                                     │
    // │ public void setCount(int count) {                                   │
    // │     this.count = count;                                             │
    // │ }                                                                   │
    // │                                                                     │
    // │ public void setInterpretation(String interpretation) {              │
    // │     this.interpretation = interpretation;                           │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINE DREI SETTER (Zeile ca. 185):




} // Ende GradeResponse

// ════════════════════════════════════════════════════════════════════════════
//  ZWEITE KLASSE: QUIZ-BONUS-RESPONSE
// ════════════════════════════════════════════════════════════════════════════

/*
 * ==========================================================================================
 * AUFGABE 6: ERSTELLE EINE ZWEITE RESPONSE-KLASSE FÜR QUIZ-ERGEBNISSE
 * ==========================================================================================
 * 
 * Kontext (Übung 4: REST API Design):
 * Analog zu GradeResponse benötigen wir eine Response-Klasse für die Quiz-Bonus-Berechnung.
 * Diese Klasse definiert, welche Informationen der Server nach der Berechnung zurückgibt.
 * 
 * --------------------------------------------------------------------------------
 * DEINE AUFGABE:
 * --------------------------------------------------------------------------------
 * Erstelle direkt unter GradeResponse eine neue Klasse namens QuizResponse
 * mit folgenden Anforderungen:
 * 
 * 1. Klassenstruktur:
 *    - Name: QuizResponse
 *    - Package: edu.fra.uas.Altaystest.model
 *    - Visibility: public class
 * 
 * 2. Datenfelder (private):
 *    a) averagePercentage (double) 
 *       → Durchschnitt aller Quiz-Prozentsätze (z.B. 83.7%)
 *    
 *    b) bonusPoints (double)
 *       → Berechnete Bonuspunkte (0.0, 0.3 oder 0.7)
 *    
 *    c) quizCount (int)
 *       → Anzahl der absolvierten Quizze (sollte 9 sein)
 *    
 *    d) interpretation (String)
 *       → Textuelle Bewertung, z.B.:
 *         - "Exzellent! 0.7 Bonuspunkte" (>= 80%)
 *         - "Gut! 0.3 Bonuspunkte" (>= 50%)
 *         - "Leider kein Bonus" (< 50%)
 * 
 * 3. Konstruktoren:
 *    - Ein leerer Default-Constructor (für Jackson)
 *    - Ein Constructor mit allen 4 Parametern (für einfache Objekt-Erstellung)
 * 
 * 4. Getter & Setter:
 *    - Für alle 4 Felder jeweils get- und set-Methoden
 * 
 * --------------------------------------------------------------------------------
 * BEISPIEL JSON-RESPONSE (wird an Browser gesendet):
 * --------------------------------------------------------------------------------
 * HTTP/1.1 200 OK
 * Content-Type: application/json
 * 
 * {
 *   "averagePercentage": 83.7,
 *   "bonusPoints": 0.7,
 *   "quizCount": 9,
 *   "interpretation": "Exzellent! Du bekommst 0.7 Bonuspunkte auf deine Gesamtnote."
 * }
 * 
 * --------------------------------------------------------------------------------
 * BONUSPUNKTE-LOGIK (zur Info, wird im Controller implementiert):
 * --------------------------------------------------------------------------------
 * if (averagePercentage >= 80.0) {
 *     bonusPoints = 0.7;
 *     interpretation = "Exzellent! Du bekommst 0.7 Bonuspunkte...";
 * } else if (averagePercentage >= 50.0) {
 *     bonusPoints = 0.3;
 *     interpretation = "Gut! Du bekommst 0.3 Bonuspunkte...";
 * } else {
 *     bonusPoints = 0.0;
 *     interpretation = "Leider kein Bonus. Versuche mindestens 50% zu erreichen.";
 * }
 * 
 * --------------------------------------------------------------------------------
 * LEARNING GOALS:
 * --------------------------------------------------------------------------------
 * ✓ Wiederverwendung des Response-Patterns für verschiedene API-Endpunkte
 * ✓ Strukturierung von API-Responses mit mehreren Datentypen (double, int, String)
 * ✓ Verständnis der Serialisierung: Java-Objekt → JSON → Browser
 * 
 * ==========================================================================================
 */

// SCHREIBE HIER DEINE QuizResponse-KLASSE:


/** ════════════════════════════════════════════════════════════════════════
 *  💡 LERNZIEL DIESER DATEI (Bezug zu Hausaufgaben):
 *  ════════════════════════════════════════════════════════════════════════
 *  
 *  📘 ÜBUNG 4 (REST) — HTTP-STATUSCODES:
 *     Wenn diese Response zurückgegeben wird: HTTP 200 OK
 *     Bei Fehler (z. B. keine Noten): HTTP 400 Bad Request
 *     → Siehe Übung 4: Statuscodes definieren!
 *  
 *  📘 ÜBUNG 4 (REST) — DARSTELLUNGEN:
 *     Diese Klasse ist die "vollständige Darstellung" einer Einzelressource.
 *     Bei einer Sammlung würdest du z. B. nur ID + Kurzinfo zurückgeben.
 *  
 *  📘 ÜBUNG 5 (GraphQL) — VERGLEICH:
 *     Bei GraphQL würdest du einen @Type im Schema definieren.
 *     Vorteil von GraphQL: Client kann Felder selektieren
 *     (z. B. nur "average", ohne "count" und "interpretation").
 *     Bei REST: Feste Struktur, alle Felder werden immer gesendet.
 *  
 *  📘 ÜBUNG 2 (MVC) — VIEW:
 *     Bei klassischem MVC wäre der View ein HTML-Template.
 *     Bei REST-APIs ist der View = JSON-Response.
 *     Diese Klasse ist das Model, das an den View übergeben wird.
 *  ════════════════════════════════════════════════════════════════════════ */
