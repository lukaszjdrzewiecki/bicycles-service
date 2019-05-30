package p76.bicycles.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.service.PartsService;

@RestController
@RequestMapping(path = "/part")
public class PartsController {

    @Autowired
    PartsService service;

    @GetMapping("{partType}")
    public ResponseEntity findBicycle(@PathVariable("partType") String partType) {
        return ResponseEntity.ok(service.findAll(toCamelCase(partType)));
    }

    static String toCamelCase(String s){
        String[] parts = s.split("_");
        String camelCaseString = "";
        for (String part : parts){
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }
}
