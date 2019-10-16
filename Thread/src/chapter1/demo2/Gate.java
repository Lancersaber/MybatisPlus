package chapter1.demo2;

public class Gate {
    private int counter=0; //记录下有多少个人过了门
    private String name="Nobody";
    private String address="Nowhere";

    public synchronized void pass(String name,String address){
        this.counter++;
        this.name=name;
        this.address=address;
        check();
    }

    //为什么这里需要加 synchronized 关键字

    /**
     *      假设当UserThread 类的线程正在执行pass方法时，其他线程X 调用了toString 方法。
     * 在线程X 引用了name字段的值尚未引用address 字段的值的这段时间，UserThread 线程可能
     * 会修改address 的值。这样一来，toString() 方法对线程X 创建字符串时使用的name 和 address 首字母
     * 可能并不一致。
     */
    public synchronized String toString(){
        return "No."+counter+": "+name+", "+address;
    }

    //如果姓名(name)和出生地(address) 首字母不同，那么说明记录数据是异常的。
    private void check(){
        if (name.charAt(0)!=address.charAt(0)){
            System.out.println("************** BROKEN ************"+toString());
        }
    }
}
