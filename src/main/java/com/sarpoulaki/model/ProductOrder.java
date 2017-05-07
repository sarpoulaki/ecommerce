package com.sarpoulaki.model;

import javax.naming.Name;
import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 * @author Masoud
 * Created on 5/6/2017.
 */

@Entity
@Table (name="productorder")
public class ProductOrder {
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn (name = "productId")
    private Long productId;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn (name = "orderId")
    private Long orderId;
    private int price;
    private int quantity;
}
