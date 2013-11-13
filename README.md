agentville-jade-archetype
=========================

Maven-Archetype für einen JADE-Agenten

Dieses Projekt erstellt einen Maven-Archetype, mit dem ein Maven-Projekt für einen JADE-Agenten angelegt werden kann.

Der Archetyp kann erzeugt und lokal im Maven-Repo (.m2) installiert werden, und zwar auf der Kommandozeile mit

>mvn clean install archetype:update-local-catalog

Anschließend kann ein neues Maven-Projekt angelegt werden, und zwar mit einem Befehl wie folgendem:

<code>
>mvn archetype:generate 
     -DarchetypeGroupId=agentville.jade.maven.archetype 
     -DarchetypeArtifactId=jade-agent-archetype 
     -DarchetypeVersion=1.0-SNAPSHOT 
     -DgroupId=<groupId> 
     -DartifactId=<artifactId>
</code>     
(Wobei sich die Versions-Nr natürlich auch mal geändert haben kann. Und die <groupId> und die <artifactId> entsprechend
ersetzt werden müssen.)

Das mit diesem Archetype erstellte Projekt kann direkt kompiliert werden und erzeugt dann zwei JARs:
Ein ausführbares Standard-Maven-Artefakt mit der Bezeichnung "<artifactId>-<version>.jar sowie
einen JADE-Agenten mit der Bezeichnung "voll_qualifizierter_Klassenname_des_Agenten.jar".

Der Agent selbst ist natürlich simpel und dient lediglich als leichter Einstieg.

TODOs:

- Die Main-Methode und vllt. auch den Agenten noch etwas ausbauen.
- Logging ergänzen
- Testfälle ergänzen
