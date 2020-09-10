package workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workshop.db.entity.Bicycle;
import workshop.db.repository.BicycleRepository;
import workshop.service.BicycleService;
import workshop.db.dto.InfoResult;
import workshop.service.compatibility.InfoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/info")
public class InfoController {

    @Autowired
    private InfoService data;

    @Autowired
    private BicycleRepository repository;

    @Autowired
    BicycleService service;
//
//    @GetMapping
//    private List<InfoResult> getAllResults() {
//        return data.getInfoResults();
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity findBicycle(@PathVariable("id") Long id) {
//        Optional<Bicycle> bicycle = repository.findById(id);
//        if (!bicycle.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
//
//        return ResponseEntity.ok(data.getInfoResult(bicycle.get()));
//    }


}