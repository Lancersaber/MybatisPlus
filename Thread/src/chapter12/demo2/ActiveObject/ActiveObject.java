package chapter12.demo2.ActiveObject;


import chapter12.demo2.result.Result;

public interface ActiveObject {
    public abstract Result<String> makeString(int count, char fillchar);
    public abstract void displayString(String string);
}
