package principal;

import installacions.Atraccio;
import installacions.Botiga;
import installacions.Restaurant;
import java.util.Scanner;
import persistencia.GestorPersistencia;

/**
 *
 * @author fta
 */
public class Application {

    private final static Scanner DADES = new Scanner(System.in);

    private static Parc[] parcs = new Parc[10];
    private static int pParcs = 0; //Priemra posició buida del vector parcs
    private static Parc parcActual = null;
    static private String FITXER = "parc";
    static private GestorPersistencia gp = new GestorPersistencia();

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {

            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de parcs");
            System.out.println("\n2. Gestió d'atraccions");
            System.out.println("\n3. Gestió de botigues");
            System.out.println("\n4. Gestió de restaurants");
            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuParcs();
                    break;
                case 2:
                    if (parcActual != null) {
                        menuInstallacions(1);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el parc al menú Gestió de parcs");
                    }
                    break;
                case 3:
                    if (parcActual != null) {
                        menuInstallacions(2);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el parc al menú Gestió de parcs");
                    }
                    break;
                case 4:
                    if (parcActual != null) {
                        menuInstallacions(3);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el parc al menú Gestió de parcs");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }

        } while (opcio != 0);
    }

    public static void menuParcs() {
        int opcio = 0;

        do {

            int indexSel = -1;

            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llista de parcs");
            System.out.println("\n5. Carregar parc");
            System.out.println("\n6. Desar parc");

            opcio = DADES.nextInt();

            switch (opcio) {

                case 0:
                    break;

                case 1:
                    parcs[pParcs] = Parc.addParc();
                    pParcs++;
                    break;
                case 2:
                    indexSel = selectParc();
                    if (indexSel >= 0) {
                        parcActual = parcs[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquest parc");
                    }
                    break;
                case 3:
                    indexSel = selectParc();
                    if (indexSel >= 0) {
                        parcs[indexSel].updateInstallacio();
                    } else {
                        System.out.println("\nNo existeix aquest parc");
                    }
                    break;
                case 4:
                    for (int i = 0; i < pParcs; i++) {
                        parcs[i].showInstallacio();
                    }
                    break;
                case 5: //Carregar parc
                    parcs.clear(); //Per facilitar la feina, només podem carregar un parc
                    gp.carregarParc("XML", FITXER);
                    parcs.add(gp.getGestor().getParc());
                    break;
                case 6: //Desar parc
                    int pos = selectParc();
                    if (pos >= 0) {
                        gp.desarParc("XML", FITXER, parcs.get(pos));
                    } else {
                        System.out.println("\nNo existeix aquest parc");
                    }
                    break;

                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }

        } while (opcio != 0);
    }

    public static void menuInstallacions(int tipus){
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    switch (tipus) {
                        case 1:
                            parcActual.addAtraccio();
                            break;
                        case 2:
                            parcActual.addBotiga();
                            break;
                        case 3:
                            parcActual.addRestaurant();
                            break;
                    }
                    break;
                case 2:
                    int indexSel = parcActual.selectInstallacio(tipus,null);
                    if (indexSel >= 0) {
                        parcActual.getInstallacions()[indexSel].updateInstallacio();
                    } else {
                        System.out.println("\nNo existeix aquesta instal.lació");
                    }
                    break;
                case 3:
                    for (int i = 0; i < parcActual.getpInstallacions(); i++) {
                            if (parcActual.getInstallacions()[i] instanceof Atraccio && tipus == 1) {
                                parcActual.getInstallacions()[i].showInstallacio();
                            } else if (parcActual.getInstallacions()[i] instanceof Botiga && tipus == 2) {
                                parcActual.getInstallacions()[i].showInstallacio();
                            } else if (parcActual.getInstallacions()[i] instanceof Restaurant && tipus == 3) {
                                parcActual.getInstallacions()[i].showInstallacio();
                            }
                        }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static Integer selectParc() {

        System.out.println("\nNom del parc?:");
        DADES.nextLine(); //Neteja de buffer
        String nom = DADES.nextLine();

        for (int i = 0; i < pParcs; i++) {
            if (parcs[i].getNom().equals(nom)) {
                return i;
            }
        }
        return -1;
    }
}
