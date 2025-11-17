package edu.fra.uas.Altaystest.model;

/** ╔══════════════════════════════════════════════════════════════════════════╗
 *  ║  DATEI: GradeResponse.java                                               ║
 *  ║  ZWECK: DTO (Data Transfer Object) für ausgehende HTTP-Responses         ║
 *  ║                                                                          ║
 *  ║  WARUM BRAUCHST DU DIESE DATEI?                                          ║
 *  ║  Nachdem der Server die Noten berechnet hat, muss er das Ergebnis       ║
 *  ║  zurück an den Browser schicken. Diese Klasse definiert die Struktur    ║
 *  ║  der Antwort (Response). Spring konvertiert das Objekt automatisch      ║
 *  ║  in JSON.                                                                ║
 *  ║                                                                          ║
 *  ║  BEISPIEL:                                                               ║
 *  ║  Server erstellt: new GradeResponse(1.67, 3, "Sehr gut")                ║
 *  ║  Browser empfängt: {"average": 1.67, "count": 3,                        ║
 *  ║                     "interpretation": "Sehr gut"}                        ║
 *  ╚══════════════════════════════════════════════════════════════════════════╝ */

public class GradeResponse {

    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 1: Erstelle drei private Felder für die Antwortdaten        │
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

    // SCHREIBE HIER DEINE FELDER (Zeile ca. 37):




    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 2: Erstelle einen leeren Konstruktor                        │
    // │                                                                     │
    // │ WARUM?                                                              │
    // │ Spring/Jackson braucht ihn zur Serialisierung (Java → JSON).       │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public GradeResponse() {                                            │
    // │     // leer lassen                                                  │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN LEEREN KONSTRUKTOR (Zeile ca. 56):


    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 3: Erstelle einen Konstruktor mit allen drei Parametern     │
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

    // SCHREIBE HIER DEINEN KONSTRUKTOR MIT PARAMETERN (Zeile ca. 76):


    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 4: Erstelle Getter für alle drei Felder                     │
    // │                                                                     │
    // │ WARUM?                                                              │
    // │ Spring/Jackson liest die Werte über Getter aus, um JSON zu bauen.  │
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

    // SCHREIBE HIER DEINE DREI GETTER (Zeile ca. 101):




    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 5: Erstelle Setter für alle drei Felder                     │
    // │                                                                     │
    // │ WARUM?                                                              │
    // │ Auch wenn wir sie hier nicht direkt brauchen, gehören Setter zum   │
    // │ JavaBean-Standard und machen die Klasse flexibler für Frameworks.  │
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

    // SCHREIBE HIER DEINE DREI SETTER (Zeile ca. 131):




} // Ende GradeResponse
