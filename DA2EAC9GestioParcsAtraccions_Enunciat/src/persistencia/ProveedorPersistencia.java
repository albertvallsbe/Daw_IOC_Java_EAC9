package persistencia;

import principal.GestorParcsAtraccionsException;
import principal.Parc;

/**
 *
 * @author fta
 */
public interface ProveedorPersistencia {
    public void desarParc(String nomFitxer, Parc parc)throws GestorParcsAtraccionsException;
    public void carregarParc(String nomFitxer)throws GestorParcsAtraccionsException; 
}
