public class Binaerbaeume {

    // Preorder-Traversierung eines Binaerbaums.
    // Liefert eine String-Darstellung der Knotenwerte in Preorder-Reihenfolge
    // (Wurzel, links, rechts).
    public static String preorder(BinTree baum) {
        if (baum == null || !baum.hasItem()) {
            return "";
        }
        String ausgabe = " " + baum.getItem();
        if (baum.hasLeft()) {
            ausgabe = ausgabe + preorder(baum.getLeft());
        }
        if (baum.hasRight()) {
            ausgabe = ausgabe + preorder(baum.getRight());
        }
        return ausgabe;
    }

    // Postorder-Traversierung eines Binaerbaums.
    // Liefert eine String-Darstellung der Knotenwerte in Postorder-Reihenfolge
    // (links, rechts, Wurzel).
    public static String postorder(BinTree baum) {
        if (baum == null || !baum.hasItem()) {
            return "";
        }
        String ausgabe = "";
        if (baum.hasLeft()) {
            ausgabe = ausgabe + postorder(baum.getLeft());
        }
        if (baum.hasRight()) {
            ausgabe = ausgabe + postorder(baum.getRight());
        }
        ausgabe = ausgabe + " " + baum.getItem();
        return ausgabe;
    }

    // Inorder-Traversierung eines Binaerbaums.
    // Liefert eine String-Darstellung der Knotenwerte in Inorder-Reihenfolge
    // (links, Wurzel, rechts).
    public static String inorder(BinTree baum) {
        if (baum == null || !baum.hasItem()) {
            return "";
        }
        String ausgabe = "";
        if (baum.hasLeft()) {
            ausgabe = ausgabe + inorder(baum.getLeft());
        }
        ausgabe = ausgabe + " " + baum.getItem();
        if (baum.hasRight()) {
            ausgabe = ausgabe + inorder(baum.getRight());
        }
        return ausgabe;
    }

    // Ein vollstaendiger Binaerbaum ist ein Binaerbaum, in dem jeder Knoten
    // entweder 0 oder 2 Kinder hat.
    public static boolean istVollstaendig(BinTree baum) {
        if (baum == null || !baum.hasItem()) {
            return true;
        }
        if (baum.hasLeft() && baum.hasRight()) {
            return istVollstaendig(baum.getLeft()) && istVollstaendig(baum.getRight());
        }
        if (!baum.hasLeft() && !baum.hasRight()) {
            return true;
        }
        return false;
    }

    // Ein perfekter Binaerbaum ist ein vollstaendiger Binaerbaum, in dem
    // zusaetzlich alle Blaetter dieselbe Tiefe haben.
    public static boolean istPerfekt(BinTree baum) {
        return istPerfekt(baum, hoehe(baum), 0);
    }

    private static boolean istPerfekt(BinTree baum, int gesamthoehe, int tiefe) {
        if (baum == null || !baum.hasItem()) {
            return true;
        }
        boolean hatLinks = baum.hasLeft();
        boolean hatRechts = baum.hasRight();
        // Blatt: muss auf der untersten Ebene liegen
        if (!hatLinks && !hatRechts) {
            return tiefe == gesamthoehe;
        }
        // innerer Knoten: muss genau zwei Kinder haben
        if (hatLinks && hatRechts) {
            return istPerfekt(baum.getLeft(), gesamthoehe, tiefe + 1)
                && istPerfekt(baum.getRight(), gesamthoehe, tiefe + 1);
        }
        return false;
    }

    // Hoehe des Baums: Anzahl der Kanten auf dem laengsten Pfad von der
    // Wurzel zu einem Blatt. Leerer Baum: -1, einzelner Knoten: 0.
    public static int hoehe(BinTree baum) {
        if (baum == null || !baum.hasItem()) {
            return -1;
        }
        int links = baum.hasLeft() ? hoehe(baum.getLeft()) : -1;
        int rechts = baum.hasRight() ? hoehe(baum.getRight()) : -1;
        return 1 + Math.max(links, rechts);
    }

    // Sucht einen Wert in einem binaeren Suchbaum. Liefert true, wenn der
    // Wert gefunden wurde, sonst false.
    public static boolean suche(BinTree baum, int suchwert) {
        if (baum == null || !baum.hasItem()) {
            return false;
        }
        if (baum.getItem() == suchwert) {
            return true;
        }
        if (suchwert < baum.getItem()) {
            return baum.hasLeft() && suche(baum.getLeft(), suchwert);
        } else {
            return baum.hasRight() && suche(baum.getRight(), suchwert);
        }
    }

    // Fuegt einen Wert in einen binaeren Suchbaum ein und liefert die
    // Wurzel zurueck. Bereits vorhandene Werte werden nicht erneut eingefuegt.
    public static BinTree einfuegen(BinTree baum, int wert) {
        if (baum == null || !baum.hasItem()) {
            return new BinTree(wert);
        }
        if (wert < baum.getItem()) {
            if (baum.hasLeft()) {
                einfuegen(baum.getLeft(), wert);
            } else {
                baum.setLeft(new BinTree(wert));
            }
        } else if (wert > baum.getItem()) {
            if (baum.hasRight()) {
                einfuegen(baum.getRight(), wert);
            } else {
                baum.setRight(new BinTree(wert));
            }
        }
        return baum;
    }
}
