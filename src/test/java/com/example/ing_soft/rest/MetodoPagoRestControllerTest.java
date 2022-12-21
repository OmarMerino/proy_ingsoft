package com.example.ing_soft.rest;

import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;

import com.example.ing_soft.model.MetodoPago;
import com.example.ing_soft.service.MetodoPagoService;

@ExtendWith(MockitoExtension.class)
public class MetodoPagoRestControllerTest {
    @Mock
    private MetodoPagoService metodoPagoService;
    @InjectMocks
    private MetodoPagoRestController metodoPagoRestController;

    private MockMvc mockMvc;
    private JacksonTester<MetodoPago> jsonMetodoPago;
    private JacksonTester<List<MetodoPago>> jsonMetodoPagoList;
    private JacksonTester<List<Integer>> jsonIntegerList;
    
}
