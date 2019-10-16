package chapter2.demo2;

public class MutablePerson {
    private String name;
    private String address;

    public MutablePerson(String name,String address){
        this.name=name;
        this.address=address;
    }

    public MutablePerson(ImmutablePerson person){
        this.name=person.getName();
        this.address=person.getAddress();
    }

    public synchronized void setPerson(String newName,String newAddress){
        name=newName;
        address=newAddress;
    }

    public synchronized ImmutablePerson getImmutablePerson(){
        return new ImmutablePerson(this);
    }


    public String getName() { //Called only by ImmutablePerson
        return name;
    }

    public String getAddress() { //Called only by ImmutablePerson
        return address;
    }

    @Override
    public synchronized String toString() {
        return "MutablePerson{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
