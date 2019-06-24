package entity;

import java.util.ArrayList;
import java.util.List;

public class Dish extends BaseEntity {

    private String name;
    private int price;



    public Dish() {
    }

    public Dish(String name, int price) {
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Dish{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
