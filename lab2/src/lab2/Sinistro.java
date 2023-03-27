package lab2;
import java.util.Random;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	
	// Construtor
	public Sinistro(String data, String endereco) {
		this.criarId();
		this.data = data;
		this.endereco = endereco;
	}
	// funcao para gerar a Id
	private void criarId(){
		
		Random ID = new Random();   // declarar objeto random ID
		this.id = ID.nextInt(999999)+10000;  // a id ira receber essa ID aleatoria de 6 digitos
		
	}
		
	// Getters e setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	

	 // toString()
	public String toString () {
		String saida = "";
		saida += " ID: " + getId() + "\n Data: " + getData() +  "\n Endereço:  " + getEndereco()+ "\n";
		return saida;
		}
	}
