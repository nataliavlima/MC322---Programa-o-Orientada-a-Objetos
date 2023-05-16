package lab4;

public enum Listar {
<<<<<<< HEAD
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
=======
	LISTAR_CLIENTE("Listar cliente"),
	LISTAR_SINISTROS_SEG("Listar sinistros por seguradoras"),
	LISTAR_SINISTROS_CLI("Listar sinistros por clientes"),
	LISTAR_VEICULO_CLI("Listar veículo por clientes"),
	LISTAR_VEICULO_SEG("Listar veículo por seguradora"),
	VOLTAR("Voltar");
	
	public final String operacao;
	
	Listar(String operacao){
		this.operacao = operacao;
	}
	
	public String getOperacao() {
>>>>>>> working
		return this.operacao;
	}
}
