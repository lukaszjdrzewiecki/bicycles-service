package workshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import workshop.enums.PartType;
import workshop.service.PartsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{userName}/bicycles/{bicycleName}")
public class PartController {

    private final PartsService service;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(PartType.class, new BicycleTypePropertyEditor(PartType.class));
    }

    @GetMapping("/{partType}")
    public Object getPart(@PathVariable String userName,
                          @PathVariable String bicycleName,
                          @PathVariable PartType partType) {
        return service.fetchBicyclePart(userName, bicycleName, partType);
    }

    @PostMapping("/{partType}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addPart(@PathVariable String userName,
                              @PathVariable String bicycleName,
                              @PathVariable PartType partType,
                              @RequestBody String partJson) {
        return service.addBicyclePart(userName, bicycleName, partType, partJson);
    }
}
