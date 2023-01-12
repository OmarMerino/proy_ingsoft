package com.example.ing_soft.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ing_soft.model.Permiso;
import com.example.ing_soft.repository.PermisoRepository;
import com.example.ing_soft.service.PermisoService;


@ExtendWith(MockitoExtension.class)
public class PermisoServiceTest {

    @Mock
    private PermisoRepository permisoRepository;

    @InjectMocks
    private PermisoService permisoService;


    @Test
    public void siInvocoFindPermisoByNombreDebeRetornarPermiso(){
        // Arrange
        Permiso permiso = getPermiso();
        when(permisoRepository.findPermisoByNombre(permiso.getNombre())).thenReturn(java.util.Optional.of(permiso));
        // Act
       Optional<Permiso> permisoResult = permisoService.findPermisoByNombre(permiso.getNombre());
        // Assert
        assertNotNull(permisoResult);
        assertEquals(permiso, permisoResult.get());
    }

    @Test 
    public void siInvocoFindPermisoByNombreYNoExistePermisoDebeRetornarNull(){
        // Arrange
        Permiso permiso = getPermiso();
        when(permisoRepository.findPermisoByNombre(permiso.getNombre())).thenReturn(null);
        // Act
        Optional<Permiso> permisoResult = permisoService.findPermisoByNombre(permiso.getNombre());
        // Assert
        assertNull(permisoResult);
        
    }

    public Permiso getPermiso(){
        Permiso bodega = new Permiso();
        bodega.setNombre("Bodega 1");
        return bodega;
    }
}


