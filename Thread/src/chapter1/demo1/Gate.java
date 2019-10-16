package chapter1.demo1;

public class Gate {
    private int counter=0; //记录下有多少个人过了门
    private String name="Nobody";
    private String address="Nowhere";

    public void pass(String name,String address){
        this.counter++;
        this.name=name;
        this.address=address;
        check();
    }

    public String toString(){
        return "No."+counter+": "+name+", "+address;
    }

    //如果姓名(name)和出生地(address) 首字母不同，那么说明记录数据是异常的。
    private void check(){
        if (name.charAt(0)!=address.charAt(0)){
            System.out.println("************** BROKEN ************"+toString());
        }
    }
}
