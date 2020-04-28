import java.util.ArrayList;

public class LinkedListSet<E> implements Set<E> {

  private LinkedList<E> list;

  public LinkedListSet() {
    list = new LinkedList<>();
  }

  @Override
  public void add(E e) {
    if (!list.contains(e)) {
      list.addFirst(e);
    }
  }

  @Override
  public void remove(E e) {
    list.removeElement(e);
  }

  @Override
  public boolean contains(E e) {
    return list.contains(e);
  }

  @Override
  public int getSize() {
    return list.getSize();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println("Pride and Prejudice");
    ArrayList<String> wordsForPP = new ArrayList<>();

    if (FileOperation.readFile("jane-austen-pride-prejudice.txt", wordsForPP)) {
      System.out.println("Total words: " + wordsForPP.size());
      LinkedListSet<String> set1 = new LinkedListSet<>();
      for (String word : wordsForPP) set1.add(word);
      System.out.println("Total different words: " + set1.getSize());
    }

    System.out.println("A Tale of Two Cities");
    ArrayList<String> wordsForTC = new ArrayList<>();

    if (FileOperation.readFile("tale-of-two-cities.txt", wordsForTC)) {
      System.out.println("Total words: " + wordsForTC.size());
      LinkedListSet<String> set2 = new LinkedListSet<>();
      for (String word : wordsForTC) set2.add(word);
      System.out.println("Total different words: " + set2.getSize());
    }
  }
}
