package edu.fra.uas.Altaystest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** ╔════════════════════════════════════════════════════════════════════════╗
 *  ║  DATEI: AltaystestApplication.java                                     ║
 *  ║  ZWECK: Einstiegspunkt (Main-Klasse) der Spring Boot Anwendung        ║
 *  ║                                                                        ║
 *  ║  WARUM BRAUCHST DU DIESE DATEI?                                        ║
 *  ║  Diese Klasse startet die gesamte Anwendung. Wenn du die App          ║
 *  ║  ausführst (z. B. mit "mvn spring-boot:run"), wird die main()-Methode ║
 *  ║  aufgerufen und Spring Boot initialisiert.                            ║
 *  ║                                                                        ║
 *  ║  WAS PASSIERT HIER?                                                    ║
 *  ║  1. @SpringBootApplication aktiviert Auto-Konfiguration               ║
 *  ║  2. Spring scannt alle Klassen im Package (findet Controller, etc.)   ║
 *  ║  3. Embedded Tomcat-Server wird gestartet (Port 8080)                 ║
 *  ║  4. Die Anwendung ist bereit für HTTP-Anfragen                        ║
 *  ║                                                                        ║
 *  ║  MUSST DU DIESE DATEI ÄNDERN?                                          ║
 *  ║  NEIN! Diese Datei ist fertig. Du brauchst sie nur zu verstehen.      ║
 *  ║  Sie bleibt normalerweise unverändert.                                 ║
 *  ╚════════════════════════════════════════════════════════════════════════╝ */

@SpringBootApplication // Kombination aus @Configuration, @EnableAutoConfiguration, @ComponentScan
public class AltaystestApplication {

	/**
	 * Main-Methode: Einstiegspunkt der Java-Anwendung.
	 * 
	 * SpringApplication.run() startet den Spring Boot Container:
	 * - Initialisiert den ApplicationContext (Container für Beans)
	 * - Startet den eingebetteten Tomcat-Server
	 * - Scannt Klassen und registriert Controller, Services, etc.
	 * 
	 * HINWEIS: Diese Methode wird EINMAL beim Start ausgeführt.
	 * Danach läuft die App und wartet auf HTTP-Anfragen.
	 */
	public static void main(String[] args) {
		SpringApplication.run(AltaystestApplication.class, args);
		// Nach dieser Zeile ist die App gestartet und hört auf Port 8080
	}

}

/** ════════════════════════════════════════════════════════════════════════
 *  ZUSAMMENFASSUNG: WIE ALLE DATEIEN ZUSAMMENARBEITEN
 *  ════════════════════════════════════════════════════════════════════════
 *  
 *  1. AltaystestApplication.java (DIESE DATEI)
 *     → Startet die Anwendung
 *  
 *  2. AltaysController.java
 *     → Definiert HTTP-Endpunkte (/calculate-average)
 *     → Empfängt Anfragen vom Browser
 *     → Gibt Antworten zurück
 *  
 *  3. GradeRequest.java & GradeResponse.java
 *     → Strukturieren die Daten (JSON ↔ Java-Objekte)
 *  
 *  4. index.html
 *     → Benutzeroberfläche im Browser
 *     → Sendet Anfragen an den Controller (fetch)
 *  
 *  5. styles.css
 *     → Macht die Webseite schön (Design, Layout)
 *  
 *  ABLAUF EINER ANFRAGE:
 *  Browser → fetch('/calculate-average') → AltaysController 
 *  → berechnet Durchschnitt → gibt GradeResponse zurück 
 *  → Browser zeigt Ergebnis an
 *  ════════════════════════════════════════════════════════════════════════ */
