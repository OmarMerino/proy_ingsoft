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

import com.example.ing_soft.service.UsuarioService;
import com.example.ing_soft.model.Usuario;
import com.example.ing_soft.rest.UsuarioRestController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class UsuarioRestControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioRestController usuarioRestController;

    private JacksonTester<Usuario> jsonUsuario;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioRestController).build();
    }

    @Test
    public void siInvocoAddUsuarioYLoHaceRetornaStatusCreated() throws Exception{
        //Given
        Usuario usuario = getUsuario();
        given(usuarioService.save(any(Usuario.class))).willReturn(true);

        //when
        MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.post("/usuario").accept(MediaType.APPLICATION_JSON)
                        .content(jsonUsuario.write(usuario).getJson())
                        .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        //then
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void siInvocoAddUsuarioYNoLoHaceRetornaStatusBadRequest() throws Exception{
        //Given
        Usuario usuario = getUsuario();
        given(usuarioService.save(any(Usuario.class))).willReturn(false);

        //when
        MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.post("/usuario").accept(MediaType.APPLICATION_JSON)
                        .content(jsonUsuario.write(usuario).getJson())
                        .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        //then
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }







    private Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setRut("12345678-9");
        usuario.setNombre("Juan");
        usuario.setDireccion("Calle 123");
        usuario.setTelefono("123456789");
        usuario.setCorreo("correo@correo.com");
        usuario.setContraseña("123456");
        return usuario;
    }
}
