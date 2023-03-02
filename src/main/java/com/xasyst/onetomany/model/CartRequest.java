package com.xasyst.onetomany.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private String cartName;

    private List<ItemRequest> items;

}
