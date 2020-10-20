package workshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workshop.db.entity.Bicycle;
import workshop.db.entity.Frame;
import workshop.db.repository.FrameRepository;
import workshop.enums.PartType;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PartsService {

    private final BicycleService bicycleService;
    private final ObjectMapper mapper;
    private final FrameRepository frameRepository;

    @SneakyThrows
    @Transactional
    public Object addBicyclePart(String userName, String bicycleName, PartType type, String partJson) {
        Bicycle bicycle = bicycleService.getBicycle(userName, bicycleName);

        if (type == PartType.FRAME) {
            return addFrame(bicycle, partJson);
        }
        return null;
    }

    private Frame addFrame(Bicycle bicycle, String frameJson) throws IOException {
        Frame frame = mapper.readValue(frameJson, Frame.class);
        frameRepository.save(frame);
        bicycle.setFrame(frame);
        bicycleService.updateBicycle(bicycle);
        return frame;
    }

    public Object fetchBicyclePart(String userName, String bicycleName, PartType type) {
        Bicycle bicycle = bicycleService.getBicycle(userName, bicycleName);
        if (type == PartType.FRAME) {
            return bicycle.getFrame();
        }
        return null;
    }
}
