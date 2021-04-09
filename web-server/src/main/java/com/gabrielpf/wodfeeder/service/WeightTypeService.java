package com.gabrielpf.wodfeeder.service;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.controller.form.WeightTypeForm;
import com.gabrielpf.wodfeeder.model.WeightType;
import com.gabrielpf.wodfeeder.repo.WeightTypeRepository;
import com.gabrielpf.wodfeeder.vo.WeightTypeVO;

@Service
public class WeightTypeService {

    private final WeightTypeRepository weightTypeRepository;

    public WeightTypeService(WeightTypeRepository weightTypeRepository) {
        this.weightTypeRepository = weightTypeRepository;
    }

    public WeightTypeVO save(WeightTypeForm form) {
        var weightType = weightTypeRepository.save(form.convert());
        return new WeightTypeVO(weightType);
    }

    public List<WeightTypeVO> findAll() {
        return weightTypeRepository
                .findAll()
                .stream()
                .map(WeightTypeVO::new)
                .collect(toUnmodifiableList());
    }

    public Optional<WeightTypeVO> findByType(String type) {
        return weightTypeRepository
                .findByType(type)
                .map(WeightTypeVO::new);
    }

    public List<WeightTypeVO> findByTypeContainingIgnoringCase(String type) {
        return weightTypeRepository
                .findByTypeContainingIgnoringCase(type)
                .stream()
                .map(WeightTypeVO::new)
                .collect(toUnmodifiableList());
    }

    public WeightTypeVO update(WeightTypeVO weightTypeVO, WeightTypeForm form) {

        var weightType = form.convert();
        weightType.setId(weightTypeVO.getId());
        var updatedWeightType = weightTypeRepository.save(weightType);
        return new WeightTypeVO(updatedWeightType);
    }

    public Optional<WeightTypeVO> findById(UUID id) {
        return weightTypeRepository.findById(id).map(WeightTypeVO::new);
    }
}
