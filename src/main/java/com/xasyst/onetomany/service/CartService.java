package com.xasyst.onetomany.service;

import com.xasyst.onetomany.entity.CartEntity;
import com.xasyst.onetomany.mapper.CartMapper;
import com.xasyst.onetomany.model.CartRequest;
import com.xasyst.onetomany.model.CartResponse;
import com.xasyst.onetomany.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    public CartResponse createCart(CartRequest cartRequest) {
        CartEntity cartEntity = cartMapper.modelToEntity(cartRequest);
        cartRepository.save(cartEntity);
        CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(cartEntity.getCartId());
        return cartResponse;


    }

    public List<CartRequest> getAllCarts() {
        List<CartEntity> cartEntity=cartRepository.findAll();
        List<CartRequest> cartRequests=cartMapper.entityToModel(cartEntity);
        return cartRequests;
    }

    public CartRequest findCartById(Long cartId) {
        CartRequest cartRequest = new CartRequest();
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);
        cartRequest=cartMapper.EntityToModel(cartEntity.get());
        return cartRequest;

    }


    public CartRequest updateCartById(Long cartId, CartRequest cartRequest) {
        CartEntity cartEntity = cartRepository.findById(cartId).get();
        CartEntity cartEntityOne =cartMapper.modelToEntity(cartRequest);
        cartEntityOne.setCartId(cartEntity.getCartId());
        return cartRequest;
    }

    public void deleteById(Long cartId) {
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);

        if (cartEntity.isPresent())

            cartRepository.deleteById(cartId);

    }
}
