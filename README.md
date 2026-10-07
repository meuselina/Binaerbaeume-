# Binärbäume · Binary Trees

Classic binary tree algorithms in Java, written recursively.

## What's inside

| Method | What it does |
|---|---|
| `preorder` | Traversal: root, left, right |
| `inorder` | Traversal: left, root, right |
| `postorder` | Traversal: left, right, root |
| `istVollstaendig` | Checks if every node has either 0 or 2 children (full binary tree) |
| `istPerfekt` | Checks if the tree is perfect (all leaves on the same level) |
| `hoehe` | Height of the tree |
| `suche` | Searches for a value in a binary search tree |
| `einfuegen` | Inserts a value into a binary search tree |

## Files

| File | Purpose |
|---|---|
| `Binaerbaeume.java` | The algorithms |
| `BinTree.java` | The binary tree data structure |
| `Main.java` | Demo that builds a search tree and runs every algorithm |
| `BinaerbaeumeTest.java` | 19 automated tests, including edge cases (empty tree, single node, duplicates) |

## Run

```bash
javac *.java
java Main               # demo
java BinaerbaeumeTest   # tests
```

```
        50
      /    \
    30      70
   /  \    /  \
  20  40  60  80

Preorder:  50 30 20 40 70 60 80
Inorder:   20 30 40 50 60 70 80   (sortiert!)
Postorder: 20 40 30 60 80 70 50
Hoehe:     2
```

## Built with

Java
