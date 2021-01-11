package com.workshop.bicycles;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workshop.enums.PartType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.workshop.db.entity.BicyclePart;
import com.workshop.db.entity.Frame;
import com.workshop.db.repository.BicyclePartRepository;
import com.workshop.db.repository.FrameRepository;

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
        PartType enumz = PartType.valueOfName("frame");
        List<BicyclePart> parts = bicyclePartRepository.findAll();
    }



}
