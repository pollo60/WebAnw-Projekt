package edu.fra.uas.Altaystest.model;

import java.util.List;

/** ╔══════════════════════════════════════════════════════════════════════════╗
 *  ║  DATEI: GradeRequest.java                                                ║
 *  ║  ZWECK: DTO (Data Transfer Object) für eingehende HTTP-Requests          ║
 *  ║                                                                          ║
 *  ║  WARUM BRAUCHST DU DIESE DATEI?                                          ║
 *  ║  Wenn der Browser Daten an den Server schickt (z. B. per fetch/POST),   ║
 *  ║  muss Spring Boot wissen, wie die JSON-Daten in ein Java-Objekt         ║
 *  ║  umgewandelt werden. Diese Klasse ist die "Form", in die Spring die     ║
 *  ║  eingehenden Daten gießt.                                                ║
 *  ║                                                                          ║
 *  ║  BEISPIEL:                                                               ║
 *  ║  Browser sendet: {"grades": [1.0, 2.3, 1.7]}                            ║
 *  ║  Spring erstellt automatisch ein GradeRequest-Objekt mit dieser Liste.  ║
 *  ╚══════════════════════════════════════════════════════════════════════════╝ */

public class GradeRequest {

    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 1: Erstelle ein privates Feld (Variable) für die Notenliste │
    // │                                                                     │
    // │ HINWEISE:                                                           │
    // │ - Typ: List<Double> (importiere java.util.List oben)               │
    // │ - Name: grades (englisch für "Noten")                              │
    // │ - Sichtbarkeit: private (Zugriff nur über Getter/Setter)           │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ private List<Double> grades;                                        │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEIN FELD (Zeile ca. 35):


    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 2: Erstelle einen leeren Konstruktor                        │
    // │                                                                     │
    // │ WARUM?                                                              │
    // │ Spring/Jackson braucht einen parameterlosen Konstruktor, um beim   │
    // │ Deserialisieren (JSON → Java-Objekt) eine Instanz zu erstellen.    │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public GradeRequest() {                                             │
    // │     // leer lassen                                                  │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN KONSTRUKTOR (Zeile ca. 51):


    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 3: Erstelle einen Getter für das Feld "grades"              │
    // │                                                                     │
    // │ WARUM?                                                              │
    // │ Der Controller muss auf die Notenliste zugreifen können.           │
    // │ In Java greifen wir nicht direkt auf private Felder zu, sondern    │
    // │ über Getter-Methoden (Kapselung/Encapsulation).                    │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public List<Double> getGrades() {                                   │
    // │     return grades;                                                  │
    // │ }                                                                   │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN GETTER (Zeile ca. 71):


    // ┌─────────────────────────────────────────────────────────────────────┐
    // │ AUFGABE 4: Erstelle einen Setter für das Feld "grades"              │
    // │                                                                     │
    // │ WARUM?                                                              │
    // │ Spring/Jackson setzt die Werte aus dem JSON in das Objekt ein.     │
    // │ Dazu braucht es eine setGrades()-Methode.                          │
    // │                                                                     │
    // │ BEISPIEL:                                                           │
    // │ public void setGrades(List<Double> grades) {                        │
    // │     this.grades = grades;                                           │
    // │ }                                                                   │
    // │                                                                     │
    // │ HINWEIS: "this.grades" bedeutet das Feld der Klasse,               │
    // │          "grades" (ohne this) ist der Parameter der Methode.       │
    // └─────────────────────────────────────────────────────────────────────┘

    // SCHREIBE HIER DEINEN SETTER (Zeile ca. 92):


} // Ende GradeRequest
