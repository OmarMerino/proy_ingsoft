package com.example.ing_soft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ing_soft.model.Bodega;
import com.example.ing_soft.repository.BodegaRepository;

@Service
public class BodegaService {

    private final BodegaRepository bodegaRepository;

    public BodegaService(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }

    public List<Bodega> findAllBodegas(){
        return bodegaRepository.findAll();
    }

    public Optional<Bodega> findBodegaById(int id_bodega){
        return bodegaRepository.findById(id_bodega);
    }

    public Optional<Bodega> findByNombre(String nombre){
        return bodegaRepository.findBodegaByNombre(nombre);
    }

    public boolean save(Bodega bodega){
        Optional<Bodega> bodegaOptional =bodegaRepository.findById(bodega.getId());
        if(bodegaOptional.isPresent()){
            bodegaRepository.saveAndFlush(bodega);
            bodegaOptional = bodegaRepository.findBodegaByNombre(bodega.getNombre());
            return bodegaOptional.isPresent();
        }else{
            return false;
        }
    }
    
    public boolean update (Bodega bodega){
        Optional<Bodega> bodegaOptional = bodegaRepository.findById(bodega.getId());
        if(bodegaOptional.isPresent()){
            bodegaRepository.saveAndFlush(bodega);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteBodegaById(int id){
        Optional<Bodega> bodegaOptional = bodegaRepository.findById(id);
        if(bodegaOptional.isPresent()){
            bodegaRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }


}