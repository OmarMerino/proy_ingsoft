package com.example.ing_soft.service;

import com.example.ing_soft.model.MetodoPago;
import com.example.ing_soft.repository.MetodoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class MetodoPagoService {
  private final MetodoPagoRepository metodopagoRepository;
  
  public MetodoPagoService(MetodoPagoRepository metodopagoRepository){
    this.metodopagoRepository = metodopagoRepository;
  }

  public List<MetodoPago> findAllMetodoPago(){
    return metodopagoRepository.findAll();
  }

  public Optional<MetodoPago> findMetodoPagoById(int id) {
    return metodopagoRepository.findById(id);
  }

  public boolean save(MetodoPago metodopago) {
    metodopagoRepository.saveAndFlush(metodopago);
    Optional<MetodoPago> metodopagoOptional = metodopagoRepository.findMetodoPagoByNombre(metodopago.getNombre());
    return metodopagoOptional.isPresent();
}

  public boolean update(MetodoPago metodopago){
    Optional<MetodoPago> metodopagoOptional = metodopagoRepository.findById(metodopago.getId_pago());
    if(metodopagoOptional.isPresent()){
        metodopagoRepository.saveAndFlush(metodopago);
        return true;
    }else{
        return false;
    } 
  }

  public boolean deleteMetodoPagoById(int id_pago) {
    Optional<MetodoPago> metodopagoOptional = metodopagoRepository.findById(id_pago);
    if (metodopagoOptional.isPresent()) {
        metodopagoRepository.deleteById(id_pago);
        return true;
    } else {
        return false;
    }
  }
}
