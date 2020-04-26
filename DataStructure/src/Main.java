import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /**
         Array<Integer> arr = new Array<>();
         for (int i = 0; i < 10; i++)
         arr.addLast(i);
         System.out.println(arr);

         arr.add(1, 100);
         System.out.println(arr);

         arr.addFirst(-1);
         System.out.println(arr);


         ArrayStack<Integer> stack = new ArrayStack<>();
         for (int i = 0; i < 5; i++) {
         stack.push(i);
         System.out.println(stack);
         }
         stack.pop();
         System.out.println(stack);
         */

        int opCount = 10000;
        double arrayQueueCost = testQueue(new ArrayQueue<>(), opCount);
        System.out.println("ArrayQueue, time: " + arrayQueueCost + "s");

        double loopQueueCost = testQueue(new LoopQueue<>(), opCount);
        System.out.println("LoopQueue, time: " + loopQueueCost + "s");


        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("linkedListQueue, time: " + time3 + " s");
    }

    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            q.dequeue();


        long endTime = System.nanoTime();
        return (endTime - startTime) / 100000000;
    }

}
