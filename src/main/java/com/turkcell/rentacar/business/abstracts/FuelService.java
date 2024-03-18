package com.turkcell.rentacar.business.abstracts;
import java.util.List;

import com.turkcell.rentacar.business.dtos.requests.CreatFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedFuelResponse;
import com.turkcell.rentacar.entities.concretes.Fuel;
public interface FuelService {

	/*Fuel add(Fuel fuel);
	*/
	void delete(int id);
	List<Fuel> getAll();
	Fuel getById(int id);
	void update(int id, Fuel updatedFuel);

	CreatedFuelResponse add(CreatFuelRequest creatFuelRequest);
}
