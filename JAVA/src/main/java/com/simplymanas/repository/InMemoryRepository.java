package com.simplymanas.repository;

import com.simplymanas.domain.Identifiable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by Manas Dash on 09/10/17 9:36 AM 9:39 AM 9:39 AM.
 * Learning REST API
 */

public abstract class InMemoryRepository<T extends Identifiable> {

    @Autowired
    private final IdGenerator idGenerator = null;

    private final List<T> elements = Collections.synchronizedList(new ArrayList<>());

    public T create(T element) {

            elements.add(element);
            element.setID(idGenerator.getNextId());
            return element;

    }

    public boolean delete(Long id) {
        return elements.removeIf(element -> element.getId().equals(id));
    }

    public List<T> findAll() {
        return elements;
    }

    public Optional<T> findByID(Long id) {
        return elements.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public int getCount() {
        return elements.size();
    }

    public void clear() {
        elements.clear();
    }

    public boolean update(Long id, T updated) {
        if (updated == null) {
            return false;
        } else {
            Optional<T> element = findByID(id);
            element.ifPresent(original -> updateIfExists(original, updated));
            return element.isPresent();
        }
    }

    protected abstract void updateIfExists(T original, T desired);
}
