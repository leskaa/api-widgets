package com.example.widget.dto;

import javax.validation.constraints.NotNull;

public class CreateWidgetRequest {
    @NotNull
    private String name;

    public CreateWidgetRequest() {
    }

    public CreateWidgetRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
