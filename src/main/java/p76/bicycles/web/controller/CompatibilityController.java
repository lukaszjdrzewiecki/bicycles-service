package p76.bicycles.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import p76.bicycles.service.compatibility.CompatibilityService;

@RestController
@RequestMapping(path = "/compatibility")
public class CompatibilityController {

    @Autowired
    private CompatibilityService compatibility;

    @GetMapping("{id}")
    public ResponseEntity getBicycleFullCompatibility(@PathVariable("id") Long id) {
        return ResponseEntity.ok(compatibility.isBicycleCompatible(id));
    }

    @GetMapping("/frontWheel/{id}")
    public ResponseEntity getFrontWheelCompatibility(@PathVariable("id") Long id) {
        return ResponseEntity.ok(compatibility.frontWheelCheck(id));
    }

    @GetMapping("/rearWheel/{id}")
    public ResponseEntity getRearWheelCompatibility(@PathVariable("id") Long id) {
        return ResponseEntity.ok(compatibility.rearWheelCheck(id));
    }

    @GetMapping("/drivetrain/{id}")
    public ResponseEntity getDrivetrainCompatibility(@PathVariable("id") Long id) {
        return ResponseEntity.ok(compatibility.drivetrainCheck(id));
    }

    @GetMapping("/frame/{id}")
    public ResponseEntity getFrameCompatibility(@PathVariable("id") Long id) {
        return ResponseEntity.ok(compatibility.frameCheck(id));
    }

}
