package com.xasyst.onetomany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemRequest {
    private String itemName;
    private double itemPrice;

    private Long itemQuantity;

}
