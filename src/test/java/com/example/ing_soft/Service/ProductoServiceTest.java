package com.example.ing_soft.Service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ing_soft.model.Producto;
import com.example.ing_soft.repository.ProductoRepository;
import com.example.ing_soft.service.ProductoService;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    public void siInvocoModificarPrecioByIdYProductoIsPresentDebeRetornarTrue(){
        // Arrange
        Producto producto = getProducto();
        when(productoRepository.findById(producto.getId())).thenReturn(java.util.Optional.of(producto));
        // Act
        boolean result = productoService.modificarPrecioById(producto.getId(), producto.getPrecio());
        // Assert
        assertTrue(result);  
        verify(productoRepository).saveAndFlush(producto);

    }

    @Test
    public void siInvocoModificarPrecioByIdYProductoIsNotPresentDebeRetornarFalse(){
        // Arrange
        Producto producto = getProducto();
        when(productoRepository.findById(producto.getId())).thenReturn(java.util.Optional.empty());
        // Act
        boolean result = productoService.modificarPrecioById(producto.getId(), producto.getPrecio());
        // Assert
        assertFalse(result);  
      

    }

    @Test
    public void siInvocoModificarDescricionByIDYProductoIsPresentDebeRetornarTrue(){
        // Arrange
        Producto producto = getProducto();
        when(productoRepository.findById(producto.getId())).thenReturn(java.util.Optional.of(producto));
        // Act
        boolean result = productoService.modificarDescripcionById(producto.getId(), producto.getDescripcion());
        // Assert
        assertTrue(result);  
        verify(productoRepository).saveAndFlush(producto);
        
    }

    @Test
    public void siInvocoModificarDescripcionByIDYProductoIsNotPresentDebeRetornarFalse(){
        // Arrange
        Producto producto = getProducto();
        when(productoRepository.findById(producto.getId())).thenReturn(java.util.Optional.empty());
        // Act
        boolean result = productoService.modificarDescripcionById(producto.getId(), producto.getDescripcion());
        // Assert
        assertFalse(result);  
        

    }

   

    private Producto getProducto() {
        Producto producto = new Producto();
        producto.setId(1);
        producto.setNombre("Producto 1");
        producto.setPrecio(1000);
        producto.setStock(0);
        producto.setDescripcion("Descripcion 1");
        return producto;
    }

   /*  private List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(getProducto());
    }  */
    
}
