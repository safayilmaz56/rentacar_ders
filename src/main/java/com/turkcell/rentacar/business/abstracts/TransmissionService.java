package com.turkcell.rentacar.business.abstracts;
import java.util.List;

import com.turkcell.rentacar.business.dtos.requests.CreateTransmissonRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedTransmissonResponse;
import com.turkcell.rentacar.entities.concretes.Transmission;

public interface TransmissionService {
	/*
	Transmission add(Transmission transmission);
	void delete(int id);
	List<Transmission> getAll();
	Transmission getById(int id);
	Transmission update(int id, Transmission updatedTransmission);

	 */

	CreatedTransmissonResponse add(CreateTransmissonRequest createTransmissonRequest);
}
