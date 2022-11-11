package com.example.ing_soft.rest;

import com.example.ing_soft.model.Permiso;
import com.example.ing_soft.service.PermisoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(value = "permiso",produces = "application/json")
public class PermisoRestController {
    private PermisoService permisoService;

    public PermisoRestController(PermisoService permisoService) {
        this.permisoService = permisoService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Permiso>> getAllPermisos() {
        List<Permiso> permisoList = permisoService.findAllPermisos();
        if (!permisoList.isEmpty()) {
            return new ResponseEntity<>(permisoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id_permiso}")
    public ResponseEntity<Permiso> getPermisoById(@PathVariable int id_permiso) {
        Optional<Permiso> permisoOptional = permisoService.findPermisoById(id_permiso);
        if (permisoOptional.isPresent()) {
            return new ResponseEntity<>(permisoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<Void> addPermiso(@RequestBody Permiso permiso) {
        boolean creado = permisoService.save(permiso);
        if (creado) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "")
    public ResponseEntity<Void> updatePermiso(@RequestBody Permiso permiso) {
        boolean actualizado = permisoService.update(permiso);
        if (actualizado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id_permiso}")
    public ResponseEntity<Void> deletePermisoById(@PathVariable int id_permiso) {
        boolean eliminado = permisoService.deletePermisoById(id_permiso);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}