package avaliacao.pessoas.repository;

import avaliacao.pessoas.model.Pessoa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {

	// pesquisar por id da pessoa
	Pessoa getById(Long id);

	// pesquisar por nome da pessoa
	Pessoa findFirstByNome(String nome);

	// listar todos as pessoas
	List<Pessoa> findAll();

	// Cadastrar/Alterar pessoa
	Pessoa save(Pessoa pessoa);

}
