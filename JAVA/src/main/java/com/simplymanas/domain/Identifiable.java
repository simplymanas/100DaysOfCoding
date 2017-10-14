package com.simplymanas.domain;

/**
 * Created by Manas Dash on 09/10/17 9:36 AM 9:39 AM 9:39 AM.
 * Learning REST API
 */
public interface Identifiable extends org.springframework.hateoas.Identifiable<Long> {
    void setID(Long id);
}
