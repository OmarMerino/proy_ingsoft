package com.example.ing_soft.service;

import com.example.ing_soft.model.MetodoPago;
import com.example.ing_soft.model.Venta;
import com.example.ing_soft.repository.MetodoPagoRepository;
import com.example.ing_soft.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private  VentaRepository ventaRepository;
    @Autowired
    private  MetodoPagoRepository metodoPagoRepository;

    public VentaService(VentaRepository ventaRepository,MetodoPagoRepository  metodoPagoRepository){
        this.ventaRepository=ventaRepository;
        this.metodoPagoRepository=metodoPagoRepository;
    }
    

    public List<Venta> findAllVentas(){
        return ventaRepository.findAll();
    }

    public Optional<Venta> findVentaById (int id_venta){
        return ventaRepository.findById(id_venta);
    }

    public boolean save (Venta venta){
        ventaRepository.saveAndFlush(venta);
        Optional<Venta> ventaOptional =ventaRepository.findById(venta.getId());
        return ventaOptional.isPresent();
    }
    

    public boolean update (Venta venta){
        Optional <Venta> ventaOptional =ventaRepository.findById(venta.getId());
        if (ventaOptional.isPresent()){
            ventaRepository.saveAndFlush(venta);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteVentaById(int id_venta){
        Optional<Venta> ventaOptional = ventaRepository.findById(id_venta);
        if(ventaOptional.isPresent()){
            ventaRepository.deleteById(id_venta);
            return true;
        }else{
            return false;
        }        
    }

    public boolean seleccionarMetodoPago(int id_venta,int metodoPago){
        //buscar venta por id
        Optional<Venta> ventaOptional = ventaRepository.findById(id_venta);
        if(ventaOptional.isPresent()){
            //buscar metodo de pago seleccionado por id
            Optional<MetodoPago> pago=metodoPagoRepository.findById(metodoPago);
            if(pago.isPresent()){
                //setear metodo de pago en la venta encontrada
                ventaOptional.get().setMetodo_pago(pago.get());

                ventaRepository.saveAndFlush(ventaOptional.get());
                return true;
            }else{
                return false;
            }

        }else{
            return false;
        }     
    }

    public boolean agregarDescuento(int id_venta,int descuento){
        
        Optional<Venta> ventaOptional = ventaRepository.findById(id_venta);
        int total=ventaOptional.get().getTotal();
        int descontado=total-(total*((descuento)/100));

        if(ventaOptional.isPresent()){
            if(ventaOptional.isPresent()){

                ventaOptional.get().setTotal(total-descontado);

                ventaOptional.get().setDescuento(descuento);
                
                ventaRepository.saveAndFlush(ventaOptional.get());
                return true;
            }else{
                return false;
            }

        }else{
            return false;
        }     
    }
}