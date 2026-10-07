/**
 * Ein einfacher Binaerbaum mit ganzzahligen Werten.
 *
 * Jeder Knoten speichert einen Wert (item) und hat hoechstens
 * einen linken und einen rechten Teilbaum.
 */
public class BinTree {

    private Integer item;
    private BinTree left;
    private BinTree right;

    /** Leerer Baum ohne Wert. */
    public BinTree() {
        this.item = null;
    }

    /** Baum mit genau einem Knoten. */
    public BinTree(int item) {
        this.item = item;
    }

    /** Baum mit Wert und zwei Teilbaeumen (die auch null sein duerfen). */
    public BinTree(int item, BinTree left, BinTree right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }

    public boolean hasItem() {
        return item != null;
    }

    public int getItem() {
        if (item == null) {
            throw new IllegalStateException("Der Baum ist leer.");
        }
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public boolean hasLeft() {
        return left != null && left.hasItem();
    }

    public boolean hasRight() {
        return right != null && right.hasItem();
    }

    public BinTree getLeft() {
        return left;
    }

    public BinTree getRight() {
        return right;
    }

    public void setLeft(BinTree left) {
        this.left = left;
    }

    public void setRight(BinTree right) {
        this.right = right;
    }
}
