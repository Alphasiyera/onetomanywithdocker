package com.xasyst.onetomany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "item_id")
    private Long itemId;
    @Column(name = "item_name")
    private String itemName;
@Column(name = "item_price")
    private double itemPrice;
@Column(name = "item_quantity")
    private Long itemQuantity;
@ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

}
