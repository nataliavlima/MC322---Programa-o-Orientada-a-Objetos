package lab4;

public enum Excluir {
	EXCLUIR_CLIENTE(1),
	EXCLUIR_VEICULO(2),
	EXCLUIR_SINISTRO(3),
	VOLTAR(4);
	
	public final int operacao;
	
	Excluir(int operacao){
		this.operacao = operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
}
