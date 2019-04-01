package com.example.widget.service;

import com.example.widget.domain.GadgetEntity;
import com.example.widget.domain.WidgetEntity;
import com.example.widget.dto.CreateWidgetRequest;
import com.example.widget.dto.WidgetResponse;
import com.example.widget.repository.GadgetRepository;
import com.example.widget.repository.WidgetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

class WidgetServiceImplTests {
    private WidgetRepository widgetRepository = mock(WidgetRepository.class);
    private GadgetRepository gadgetRepository = mock(GadgetRepository.class);
    private WidgetServiceImpl widgetService = new WidgetServiceImpl(widgetRepository, gadgetRepository);

    @Test
    void FindAll_ReturnsAPageOfWidgets() {
        when(gadgetRepository.findAll()).thenReturn(new ArrayList<>());

        List<WidgetEntity> widgetEntityList = Arrays.asList(
                new WidgetEntity(1L, "Fake widget 1"),
                new WidgetEntity(2L, "Fake widget 2")
        );
        Page<WidgetEntity> widgetEntityPage = new PageImpl<>(widgetEntityList);
        when(widgetRepository.findAll(PageRequest.of(0, 2))).thenReturn(widgetEntityPage);

        Page<WidgetResponse> widgets = widgetService.findAll(0, 2);

        assertThat(widgets.getTotalElements(), equalTo(2L));

        verify(widgetRepository).findAll(PageRequest.of(0, 2));
    }

    @Test
    void FindAll_ReturnsEmptyPageOfWidgets() {
        when(gadgetRepository.findAll()).thenReturn(new ArrayList<>());
        Page<WidgetEntity> widgetEntityPage = new PageImpl<>(new ArrayList<>());
        when(widgetRepository.findAll(PageRequest.of(0, 2))).thenReturn(widgetEntityPage);

        Page<WidgetResponse> widgets = widgetService.findAll(0, 2);

        assertThat(widgets.getTotalElements(), equalTo(0L));

        verify(widgetRepository).findAll(PageRequest.of(0, 2));
    }

    @Test
    void FindAll_ReturnsAPageOfWidgetsWithAssociatedGadgets() {
        List<GadgetEntity> gadgetEntityList = Arrays.asList(
                new GadgetEntity(1L, "Fake gadget 1", 2L),
                new GadgetEntity(2L, "Fake gadget 2", 2L)
        );
        when(gadgetRepository.findAll()).thenReturn(gadgetEntityList);

        List<WidgetEntity> widgetEntityList = Arrays.asList(
                new WidgetEntity(1L, "Fake widget 1"),
                new WidgetEntity(2L, "Fake widget 2")
        );
        Page<WidgetEntity> widgetEntityPage = new PageImpl<>(widgetEntityList);
        when(widgetRepository.findAll(PageRequest.of(0, 2))).thenReturn(widgetEntityPage);

        Page<WidgetResponse> widgets = widgetService.findAll(0, 2);

        assertThat(widgets.get().collect(Collectors.toList()).get(1).getGadgets().size(), equalTo(2));

        verify(widgetRepository).findAll(PageRequest.of(0, 2));
    }

    @Test
    void FindAll_GadgetsOnlyAssociateWithTheCorrectWidgetId() {
        List<GadgetEntity> gadgetEntityList = Arrays.asList(
                new GadgetEntity(1L, "Fake gadget 1", 2L),
                new GadgetEntity(2L, "Fake gadget 2", 2L)
        );
        when(gadgetRepository.findAll()).thenReturn(gadgetEntityList);

        List<WidgetEntity> widgetEntityList = Arrays.asList(
                new WidgetEntity(1L, "Fake widget 1"),
                new WidgetEntity(2L, "Fake widget 2")
        );
        Page<WidgetEntity> widgetEntityPage = new PageImpl<>(widgetEntityList);
        when(widgetRepository.findAll(PageRequest.of(0, 2))).thenReturn(widgetEntityPage);

        Page<WidgetResponse> widgets = widgetService.findAll(0, 2);

        assertThat(widgets.get().collect(Collectors.toList()).get(0).getGadgets().size(), equalTo(0));

        verify(widgetRepository).findAll(PageRequest.of(0, 2));
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
