agentville-jade-archetype
=========================

Maven-Archetype für einen JADE-Agenten

Dieses Projekt erstellt einen Maven-Archetype, mit dem ein Maven-Projekt für einen JADE-Agenten angelegt werden kann.

Der Archetyp kann erzeugt und lokal im Maven-Repo (.m2) installiert werden, und zwar auf der Kommandozeile mit
<pre><code>
>mvn clean install archetype:update-local-catalog
</code></pre> 
Anschließend kann ein neues Maven-Projekt angelegt werden, und zwar mit einem Befehl wie folgendem:

<pre><code>
>mvn archetype:generate 
     -DarchetypeGroupId=agentville.jade.maven.archetype 
     -DarchetypeArtifactId=jade-agent-archetype 
     -DarchetypeVersion=1.0-SNAPSHOT 
     -DgroupId=&lt;groupId> 
     -DartifactId=&lt;artifactId>
</code></pre>     
(Wobei sich die Versions-Nr natürlich auch mal geändert haben kann. Und die &lt;groupId> und die &lt;artifactId> entsprechend
ersetzt werden müssen.)

Das mit diesem Archetype erstellte Projekt kann in Eclipse (o.ä.) importiert und auch direkt kompiliert werden. Es erzeugt dann zwei JARs:
Ein ausführbares Standard-Maven-Artefakt mit der Bezeichnung <code>&lt;artifactId>-&lt;version>.jar</code> sowie
einen JADE-Agenten mit der Bezeichnung <code>voll_qualifizierter_Klassenname_des_Agenten.jar</code>. Inhaltlich sind beide Agenten identisch.

Der Agent selbst ist natürlich simpel und dient lediglich als leichter Einstieg.

TODOs:

- Die Main-Methode und vllt. auch den Agenten noch etwas ausbauen.
- Logging ergänzen
- Testfälle ergänzen
- Dokumentation mit site
- Archetype veröffentlichen (oder wenigstens als Binary zur Verfügung stellen.)
