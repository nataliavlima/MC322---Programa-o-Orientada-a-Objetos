package lab05;

public enum Operacoes {
	CADASTRAR_CLIENTE("1.1"),
	CADASTRAR_VEICULO("1.2"),
	CADASTRAR_SEGURADORA("1.3"),
	
	LISTAR_CLIENTE("2.1"),
	LISTAR_SINISTROS_SEG("2.2"),
	LISTAR_SINISTROS_CLI("2.3"),
	LISTAR_VEICULO_CLI("2.4"),
	LISTAR_VEICULO_SEG("2.5"),
	
	EXCLUIR_CLIENTE("3.1"),
	EXCLUIR_VEICULO("3.2"),
	EXCLUIR_SINISTRO("3.3"),
	
	VOLTAR("0");
	public final String operacao;
	
	Operacoes(String operacao){
		this.operacao = operacao;
	}
	
	public String getOperacao() {
		return this.operacao;
	}

}
