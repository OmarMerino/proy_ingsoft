package com.example.ing_soft.service;

import com.example.ing_soft.model.Venta;
import com.example.ing_soft.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;

    public VentaService (VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> findAllVentas(){
        return ventaRepository.findAll();
    }

    public Optional<Venta> findVentaById (int id_venta){
        return ventaRepository.findById(id_venta);
    }

    public boolean save (Venta venta){
        ventaRepository.saveAndFlush(venta);
        Optional <Venta> ventaOptional=ventaRepository.findVentaById(venta.getId_venta());
        return ventaOptional.isPresent();
    }
    

    public boolean update (Venta venta){
        Optional <Venta> ventaOptional =ventaRepository.findById(venta.getId_venta());
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