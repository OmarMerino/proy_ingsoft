package com.example.ing_soft.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ing_soft.model.Usuario;
import com.example.ing_soft.repository.UsuarioRepository;
import com.example.ing_soft.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void siInvocoFindAllUsuarioRetornaListaUsuario() throws Exception {
        // Arrange
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(getUsuario());
        when(usuarioRepository.findAll()).thenReturn(usuarios);
        // Act
        List<Usuario> usuariosResult = usuarioService.findAllUsuarios();
        // Assert
        assertNotNull(usuariosResult);
        assertEquals(usuarios.size(), usuariosResult.size());
        assertEquals(usuarios, usuariosResult);
    }

    @Test
    public void siInvocoDeleteUsuarioDebeRetornarTrue() {
        // Arrange
        Usuario usuario = new Usuario();
        when(usuarioRepository.findById(12345678 - 9)).thenReturn(Optional.of(usuario));
        // Act
        boolean result = usuarioService.deleteUsuarioById(12345678 - 9);
        // Assert
        assertTrue(result);
    }

    @Test
    public void siInvocoDeleteUsuarioDebeRetornarFalse(){
        // Arrange
        when(usuarioRepository.findById(12345678 - 9)).thenReturn(Optional.empty());
        // Act
        boolean result = usuarioService.deleteUsuarioById(12345678 - 9);
        // Assert
        assertFalse(result);
    }

    @Test
    public void siInvocoSaveUsuarioDebeRetornarIsPresent(){
        // Arrange
        Usuario usuario = getUsuario();
        when(usuarioRepository.findById(usuario.getId())).thenReturn(java.util.Optional.of(usuario));
        when(usuarioRepository.saveAndFlush(usuario)).thenReturn(usuario);
        // Act
        boolean result = usuarioService.save(usuario);
        // Assert
        assertTrue(result);
        verify(usuarioRepository).saveAndFlush(usuario);
    }

    public Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setRut("12345678-9");
        usuario.setNombre("Juan");
        usuario.setDireccion("Av. Siempre Viva 123");
        usuario.setTelefono("123456789");
        usuario.setCorreo("correo@correo.com");
        usuario.setContraseña("123456");
        return usuario;
    }

    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(getUsuario());
        return usuarios;
    }

}
