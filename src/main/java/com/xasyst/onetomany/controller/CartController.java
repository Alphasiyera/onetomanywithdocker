package com.xasyst.onetomany.controller;

import com.xasyst.onetomany.model.CartRequest;
import com.xasyst.onetomany.model.CartResponse;
import com.xasyst.onetomany.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/carts")
    public ResponseEntity<CartResponse> createCart(@RequestBody CartRequest cartRequest){
        CartResponse cartResponse = cartService.createCart(cartRequest);
        return new ResponseEntity<>(cartResponse, HttpStatus.CREATED);
    }
    @GetMapping(value = "/carts")
    public ResponseEntity<List<CartRequest>> getAllCarts(){
List<CartRequest> cartRequests = cartService.getAllCarts();
return  new ResponseEntity<>(cartRequests,HttpStatus.FOUND);

    }
    @GetMapping(value = "/carts/{cartId}")
    public ResponseEntity<CartRequest> findCartById(@PathVariable Long cartId){
    CartRequest cartRequest = cartService.findCartById(cartId);
    return new ResponseEntity<>(cartRequest,HttpStatus.FOUND);

    }
    @PutMapping(value = "/cart/{cartId}")
    public ResponseEntity<CartRequest> updateCartById(@PathVariable Long cartId, @RequestBody CartRequest cartRequest) {
        CartRequest cartRequest1 = cartService.updateCartById(cartId, cartRequest);

        return new ResponseEntity<>(cartRequest1, HttpStatus.OK);
    }
    @DeleteMapping(value = "/cart/{cartId}")
    public void deleteById(@PathVariable Long cartId) {


        cartService.deleteById(cartId);
    }
}
