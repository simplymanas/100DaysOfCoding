package com.simplymanas.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.simplymanas.domain.Order;
import org.springframework.hateoas.ResourceSupport;


/**
 * Created by Manas Dash on 09/10/17 9:36 AM 9:39 AM 9:39 AM.
 * Learning REST API
 */
public class OrderResource extends ResourceSupport {

    private final long id;
    private final String description;

    private final long costInCents;
    private final boolean isComplete;

    OrderResource(Order order) {
        id = order.getId();
        description = order.getDescription();
        costInCents = order.getCostIncents();
        isComplete = order.isComplete();
    }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public long getCostInCents() {
        return costInCents;
    }

    public boolean isComplete() {
        return isComplete;
    }

}

