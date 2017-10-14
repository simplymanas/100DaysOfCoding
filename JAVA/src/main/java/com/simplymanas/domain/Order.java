package com.simplymanas.domain;

/**
 * Created by Manas Dash on 09/10/17 9:36 AM 9:39 AM 9:39 AM.
 * Learning REST API
 */
public class Order implements Identifiable {
    private Long id;
    private String description;
    private long costIncents;
    private boolean isComplete;

    @Override
    public void setID(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCostIncents() {
        return costIncents;
    }

    public void setCostIncents(long cost) {
        this.costIncents = cost;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public void markComplete() {
        setComplete(true);
    }

    public void markInComplete() {
        setComplete(false);
    }
}
