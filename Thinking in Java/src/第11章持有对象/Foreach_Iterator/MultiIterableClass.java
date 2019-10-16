package 第11章持有对象.Foreach_Iterator;

import java.util.*;

public class MultiIterableClass extends IterableClass {

    public Iterable<String> reversed(){
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current=words.length-1;
                    @Override
                    public boolean hasNext() {
                        return current>-1;
                    }

                    @Override
                    public String next() {
                        return words[current--];
                    }
                };
            }
        };
    }

    public Iterable<String> randomized(){
        return new Iterable<String>() {
            @Override
            //shuffle :洗牌
            //static void shuffle(List<?> list, Random rnd)
            //使用指定的随机源随机排列指定的列表。
            public Iterator<String> iterator() {
                List<String> shuffled=new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(shuffled,new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args){
        MultiIterableClass mic=new MultiIterableClass();
        for (String s : mic.reversed()){
            System.out.print(s+" ");
        }
        System.out.println();
        for (String s: mic.randomized()){
            System.out.print(s+" ");
        }
        System.out.println();
        for (String s:mic){
            System.out.print(s+" ");
        }
        /**
         * 从输出可以看到，Collection.shuffle()方法没有影响到原来的数组，而只是打乱了shuffled中的引用。
         */
        test();
    }

    public static void test(){
        System.out.println();
        System.out.println("**********************");
        Random rand=new Random(47);
        Integer[] ia={1,2,3,4,5,6,7,8,9,10};
        List<Integer> list1=new ArrayList<>(Arrays.asList(ia));
        System.out.println("Before shuffling: "+ list1);
        Collections.shuffle(list1,rand);
        System.out.println("After shuffling: "+ list1);
        System.out.println("array: "+Arrays.toString(ia));

        List<Integer> list2=Arrays.asList(ia);
        System.out.println("Before shuffling: "+ list2);
        Collections.shuffle(list2,rand);
        System.out.println("After shuffling: "+ list2);
        System.out.println("array: "+Arrays.toString(ia));
    }
}
