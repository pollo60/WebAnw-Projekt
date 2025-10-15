package edu.fra.uas.Altaystest.controllerDS5only; // Paketdeklaration: organisiert Klassen im Namensraum und beeinflusst das Classpath-Package

/** /----------------------------------------------------------------------\
 *  | Spring Framework Annotationen und Web-MVC Typen:                     |
 *  |                                                                      |
 *  | Web‑MVC‑Typen sind die Komponenten des                               |
 *  | Model‑View‑Controller‑Musterns (z. B. Dispatcher/Router,             |
 *  | Controller, Model, View, HandlerMapping, ViewResolver), die zusammen |
 *  | HTTP‑Anfragen routen, Daten bereitstellen und Antworten rendern.     | 
 *  |______________________________________________________________________| */ 

import org.springframework.stereotype.Controller; // @Controller markiert eine Komponente als Spring MVC-Controller (stereotype)
import org.springframework.web.bind.annotation.RequestMapping; // @RequestMapping verbindet HTTP-Requests mit Methoden
import org.springframework.web.bind.annotation.RequestMethod; // enum für HTTP-Methoden (GET, POST ...)
import org.springframework.web.bind.annotation.ResponseBody; // @ResponseBody sagt Spring, dass der Rückgabewert direkt in die HTTP-Antwort geschrieben wird


@Controller // Stereotype: Spring registriert diese Klasse als Bean im ApplicationContext und als MVC-Controller
public class AltaysController { // öffentliche Klasse, die HTTP-Endpunkte (Handler) bereitstellt

    // RequestMapping verbindet Pfad + HTTP-Methode mit der folgenden Handler-Methode
    // value = "/altaystest": der URL-Pfad (relativ zur Root-URL der Anwendung)
    // method = RequestMethod.GET: nur GET-Anfragen werden von dieser Methode verarbeitet
    @RequestMapping(value = "/altaystest", method = RequestMethod.GET) //Im Browser: http://localhost:8080/altaystest oder http://127.0.0.1:8080/altaystest

    /** @ResponseBody
     * Liefert einen Begrüßungstext für die Testseite.
     * Diese Javadoc beschreibt die Absicht der Methode für Entwickler-Tools und API-Dokumentation.
     * @return HTML-String mit der Begrüßung -- wird direkt als HTTP-Response-Body gesendet (siehe @ResponseBody)
     */
    @ResponseBody // Verhindert, dass Spring versucht, einen View-Namen zu rendern; gibt stattdessen den String als Response zurück
    public String getHelloWorld() { 
        // Rückgabe eines einfachen HTML-Strings. Hinweis: Roh-HTML hier ist für Tests ok, in Produktionscode sollte man Templates/Thymeleaf o.ä. oder JSON verwenden
        // Sicherheitsaspekt: wenn Inhalte aus Benutzereingaben zusammengebaut werden, sind Escaping und XSS-Schutz notwendig.
        return "<h1> Hello World from AltaysTestApplication </h1>"; // Literal-String: direkt in die HTTP-Antwort geschrieben

    } // Ende der Methode getHelloWorld

} // Ende der Klasse AltaysController
