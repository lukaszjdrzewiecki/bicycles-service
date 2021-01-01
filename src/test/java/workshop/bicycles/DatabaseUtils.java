package workshop.bicycles;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import workshop.db.entity.Frame;
import workshop.db.repository.FrameRepository;

import java.nio.file.Paths;
import java.util.List;


@SpringBootTest
class DatabaseUtils {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FrameRepository frameRepository;

    @Test
    void saveFrames() throws Exception {
        List<Frame> frames = frameRepository.findAllByIsOfficialTrue();

        objectMapper.writeValueAsString(frames);

        objectMapper.writeValue(Paths.get("src/test/resources/db/frames.json").toFile(), frames);
    }




}
