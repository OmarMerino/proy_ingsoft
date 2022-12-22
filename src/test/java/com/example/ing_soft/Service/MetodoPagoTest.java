package com.example.ing_soft.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ing_soft.model.MetodoPago;
import com.example.ing_soft.repository.MetodoPagoRepository;
import com.example.ing_soft.service.MetodoPagoService;


@ExtendWith(MockitoExtension.class)
public class MetodoPagoTest {

    @Mock
    private MetodoPagoRepository metodoPagoRepository;

    @InjectMocks
    private MetodoPagoService metodoPagoService;

    @Test
    public void siInvocoDeleteMetodoDePagoPorIdYExisteEntoncesRetornaTrue() {
        // Arrange
        int id = 1;
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setId(id);
        when(metodoPagoRepository.findById(id)).thenReturn(Optional.of(metodoPago));

        // Act
        boolean resultado = metodoPagoService.deleteMetodoPagoById(id);

        // Assert
        assertTrue(resultado);
    }
    
    @Test
    public void siInvocoDeleteMetodoDePagoPorIdYNoExisteEntoncesRetornaFalse() {
        // Arrange
        int id = 1;
        when(metodoPagoRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        boolean resultado = metodoPagoService.deleteMetodoPagoById(id);

        // Assert
        assertFalse(resultado);
    }
    
}
