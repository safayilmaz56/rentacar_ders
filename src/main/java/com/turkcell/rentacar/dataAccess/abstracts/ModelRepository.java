package com.turkcell.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.rentacar.entities.concretes.Model;


public interface ModelRepository extends JpaRepository<Model,Integer>{

}
