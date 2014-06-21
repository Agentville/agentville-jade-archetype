package ${groupId}.${artifactId};

import ${groupId}.${artifactId}.behaviours.*;
import jade.core.Agent;
import jade.util.Logger;

/**
 * Die Implementierung des Agenten.
 * 
 * @author Marco Steffens
 *
 */
public class MyAgent extends Agent {
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = jade.util.Logger.getMyLogger(
			MyAgent.class.getName());	
	
	/*
	 * (non-Javadoc)
	 * @see jade.core.Agent#setup()
	 */
	protected void setup() {
		
		if (logger.isLoggable(jade.util.Logger.WARNING))
			logger.log(jade.util.Logger.WARNING, 
					"Hello Eclipse! This is " + getLocalName());
	    	
        System.out.println("Hello Eclipse! This is "
                + getLocalName());
        
		//Der/die/das Behaviour wird ausgeführt, sobald hier die
        //setup()-Methode abgearbeitet wird. Also danach läuft
        //wohl der Scheduler an und führt den ersten Behaviour aus?
        KeepAliveBehaviour kab = new KeepAliveBehaviour(this);
		this.addBehaviour(kab);
        
    }
	
	/*
	 * Die takeDown-Methode wird automatisch ausgeführt, wenn der Agent 
	 * per "doDelete()" gelöscht wird. Hier wäre also der richtige Ort
	 * fuer Aufraeumarbeiten.
	 * 
	 * @see jade.core.Agent#takeDown()
	 */
	protected void takeDown() {
		if (logger.isLoggable(jade.util.Logger.WARNING))
			logger.log(jade.util.Logger.WARNING, "takeDown");
		
		//aufräumen
	}
}
