package 第15章泛型.Erased.ErasedCompensate;

public class InstantiateGenericType {
    /**
     *  这可以编译，但是会因 ClassAsFactory<Integer>而失败，因为Integer没有任何默认的构造函数
     *
     */

    public static void main(String[] args){
        ClassAsFactory<Employee> fe=new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeed");
        try {
            ClassAsFactory<Integer> fi=new ClassAsFactory<>(Integer.class);
        }catch (Exception e){
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}

class Employee{

}

class ClassAsFactory<T>{
    T x;
    public ClassAsFactory(Class<T> kind){
        try{
            x=kind.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
