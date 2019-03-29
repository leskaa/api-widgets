package com.example.widget.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GadgetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long widgetId;

    public GadgetEntity() {
    }

    public GadgetEntity(String name, Long widgetId) {
        this.name = name;
        this.widgetId = widgetId;
    }

    public GadgetEntity(Long id, String name, Long widgetId) {
        this.id = id;
        this.name = name;
        this.widgetId = widgetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Long getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(Long widgetId) {
        this.widgetId = widgetId;
    }
}
