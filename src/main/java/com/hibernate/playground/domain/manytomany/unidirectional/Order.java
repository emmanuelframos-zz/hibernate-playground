package com.hibernate.playground.domain.manytomany.unidirectional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
/** The Order word is a reserved keyword, you have to escape it. **/
@Table(name="`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="order_number")
    private String orderNumber;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Set<Item> items;

    /** Avoid: No default constructor for entity. **/
    private Order(){}

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
        this.items = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Set<Item> getItems() {
        return items;
    }

    public Order addItem(Item item){
        this.items.add(item);
        return this;
    }

    @Override
    public String toString() {
        return String.format("Order{id=%d, orderNumber=%s, items=%s}", id, orderNumber, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderNumber, order.orderNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber);
    }
}
