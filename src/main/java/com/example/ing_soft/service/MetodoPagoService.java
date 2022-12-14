package com.example.ing_soft.service;

import com.example.ing_soft.model.MetodoPago;
import com.example.ing_soft.repository.MetodoPagoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class MetodoPagoService {
  @Autowired
  private  MetodoPagoRepository metodopagoRepository;
  
  

  public List<MetodoPago> findAllMetodoPago(){
    return metodopagoRepository.findAll();
  }

  public Optional<MetodoPago> findMetodoPagoById(int id) {
    return metodopagoRepository.findById(id);
  }

  public boolean save(MetodoPago metodopago) {
    metodopagoRepository.saveAndFlush(metodopago);
    Optional<MetodoPago> metodopagoOptional = metodopagoRepository.findById(metodopago.getId());
    return metodopagoOptional.isPresent();
}

  public boolean update(MetodoPago metodopago){
    Optional<MetodoPago> metodopagoOptional = metodopagoRepository.findById(metodopago.getId());
    if(metodopagoOptional.isPresent()){
        metodopagoRepository.saveAndFlush(metodopago);
        return true;
    }else{
        return false;
    } 
  }

  public boolean deleteMetodoPagoById(int id) {
    Optional<MetodoPago> metodopagoOptional = metodopagoRepository.findById(id);
    if (metodopagoOptional.isPresent()) {
        metodopagoRepository.deleteById(id);
        return true;
    } else {
        return false;
    }
  }
}
