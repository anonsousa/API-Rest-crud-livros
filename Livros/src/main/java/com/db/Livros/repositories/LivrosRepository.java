package com.db.Livros.repositories;


import com.db.Livros.models.LivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LivrosRepository extends JpaRepository<LivrosModel, UUID> {
}
