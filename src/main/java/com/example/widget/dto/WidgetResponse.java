package com.example.widget.dto;

import java.util.List;

public class WidgetResponse {
    private String name;
    private List<GadgetResponse> gadgets;

    public WidgetResponse() {
    }

    public WidgetResponse(String name) {
        this.name = name;
    }

    public WidgetResponse(String name, List<GadgetResponse> gadgets) {
        this.name = name;
        this.gadgets = gadgets;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GadgetResponse> getGadgets() {
        return gadgets;
    }

    public void setGadgets(List<GadgetResponse> gadgets) {
        this.gadgets = gadgets;
    }
}
