package com.gabrielpf.wodfeeder.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielpf.wodfeeder.model.WeightType;

public interface WeightTypeRepository extends JpaRepository<WeightType, UUID> {
    List<WeightType> findByTypeContainingIgnoringCase(String Type);
    Optional<WeightType> findByType(String type);
}
