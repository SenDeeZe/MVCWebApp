package org.example.entities;
import javax.persistence.*;

@Entity
@Table(name = "MYGOODS")
public class Goods {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;
    @Column(name = "price")
    Double price;

    public Goods() {
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
