package lab02;
import java.util.Random;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	
	// Construtor
	public Sinistro(int id, String data, String endereco) {
		this.id = id;
		this.data = data;
		this.endereco = endereco;
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
	
	
	// funcao para gerar a Id
	public static void main(String[] args, int id){
		
		Random ID = new Random();   // declarar objeto random ID
		id = ID.nextInt(999999)+10000;  // a id ira receber essa ID aleatoria de 6 digitos
		System.out.println("Id: ");
		System.out.println(id);
		}
}