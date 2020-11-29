package workshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import workshop.component.BicycleTypePropertyEditor;
import workshop.enums.PartType;
import workshop.service.PartsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class PartController {

    private final PartsService service;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(PartType.class, new BicycleTypePropertyEditor(PartType.class));
    }

    @GetMapping("/parts/{partType}/{partId}")
    public Object fetchPart(@PathVariable PartType partType, @PathVariable String partId) {
        return service.getPart(partType, partId);
    }

    @GetMapping("/parts/{partType}")
    public Object fetchParts(@PathVariable PartType partType, @RequestParam(required = false) String brand) {
        return service.getParts(partType, brand);
    }

    @PostMapping("/parts/{partType}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addPart(@PathVariable PartType partType, @RequestBody String partJson) {
        return service.addPart(partType, partJson);
    }

    @GetMapping("/{userName}/bicycles/{bicycleName}/{partType}")
    public Object getPartOfBicycle(@PathVariable String userName, @PathVariable String bicycleName,
                          @PathVariable PartType partType) {
        return service.fetchBicyclePart(userName, bicycleName, partType);
    }

    @PostMapping("/{userName}/bicycles/{bicycleName}/{partType}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addPartToBicycle(@PathVariable String userName, @PathVariable String bicycleName,
                              @PathVariable PartType partType, @RequestBody String partJson) {
        return service.addPartToBicycle(userName, bicycleName, partType, partJson);
    }

    @DeleteMapping("/{userName}/bicycles/{bicycleName}/{partType}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBicyclePart(@PathVariable String userName, @PathVariable String bicycleName,
                                   @PathVariable PartType partType) {
        service.deleteBicyclePart(userName, bicycleName, partType);
    }

    @PostMapping("/{userName}/bicycles/{bicycleName}/{partType}/{partId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addExistingPartToBicycle(@PathVariable String userName, @PathVariable String bicycleName,
                                   @PathVariable PartType partType, @PathVariable String partId) {
        return service.addExistingPartToBicycle(userName, bicycleName, partType, partId);
    }


}
