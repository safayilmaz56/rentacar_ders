package com.turkcell.rentacar.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.turkcell.rentacar.business.dtos.requests.CreateTransmissonRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.CreatedTransmissonResponse;
import com.turkcell.rentacar.core.entities.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Model;
import org.springframework.stereotype.Service;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService{

	private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedTransmissonResponse add(CreateTransmissonRequest createTransmissonRequest) {
        /*
        Transmission transmission = new Transmission();

        transmission.setName(createTransmissonRequest.getName());
        transmission.setCreatedDate(LocalDateTime.now());

        //Brand createBrand = brandRepository.save(brand);
        Transmission createTransmission = new Transmission();

        //CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();
        CreatedTransmissonResponse createdTransmissonResponse = new CreatedTransmissonResponse();
        createdTransmissonResponse.setId(createTransmission.getId());
        createdTransmissonResponse.setName(createTransmission.getName());
        createdTransmissonResponse.setCreatedDate(createTransmission.getCreatedDate());

        return createdTransmissonResponse;

         */

        Transmission transmission = this.modelMapperService.forRequest().map(createTransmissonRequest,Transmission.class);
        transmission.setCreatedDate(LocalDateTime.now());
        Transmission createdTransmisson =  transmissionRepository.save(transmission);
        CreatedTransmissonResponse createdTransmissonResponse = this.modelMapperService.forResponse().map(createdTransmisson,CreatedTransmissonResponse.class);
        return createdTransmissonResponse;
    }
/*
    @Override
    public Transmission add(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }
    @Override
    public Transmission update(int id, Transmission updatedTransmission) {
        Optional<Transmission> existingTransmissionOptional = transmissionRepository.findById(id);
        if (existingTransmissionOptional.isEmpty()) {
            throw new IllegalArgumentException("Transmission Bulunamadı!: " + id);
        }
        Transmission existingTransmission = existingTransmissionOptional.get();
        existingTransmission.setName(updatedTransmission.getName());
        return transmissionRepository.save(existingTransmission);
    }

    @Override
    public void delete(int id) {
    	Optional<Transmission> existingTransmissionOptional = transmissionRepository.findById(id);
        if (existingTransmissionOptional.isEmpty()) {
            throw new IllegalArgumentException("Transmission Bulunamadı!: " + id);
        }
        transmissionRepository.deleteById(id);
    }

    @Override
    public List<Transmission> getAll() {
        return transmissionRepository.findAll();
    }

    @Override
    public Transmission getById(int id) {
        return transmissionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transmission bulunamadı: " + id));
    }


 */


}
