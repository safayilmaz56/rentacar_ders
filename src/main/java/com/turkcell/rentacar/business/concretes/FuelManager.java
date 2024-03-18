package com.turkcell.rentacar.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.turkcell.rentacar.business.dtos.requests.CreatFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedFuelResponse;
import com.turkcell.rentacar.core.entities.utilities.mapping.ModelMapperService;
import org.springframework.stereotype.Service;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class FuelManager implements FuelService{

	  private FuelRepository fuelRepository;
	  private ModelMapperService modelMapperService;

	@Override
	public CreatedFuelResponse add(CreatFuelRequest creatFuelRequest) {
		/*
		Fuel fuel = new Fuel();

		fuel.setName(creatFuelRequest.getName());
		fuel.setCreatedDate(LocalDateTime.now());

		//Brand createBrand = fuelRepository.save(fuel);
		Fuel createdFuel = this.fuelRepository.save(fuel);

		CreatedFuelResponse createdFuelRespons = new CreatedFuelResponse();
		createdFuelRespons.setId(createdFuel.getId());
		createdFuelRespons.setName(createdFuel.getName());
		createdFuelRespons.setCreatedDate(createdFuel.getCreatedDate());

		return createdFuelRespons;

		 */

		Fuel fuel = this.modelMapperService.forRequest().map(creatFuelRequest,Fuel.class);
		fuel.setCreatedDate(LocalDateTime.now());
		Fuel createdFuel =  fuelRepository.save(fuel);
		CreatedFuelResponse createdFuelResponse = this.modelMapperService.forResponse().map(createdFuel,CreatedFuelResponse.class);
		return createdFuelResponse;
	}
/*
	    @Override
	    public Fuel add(Fuel fuel) {
	        return fuelRepository.save(fuel);
	    }
*/
	    @Override
	    public void update(int id, Fuel updatedFuel) {
			/*
	        Optional<Fuel> existingFuelOptional = fuelRepository.findById(id);
	        if (existingFuelOptional.isEmpty()) {
	            throw new IllegalArgumentException("Yakıt Türü Bulunamadı!: " + id);
	        }
	        Fuel existingFuel = existingFuelOptional.get();
	        existingFuel.setName(updatedFuel.getName());
	        return fuelRepository.save(existingFuel);

			 */

			Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
			if (existsFuel.isPresent()){

			}
	    }

	    @Override
	    public void delete(int id) {
	        fuelRepository.deleteById(id);
	    }

	    @Override
	    public List<Fuel> getAll() {
	        return fuelRepository.findAll();
	    }

	    @Override
	    public Fuel getById(int id) {
	        return fuelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Yakıt Türü bulunamadı: " + id));
	    }



}
