package lab4;

public enum Listar {
	LISTAR_CLIENTE(1),
	LISTAR_SINISTROS_SEG(2),
	LISTAR_SINISTROS_CLI(3),
	LISTAR_VEICULO_CLI(4),
	LISTAR_VEICULO_SEG(5),
	VOLTAR(6);
	
	public final int operacao;
	
	Listar(int operacao){
		this.operacao = operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
}
