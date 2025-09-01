package com.agrigestor.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agrigestor.model.Agricultor;

@Repository
public interface AgricultorRepository extends JpaRepository<Agricultor, Long> {
	
	boolean existsByCpfCnpj(String cpfCnpj);
}
