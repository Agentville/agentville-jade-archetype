agentville-jade-archetype
=========================

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

Notwendige Anpassungen
----------------------

- Wenn die Klasse "MyAgent" umbenannt wird, dann muss diese Bezeichnung auch in der POM geändert werden.
- Wenn die Klasse "MyAgent" umbenannt wird, dann muss außerdem die Referenz in der Klasse "AgentStarter" geändert werden - außer die Umbenennung der Klasse erfolgte mit der Rename-Funktion der IDE. Die macht das automatisch.
- Wenn die Klasse "AgentStarter" umbenannt wird, dann muss ebenfalls eine Referenz in der POM geändert werden.
- Wenn die Klasse "AgentStarter" gelöscht wird, beispielsweise weil der Agent keine <code>Main</code>-Methode benötigt, wird durch die POM ein ungültiger Eintrag in der Manifest-Datei der erstellten Binaries erzeugt. Der Eintrag kann dann auch einfach entfallen, also folgende Zeile löschen: <pre><code>&lt;mainClass>${project.groupId}.AgentStarter&lt;/mainClass></code></pre>
- Die Properties "name" und "url" in der POM sollten natürlich auch sinnvoll geändert werden.

TODOs
-----

- Die Main-Methode und vllt. auch den Agenten noch etwas ausbauen.
- Logging ergänzen (Java logging, JADE logging)
- Testfälle ergänzen (JADE TestSuite, junit?)
- API-Docs und Reports (javadoc, site)
- Archetype veröffentlichen (oder wenigstens als Binary zur Verfügung stellen.) (Vor dem veröffentlichen für eine vernünftige Domain/eine vernünftige GroupID sorgen.)
 
Nice to haves
-------------

Uns allen ist klar, dass ich folgendes vermutlich nie machen werde - auch wenn ich es gern würde:
- _vernünftiges_ Logging mit log4j o.ä. Da gibts auch was für, heißt log4jade, funzt aber net unter bspswse Android afaik.
- Aufteilung auf verschiedene Archetypen:

<table border="1">
  <tr>
    <th></th>
    <th>rare</th>
    <th>medium</th>
    <th>well done</th>
  </tr>
  <tr>
    <td>Grundstruktur</td>
    <td>X</td>
    <td>X</td>
    <td>X</td>
  </tr>
  <tr>
    <td>Java-Docs (API)</td>
    <td>X</td>
    <td>X</td>
    <td>X</td>
  </tr>
  <tr>
    <td>Logging</td>
    <td></td>
    <td>X</td>
    <td>X</td>
  </tr>
  <tr>
    <td>Testing</td>
    <td></td>
    <td></td>
    <td>X</td>
  </tr>
  <tr>
    <td>Reports</td>
    <td></td>
    <td></td>
    <td>X</td>
  </tr>
</table>


