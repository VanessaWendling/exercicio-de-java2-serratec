package br.org.serratec.projeto02.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projeto02.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo,Long>{
	
}
