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

import com.example.ing_soft.model.Categoria;
import com.example.ing_soft.repository.CategoriaRepository;
import com.example.ing_soft.service.CategoriaService;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;


  
    @Test
    public void siInvocoFindCategoriaByNombreDebeRetornarCategoria(){
        // Arrange
        Categoria categoria = getCategoria();
        when(categoriaRepository.findCategoriaByNombre(categoria.getNombre())).thenReturn(java.util.Optional.of(categoria));
        // Act
       Optional<Categoria> categoriaResult = categoriaService.findCategoriaByNombre(categoria.getNombre());
        // Assert
        assertNotNull(categoriaResult);
        assertEquals(categoria, categoriaResult.get());
    }

    @Test
    public void siInvocoFindCategoriaByIdDebeRetornarCategoria(){
        // Arrange
        Categoria categoria = getCategoria();
        when(categoriaRepository.findById(categoria.getId())).thenReturn(java.util.Optional.of(categoria));
        // Act
       Optional<Categoria> categoriaResult = categoriaService.findCategoriaById(categoria.getId());
        // Assert
        assertNotNull(categoriaResult);
        assertEquals(categoria, categoriaResult.get());
    }

    @Test
    public void siInvocoDeleteCategoriaByIdDebeRetornarTrue(){
        int id = 1;
        Categoria categoria = new Categoria();
        categoria.setId(id);
        when(categoriaRepository.findById(id)).thenReturn(java.util.Optional.of(categoria));
        // Act
        boolean categoriaResult = categoriaService.deleteCategoriaById(id);

        // Assert
        assertTrue(categoriaResult);
        
    }

    @Test
    public void siInvocoDeleteCategoriaByIdDebeRetornarFalse(){
        //Arrange
        int id = 1;
        when(categoriaRepository.findById(id)).thenReturn(Optional.empty());

        //Act
        boolean categoriaResult = categoriaService.deleteCategoriaById(id);
        
        //Assert
        assertFalse(categoriaResult);
        
    }



    




    public Categoria getCategoria() {
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNombre("categoria1");
        return categoria;
    }


}


