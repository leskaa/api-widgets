package com.example.widget.service;

import com.example.widget.domain.GadgetEntity;
import com.example.widget.dto.CreateGadgetRequest;
import com.example.widget.dto.GadgetResponse;
import com.example.widget.repository.GadgetRepository;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

class GadgetServiceImplTests {
    private GadgetRepository gadgetRepository = mock(GadgetRepository.class);
    private GadgetServiceImpl gadgetService = new GadgetServiceImpl(gadgetRepository);

    @Test
    void FindAll_ReturnsAListOfGadgets() {
        when(gadgetRepository.findAll()).thenReturn(Arrays.asList(
                new GadgetEntity(1L, "Fake gadget 1", 1L),
                new GadgetEntity(2L, "Fake gadget 2", 2L)
        ));

        List<GadgetResponse> gadgets = gadgetService.findAll();

        assertThat(gadgets.size(), equalTo(2));

        verify(gadgetRepository).findAll();
    }

    @Test
    void FindAll_ReturnsEmptyListOfGadgets() {
        when(gadgetRepository.findAll()).thenReturn(new ArrayList<>());

        List<GadgetResponse> gadgets = gadgetService.findAll();

        assertThat(gadgets.size(), equalTo(0));

        verify(gadgetRepository).findAll();

    }

    @Test
    void Create_CreatesNewGadget() {
        CreateGadgetRequest createGadgetRequest = new CreateGadgetRequest("Cool Gadget");
        GadgetEntity gadgetEntity = new GadgetEntity("Cool Gadget", 2L);
        GadgetEntity gadgetEntityWithId = new GadgetEntity(1L, gadgetEntity.getName(), 2L);

        when(gadgetRepository.save(gadgetEntity)).thenReturn(gadgetEntityWithId);

        gadgetService.createGadget(createGadgetRequest, 2L);

        verify(gadgetRepository).save(any());
    }
}
