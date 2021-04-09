package com.gabrielpf.wodfeeder.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielpf.wodfeeder.controller.form.WeightTypeForm;
import com.gabrielpf.wodfeeder.service.WeightTypeService;
import com.gabrielpf.wodfeeder.vo.WeightTypeVO;

import io.jsonwebtoken.lang.Assert;

@RestController
@RequestMapping(path = "/api/weight-types", produces = MediaType.APPLICATION_JSON_VALUE)
public class WeightTypeController {

    private final WeightTypeService weightTypeService;

    public WeightTypeController(WeightTypeService weightTypeService) {
        this.weightTypeService = weightTypeService;
    }

    @GetMapping
    public List<WeightTypeVO> list(@RequestParam(required = false) String type) {
        if (type == null)
            return weightTypeService.findAll();
        return weightTypeService.findByTypeContainingIgnoringCase(type);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('admin')")
    public WeightTypeVO create(@Valid @RequestBody WeightTypeForm form) {
        return weightTypeService.save(form);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeightTypeVO> getOne(@PathVariable UUID id) {
        return ResponseEntity.of(weightTypeService.findById(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<WeightTypeVO> update(@Valid @RequestBody WeightTypeForm form, @PathVariable UUID id) {
        return weightTypeService
                .findById(id)
                .map(foundWeightType -> weightTypeService.update(foundWeightType, form))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
