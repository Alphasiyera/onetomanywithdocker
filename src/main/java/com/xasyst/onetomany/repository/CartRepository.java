package com.xasyst.onetomany.repository;

import com.xasyst.onetomany.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository <CartEntity,Long> {
}
