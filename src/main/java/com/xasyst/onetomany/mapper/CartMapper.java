package com.xasyst.onetomany.mapper;

import com.xasyst.onetomany.entity.CartEntity;
import com.xasyst.onetomany.model.CartRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    public CartEntity modelToEntity (CartRequest cartRequest);

    public CartRequest EntityToModel(CartEntity cartEntity);


    public List<CartRequest> entityToModel(List<CartEntity> cartEntities);
}
