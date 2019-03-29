package com.example.widget.service;

import com.example.widget.domain.WidgetEntity;
import com.example.widget.dto.CreateWidgetRequest;
import com.example.widget.dto.WidgetResponse;
import com.example.widget.repository.WidgetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetServiceImpl implements WidgetService {
    private WidgetRepository widgetRepository;

    public WidgetServiceImpl(WidgetRepository widgetRepository) {
        this.widgetRepository = widgetRepository;
    }

    @Override
    public void createWidget(CreateWidgetRequest createWidgetRequest) {
        this.widgetRepository.save(new WidgetEntity(createWidgetRequest.getName()));
    }

    @Override
    public List<WidgetResponse> findAll() {
        List<WidgetResponse> response = new ArrayList<>();


        List<WidgetEntity> entities = this.widgetRepository.findAll();

        for (WidgetEntity entity : entities) {
            response.add(new WidgetResponse(entity.getName()));
        }

        return response;
    }
}
