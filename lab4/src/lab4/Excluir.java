package lab4;

public enum Excluir {
<<<<<<< HEAD
	EXCLUIR_CLIENTE(1),
	EXCLUIR_VEICULO(2),
	EXCLUIR_SINISTRO(3),
	VOLTAR(4);
	
	public final int operacao;
	
	Excluir(int operacao){
		this.operacao = operacao;
	}
	
	public int getOperacao() {
=======
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veículo"),
	EXCLUIR_SINISTRO("Excluir sinistro"),
	VOLTAR("Voltar");
	
	public final String operacao;
	
	Excluir(String operacao){
		this.operacao = operacao;
	}
	
	public String getOperacao() {
>>>>>>> working
		return this.operacao;
	}
}
