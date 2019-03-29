package com.example.widget.dto;

public class GadgetResponse {
    private String name;
    private Long widgetId;

    public GadgetResponse() {
    }

    public GadgetResponse(String name, long widgetId) {
        this.name = name;
        this.widgetId = widgetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(Long widgetId) {
        this.widgetId = widgetId;
    }
}
