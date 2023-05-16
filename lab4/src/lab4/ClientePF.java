package lab4;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> working
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

// define essa classe como uma subclasse de Cliente (extends)
public class ClientePF extends Cliente {
 private final String cpf ;
 private Date dataNascimento ;
 private Date dataLicenca;
 private String educacao;
 private String genero;
 private String classeEconomica;

<<<<<<< HEAD
 public ClientePF ( String nome , String endereco,  List < Veiculo > listaVeiculos , String cpf , Date dataNascimento , Date dataLicenca , String educacao , String genero , String classeEconomica ) {
=======
 public ClientePF ( String nome , String endereco,  ArrayList < Veiculo > listaVeiculos , String cpf , Date dataNascimento , Date dataLicenca , String educacao , String genero , String classeEconomica ) {
>>>>>>> working
	 
 // chama o construtor da superclasse
 super ( nome , endereco ,  listaVeiculos  );
 this.cpf = cpf ;
 this.dataNascimento = dataNascimento ;
 this.dataLicenca = dataLicenca;
 this.educacao = educacao;
 this.genero = genero;
 this.classeEconomica = classeEconomica;
 }

 // get e set CPF e data de nascimento
 public  String getCpf() {
	 return cpf;
 	}

 public Date getDataNascimento() {
	 return dataNascimento;
 	}

 public void setDataNascimento(Date dataNascimento) {
	 this.dataNascimento = dataNascimento;
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
 
 
 
  public int calculaIdade(Date dataNascimento)throws ParseException {
	 	
	 	// Define a data de hoje numa variavel
		Date date = new Date(); 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		// Separa a data de nascimento em Dia, Mes e Ano:
	 	SimpleDateFormat y = new SimpleDateFormat("yyyy"); 
		SimpleDateFormat m = new SimpleDateFormat("MM"); 
		SimpleDateFormat d = new SimpleDateFormat("dd"); 	
		int nAno = Integer.parseInt( y.format(dataNascimento)); 
		int nMes = Integer.parseInt( m.format(dataNascimento)); 
		int nDia = Integer.parseInt( d.format(dataNascimento)); 
		
		// Define a data do dia de hoje separada em Dia, Mes e Ano:
		int ano = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH);
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		
		
		// Calcula a idade:
		int idade = 0;
		
		int idadeAno =  ano - nAno;
		int idadeDia = dia - nDia;
		int idadeMes = mes - nMes;
		
		/* Se o mes/dia do aniversario for maior que o data de hoje (subtração deu negativa) 
		*  entao a pessoa ainda nao fez aniversario
		*  logo a idade e' a diferenca de anos -1
		*/
		
		if ((idadeMes <= 0) || (idadeDia < 0)) { 
				idade = idadeAno - 1;
				
		}else {
			idade = idadeAno;
		}
		return idade;
 }
  
	 public double calculaScore() throws ParseException {
		 double score;
		 int quantidadeCarros = listaVeiculos.size();
		 int idade = calculaIdade(dataNascimento);
		 double fator_idade = 0;
		 
		 if ((idade >= 18) && (idade <= 30)){
			 fator_idade = CalcSeguro.FATOR_18_30.fator;
		 } else if((idade > 30) && (idade <= 60)) {
			 fator_idade = CalcSeguro.FATOR_30_60.fator;
		 } else if((idade > 60) && (idade <= 60)) {
			 fator_idade = CalcSeguro.FATOR_60_90.fator;
		 } else {
			 System.out.println("ERRO: Idade do cliente inválida\n");
		 }
		 
		score = (CalcSeguro.VALOR_BASE.fator)*fator_idade*quantidadeCarros;
		 
		 
		return score; 
	 }
 
 @Override
 public String toString () {
		String saida = "";
		saida += super.toString() 
			+ " Cpf: " + this.cpf +
			"\n Data de Nascimento: " + this.dataNascimento + 
			"\n Data da Licença: " + this.dataLicenca + 
			"\n Educação: " + this.educacao +  
			"\n Gênero:  " + this.genero+ 
			"\n Classe Econômica:  " + this.classeEconomica+
			"\n\n";
		return saida;
		}
 }
