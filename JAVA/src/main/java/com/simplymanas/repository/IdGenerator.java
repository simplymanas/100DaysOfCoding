package com.simplymanas.repository;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by Manas Dash on 09/10/17 9:36 AM 9:39 AM 9:39 AM.
 * Learning REST API
 */

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
class IdGenerator {

    private final AtomicLong nextId = new AtomicLong(1);

    long getNextId() {
        return nextId.getAndIncrement();
    }
}
