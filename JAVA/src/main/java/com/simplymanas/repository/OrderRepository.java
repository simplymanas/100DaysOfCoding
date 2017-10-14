package com.simplymanas.repository;

import com.simplymanas.domain.Order;
import org.springframework.stereotype.Repository;

/**
 * Created by Manas Dash on 09/10/17 9:36 AM 9:39 AM 9:39 AM.
 * Learning REST API
 */
@Repository
public class OrderRepository extends InMemoryRepository<Order> {
    @Override
    protected void updateIfExists(Order original, Order updated) {
        original.setDescription(updated.getDescription());
        original.setCostIncents(updated.getCostIncents());
        original.setComplete(updated.isComplete());
    }
}


