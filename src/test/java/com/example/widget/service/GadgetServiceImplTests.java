package com.example.widget.service;

import com.example.widget.repository.GadgetRepository;

import static org.mockito.Mockito.mock;

class GadgetServiceImplTests {
    private GadgetRepository gadgetRepository = mock(GadgetRepository.class);
    private GadgetServiceImpl gadgetService = new GadgetServiceImpl(gadgetRepository);

}
