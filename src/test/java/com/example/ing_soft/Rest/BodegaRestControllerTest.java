package com.example.ing_soft.Rest;

import java.util.ArrayList;
import java.util.List;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.ing_soft.service.BodegaService;
import com.example.ing_soft.model.Bodega;
import com.example.ing_soft.rest.BodegaRestController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BodegaRestControllerTest {
    @Mock
    private BodegaService bodegaService;
    @InjectMocks
    private BodegaRestController bodegaRestController;

    private JacksonTester<Bodega> jsonBodega;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(bodegaRestController).build();
    }

    // TESTING METODO ADDBODOGA SE PUEDE GRABAR RETORNA ESTADO CREADO
    @Test
    public void siInvocoAddBodegaYLoHaceRetornaStatusCreated() throws Exception{
       //Given
       Bodega bodega = getBodega();
       given(bodegaService.save(any(Bodega.class))).willReturn(true);

       //when 
       MockHttpServletResponse response = mockMvc
       .perform(MockMvcRequestBuilders.post("/bodega").accept(MediaType.APPLICATION_JSON)
       .content(jsonBodega.write(bodega).getJson())
         .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

       //Assert
         assertEquals(HttpStatus.CREATED.value(),response.getStatus());
    }

    // TESTING METDO ADDBODEGA NO SE PUEDE GRABAR RETORNA BAD REQUEST;
    @Test
    public void siInvocoAddBodegaYNoSePuedeGrabarRetornaStatusBadRequest() throws Exception {
       //Given
       Bodega bodega = getBodega();
       given(bodegaService.save(any(Bodega.class))).willReturn(false);

       //when 
       MockHttpServletResponse response = mockMvc
       .perform(MockMvcRequestBuilders.post("/bodega").accept(MediaType.APPLICATION_JSON)
       .content(jsonBodega.write(bodega).getJson())
         .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

       //Assert
         assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
    }


    

    public Bodega getBodega() {
        Bodega bodega = new Bodega();
        bodega.setNombre("Bodega 1");
        bodega.setUbicacion("Calle 1");
        bodega.setId(1);
        return bodega;
    }
}
