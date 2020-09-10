package workshop.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import workshop.db.dto.BicycleDto;
import workshop.db.entity.Bicycle;

import workshop.db.repository.BicycleRepository;

@Data
@Service
@RequiredArgsConstructor
public class BicycleService {

    private final BicycleRepository repository;

    public Bicycle addBicycle(Bicycle bicycle) {
        return repository.save(bicycle);
    }

    public List<BicycleDto> findAllBicycles() {
        List<Bicycle> bicycles = repository.findAll();
        return mapToDto(bicycles);
    }

    private List<BicycleDto> mapToDto(List<Bicycle> bicycles) {
        return bicycles.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private BicycleDto mapToDto(Bicycle bicycle) {
        return BicycleDto.builder()
                .id(bicycle.getId())
                .name(bicycle.getName())
                .type(bicycle.getType())
                .brand(bicycle.getBrand())
                .model(bicycle.getModel())
                .weight(bicycle.getPredefinedWeight() == null ? bicycle.getCountedWeight() : bicycle.getPredefinedWeight())
                .type(bicycle.getType())
                .build();
    }

}


