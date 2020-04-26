import java.util.Random;

public class LinkedListStack<E> implements Stack<E> {

  private LinkedList<E> list;

  public LinkedListStack() {
    list = new LinkedList<>();
  }

  @Override
  public int getSize() {
    return list.getSize();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public void push(E e) {
    list.add(0, e);
  }

  @Override
  public E pop() {
    return list.removeFirst();
  }

  @Override
  public E peek() {
    return list.getFirst();
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("Stack: top ");
    res.append(list);
    return res.toString();
  }

  private static double testStack(Stack<Integer> stack, int opCount) {
    long startTime = System.nanoTime();
    Random random = new Random();
    for (int i = 0; i < opCount; i++) stack.push(random.nextInt(Integer.MAX_VALUE));
    for (int i = 0; i < opCount; i++) stack.pop();

    long endTime = System.nanoTime();
    return (endTime - startTime) / 1000000000.0;
  }

  public static void main(String[] args) {
    int opCount = 100000;
    ArrayStack<Integer> arrayStack = new ArrayStack<>();
    double time1 = testStack(arrayStack, opCount);
    System.out.println("ArrayStack, time: " + time1 + " s");

    LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
    double time2 = testStack(linkedListStack, opCount);
    System.out.println("LinkedListStack, time: " + time2 + " s");

  }
}
