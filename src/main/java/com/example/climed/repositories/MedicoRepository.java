package com.example.climed.repositories;

import com.example.climed.entidades.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, UUID> {
}
