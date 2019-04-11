package xyz.cavalheiro.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cavalheiro.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	Empresa findByCnpj(String cnpj);
	
}
