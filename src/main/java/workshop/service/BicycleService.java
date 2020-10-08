package workshop.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import workshop.db.dto.BicycleDto;
import workshop.db.entity.Bicycle;

import workshop.db.repository.BicycleRepository;

import javax.persistence.EntityNotFoundException;

@Data
@Slf4j
@Service
@RequiredArgsConstructor
public class BicycleService {

    private final BicycleRepository repository;

    public Bicycle addBicycle(Bicycle bicycle) {
        return repository.save(bicycle);
    }

    public Bicycle updateBicycle(String name, Bicycle update) {
        Bicycle bicycle = getBicycleByName(name);
        Bicycle updatedBicycle = updateBicycleFields(bicycle, update);
        return repository.save(updatedBicycle);
    }

    public void deleteBicycle(String name) {
        Bicycle bicycle = getBicycleByName(name);
        repository.deleteById(bicycle.getId());
        log.info("Deleted bicycle with name {}", name);
    }

    public Bicycle getBicycleByName(String name) {
        return repository.findByName(StringUtils.trimAllWhitespace(name))
                .orElseThrow(() -> new EntityNotFoundException(String.format("Couldn't find the bicycle of name %s", name)));
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

    private Bicycle updateBicycleFields(Bicycle oldBicycle, Bicycle updated) {
        return oldBicycle.toBuilder()
                .brand(updated.getBrand())
                .model(updated.getModel())
                .name(updated.getName())
                .predefinedWeight(updated.getPredefinedWeight())
                .type(updated.getType())
                .year(updated.getYear())
                .build();
    }

}


