package ${groupId};

import java.util.logging.LogManager;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;


/**
 * Die Implementierung der Main-Methode erzeugt einen lokalen 
 * JADE-Main-Container mit RMA. Die damit erzeugte Plattform  
 * ist die Testumgegung für die Entwicklung des Agenten und er-
 * möglicht so eine kontrollierte Umgebung. Eine "produktive"
 * Umgebung wird dadurch aber nicht erzeugt.
 * 
 * @author Marco Steffens
 * 
 */
public class AgentStarter {
	
	Agent remoteManagementAgent = null;

	public static void main(String[] args){
	
		String host;
		int port;
		String platform = null;		//default name
		boolean main = true;
	
		host = "localhost";
		port = -1;			//default-port 1099
	
		configureLogging();

		Runtime runtime = Runtime.instance();
	
		Profile profile = null;
		AgentContainer container = null;
	
		profile = new ProfileImpl(host, port, platform, main);
	
		//Container erzeugen
		container = runtime.createMainContainer(profile);

		remoteManagementAgent = new jade.tools.rma.rma();
		// Remote Monitoring Agenten erzeugen
		try {
			AgentController rma = container.acceptNewAgent(
	                	"RMA",
	                	remoteManagementAgent
	                    );
			rma.start();
		} catch(StaleProxyException e) {
			throw new RuntimeException(e);
		}
	

		// Agenten erzeugen und startet - oder aussteigen.
		try {
			AgentController agent = container.createNewAgent(
	                	"MyAgent",
	                    MyAgent.class.getName(),
	                    args);
			agent.start();
	    } catch(StaleProxyException e) {
	        throw new RuntimeException(e);
	    }
	}

	/*
	 * Das Logging-System von JADE basiert auf java.util.logging, und im
	 * Zusammenhang mit Maven bringt das ein paar Probleme mit sich. Einmal
	 * weil Java die Konfigurationsdatei per default im Installationsverzeichnis
	 * des SDK sucht. Und dann noch weil der Logging-Agent von JADE nur ganz
	 * am Anfang die Konfiguration einliest und sich nicht mehr umkonfigurieren
	 * lässt. Das bedeutet: 
	 * Da wir in einem Maven-Projekt alle relevanten Konfigurationsdateien im 
	 * Projektverzeichnis ablegen wollen, müssen wir den Pfad dahin noch irgendwie
	 * innerhalb unserer VM bekannt machen. Einer der üblichen Wege ist die Übergabe
	 * als VM-Parameter beim Start, aber da wir unsere Agenten auf verschiedene Arten
	 * starten wollen, bietet sich das nicht an. Da andererseites der Logging-Agent
	 * die Konfiguration aber nur beim Start einliest, muss die Konfiguration VOR dem
	 * Erzeugen der Plattform stattfinden. Und das ist genau hier. Das heißt aber auch,
	 * dass bei allen Startarten, die die Main-Methode umgehen, die jeweils lokal
	 * vorhandene Konfigurationsdatei verwendet wird.
	 */
	private static void configureLogging() {

		System.setProperty( "java.util.logging.config.file",
							"src/main/resources/logging.properties" );

		try {
			LogManager.getLogManager().readConfiguration();
			}
		catch ( Exception e ) { 
			e.printStackTrace(); }
	}
}
