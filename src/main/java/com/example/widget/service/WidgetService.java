package com.example.widget.service;

import com.example.widget.dto.CreateWidgetRequest;
import com.example.widget.dto.WidgetResponse;

import java.util.List;

public interface WidgetService {
    void createWidget(CreateWidgetRequest createWidgetRequest);

    List<WidgetResponse> findAll();
}
