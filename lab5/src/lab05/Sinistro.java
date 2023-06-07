package lab05;
import java.util.Date;


public class Sinistro {
	private final int id;
	private Date data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	private static int  num = 99999;
	
	// Construtor
	public Sinistro(Date data, String endereco,Condutor condutor,Seguro seguro ) {
		num++;
		this.id = num;
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
	}
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) { // atualiza a variavel estatica que atualiza o id
		Sinistro.num = num;
	}
	// Getters e setters
	
	public int getId() {
		return id;
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
	
	
	public Condutor getCondutor() {
		return condutor;
	}
	
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
	
	public Seguro getSeguro() {
		return seguro;
	}
	
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	
	

	 // toString()
	public String toString () {
		return "Sinistro:" +
				"\n ID: " + this.id + 
				"\n Data: " + this.data + 
				"\n Endereço: " + this.endereco + 
				"\n Seguro ID: " + this.seguro.getSeguradora().getNome() + 
				"\n Condutor: " + this.condutor.getNome() +  
				"\n";
		
		}
	}