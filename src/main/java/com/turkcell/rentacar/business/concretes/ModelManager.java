package com.turkcell.rentacar.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.turkcell.rentacar.business.dtos.requests.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.CreatedModelResponse;
import com.turkcell.rentacar.core.entities.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.entities.concretes.Fuel;
import org.springframework.stereotype.Service;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Model;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ModelManager implements ModelService{

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        /*
        Model model = new Model();

        model.setName(createModelRequest.getName());
        model.setCreatedDate(LocalDateTime.now());

        //Brand createBrand = fuelRepository.save(fuel);
        Model createdModel = this.modelRepository.save(model);

        //CreatedFuelResponse createdFuelRespons = new CreatedFuelResponse();
        CreatedModelResponse createdModelResponse = new CreatedModelResponse();
        createdModelResponse.setId(createdModel.getId());
        createdModelResponse.setName(createdModel.getName());
        createdModelResponse.setCreatedDate(createdModel.getCreatedDate());

        return createdModelResponse;

         */

        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        model.setCreatedDate(LocalDateTime.now());
        Model createdModel =  modelRepository.save(model);
        CreatedModelResponse createdModelResponse = this.modelMapperService.forResponse().map(createdModel,CreatedModelResponse.class);
        return createdModelResponse;
    }

    /*
    @Override
    public Model add(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model update(int id, Model updatedModel) {
        Optional<Model> existingModelOptional = modelRepository.findById(id);
        if (existingModelOptional.isEmpty()) {
            throw new IllegalArgumentException("Model Bulunamadı!: " + id);
        }
        Model existingModel = existingModelOptional.get();
        existingModel.setName(updatedModel.getName());
        return modelRepository.save(existingModel);
    }

    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public Model getById(int id) {
        return modelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Model bulunamadı: " + id));
    }
    */

}
