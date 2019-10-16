package chapter3.demo1;

public class Main {
    public static void main(String[] args){
        RequestQueue requestQueue=new RequestQueue();
        new ClientThread(requestQueue,"Alice",312222L).start();
        new ServerThread(requestQueue,"Bobby",444444L).start();
    }
}
