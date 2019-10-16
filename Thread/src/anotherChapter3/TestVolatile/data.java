package anotherChapter3.TestVolatile;

public class data extends Thread{

    static int j=10000;
    volatile boolean end=false;

    public void run(){
        while (!end){
            j--;

        }
    }


}
