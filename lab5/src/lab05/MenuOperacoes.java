package lab05;

public enum MenuOperacoes {
	CADASTRAR(1),
	LISTAR(2),
	EXCLUIR(3), 
	CALCULAR_RECEITA(4),
	SAIR(0);
	
	public final int operacao;
	
	MenuOperacoes (int operacao){
		this.operacao = operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
}
