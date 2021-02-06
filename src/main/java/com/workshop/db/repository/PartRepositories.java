package com.workshop.db.repository;

import com.workshop.enums.PartType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PartRepositories {

    private final FrameRepository frameRepository;

    public Map<Object, Object> getRepositoryInstance() {
        return  Map.ofEntries(
                Map.entry(PartType.FRAME, frameRepository));
    }
}
