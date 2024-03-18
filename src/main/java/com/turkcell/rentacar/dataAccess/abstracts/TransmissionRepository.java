package com.turkcell.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.rentacar.entities.concretes.Transmission;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer>{

}
