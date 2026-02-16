package br.com.quantusoft.quantum_api.repository;

import br.com.quantusoft.quantum_api.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
