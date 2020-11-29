package workshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workshop.db.entity.Bicycle;
import workshop.db.entity.Frame;
import workshop.db.repository.ForkRepository;
import workshop.db.repository.FrameRepository;
import workshop.enums.PartType;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;

import static workshop.db.specification.FrameSpecification.buildFrameSpecification;

@Service
@RequiredArgsConstructor
public class PartsService {

    private final BicycleService bicycleService;
    private final ObjectMapper mapper;
    private final FrameRepository frameRepository;
    private final ForkRepository forkRepository;
    private final EntityManager em;

    @SneakyThrows
    @Transactional
    public Object addPart(PartType type, String partJson) {
        if (type == PartType.FRAME) {
            return addFrame(partJson);
        }
        if (type == PartType.FORK) {
            return addFrame(partJson);
        }
        throw new IllegalArgumentException("Not recognized part");
    }

    public Object getPart(PartType type, String id) {
        if (type == PartType.FRAME) {
            return frameRepository.findByProductId(id).orElseThrow(() -> new EntityNotFoundException("Couldn't find part"));
        }
        if (type == PartType.FORK) {
            return forkRepository.findByProductId(id).orElseThrow(() -> new EntityNotFoundException("Couldn't find part"));
        }
        throw new IllegalArgumentException("Not recognized part");
    }

    public Object getParts(PartType type, String brand) {
        Specification<Frame> spec = buildFrameSpecification(brand);

        if (type == PartType.FRAME) {

            return frameRepository.findAll(spec);
        }
        if (type == PartType.FORK) {
            return forkRepository.findAllByIsOfficialTrue();
        }
        throw new IllegalArgumentException("Not recognized part");
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

    private Frame addFrame(String frameJson) throws IOException {
        Frame frame = mapper.readValue(frameJson, Frame.class);
        frame.setId(null);
        frame.setProduct("frame");
        frame.setIsOfficial(true);
        return frameRepository.save(frame);
    }

    private void deleteFrameOfBicycle(Bicycle bicycle) throws IOException {
        Frame frame = bicycle.getFrame();
        bicycle.setFrame(null);
        bicycleService.updateBicycle(bicycle);
        if(!frame.getIsOfficial()) {
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
