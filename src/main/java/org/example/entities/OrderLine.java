package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "MYORDERLINES")
public class OrderLine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "order_id")
    Integer orderId;
    @Column(name = "goods_id")
    Integer goodsIf;
    @Column(name = "count")
    Integer count;

    public OrderLine() {
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", goodsIf=" + goodsIf +
                ", count=" + count +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsIf() {
        return goodsIf;
    }

    public void setGoodsIf(Integer goodsIf) {
        this.goodsIf = goodsIf;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
