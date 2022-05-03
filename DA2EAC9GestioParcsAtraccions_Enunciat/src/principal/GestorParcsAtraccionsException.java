package principal;

/**
 *
 * @author fta
 */
public class GestorParcsAtraccionsException extends Exception {

    private String codiCausa = "desconegut";
    private String missatge;

    public GestorParcsAtraccionsException(String codiCausa) {
        this.codiCausa = codiCausa;
        switch (codiCausa) {
            case "1":
                missatge = "L'opció introduïda no és numèrica";
                break;
            case "2":
                missatge = "El valor introduït no és correcte";
                break;
            case "3":
                missatge = "Ja no hi caben més instal.lacions";
                break;
            case "4":
                missatge = "Aquest parc ja existeix";
                break;
            case "GestorXML.model":
                missatge = "No s'ha pogut crear el model XML per desar el parc";
                break;
            case "GestorXML.desar":
                missatge = "No s'ha pogut desar el parc a causa d'error d'entrada/sortida";
                break;
            case "GestorXML.carrega":
                missatge = "No s'ha pogut carregar el parc a causa d'error d'entrada/sortida";
                break;
            default:
                missatge = "Error desconegut";
                break;
        }
    }

    public String getMessage() {
        
        
    }
}
