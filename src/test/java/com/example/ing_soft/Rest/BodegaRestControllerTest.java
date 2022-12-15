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
import org.springframework.mock.web.MockHttpServletMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.ing_soft.model.Bodega;
import com.example.ing_soft.repository.BodegaRepository;

import com.example.ing_soft.service.BodegaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


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
    public void siInvocoAddBodegaYSePuedeGrabarRetornaStatusCreated() throws Exception{
        // Arrange
        Bodega bodega = getBodega();
        given(bodegaService.save(any(Bodega.class))).willReturn(true);

        // Act
        MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.post("/bodega")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonBodega.write(bodega).getJson())
                        .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        // Assert
        assertEquals(HttpStatus.CREATED.value(),response.getStatus());
    }
   
   
      
    
    
    




    public List<Bodega> findAllBodegas() {
        return bodegaRepository.findAll();
    }




    public Bodega getBodega(){
        Bodega bodega = new Bodega();
        bodega.setNombre("Bodega 1");
        bodega.setUbicacion("Calle 1");
        bodega.setId(1);  
        return bodega; 
    }
}






