import java.util.*;

public class BST {
  private class Node {
    private int value;
    private Node left;
    private Node right;

    Node(int v, Node l, Node r) {
      value = v;
      left = l;
      right = l;
    }
  }

  private Node root;

  BST() {
    root = null;
  }

  public boolean search(int value) {
    Node subtree = root;
    while (subtree != null) {
      if (value == subtree.value) return true;
      else if (value < subtree.value) subtree = subtree.left;
      else if (value > subtree.value) subtree = subtree.right;
    }
    return false;
  }

  public void insert(int value) {
    root = insert(value, root);
  }

  private Node insert(int value, Node subtree) {
    if (subtree == null) return new Node(value, null, null);
    if (value < subtree.value) {
      subtree.left = insert(value, subtree.left);
    }
    if (value > subtree.value) {
      subtree.right = insert(value, subtree.right);
    }
    return subtree;
  }

  public int max() {
    Node tree = root;
    while (tree != null && tree.right != null) {
      tree = tree.right;
    }
    return tree.value;
  }

  public Integer[] traverse() {
    ArrayList<Integer> xs = traverse(root);
    Integer[] ys = xs.toArray(new Integer[xs.size()]);
    return ys;
  }

  private ArrayList<Integer> traverse(Node subtree) {
    ArrayList<Integer> xs = new ArrayList<>();
    if (subtree == null) return xs;
    xs.addAll(traverse(subtree.left));
    xs.add(subtree.value);
    xs.addAll(traverse(subtree.right));
    return xs;
  }

  public int height() {
     return height(root);
  }

  private int height(Node subtree) {
    if (subtree == null) return 0;
    return 1 + Math.max(height(subtree.right), height(subtree.left));
  }

  public static void main(String[] args) {
    BST bst = new BST();
    int[] nums = { 7, 14, 3, 22, 1, 0, 66, 16 };
    for (int n : nums) bst.insert(n);
    System.out.println(bst.search(3));
    System.out.println(bst.search(12));
    System.out.println(bst.max());
    Integer[] sorted = bst.traverse();
    System.out.print("{ ");
    for (int s: sorted) {
      System.out.print(s + " , ");
    }
    System.out.println(" }");
    System.out.println(bst.height());
  }
}
