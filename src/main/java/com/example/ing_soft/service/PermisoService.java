package com.example.ing_soft.service;


import com.example.ing_soft.model.Permiso;
import com.example.ing_soft.repository.PermisoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {

    @Autowired
    private  PermisoRepository permisoRepository;

    public List<Permiso> findAllPermisos() {
        return permisoRepository.findAll();
    }

    public Optional<Permiso> findPermisoById(int id) {
        return permisoRepository.findById(id);
    }
    public Optional<Permiso> findPermisoByNombre(String nombre) {
        return permisoRepository.findPermisoByNombre(nombre);
    }

    public boolean save(Permiso permiso) {
        permisoRepository.saveAndFlush(permiso);
        Optional<Permiso> permisoOptional = permisoRepository.findById(permiso.getId());
        return permisoOptional.isPresent();
    }

    public boolean update(Permiso permiso) {
        Optional<Permiso> permisoOptional = permisoRepository.findById(permiso.getId());
        if (permisoOptional.isPresent()) {
            permisoRepository.saveAndFlush(permiso);
            return true;
        } else {
            return false;
        }   
    }

    public boolean deletePermisoById(int id) {
        Optional<Permiso> permisoOptional = permisoRepository.findById(id);
        if (permisoOptional.isPresent()) {
            permisoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
