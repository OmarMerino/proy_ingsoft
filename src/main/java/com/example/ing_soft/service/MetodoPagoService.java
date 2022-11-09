package com.example.ing_soft.service;

import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ing_soft.model.MetodoPago;

@RestController
@RequestMapping("/MetodoPago")
public class MetodoPagoService {
    //Autowired?
    private final MetodoPagoRepository;
    //constructor??
    @PostMapping
    public void crear(@RequestBody MetodoPago metodopago){
        MetodoPagoRepository.save(metodopago);
    }

    @PutMapping
    public void editar(@RequestBody MetodoPago metodopago){
        MetodoPagoRepository.save(metodopago);
    }
    
    @GetMapping
    public List<MetodoPago> listar(){
        return MetodoPagoRepository.findAll();
    }

    @DeleteMapping(value="/(id)")  //pasa por id el metodo de pago que sera eliminado
    public void eliminar(@PathVariable("id") int id){
        MetodoPagoRepository.deleteById(id);
    }
}
