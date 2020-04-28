import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
  private class Node {
    public E e;
    public Node left, right;

    public Node(E e) {
      this.e = e;
      left = null;
      right = null;
    }
  }

  private Node root;
  private int size;

  public BST() {
    root = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  /*
  public void add(E e) {
    if (root == null) {
      root = new Node(e);
      size++;
    } else {
      add(root, e);
    }
  }

  private void add(Node node, E e) {
    if (e.equals(node.e)) {
      return;
    } else if (e.compareTo(node.e) < 0 && node.left == null) {
      node.left = new Node(e);
      size++;
      return;
    } else if (e.compareTo(node.e) > 0 && node.right == null) {
      node.right = new Node(e);
      size++;
      return;
    }

    if (e.compareTo(node.e) < 0) add(node.left, e);
    else add(node.right, e);
  }

   */

  public void add(E e) {
    root = add(root, e);
  }

  private Node add(Node node, E e) {
    if (node == null) {
      size++;
      return new Node(e);
    }


    if (e.compareTo(node.e) < 0) node.left = add(node.left, e);
    else if (e.compareTo(node.e) > 0) node.right = add(node.right, e);
    return node;
  }

  public boolean contains(E e) {
    return contains(root, e);
  }

  private boolean contains(Node node, E e) {

    if (node == null) {
      return false;
    }
    if (e.compareTo(node.e) == 0) return true;
    else if (e.compareTo(node.e) < 0) return contains(node.left, e);
    else return contains(node.right, e);
  }

  public void levelOrder() {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      System.out.println(node.e);
      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }
  }

  public void preOrderNR() {
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node cur = stack.pop();
      System.out.println(cur.e);

      if (cur.right != null) stack.push(cur.right);
      if (cur.left != null) stack.push(cur.left);
    }
  }

  public void preOrder() {
    preOrder(root);
  }

  private void preOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.println(node.e);
    preOrder(node.left);
    preOrder(node.right);
  }

  public void inOrder() {
    inOrder(root);
  }

  private void inOrder(Node node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    System.out.println(node.e);
    inOrder(node.right);
  }

  public void postOrder() {
    postOrder(root);
  }

  private void postOrder(Node node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.e);
  }

  public E maximum() {
    if (size == 0) throw new IllegalArgumentException("BST is empty");
    return maximum(root);
  }

  private E maximum(Node node) {
    if (node.right == null) {
      return node.e;
    }
    return maximum(node.right);
  }

  public E minimum() {
    if (size == 0) throw new IllegalArgumentException("BST is empty");
    return minimum(root).e;
  }

  private Node minimum(Node node) {
    if (node.left == null) {
      return node;
    }
    return minimum(node.left);
  }

  public E removeMin() {
    E ret = minimum();
    removeMin(root);
    return ret;
  }

  private Node removeMin(Node node) {
    if (node.left == null) {
      Node rightNode = node.right;
      node.right = null;
      size--;
      return rightNode;
    }
    node.left = removeMin(node.left);
    return node;
  }

  public E removeMax() {
    E ret = maximum();
    removeMax(root);
    return ret;
  }

  private Node removeMax(Node node) {
    if (node.right == null) {
      Node leftNode = node.left;
      node.left = null;
      size--;
      return leftNode;
    }
    node.right = removeMax(node.right);
    return node;
  }

  public void remove(E e) {
    remove(root, e);
  }

  private Node remove(Node node, E e) {
    if (node == null) return null;

    if (e.compareTo(node.e) < 0) {
      node.left = remove(node.left, e);
      return node;
    } else if (e.compareTo(node.e) > 0) {
      node.right = remove(node.right, e);
      return node;
    } else {
      if (node.left == null) {
        Node rightNode = node.right;
        node.right = null;
        size--;
        return rightNode;
      }
      if (node.right == null) {
        Node leftNode = node.left;
        node.left = null;
        size--;
        return leftNode;
      }
      Node successor = minimum(node.right);
      successor.right = removeMin(node.right);
      successor.left = node.left;
      node.left = node.right = null;
      return successor;
    }
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    generateBSTString(root, 0, res);
    return res.toString();
  }

  private void generateBSTString(Node node, int depth, StringBuilder res) {
    if (node == null) {
      res.append(generateDepthString(depth) + "null\n");
      return;
    }
    res.append(generateDepthString(depth) + node.e + "\n");
    generateBSTString(node.left, depth + 1, res);
    generateBSTString(node.right, depth + 1, res);
  }

  private String generateDepthString(int depth) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < depth; i++) res.append("--");
    return res.toString();
  }

  public static void main(String[] args) {

    BST<Integer> bst = new BST<>();
    int[] nums = {5, 3, 6, 8, 4, 2};
    for (int num : nums) bst.add(num);
    //    bst.preOrder();
    //    System.out.println("or");
    //    bst.preOrderNR();
    //    System.out.println();
    //    // System.out.println(bst);
    //    bst.inOrder(); // in order print
    //    System.out.println();
    //    bst.postOrder(); // free memory
    //    System.out.println();
    //    bst.levelOrder();
    //    System.out.println("query:");
    //    System.out.println(bst.maximum());
    //    System.out.println(bst.minimum());

    bst.inOrder();
    System.out.println();
    bst.removeMin();
    System.out.println();
    bst.inOrder();
    bst.removeMax();
    System.out.println();
    bst.inOrder();
  }
}
