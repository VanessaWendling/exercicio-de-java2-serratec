package br.org.serratec.projeto02.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projeto02.model.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	private static List<Aluno> listaAlunos = new ArrayList<Aluno>();
	
	// bloco de inicialização estático - é carregado durante a criação da classe
	// ele é sempre executado primeiro
	// o L depois da matricula é de Long

	static {
		listaAlunos.add(new Aluno(1234L, "Adriano", "2234-5580"));
		listaAlunos.add(new Aluno(4567L, "Carla", "2234-5050"));
		listaAlunos.add(new Aluno(8967L, "Antônio", "2237-5152"));
		listaAlunos.add(new Aluno(3234L, "João", "2245-1505"));
		listaAlunos.add(new Aluno(8797L, "Carlos", "2234-1606"));
	}

	@GetMapping()
	public List<Aluno> listar() {
		return listaAlunos;
	}

	@PostMapping()
	public Aluno inserir(@RequestBody Aluno aluno) {
		listaAlunos.add(aluno);
		return aluno;
	}

	@DeleteMapping()
	public void deletar(@RequestParam Long matricula) {
		for (int i = 0; i < listaAlunos.size(); i++)
			if (listaAlunos.get(i).getMatricula().equals(matricula))
				listaAlunos.remove(i);

	}
	
	/*
	 * 
	@PutMapping()
	public void atualizar(@RequestBody Aluno aluno, @RequestParam Long matricula) {
		for (int i = 0; i < listaAlunos.size(); i++)
			if (listaAlunos.get(i).getMatricula().equals(matricula)) { */
				
				/*Aluno a = new Aluno(matricula, aluno.getNome(), aluno.getTelefone());
				listaAlunos.set(i, a); 				OU				*/
				
				/*listaAlunos.set(i, new Aluno (matricula, aluno.getNome(), aluno.getTelefone()));
				}
				
	}
	
				 	OU
	*/
	
	@PutMapping("{matricula}")
	public Aluno atualizar(@RequestBody Aluno aluno, @PathVariable Long matricula) {
		for (int i = 0; i < listaAlunos.size(); i++)
			if (listaAlunos.get(i).getMatricula().equals(matricula)) {
				listaAlunos.set(i, new Aluno (matricula, aluno.getNome(), aluno.getTelefone()));
				}
		return aluno;		
	}
	
	@GetMapping("{matricula}")
	public Aluno buscar(@PathVariable Long matricula) {
		for (int i = 0; i < listaAlunos.size(); i++)
			if (listaAlunos.get(i).getMatricula().equals(matricula)) {
				return listaAlunos.get(i);
			}
				return null;
	}
}
