package com.example.widget.service;

import com.example.widget.repository.GadgetRepository;
import org.springframework.stereotype.Service;

@Service
public class GadgetServiceImpl implements GadgetService {
    private GadgetRepository gadgetRepository;

    public GadgetServiceImpl(GadgetRepository gadgetRepository) {
        this.gadgetRepository = gadgetRepository;
    }
}
