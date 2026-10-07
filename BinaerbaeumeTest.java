/**
 * Automatische Tests fuer alle Methoden in Binaerbaeume.
 * Ohne externe Bibliothek: einfach kompilieren und starten.
 *
 *   javac *.java
 *   java BinaerbaeumeTest
 */
public class BinaerbaeumeTest {

    private static int bestanden = 0;
    private static int fehlgeschlagen = 0;

    private static void pruefe(String name, Object erwartet, Object tatsaechlich) {
        if (erwartet.equals(tatsaechlich)) {
            bestanden++;
        } else {
            fehlgeschlagen++;
            System.out.println("FEHLER " + name + ": erwartet <" + erwartet + ">, bekommen <" + tatsaechlich + ">");
        }
    }

    private static BinTree baue(int... werte) {
        BinTree baum = null;
        for (int wert : werte) {
            baum = Binaerbaeume.einfuegen(baum, wert);
        }
        return baum;
    }

    public static void main(String[] args) {
        BinTree perfekt = baue(50, 30, 70, 20, 40, 60, 80);

        pruefe("preorder", " 50 30 20 40 70 60 80", Binaerbaeume.preorder(perfekt));
        pruefe("inorder", " 20 30 40 50 60 70 80", Binaerbaeume.inorder(perfekt));
        pruefe("postorder", " 20 40 30 60 80 70 50", Binaerbaeume.postorder(perfekt));
        pruefe("hoehe perfekt", 2, Binaerbaeume.hoehe(perfekt));
        pruefe("perfekt ist vollstaendig", true, Binaerbaeume.istVollstaendig(perfekt));
        pruefe("perfekt ist perfekt", true, Binaerbaeume.istPerfekt(perfekt));
        pruefe("suche vorhanden", true, Binaerbaeume.suche(perfekt, 60));
        pruefe("suche fehlt", false, Binaerbaeume.suche(perfekt, 65));

        // Leerer Baum
        pruefe("hoehe leer", -1, Binaerbaeume.hoehe(new BinTree()));
        pruefe("hoehe null", -1, Binaerbaeume.hoehe(null));
        pruefe("preorder leer", "", Binaerbaeume.preorder(null));
        pruefe("suche leer", false, Binaerbaeume.suche(null, 1));

        // Einzelner Knoten
        BinTree eins = new BinTree(7);
        pruefe("hoehe ein Knoten", 0, Binaerbaeume.hoehe(eins));
        pruefe("ein Knoten perfekt", true, Binaerbaeume.istPerfekt(eins));

        // Knoten mit nur einem Kind: weder vollstaendig noch perfekt
        BinTree schief = baue(10, 5);
        pruefe("schief vollstaendig", false, Binaerbaeume.istVollstaendig(schief));
        pruefe("schief perfekt", false, Binaerbaeume.istPerfekt(schief));

        // Vollstaendig, aber nicht perfekt (Blaetter auf verschiedenen Ebenen)
        BinTree vollNichtPerfekt = baue(50, 30, 70, 60, 80);
        pruefe("voll aber nicht perfekt: voll", true, Binaerbaeume.istVollstaendig(vollNichtPerfekt));
        pruefe("voll aber nicht perfekt: perfekt", false, Binaerbaeume.istPerfekt(vollNichtPerfekt));

        // Doppelte Werte werden nicht erneut eingefuegt
        BinTree doppelt = baue(5, 3, 5, 3);
        pruefe("keine Duplikate", " 3 5", Binaerbaeume.inorder(doppelt));

        System.out.println(bestanden + " Tests bestanden, " + fehlgeschlagen + " fehlgeschlagen.");
        if (fehlgeschlagen > 0) {
            System.exit(1);
        }
    }
}
