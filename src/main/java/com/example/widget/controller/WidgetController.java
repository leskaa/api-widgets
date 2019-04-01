package com.example.widget.controller;

import com.example.widget.dto.CreateWidgetRequest;
import com.example.widget.dto.WidgetResponse;
import com.example.widget.service.WidgetService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"api/v1/widgets"})
public class WidgetController {
    private WidgetService widgetService;

    public WidgetController(WidgetService widgetService) {
        this.widgetService = widgetService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createWidget(@Valid @RequestBody CreateWidgetRequest createWidgetRequest) {
        this.widgetService.createWidget(createWidgetRequest);
    }

    @GetMapping(params = {"page", "size"})
    @ResponseStatus(HttpStatus.OK)
    public Page<WidgetResponse> getWidgets(@RequestParam("page") int page, @RequestParam("size") int size) {
        return this.widgetService.findAll(page, size);
    }
}
