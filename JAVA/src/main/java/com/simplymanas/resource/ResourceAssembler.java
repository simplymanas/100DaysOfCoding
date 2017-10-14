package com.simplymanas.resource;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Manas Dash on 09/10/17 9:36 AM 9:39 AM 9:39 AM.
 * Learning REST API
 */
public abstract class ResourceAssembler<DomainType, ResourceType> {

    protected abstract ResourceType toResource(DomainType domainObject);

    public Collection<ResourceType> toResourceCollection(Collection<DomainType> domainObjects) {
        return domainObjects.stream().map(this::toResource).collect(Collectors.toList());
    }
}
