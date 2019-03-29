package com.example.widget.service;

import com.example.widget.domain.WidgetEntity;
import com.example.widget.dto.CreateWidgetRequest;
import com.example.widget.dto.WidgetResponse;
import com.example.widget.repository.WidgetRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

class WidgetServiceImplTests {
    private WidgetRepository widgetRepository = mock(WidgetRepository.class);
    private WidgetServiceImpl widgetService = new WidgetServiceImpl(widgetRepository);

    @Test
    void FindAll_ReturnsAListOfWidgets() {
        when(widgetRepository.findAll()).thenReturn(Arrays.asList(
                new WidgetEntity(1L, "Fake widget 1"),
                new WidgetEntity(2L, "Fake widget 2")
        ));

        List<WidgetResponse> widgets = widgetService.findAll();

        assertThat(widgets.size(), equalTo(2));

        verify(widgetRepository).findAll();
    }

    @Test
    void FindAll_ReturnsEmptyListOfWidgets() {
        when(widgetRepository.findAll()).thenReturn(new ArrayList<>());

        List<WidgetResponse> widgets = widgetService.findAll();

        assertThat(widgets.size(), equalTo(0));

        verify(widgetRepository).findAll();

    }

    @Test
    void Create_CreatesNewWidget() {
        CreateWidgetRequest createWidgetRequest = new CreateWidgetRequest("Cool Widget");
        WidgetEntity widgetEntity = new WidgetEntity("Cool widget");
        WidgetEntity widgetEntityWithId = new WidgetEntity(1L, widgetEntity.getName());

        when(widgetRepository.save(widgetEntity)).thenReturn(widgetEntityWithId);

        widgetService.createWidget(createWidgetRequest);


        verify(widgetRepository).save(any());
    }
}
