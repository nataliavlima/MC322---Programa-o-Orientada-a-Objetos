package lab4;

public enum MenuOperacoes {
	CADASTRAR(1),
	LISTAR(2),
	EXCLUIR(3), 
	GERAR_SINISTRO(4),
	TRANSFERIR_SEGURO(5),
	CALCULAR_RECEITA(6),
	SAIR(0);
	
	/*
	// Cadastrar
	CADASTRAR_CLIENTE(1.1),
	CADASTRAR_VEICULO(1.2),
	CADASTRAR_SEGURADORA(1.3),
	
	
	// Listar
	LISTAR_CLIENTE(2.1),
	LISTAR_SINISTROS_SEG(2.2),
	LISTAR_SINISTROS_CLI(2.3),
	LISTAR_VEICULO_CLI(2.4),
	LISTAR_VEICULO_SEG(2.5),
	
	// Excluir
	EXCLUIR_CLIENTE(3.1),
	EXCLUIR_VEICULO(3.2),
	EXCLUIR_SINISTRO(3.3),

	VOLTAR(7);
	
	*/
	public final int operacao;
	
	MenuOperacoes (int operacao){
		this.operacao = operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
}
