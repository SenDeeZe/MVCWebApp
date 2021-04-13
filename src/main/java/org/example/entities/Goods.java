package org.example.entities;
import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return id.equals(goods.id) &&
                Objects.equals(name, goods.name) &&
                Objects.equals(price, goods.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
