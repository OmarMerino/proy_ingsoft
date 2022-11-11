package com.example.ing_soft.service;


import com.example.ing_soft.model.Permiso;
import com.example.ing_soft.repository.PermisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {
    private final PermisoRepository permisoRepository;

    public PermisoService(PermisoRepository permisoRepository) {
        this.permisoRepository = permisoRepository;
    }

    public List<Permiso> findAllPermisos() {
        return permisoRepository.findAll();
    }

    public Optional<Permiso> findPermisoById(int id) {
        return permisoRepository.findById(id);
    }

    public boolean save(Permiso permiso) {
        permisoRepository.saveAndFlush(permiso);
        Optional<Permiso> permisoOptional = permisoRepository.findPermisoByNombre(permiso.getNombre());
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

    public boolean deletePermisoById(int id_permiso) {
        Optional<Permiso> permisoOptional = permisoRepository.findById(id_permiso);
        if (permisoOptional.isPresent()) {
            permisoRepository.deleteById(idEmp);
            return true;
        } else {
            return false;
        }
    }
}
