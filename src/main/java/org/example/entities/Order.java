package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "MYORDERS")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "client")
    String client;
    @Column(name = "date")
    String date;
    @Column(name = "address")
    String address;

    public Order() {

    }
    @Override
    public String toString() {
        return id + " " + client + " " + date + " " + address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
