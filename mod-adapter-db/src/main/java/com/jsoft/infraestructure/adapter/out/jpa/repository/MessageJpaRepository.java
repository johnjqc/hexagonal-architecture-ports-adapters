package com.jsoft.infraestructure.adapter.out.jpa.repository;

import com.jsoft.infraestructure.adapter.out.jpa.entity.MessageJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageJpaRepository extends JpaRepository<MessageJpaEntity, Long> {

}
