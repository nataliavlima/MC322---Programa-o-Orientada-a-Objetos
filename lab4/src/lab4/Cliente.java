package lab4;
import java.util.List;
import java.text.ParseException;
import java.util.ArrayList;

public class Cliente {
	protected String nome;
	protected String endereco;
	protected double valorSeguro = 0;

	protected List < Veiculo > listaVeiculos = new ArrayList<Veiculo>();

	// Construtor
	 	public Cliente (String nome , String endereco, List<Veiculo>listaVeiculos ) {
		 this.nome = nome;
		 this.endereco = endereco;
		 this.valorSeguro = valorSeguro;
		 this.listaVeiculos = new ArrayList<Veiculo>();
	 }
		
		 
	// Getters e setters
	 public String getNome() {
		 return nome;
	 	}

	 public void setNome(String nome) {
		 this.nome = nome;
	 	}
	 
	 public String getEndereco() {
		 return endereco;
	 	}

	 public void setEndereco( String endereco ) {
		 this.endereco = endereco;
	 	}

	 public void setValorSeguro(double valorSeguro) {
		 this.valorSeguro = valorSeguro;
	 	}
	 
	 public double getValorSeguro() {
		 return valorSeguro;
	 	}
	 
	public List<Veiculo> getListaVeiculo(){
		return listaVeiculos;
		}
	public void adicionaVeiculo(Veiculo veiculo) {
		this.listaVeiculos.add(veiculo);
	}
	
	public double calculaScore(Cliente cliente1) throws ParseException{
		double seguro = 0;
		 // calculo do valor do seguro
		 
		 	if(cliente1 instanceof ClientePF) {
				 seguro = ((ClientePF) cliente1).calculaScore();
				cliente1.valorSeguro = seguro;
				
			} else if(cliente1 instanceof ClientePJ) {
				seguro = ((ClientePJ) cliente1).calculaScore();
				cliente1.valorSeguro = seguro;
			} else {
				seguro = 0;
			}
		
		 return seguro;
	}
	
	@Override
	public String toString () {
		return  " Nome: " + this.nome + 
				"\n Endereço: " + this.endereco + 
				"\n Veiculos: " + this.listaVeiculos+ 
				"\n Valor Seguro: R$ " + this.valorSeguro + 
				"\n";
		
		}
	
  
}