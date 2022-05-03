package persistencia;

import principal.GestorParcsAtraccionsException;
import principal.Parc;
/**
 *
 * @author fta
 */
public class GestorPersistencia {

    private GestorXML gestor;

    public GestorXML getGestor() {
        return gestor;
    }

    public void setGestor(GestorXML pGestor) {
        gestor = pGestor;
    }

    public void desarParc(String tipusPersistencia, String nomFitxer, Parc parc) throws GestorParcsAtraccionsException {
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.desarParc(nomFitxer, parc);
        }
    }

    public void carregarParc(String tipusPersistencia, String nomFitxer) throws GestorParcsAtraccionsException {

        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.carregarParc(nomFitxer);
        }
    }
}
