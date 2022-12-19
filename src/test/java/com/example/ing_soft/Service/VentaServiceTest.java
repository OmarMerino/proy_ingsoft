package com.example.ing_soft.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ing_soft.model.Venta;
import com.example.ing_soft.repository.VentaRepository;
import com.example.ing_soft.service.VentaService;

@ExtendWith(MockitoExtension.class)
public class VentaServiceTest {
    @Mock
    private VentaRepository ventaRepository;

    @InjectMocks
    private VentaService ventaService;

    @Test
    public void siInvocoGetAllVentasRetornaListaVentas() throws Exception{
        // Arrange
        Venta venta = getVenta();
        List <Venta> ventas = new ArrayList<>();
        ventas.add(venta);
        when(ventaRepository.findAll()).thenReturn(ventas);
        // Act
        List<Venta> ventasResult = ventaService.findAllVentas();
        // Assert
        assertNotNull(ventasResult);
        assertEquals(ventas.size(), ventasResult.size());
        assertEquals(ventas, ventasResult);
    }

    @Test
    public void siInvocogetAllventaYNoHayVentasRetornaListaVacia() throws Exception{
        // Arrange
        List<Venta> ventas = new ArrayList<>();
        when(ventaRepository.findAll()).thenReturn(ventas);
        // Act
        List<Venta> ventasResult = ventaService.findAllVentas();
        // Assert
        assertNotNull(ventasResult);
        assertEquals(ventas.size(), ventasResult.size());
        assertEquals(ventas, ventasResult);
    }

    @Test
    public void siInvocoSaveVentaRetornaTrue() throws Exception{
        // Arrange
        Venta venta = getVenta();
        when(ventaRepository.saveAndFlush(venta)).thenReturn(venta);
        // Act
        boolean result = ventaService.save(venta);
        // Assert
        assertEquals(true, result);
    }

    private Venta getVenta() {
        Venta venta = new Venta();
        venta.setId(1);
        venta.setFecha("2020-12-12");
        venta.setDescuento(0);
        venta.setTotal(10000);
        return venta;
    }

    private List<Venta> getVentas() {
        List<Venta> ventas = new ArrayList<>();
        ventas.add(getVenta());
        return ventas;
    }


    
    
    
}
