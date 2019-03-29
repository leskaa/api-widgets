package com.example.widget.repository;

import com.example.widget.domain.GadgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetRepository extends JpaRepository<GadgetEntity, Long> {
}
