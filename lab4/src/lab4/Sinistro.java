package lab4;
import java.util.Date;

public class Sinistro {
	private int id = 0;
	private Date data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	private static int  num = 99999;
	
	// Construtor
	public Sinistro(Date data, String endereco,Seguradora seguradora,Veiculo veiculo,Cliente cliente ) {
		this.criarId();
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	// funcao para gerar a Id
	private void criarId(){
		num++;
		id = num;		
	}
		
	// Getters e setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	 // toString()
	public String toString () {
		return "Sinistro:" +
				"\n ID: " + this.id + 
				"\n Endereço: " + this.endereco + 
				"\n Seguradora: " + this.seguradora.getNome() + 
				"\n Veículo: " + this.veiculo.getPlaca() +  
				"\n Cliente:  " + this.cliente.getNome()+ "\n";
		
		}
	}