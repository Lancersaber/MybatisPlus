package chapter2.demo2;

public class CrackerThread extends Thread {
    private final MutablePerson mutable;
    public CrackerThread(MutablePerson mutable){
        this.mutable=mutable;
    }

    public void run(){
        while (true){
            ImmutablePerson immutable=new ImmutablePerson(mutable);
            if (!immutable.getName().equals(immutable.getAddress())){
                System.out.println(currentThread().getName()+" ******* BROKEN ******* "+immutable);
            }
        }
    }
}
