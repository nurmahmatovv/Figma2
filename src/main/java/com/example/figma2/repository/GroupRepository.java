package com.example.figma2.repository;

import com.example.figma2.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Integer> {

    boolean existsByName(String name);

    Optional<Group> findByIdAndActiveTrue(Integer id);
    boolean existsByNameIgnoreCaseAndActiveIsTrue(String name);


}
