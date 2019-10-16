package chapter9.demo1;

import java.io.Serializable;

public class TestData implements Serializable {
    private String name;
    public TestData(String name){
        this.name=name;
    }

    public TestData(){
        name="Mike";
    }

    @Override
    public String toString() {
        return name;
    }
}
