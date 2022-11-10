package com.example.ing_soft.rest;

import com.example.ing_soft.model.Categoria;
import com.example.ing_soft.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService{
    private final CategoriaRepository categoriaRepository;

    public CategoriaService( CategoriaRepository categoriaRepository){
        this.categoriaRepository=categoriaRepository;
    }

    public List<Categoria> findAllCategoria(){
        return categoriaRepository.findAll();
    }

    public Optional <Categoria> findCategoriaById(int idCategoria){
        return CategoriaRepository.findById(idCategoria);
    }

    public boolean save (Categoria categoria){
        categoriaRepository.saveAndFlush(categoria);
        Optional <Categoria> categoriaOptional=categoriaRepository.findCategoriaById(categoria.getId_categoria());
        return empleadoOptional.isPresent();
    }

    public boolean update (Categoria categoria){
        Optional<Categoria> categoriaOptional=categoriaRepository.findById(categoria.getId_categoria());
        if(categoriaOptional.isPresent()){
            categoriaRepository.saveAndFlush(categoria);
            return true;
        }else{
            return false;
        }
    }










    public boolean deleteCategoriaById (int idCategoria ){
        Optional <Categoria> categoriaOptional=categoriaRepository.findById(venta.getId_categoria());
        if ( categoriaOptional.isPresent()){
            categoriaRepository.deleteByid(idCategoria);
            return true;
        }else{
            return false;
        }
    }

}