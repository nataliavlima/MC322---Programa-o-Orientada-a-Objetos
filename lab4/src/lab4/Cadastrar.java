package lab4;

public enum Cadastrar {
<<<<<<< HEAD
	CADASTRAR_CLIENTE(1),
	CADASTRAR_VEICULO(2),
	CADASTRAR_SEGURADORA(3),
	VOLTAR(4);
	
	public final int operacao;
	
	Cadastrar(int operacao){
		this.operacao = operacao;
	}
	
	public int getOperacao() {
=======
	CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	VOLTAR("Voltar");
	
	public final String operacao;
	
	Cadastrar(String operacao){
		this.operacao = operacao;
	}
	
	public String getOperacao() {
>>>>>>> working
		return this.operacao;
	}
}
