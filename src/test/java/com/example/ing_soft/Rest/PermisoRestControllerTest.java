package com.example.ing_soft.Rest;





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

import com.example.ing_soft.service.PermisoService;
import com.example.ing_soft.model.Permiso;
import com.example.ing_soft.rest.PermisoRestController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class PermisoRestControllerTest {
    @Mock
    private PermisoService permisoService;

    @InjectMocks
    private PermisoRestController permisoRestController;

    private JacksonTester<Permiso> jsonPermiso;
    private MockMvc mockMvc;
  

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(permisoRestController).build();
    }

    @Test
    public void siInvocoAddPermisoYLoHaceRetornaStatusCreated() throws Exception{
       //Given
       Permiso permiso = getPermiso();
       given(permisoService.save(any(Permiso.class))).willReturn(true);

       //when 
       MockHttpServletResponse response = mockMvc
       .perform(MockMvcRequestBuilders.post("/permiso").accept(MediaType.APPLICATION_JSON)
       .content(jsonPermiso.write(permiso).getJson())
         .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

       //Assert
       assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void siInvocoAddPermisoYNoLoHaceRetornaStatusBadRequest() throws Exception{
       //Given
       Permiso permiso = getPermiso();
       given(permisoService.save(any(Permiso.class))).willReturn(false);

       //when 
       MockHttpServletResponse response = mockMvc
       .perform(MockMvcRequestBuilders.post("/permiso").accept(MediaType.APPLICATION_JSON)
       .content(jsonPermiso.write(permiso).getJson())
         .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

       //Assert
       assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }



    private Permiso getPermiso() {
        Permiso permiso = new Permiso();
        permiso.setId(1);
        permiso.setNombre("nombre");
        return permiso;
    }
   
    
}
