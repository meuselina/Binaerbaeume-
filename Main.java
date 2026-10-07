/**
 * Kleine Demo: baut einen binaeren Suchbaum auf und zeigt alle Algorithmen.
 *
 * Starten mit:
 *   javac *.java
 *   java Main
 */
public class Main {

    public static void main(String[] args) {
        int[] werte = {50, 30, 70, 20, 40, 60, 80};

        BinTree baum = null;
        for (int wert : werte) {
            baum = Binaerbaeume.einfuegen(baum, wert);
        }

        System.out.println("Eingefuegt: 50 30 70 20 40 60 80");
        System.out.println();
        System.out.println("        50");
        System.out.println("      /    \\");
        System.out.println("    30      70");
        System.out.println("   /  \\    /  \\");
        System.out.println("  20  40  60  80");
        System.out.println();
        System.out.println("Preorder: " + Binaerbaeume.preorder(baum));
        System.out.println("Inorder:  " + Binaerbaeume.inorder(baum) + "   (sortiert!)");
        System.out.println("Postorder:" + Binaerbaeume.postorder(baum));
        System.out.println();
        System.out.println("Hoehe:          " + Binaerbaeume.hoehe(baum));
        System.out.println("Vollstaendig:   " + Binaerbaeume.istVollstaendig(baum));
        System.out.println("Perfekt:        " + Binaerbaeume.istPerfekt(baum));
        System.out.println("Suche 60:       " + Binaerbaeume.suche(baum, 60));
        System.out.println("Suche 65:       " + Binaerbaeume.suche(baum, 65));

        Binaerbaeume.einfuegen(baum, 65);
        System.out.println();
        System.out.println("Nach Einfuegen von 65:");
        System.out.println("Hoehe:          " + Binaerbaeume.hoehe(baum));
        System.out.println("Vollstaendig:   " + Binaerbaeume.istVollstaendig(baum));
        System.out.println("Perfekt:        " + Binaerbaeume.istPerfekt(baum));
    }
}
