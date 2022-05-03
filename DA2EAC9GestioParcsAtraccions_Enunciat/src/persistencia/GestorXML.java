package persistencia;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import principal.GestorParcsAtraccionsException;
import principal.Parc;

/**
 *
 * @author fta
 */
public class GestorXML implements ProveedorPersistencia {

    private Document doc;
    private Parc parc;

    public Document getDoc() {
        return doc;
    }

    public Parc getParc() {
        return parc;
    }

    @Override
    public void desarParc(String nomFitxer, Parc parc) throws GestorParcsAtraccionsException {
        construeixModel(parc);
        desarModel(nomFitxer);
    }

    @Override
    public void carregarParc(String nomFitxer) throws GestorParcsAtraccionsException {
        carregarFitxer(nomFitxer);
        llegirFitxerParc();
    }

    /*Paràmetres: Parc a partir de la qual volem construir el model
     *
     *Acció: 
     * - Llegir els atributs de l'objecte parc passat per paràmetre per construir 
     *   un model (document XML) sobre el Document doc (atribut de GestorXML).
     *
     * - L'arrel del document XML és "parc". Aquesta arrel, l'heu d'afegir a doc. Un 
     *   cop fet això, heu de recórrer l'ArrayList installacions del parc passat per
     *   paràmetre i per a cada instal.lació, afegir un fill a doc. Cada fill tindrà
     *   com atributs els atributs de l'objecte (codi, nom, tipus, etc.)
     *
     * - Si heu de gestionar alguna excepció relacionada amb la construcció del model,
     *   heu de llençar una excepció de tipus GestorParcsAtraccionsException amb codi 
     *   "GestorXML.model".
     *
     *Retorn: cap
     */
    public void construeixModel(Parc parc) throws GestorParcsAtraccionsException {
        
    }

    public void desarModel(String nomFitxer) throws GestorParcsAtraccionsException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            File f = new File(nomFitxer + ".xml");
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (Exception ex) {
            throw new GestorParcsAtraccionsException("GestorXML.desar");
        }
    }

    public void carregarFitxer(String nomFitxer) throws GestorParcsAtraccionsException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            File f = new File(nomFitxer + ".xml");
            doc = builder.parse(f);
        } catch (Exception ex) {
            throw new GestorParcsAtraccionsException("GestorXML.carrega");
        }
    }

    /*Paràmetres: cap
     *
     *Acció: 
     * - Llegir el fitxer del vostre sistema i carregar-lo sobre l'atribut doc, per
     *   assignar valors als atributs del parc i la resta d'objectes que formen les
     *   instal.lacions del parc.
     *    
     * - Primer heu de crear l'objecte de la classe Parc a partir de l'arrel del document XML
     *   per després recórrer el doc i per cada fill, afegir un objecte a l'atribut instal.lacions 
     *   del parc mitjançant el mètode escaient de la classe Parc. Recordeu que com l'arrel conté
     *   els atributs nom i adreça del parc, al fer Element arrel = doc.getDocumentElement(); 
     *   ja podeu crear l'objecte de la classe.
     *
     *Retorn: cap
     */
    private void llegirFitxerParc() throws GestorParcsAtraccionsException {
        
    }
}
