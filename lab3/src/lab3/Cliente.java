package lab3;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Cliente {
	protected String nome;
	protected String endereco;
	protected Date dataLicenca;
	protected String educacao;
	protected String genero;
	protected String classeEconomica;

	protected List < Veiculo > listaVeiculos = new ArrayList<Veiculo>();

	// Construtor
	 	public Cliente (String nome , String endereco, Date dataLicenca , String educacao, String genero, String classeEconomica, List<Veiculo>listaVeiculos ) {
		 this.nome = nome;
		 this.endereco = endereco;
		 this.dataLicenca = dataLicenca;
		 this.educacao = educacao;
		 this.genero = genero;
		 this.classeEconomica = classeEconomica;
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

	 
	 public Date getDataLicenca() {
		 return dataLicenca;
	 	}

	 public void setDataLicenca(Date dataLicenca) {
		 this.dataLicenca = dataLicenca;
	 	}
	 
	 public String getEducacao(){
		 return educacao;
	 	}

	 public void setEducacao(String educacao) {
		 this.educacao = educacao;
	 	}

	 public String getGenero(){
		 return genero;
	 	}

	 public void setGenero(String genero) {
		 this.genero = genero;
	 	}
	 public String getClasseEconomica(){
		 return classeEconomica;
	 	}

	 public void setClasseEconomica(String  classeEconomica) {
		 this.classeEconomica = classeEconomica;
	 	}
	 
	public List<Veiculo> getListaVeiculo(){
		return listaVeiculos;
		}
	public void adicionaVeiculo(Veiculo veiculo) {
		this.listaVeiculos.add(veiculo);
	}
	
	
	@Override
	public String toString () {
		return  " Nome: " + this.nome + 
				"\n Endereço: " + this.endereco + 
				"\n Data da Licença: " + this.dataLicenca + 
				"\n Educação: " + this.educacao +  
				"\n Gênero:  " + this.genero+ 
				"\n Classe Econômica:  " + this.classeEconomica+ 
				"\n Veiculos: " + this.listaVeiculos+ "\n";
		
		}
	
  
}