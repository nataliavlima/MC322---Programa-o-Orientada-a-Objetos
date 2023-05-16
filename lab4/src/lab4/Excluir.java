package lab4;

public enum Excluir {
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veículo"),
	EXCLUIR_SINISTRO("Excluir sinistro"),
	VOLTAR("Voltar");
	
	public final String operacao;
	
	Excluir(String operacao){
		this.operacao = operacao;
	}
	
	public String getOperacao() {
		return this.operacao;
	}
}
