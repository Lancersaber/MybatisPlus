package 第11章持有对象.queue;

import java.util.*;

public class PriorityQueueDemo {

    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        Random rand=new Random(47);
        for (int i=0;i<10;i++){
            priorityQueue.offer(rand.nextInt(i+10));
        }
        printQ(priorityQueue);
        List<Integer> ints= Arrays.asList(25,22,20,18,14,9,3,1,1,2,3,9,14,18,21,23,25);
        priorityQueue=new PriorityQueue<>(ints);
        printQ(priorityQueue);
        priorityQueue=new PriorityQueue<>(ints.size(),Collections.reverseOrder());
        priorityQueue.addAll(ints);
        printQ(priorityQueue);

        String fact="EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings=Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ=new PriorityQueue<>(strings);
        printQ(stringPQ);
        stringPQ=new PriorityQueue<>(strings.size(),Collections.reverseOrder());
        stringPQ.addAll(strings);
        printQ(stringPQ);
    }

    /**
     * 从运行结果可以看到，重复是允许的，最小的值拥有最高的优先级(如果是String，空格也可以算作值，并且比字母的优先级高)。
     */

    public static void printQ(Queue queue){
        while (queue.peek()!=null){
            System.out.print(queue.remove()+" ");
        }
        System.out.println(" ");
    }
}
