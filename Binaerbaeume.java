public class Binaerbaeume {

// Preoder-Traversierung eines Binärbaums. 
// Liefert eine String-Darstellung der Knotenwerte in Preorder-Reihenfolge
public static String preorder (BinTree baum) {
    String ausgabe = "";
    ausgabe = ausgabe +  " " + baum.getItem();
    if (baum.hasLeft());
    ausgabe = ausgabe + preorder(baum.getLeft());
    if (baum.hasRight());
    ausgabe= ausgabe + preorder(baum.hasRight());
    return ausgabe;
}    

// Postorder-Traversierung eines Binärmbaums. 
// Liefert eine String-Darstellung der Knotenwerte in Postorder-Reihenfolge.
public static String postorder (BinTree baum){
    String ausgabe = "";
    if (baum.hasLeft());
    ausgabe = ausgabe + postorder(baum.getLeft());
    if (baum.hasRight());
    ausgabe = ausgabe + postorder(baum.getRight());
    ausgabe = ausgabe + " " + baum.getItem();
    return ausgabe;
}  

// Inorder-Traversierung eines Binärbaums.Lifert eine 
// String-Darstellung der Knotenwerte in Inorder-Reihenfolge
public static String inorder (BinTree baum){
    String ausgabe = "";
    if (baum.hasLeft());
    ausgabe = ausgabe + inorder(baum.getLeft());
    ausgabe = ausgabe + " " + baum.getItem();
    if (baum.hasRight());
    ausgabe = ausgabe + inorder(baum.getRight());
    return ausgabe;
}

// Ein vollständiger Binärbaum ist ein Binärbaum in dem jeder Knoten 
// entweder 0 oder 2 Kinder hat.
public static booloean istVollstaendig (BinTree baum){
    if (baum == null) {
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

// Ein perfekter Binärbaum ist ein Binärbaum in dem alle Blätter die 
// gleiche Tiefe haben und jeder Knoten entweder 0 oder 2 Kinder hat.
public static boolean istPerfekt (BinTree baum){
    if (baum == null) {
        return true;
    }
    if (baum.hasLeft() && baum.hasRight()) {
        return istPerfekt(baum.getLeft()) && istPerfekt(baum.getRight());
    }
    if (!baum.hasLeft() && !baum.hasRight()) {
        return true;
    }
    return false;
}

// Nach einem Wert innerhalb des Baums suchen. Liefert true, 
// wenn der Wertgefunden wurde, sonst flase.
public static boolean suche (BinTree baum, int suchwert){
    if(baum.hasItem()){
        if(baum.getItem() == suchwert){
            return true;
        }
        else {
            if(baum.getItem()<suchwert){
                if(baum.hasRight()){}
                return suche(baum.getRight(),suchwert);
            }
        
            else{
                return false;
            }
        }

        else {
            if(baum.hasLeft()){
                return suche(baum.hasLeft(), suchwert);
            }
            else{
                return false;
            }
        }
    }
    return false; 
}
        
// Wert in den Binrbaum einfügen. Liefert den Baum mit 
// dem eingefügten Wert zurück.       
public static BinTree einfuegen (Bin Tree baum, int wert){
    if ( wert < baum.getItem()){
        if (baum.hasLeft()){
            return einfuegen(baum.getLeft(), wert);
        }
        else{
            baum.setLeft(new BinTree(wert));
            return baum;
        }
    }
    if (wert > baum.getItem()){
        if  (baum.hasLeft()){
            einfuegen (baum.getRight(),wert);
        }
        else{
            baum.setRight(new BinTree(wert));
            return baum;
        }
    }
    return baum;
}
 
}


        
    

