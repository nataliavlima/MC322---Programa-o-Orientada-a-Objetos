package lab4;

public enum Operacoes {

	CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	
	LISTAR_CLIENTE("Listar clientes por seguradora"),
	LISTAR_SINISTROS_SEG("Listar sinistros por seguradoras"),
	LISTAR_SINISTROS_CLI("Listar sinistros por clientes"),
	LISTAR_VEICULO_CLI("Listar veículo por clientes"),
	LISTAR_VEICULO_SEG("Listar veículo por seguradora"),
	
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veículo"),
	EXCLUIR_SINISTRO("Excluir sinistro"),
	
	VOLTAR("Voltar");
	
	public final String operacao;
	
	Operacoes(String operacao){
		this.operacao = operacao;
	}
	
	public String getOperacao() {
		return this.operacao;
	}

	
	}
