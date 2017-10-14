package com.simplymanas.resource;

import com.simplymanas.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

/**
 * Created by Manas Dash on 09/10/17 9:36 AM 9:39 AM 9:39 AM.
 * Learning REST API
 */
@Component
public class OrderResourceAssembler extends ResourceAssembler<Order, OrderResource> {

    private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";
    @Autowired
    private final EntityLinks entityLinks = null;

    @Override
    public OrderResource toResource(Order order) {
        try {
            OrderResource resource = new OrderResource(order);

            final Link selfLink = entityLinks.linkToSingleResource(order);

            resource.add(selfLink.withSelfRel());
            resource.add(selfLink.withRel(UPDATE_REL));
            resource.add(selfLink.withRel((DELETE_REL)));

            return resource;
        } finally {

        }
    }
}
