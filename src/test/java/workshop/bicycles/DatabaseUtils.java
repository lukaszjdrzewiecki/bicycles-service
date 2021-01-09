package workshop.bicycles;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import workshop.db.entity.BicyclePart;
import workshop.db.entity.Frame;
import workshop.db.repository.BicyclePartRepository;
import workshop.db.repository.FrameRepository;

import javax.lang.model.type.ReferenceType;
import java.nio.file.Paths;
import java.util.List;


@SpringBootTest
class DatabaseUtils extends IntegrationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FrameRepository frameRepository;

    @Autowired
    private BicyclePartRepository bicyclePartRepository;

    @Test
    void saveFrames() throws Exception {
        List<Frame> frames = frameRepository.findAllByIsOfficialTrue();

        objectMapper.writeValueAsString(frames);

        objectMapper.writeValue(Paths.get("src/test/resources/db/frames.json").toFile(), frames);
    }

    @Test
    void deleteFrames() throws Exception {
        frameRepository.deleteAll();
    }

    @Test
    void addFrames() throws Exception {
        String json = resourceAsJson("db/frames.json");
        List<Frame> frames = objectMapper.readValue(json, new TypeReference<List<Frame>>() {});
        frameRepository.saveAll(frames);
    }

    @Test
    void getAllParts() throws Exception {
        List<BicyclePart> parts = bicyclePartRepository.findAll();
    }





}
