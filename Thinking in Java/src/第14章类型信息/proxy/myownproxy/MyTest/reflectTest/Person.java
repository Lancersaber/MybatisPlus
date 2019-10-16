package 第14章类型信息.proxy.myownproxy.MyTest.reflectTest;

public class Person {
    private String name;
    private int age;

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public Person(String name){
        this.name=name;
    }

    public Person(int age){
        this.age=age;
    }

    public void sayHello(){
        System.out.println("Hello world");
    }

    public String getName() {
        return name;
    }

    private void run(){
        System.out.println("I can run");
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
