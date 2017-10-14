package com.simplymanas.controller;

import com.simplymanas.domain.Order;
import com.simplymanas.repository.OrderRepository;
import com.simplymanas.resource.OrderResource;
import com.simplymanas.resource.OrderResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Manas Dash on 09/10/17 9:36 AM 9:39 AM 9:39 AM.
 * Learning REST API
 */

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Order.class)
@RequestMapping(value = "/order", produces = "application/json")
class OrderController {

    @Autowired
    private final OrderRepository repository = null;

    @Autowired
    private final OrderResourceAssembler assembler = null;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<OrderResource>> findAllOrders() {
        List<Order> orders = repository.findAll();
        return new ResponseEntity<>(assembler.toResourceCollection(orders), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private ResponseEntity<OrderResource> findOrderById(@PathVariable Long id) {
        Optional<Order> order = repository.findByID(id);

        if (order.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(order.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<OrderResource> createOrder(@RequestBody Order order) {
        Order createOrder = repository.create(order);
        return new ResponseEntity<>(assembler.toResource(createOrder), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        boolean wasDeleted = repository.delete(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<OrderResource> updateOrder(@PathVariable Long id, @RequestBody Order updateOrder) {
        boolean wasUpdated = repository.update(id, updateOrder);

        if (wasUpdated) {
            return findOrderById(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
