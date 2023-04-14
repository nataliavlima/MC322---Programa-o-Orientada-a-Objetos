package lab3;
import java.util.Date;
//import java.util.List;
//import java.util.LinkedList;
import java.util.Random;

public class Cliente implements Comparable<Cliente>{
	protected String nome;
	protected String endereco;
	protected Date dataLicenca;
	protected String educacao;
	protected String genero;
	protected String classeEconomica;
	int id;
	
	//protected List < Veiculo > listaVeiculos = new LinkedList<Veiculo>();

	// Construtor
	 	//public Cliente (String nome , String endereco, Date dataLicenca , String educacao, String genero, String classeEconomica, List<Veiculo>listaVeiculos ) {
		 public Cliente (String nome , String endereco, Date dataLicenca , String educacao, String genero, String classeEconomica ) {
		 this.nome = nome;
		 this.endereco = endereco;
		 this.dataLicenca = dataLicenca;
		 this.educacao = educacao;
		 this.genero = genero;
		 this.classeEconomica = classeEconomica;
		// this.Id;
		 
	 }
		 //int id = 9999;
		 private void criarId(){
				
			 id++;
			// ID = ID + 1;
				//Random ID = new Random();   // declarar objeto random ID
				//this.id = ID;  // a id ira receber essa ID aleatoria de 6 digitos
				
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
	 public int getId(){
		 return id;
	 	}
	 
	 public void setId(int id) {
			this.id = id;
	 }
			
	 /*
	 // Id - remover depois
	 public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
*/

	 /*
	public List<Veiculo> getListaVeiculo(){
		return listaVeiculos;
		}
	public void adiciona(Veiculo veiculo) {
		this.listaVeiculos.add(veiculo);
	}
	*/
	
	@Override
	public String toString () {
		
		//return "Nome: " + this.nome + ", Endereço: " + this.endereco + ", Data da Licença: " + this.dataLicenca + ", Educação: " + this.educacao +  ", Gênero:  " + this.genero+ " , Classe Econômica:  " + this.classeEconomica+ "]\n";
		return "ID: " + this.id + "\n Nome: " + this.nome + "\n Endereço: " + this.endereco + "\n Data da Licença: " + this.dataLicenca + "\n Educação: " + this.educacao +  "\n Gênero:  " + this.genero+ "\n Classe Econômica:  " + this.classeEconomica+ "\n------------------\n";
		
		
		}
	/*
	public String toString () {
		String saida = "";
		saida += " Nome: " + this.nome + " , Endereço: " + this.endereco + " , Data da Licença: " + this.dataLicenca + " , Educação: " + this.educacao +  " , Gênero:  " + this.genero+ " , Classe Econômica:  " + this.classeEconomica+ "\n";
		return saida;
		}
	 */
  
	@Override
	public int compareTo(Cliente outroCliente) {
		return this.nome.compareTo(outroCliente.nome);
	}
	 }