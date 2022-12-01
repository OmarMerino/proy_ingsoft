package com.example.ing_soft.Rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.ing_soft.model.Bodega;
import com.example.ing_soft.repository.BodegaRepository;
import com.example.ing_soft.rest.BodegaRestController;
import com.example.ing_soft.service.BodegaService;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
public class BodegaRestControllerTest {
    private JacksonTester<Bodega> jsonBodega;
    private MockMvc mockMvc;

    @Mock
    private BodegaRepository bodegaRepository;
    @Mock
    private BodegaService bodegaService;
    @InjectMocks
    private BodegaRestControllerTest bodegaRestController;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(bodegaRestController).build();
    }

    @Test
    void siInvocoGetAllBodegasEntoncesRetornaStatusOk() {
        //Given
        given(bodegaService.findAllBodegas()).willReturn(new ArrayList<Bodega>());
    } 
    
    




    public List<Bodega> findAllBodegas() {
        return bodegaRepository.findAll();
    }




    public void getBodega(){
        Bodega bodega = new Bodega();
        bodega.setNombre("Bodega 1");
        bodega.setUbicacion("Calle 1");
        bodega.setId(1);   
    }
}






