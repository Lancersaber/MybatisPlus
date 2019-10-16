package Chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 *      Java堆内存的OOM 异常是实际应用中最常见的内存移出异常情况。出现Java堆内存溢出时，异常堆栈信息"Java.lang.OutOfMemoryError"会
 * 跟着进一步提示"Java heap space".
 *      要解决这个区域的异常，一般的手段是首先通过内存映像分析工具对dump出来的堆转储快照进行分析，重点是确认内存中的对象是否必要的，
 * 也就是要先分清楚到底是出现了内存泄漏(Memory Leak)还是内存溢出(Memory Overflow)
 *      如果是内存泄漏，可进一步通过工具查看泄漏对象到GC Roots 的引用链。于是就能找到泄漏对象是通过怎样的路径与GC Roots相关联并导致
 * 垃圾收集器无法自动回收它们的。掌握了泄漏对象的类型信息，以及GC Roots引用链的信息，就可以比较准确地地位泄漏代码的位置。
 *      如果不存在泄漏，换句话说就是内存中的对象确实都还必须活着，那就应当检查虚拟机的堆参数(-Xms 与 -Xmx),与机器物理内存对比看是否
 * 还可以调大，从代码上检查是否存在某些对象生命周期过长、持有时间过长的情况，尝试减少程序运行期的内存消耗。
 */

/**
 * 这个程序设置的虚拟机参数为
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 其中：
 * -Xms 是堆的最小值
 * -Xmx 是堆的最大值
 * -XX:+HeapDumpOnOutOfMemoryError 可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后进行分析
  */
//java 堆内存逸出异常测试
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args){
        List<OOMObject> list=new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
