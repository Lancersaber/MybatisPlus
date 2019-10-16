package chapter12.demo1;

public interface ActiveObject {
    public abstract Result<String> makeString(int count,char fillchar);
    public abstract void displayString(String string);
}
