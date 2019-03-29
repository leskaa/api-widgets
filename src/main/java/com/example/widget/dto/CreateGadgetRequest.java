package com.example.widget.dto;

import javax.validation.constraints.NotNull;

public class CreateGadgetRequest {
    @NotNull
    private String name;

    public CreateGadgetRequest() {
    }

    public CreateGadgetRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
