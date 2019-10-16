package 第15章泛型.buildComplexModel;

import 第15章泛型.generator.Generator;
import 第15章泛型.generator.generic_generator.Generators;

import java.util.ArrayList;
import java.util.Random;

/**
 * 泛型的一个重要好处是能够简单而安全地创建复杂的模型
 */
class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int IDnumber,String description,double price){
        this.id=IDnumber;
        this.description=description;
        this.price=price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void priceChange(double change){
        price+=change;
    }

    public static Generator<Product> generator(){
        return new Generator<Product>() {
            private Random rand=new Random(47);
            @Override
            public Product next() {
                return new Product(rand.nextInt(1000),"Test",Math.round(rand.nextDouble())*1000.0+0.99);
            }
        };
    }
}

class Shelf extends ArrayList<Product>{
    public Shelf(int nProducts){
        Generators.fill(this,Product.generator(),nProducts);
    }
}

class Aisle extends ArrayList<Shelf> {
    public Aisle (int nShelves,int nProducts){
        for (int i=0;i<nShelves;i++){
            add(new Shelf(nProducts));
        }
    }
}

class CheckoutStand{

}

class Office{

}

public class Store extends ArrayList<Aisle>{
    private ArrayList<CheckoutStand> checkouts=new ArrayList<>();
    private Office office=new Office();

    public Store(int nAisles,int nShelves,int nProducts){
        for (int i=0;i<nAisles;i++){
            add(new Aisle(nShelves,nProducts));
        }
    }

    public String toString(){
        StringBuilder result=new StringBuilder();
        for (Aisle a:this){
            for (Shelf s:a){
               for (Product p:s){
                   result.append(p);
                   result.append("\n");
               }
            }
        }
        return result.toString();
    }

    /**
     * 正如我们在String.toString()中看到的，其结果是多层容器，但是它们是类型安全且可管理的
     */

    public static void main(String[] args){
        System.out.println(new Store(14,5,10));
    }
}
