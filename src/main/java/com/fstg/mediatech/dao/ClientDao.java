package com.fstg.mediatech.dao;

import com.fstg.mediatech.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity, Integer> {
    ClientEntity findByNom(String nom);
    Optional<ClientEntity> findByCin(String cin);
}
