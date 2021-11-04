package br.org.serratec.projeto02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projeto02.model.Veiculo;
import br.org.serratec.projeto02.model.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Veiculo> buscar(@PathVariable Long id){
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		if (veiculo.isPresent()) {
			return ResponseEntity.ok(veiculo.get());
		}
		return ResponseEntity.notFound().build();
	}
	@GetMapping
	public ResponseEntity <List<Veiculo>> listar(){
		List <Veiculo> veiculos = veiculoRepository.findAll();
		return ResponseEntity.ok(veiculos);
	}
	@PutMapping("{id}")
	public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo){
		if(!veiculoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
	veiculo.setId(id);
	veiculo = veiculoRepository.save(veiculo);
	return ResponseEntity.ok(veiculo);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id){
		if(!veiculoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		veiculoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
