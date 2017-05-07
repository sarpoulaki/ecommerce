package com.sarpoulaki.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 */

@Entity
@Table (name="order")
public class Order {

    @Id
    @Column (name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    @ManyToOne(cascade = CascadeType.ALL)

    private Long id;

    @Column
    private LocalDateTime orderDate;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn (name = "status")
    private String status;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
