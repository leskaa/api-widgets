package com.example.widget.service;

import com.example.widget.domain.GadgetEntity;
import com.example.widget.domain.WidgetEntity;
import com.example.widget.dto.CreateWidgetRequest;
import com.example.widget.dto.GadgetResponse;
import com.example.widget.dto.WidgetResponse;
import com.example.widget.repository.GadgetRepository;
import com.example.widget.repository.WidgetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WidgetServiceImpl implements WidgetService {
    private WidgetRepository widgetRepository;
    private GadgetRepository gadgetRepository;

    public WidgetServiceImpl(WidgetRepository widgetRepository, GadgetRepository gadgetRepository) {
        this.widgetRepository = widgetRepository;
        this.gadgetRepository = gadgetRepository;
    }

    @Override
    public void createWidget(CreateWidgetRequest createWidgetRequest) {
        this.widgetRepository.save(new WidgetEntity(createWidgetRequest.getName()));
    }

    @Override
    public Page<WidgetResponse> findAll(int page, int size) {
        List<GadgetResponse> gadgetResponses = new ArrayList<>();

        for (GadgetEntity gadgetEntity: this.gadgetRepository.findAll()) {
            gadgetResponses.add(new GadgetResponse(gadgetEntity.getName(), gadgetEntity.getWidgetId()));
        }

        Page<WidgetEntity> widgetEntityPage = this.widgetRepository.findAll(PageRequest.of(page, size));

        // Maps page of entities to page of responses
        // Filters list of gadgets for each response
        return widgetEntityPage.map(widgetEntity ->
                new WidgetResponse(widgetEntity.getName(), gadgetResponses.stream().filter(gadgetResponse ->
                        gadgetResponse.getWidgetId().equals(widgetEntity.getId())).collect(Collectors.toList())));
    }
}
