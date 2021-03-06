import java.util.ArrayList;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
  private BST<E> bst;

  public BSTSet() {
    bst = new BST<>();
  }

  @Override
  public void add(E e) {
    bst.add(e);
  }

  @Override
  public void remove(E e) {
    bst.remove(e);
  }

  @Override
  public boolean contains(E e) {
    return bst.contains(e);
  }

  @Override
  public int getSize() {
    return bst.size();
  }

  @Override
  public boolean isEmpty() {
    return bst.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println("Pride and Prejudice");
    ArrayList<String> wordsForPP = new ArrayList<>();

    if (FileOperation.readFile("jane-austen-pride-prejudice.txt", wordsForPP)) {
      System.out.println("Total words: " + wordsForPP.size());
      BSTSet<String> set1 = new BSTSet<>();
      for (String word : wordsForPP) set1.add(word);
      System.out.println("Total different words: " + set1.getSize());
    }

    System.out.println("A Tale of Two Cities");
    ArrayList<String> wordsForTC = new ArrayList<>();

    if (FileOperation.readFile("tale-of-two-cities.txt", wordsForTC)) {
      System.out.println("Total words: " + wordsForTC.size());
      BSTSet<String> set2 = new BSTSet<>();
      for (String word : wordsForTC) set2.add(word);
      System.out.println("Total different words: " + set2.getSize());
    }
  }
}
