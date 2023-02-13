package avaliacao.pessoas.dto;

import avaliacao.pessoas.model.Pessoa;

public class PessoaDTO {

	private Long id;
	private String nome;
	private String dataNascimento;
	private String logradouro;
	private String cep;
	private Long numero;
	private String cidade;

	public PessoaDTO() {
	}

	public PessoaDTO(Long id, String nome, String dataNascimento, String logradouro, String cep, Long numero,
			String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
	}

	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.dataNascimento = pessoa.getDataNascimentoFormada();
		this.logradouro = pessoa.getLogradouro();
		this.cep = pessoa.getCep();
		this.numero = pessoa.getNumero();
		this.cidade = pessoa.getCidade();

	}

	public Pessoa converterParaPessoa(PessoaDTO dto) {
		this.id = null;
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(dto.nome);
		pessoa.setDataNascimento(dto.dataNascimento);
		pessoa.setLogradouro(dto.logradouro);
		pessoa.setCep(dto.cep);
		pessoa.setNumero(dto.numero);
		pessoa.setCidade(dto.cidade);

		return pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "PessoaDTO{" + "id=" + id + ", nome='" + nome + '\'' + ", dataNascimento='" + dataNascimento + '\''
				+ ", logradouro='" + logradouro + '\'' + ", cep='" + cep + '\'' + ", numero='" + numero + '\''
				+ ", cidade='" + cidade + '}';
	}

}