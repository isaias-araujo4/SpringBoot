package com.example.control_drive.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.control_drive.modelo.CarroModelo;

@Repository
public interface CarroRepositorio extends CrudRepository<CarroModelo, Long> {

    
}