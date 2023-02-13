package avaliacao.pessoas.controller;

import avaliacao.pessoas.dto.PessoaDTO;
import avaliacao.pessoas.model.Pessoa;
import avaliacao.pessoas.repository.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepositorio pessoaRepository;

	// localizar um objeto de pessoa pelo id da pessoa
	@GetMapping("/{id}")
	@RequestMapping(value = "/pessoas/id/{id}", method = RequestMethod.GET)
	public PessoaDTO localizarPessoa(@PathVariable(name = "id") Long id) {
		Pessoa pessoa = pessoaRepository.getById(id);
		PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
		return pessoaDTO;
	}

	// localizar um objeto de pessoa pelo nome da pessoa
	@GetMapping("/nome/{nome}")
	@RequestMapping(value = "/pessoas/nome/{nome}", method = RequestMethod.GET)
	public PessoaDTO localizarPessoaPorNome(@PathVariable(name = "nome") String nome) {
		Pessoa funcionario = pessoaRepository.findFirstByNome(nome);
		return new PessoaDTO(funcionario);
	}

	// listar(select - ler) todas as pessoas cadastrados através de um
	// ArrayList - CRUD - criar, ler, alterar e excluir
	@GetMapping("/")
	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
	public List<PessoaDTO> listarPessoas() {
		List<PessoaDTO> pessoaDTOS = new ArrayList<>();
		List<Pessoa> pessoalist = pessoaRepository.findAll();
		for (Pessoa pessoa : pessoalist) {
			PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
			pessoaDTOS.add(pessoaDTO);
		}
		return pessoaDTOS;
	}

	// função de salvar(insert - criar) pessoas dentro de um repositorio
	@PostMapping("/")
	@RequestMapping(value = "/pessoas", method = RequestMethod.POST)
	public void gravarPessoa(@RequestBody PessoaDTO dto) {
		Pessoa pessoa = dto.converterParaPessoa(dto);
		pessoaRepository.save(pessoa);
	}

	// função de alterar dados de uma pessoa
	@PutMapping("/{id}")
	@RequestMapping(value = "/pessoas", method = RequestMethod.PUT)
	public @ResponseBody Pessoa alterarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

}
