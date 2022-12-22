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

import com.example.ing_soft.model.Bodega;
import com.example.ing_soft.repository.BodegaRepository;
import com.example.ing_soft.service.BodegaService;

@ExtendWith(MockitoExtension.class)
public class BodegaServiceTest {

    @Mock
    private BodegaRepository bodegaRepository;

    @InjectMocks
    private BodegaService bodegaService;


    @Test
    public void siInvocoFindAllBodegaRetornaListaBodega() throws Exception{
        // Arrange
        Bodega bodega = getBodega();
        List<Bodega> bodegas = new ArrayList<>();
        bodegas.add(bodega);
        when(bodegaRepository.findAll()).thenReturn(bodegas);
        // Act
        List<Bodega> bodegasResult = bodegaService.findAllBodegas();
        // Assert
        assertNotNull(bodegasResult);
        assertEquals(bodegas.size(),bodegasResult.size());
        assertEquals(bodegas, bodegasResult);
    }

    @Test
    public void siInvocoFindAllBodegaYNoHayBodegasRetornaListaVacia() throws Exception{
        // Arrange
        List<Bodega> bodegas = new ArrayList<>();
        when(bodegaRepository.findAll()).thenReturn(bodegas);
        // Act
        List<Bodega> bodegasResult = bodegaService.findAllBodegas();
        // Assert
        assertNotNull(bodegasResult);
        assertEquals(bodegas.size(),bodegasResult.size());
        assertEquals(bodegas, bodegasResult);
        assertTrue(bodegasResult.isEmpty());
    }

    @Test
    public void siInvocoSaveDeBodegaDebeRetornarIsPresent() throws Exception{
        // Arrange
        Bodega bodega = getBodega();
        when(bodegaRepository.findById(bodega.getId())).thenReturn(java.util.Optional.of(bodega));
        when(bodegaRepository.saveAndFlush(bodega)).thenReturn(bodega);
        // Act
        boolean result = bodegaService.save(bodega);
        // Assert
        assertTrue(result);
        verify(bodegaRepository).saveAndFlush(bodega);
    }

    @Test
    public void siInvocoSaveDeBodegaYNoHaceSaveDebeRetornarFalse() throws Exception{
        // Arrange
        Bodega bodega = getBodega();
        when(bodegaRepository.findById(bodega.getId())).thenReturn(java.util.Optional.of(bodega));
        when(bodegaRepository.saveAndFlush(bodega)).thenReturn(null);
        // Act
        boolean result = bodegaService.save(bodega);
        // Assert
        assertFalse(result);
        
        verify(bodegaRepository).saveAndFlush(bodega);
    }

    @Test
    public void siInvocoUpdateDeBodegaDebeRetornarTrue(){
        // Arrange
        Bodega bodega = getBodega();
        when(bodegaRepository.findById(bodega.getId())).thenReturn(java.util.Optional.of(bodega));
        when(bodegaRepository.saveAndFlush(bodega)).thenReturn(bodega);
        // Act
        boolean result = bodegaService.update(bodega);
        // Assert
        assertTrue(result);
        verify(bodegaRepository).saveAndFlush(bodega);
    }

    @Test
    public void SiInvocoUpdateDeBodegaYNoUpdateaDebeRetornarFalse(){
        // Arrange
        Bodega bodega = getBodega();
        when(bodegaRepository.findById(bodega.getId())).thenReturn(java.util.Optional.of(bodega));
        when(bodegaRepository.saveAndFlush(bodega)).thenReturn(null);
        // Act
        boolean result = bodegaService.update(bodega);
        // Assert
        assertFalse(result);
        verify(bodegaRepository).saveAndFlush(bodega);
    }

    @Test
    public void siInvocoFindBodegaByNombreDebeRetornarBodega(){
        // Arrange
        Bodega bodega = getBodega();
        when(bodegaRepository.findBodegaByNombre(bodega.getNombre())).thenReturn(java.util.Optional.of(bodega));
        // Act
       Optional<Bodega> bodegaResult = bodegaService.findByNombre(bodega.getNombre());
        // Assert
        assertNotNull(bodegaResult);
        assertEquals(bodega, bodegaResult.get());
    }

    @Test
    public void siInvocoFindBodegaByNombreYNoExisteBodegaDebeRetornarNull(){
        // Arrange
        Bodega bodega = getBodega();
        when(bodegaRepository.findBodegaByNombre(bodega.getNombre())).thenReturn(null);
        // Act
        Optional<Bodega> bodegaResult = bodegaService.findByNombre(bodega.getNombre());
        // Assert
        assertNull(bodegaResult);
    }
   



    public Bodega getBodega(){
        Bodega bodega = new Bodega();
        bodega.setNombre("Bodega 1");
        bodega.setUbicacion("Ubicacion 1");
        return bodega;
    }
    public List<Bodega> getListBodega(){       
        List<Bodega> bodegas = new ArrayList<>();
        Bodega bodega = new Bodega();
        bodega.setUbicacion("Chillan");
        bodega.setNombre("Bodega 1");
        bodegas.add(bodega);
        return bodegas;
    }


    
    
}
