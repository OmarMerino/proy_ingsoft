package com.example.ing_soft.service;

import com.example.ing_soft.model.Categoria;
import com.example.ing_soft.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService{
    @Autowired
    private  CategoriaRepository categoriaRepository;

   
    public List<Categoria> findAllCategoria(){
        return categoriaRepository.findAll();
    }

    public Optional <Categoria> findCategoriaById(int id_categoria){
        return categoriaRepository.findById(id_categoria);
    }

    public boolean save (Categoria categoria){
        categoriaRepository.saveAndFlush(categoria);
        Optional <Categoria> categoriaOptional=categoriaRepository.findById(categoria.getId());
        return categoriaOptional.isPresent();
    }

    public boolean update (Categoria categoria){
        Optional<Categoria> categoriaOptional=categoriaRepository.findById(categoria.getId());
        if(categoriaOptional.isPresent()){
            categoriaRepository.saveAndFlush(categoria);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteCategoriaById (int id_categoria ){
        Optional <Categoria> categoriaOptional= categoriaRepository.findById(id_categoria);
        if ( categoriaOptional.isPresent()){
            categoriaRepository.deleteById(id_categoria);
            return true;
        }else{
            return false;
        }
    }
}