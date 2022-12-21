package com.example.ing_soft.rest;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.ing_soft.model.MetodoPago;
import com.example.ing_soft.service.MetodoPagoService;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    
    @BeforeEach
    public void setup(){
        JacksonTester.initFields(this,new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(metodoPagoRestController).build();
    }

    @Test
    public void siInvocoGetAllMetodoPagoYExistenMetodosPagoRetornarListaMetodoPagoYStatusOk() throws Exception{
        // Arrage
        MetodoPago metodoPago = getMetodoPago();
        List<MetodoPago> metodoPagoList = List.of();
        given(metodoPagoService.findAllMetodoPago()).willReturn(metodoPagoList);

        // Act
        MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.get("/metodoPago"))
}
