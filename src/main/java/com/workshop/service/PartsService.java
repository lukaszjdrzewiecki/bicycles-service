package com.workshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workshop.db.repository.PartRepositories;
import com.workshop.db.specification.Specifications;
import com.workshop.enums.PartType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.workshop.db.entity.Bicycle;
import com.workshop.db.entity.BicyclePart;
import com.workshop.db.entity.Frame;
import com.workshop.db.repository.BicyclePartRepository;

import com.workshop.db.repository.FrameRepository;
import com.workshop.db.specification.GenericSpecification;
import com.workshop.enums.PartSpec;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.workshop.utils.PartNamingUtils.PART_SPECIALIZATIONS;
import static com.workshop.utils.PartNamingUtils.createProductId;
import static com.workshop.utils.SerializationUtils.deserializeEntity;


@Service
@RequiredArgsConstructor
public class PartsService {

    private final BicycleService bicycleService;
    private final ObjectMapper mapper;
    private final FrameRepository frameRepository;
    private final BicyclePartRepository partRepository;
    private final PartRepositories repositories;


    @SneakyThrows
    @Transactional
    public BicyclePart addPart(PartType type, String partJson) {

        PartSpec spec = PART_SPECIALIZATIONS.get(type);

        Class<?> clazz = spec.getClazz();
        BicyclePart part = (BicyclePart) deserializeEntity(partJson, clazz);

        String productId = createProductId(part);
        part.setProductId(productId);
        part.setId(null);
        part.setProduct(type.getName());
        part.setIsOfficial(true);

        return partRepository.save(part);

    }

    public Object getPart(PartType type, String id) {
        return partRepository.findByProductId(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Couldn't find part of type %s and if %s", type.getName(), id)));
    }

    @SneakyThrows
    public Object getParts(PartType type, Pageable pageable, GenericSpecification genericSpec) {
        Specification specification = Specifications.buildSpecification(genericSpec);

        Object[] parameters = {specification, pageable};
        Object repositoryInstance = repositories.getRepositoryInstance().get(type);

        Class<?> clazz = repositoryInstance.getClass();

        Method method = clazz.getMethod("findAll", Specification.class, Pageable.class);
        return method.invoke(repositoryInstance, parameters);
    }

    @SneakyThrows
    @Transactional
    public Object addPartToBicycle(String userName, String bicycleName, PartType type, String partJson) {
        Bicycle bicycle = bicycleService.getBicycle(userName, bicycleName);

        if (type == PartType.FRAME) {
            return addFrame(bicycle, partJson);
        }
        return null;
    }

    @Transactional
    public Object addExistingPartToBicycle(String userName, String bicycleName, PartType type, String partId) {
        Bicycle bicycle = bicycleService.getBicycle(userName, bicycleName);
        if (type == PartType.FRAME) {
            Frame frame = frameRepository.findByProductId(partId).orElseThrow(() -> new EntityNotFoundException("Couldn't find part"));
            bicycle.setFrame(frame);
        }
        return bicycleService.updateBicycle(bicycle);
    }

    @SneakyThrows
    @Transactional
    public void deleteBicyclePart(String userName, String bicycleName, PartType type) {
        Bicycle bicycle = bicycleService.getBicycle(userName, bicycleName);

        if (type == PartType.FRAME) {
            deleteFrameOfBicycle(bicycle);
        }
    }

    private Frame addFrame(Bicycle bicycle, String frameJson) throws IOException {
        Frame frame = mapper.readValue(frameJson, Frame.class);
        frameRepository.save(frame);
        bicycle.setFrame(frame);
        bicycleService.updateBicycle(bicycle);
        return frame;
    }

    private void deleteFrameOfBicycle(Bicycle bicycle) throws IOException {
        Frame frame = bicycle.getFrame();
        bicycle.setFrame(null);
        bicycleService.updateBicycle(bicycle);
        if (!frame.getIsOfficial()) {
            frameRepository.delete(frame);
        }
    }

    public Object fetchBicyclePart(String userName, String bicycleName, PartType type) {
        Bicycle bicycle = bicycleService.getBicycle(userName, bicycleName);
        if (type == PartType.FRAME) {
            return bicycle.getFrame();
        }
        return null;
    }


}
