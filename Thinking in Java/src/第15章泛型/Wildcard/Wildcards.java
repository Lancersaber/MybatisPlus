package 第15章泛型.Wildcard;

public class Wildcards {

    static void rawArgs(Holder holder,Object arg){
        holder.setValue(arg);//warning
        holder.setValue(new Wildcards()); //The same warning
        //Can't do this; don't have any 'T'
        // T t=holder.getValue();

        //Ok , but the type information has been lost
        Object obj=holder.getValue();
    }

    static void unboundedArg(Holder<?> holder,Object arg){
        //holder.setValue(arg);     Error
        //holder.setValue(new Wildcards()); The same error
        //Reason: set(capture of ?) in Holder<capture of ? >can't be applied to Object

        //Ok , but the type information has been lost
        Object obj=holder.getValue();
    }

    static <T> T exact1(Holder<T> holder){
        T t=holder.getValue();
        return t;
    }

    static <T> T exact2(Holder<T> holder,T arg){
        holder.setValue(arg);
        T t=holder.getValue();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder,T arg){
//        holder.setValue(arg);     Error
        //set (capture of ? extends T> in
        //Holder<capture of > extends T>
        //cannot be applied to (T)
        T t=holder.getValue();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder,T arg){
        holder.setValue(arg);
        //T t=holder.getValue();    Error
        //Incompatible types : found Object,required T

        //Ok , but the type information has been lost
        Object obj=holder.getValue();
    }

    public static void main(String[] args){

    }
}
