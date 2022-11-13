package com.example.ing_soft.service;

import com.example.ing_soft.model.Venta;
import com.example.ing_soft.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;


    public List<Venta> findAllVentas(){
        return ventaRepository.findAll();
    }

    public Optional<Venta> findVentaById (int id_venta){
        return ventaRepository.findById(id_venta);
    }

    public boolean save (Venta venta){
        ventaRepository.saveAndFlush(venta);
        Optional <Venta> ventaOptional=ventaRepository.findVentaById(venta.getId());
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
}