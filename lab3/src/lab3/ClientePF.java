package lab3;
import java.util.Date;
import java.util.List;
import java.util.LinkedList;

// define essa classe como uma subclasse de Cliente (extends)
public class ClientePF extends Cliente {
 private String cpf ;
 private Date dataNascimento ;

 public ClientePF ( String nome , String endereco , Date dataLicenca , String educacao , String genero , String classeEconomica ,
 List < Veiculo > listaVeiculos , String cpf , Date dataNascimento ) {
	 
 // chama o construtor da superclasse
 super ( nome , endereco , dataLicenca , educacao , genero , classeEconomica);
 //super ( nome , endereco , dataLicenca , educacao , genero , classeEconomica , listaVeiculos );
 this.cpf = cpf ;
 this .dataNascimento = dataNascimento ;
 }

 // get e set CPF e data de nascimento
 public String getCpf() {
	 return cpf;
 	}

 public void setCpf(String cpf) {
	 this.cpf = cpf;
 	}

 public Date getDataNascimento() {
	 return dataNascimento;
 	}

 public void setDataNascimento(Date dataNascimento) {
	 this.dataNascimento = dataNascimento;
 	}
  
 
 public static boolean validarCpf(String cpf) {  // vai retornar verdadeiro ou falso pro cpf
		// tira tudo que nao for numero 
			cpf = cpf.replaceAll("[^0-9]+", ""); 
			
			// transforma em um vetor de int
			char[] arrayCpf = cpf.toCharArray();        // pega a string e escreve como array
			int[] cpfInt = new int[arrayCpf.length];                 // declara um vetor de int no tamanho do cpf so' numeros
			
			for (int i = 0; i < arrayCpf.length; i++) {
				cpfInt[i] = Integer.parseInt(cpf.substring(i, i+1));  // adiciona numero por numero convertido no vetor de int
			}
			
			// Verifica se tem 11 digitos
			if(cpfInt.length != 11) {
				 return false;
			}
			
			// Verifica se os digitos sao iguais
			int soma = 0;
			for (int i = 1; i < 11; i++) {
				if(cpfInt[0] == cpfInt[i]) {
					soma = soma + 1;
				}
			} 
			
			if(soma == 10) {   // se todos forem iguais a soma da 10 entao ele retorna que o cpf nao e' valido (falso)
				return false;
				}

			int d1 = 0;
			int d2 = 0;     // digitos verificadores 		
			// Verifica os digitos verificadores
			for(int x = 0; x<2; x++){
				int j = 10;
				int soma2 = 0;
				int r1 = 0;
				int r2 = 0;     // resto da divisao
				

				for(int i=0+x; i < 9+x; i++){			// aplicacao da formula padrao do cpf
					soma2 = soma2 +(j * cpfInt[i]);
					j--;
				}
				
				if(x == 0) {		
					r1 = soma2 % 11;
					if((r1 == 0) || (r1 == 1)){
						d1 = 0;
					}
					else {
						d1 = 11 - r1;
					}
				}
				if(x == 1) {		
					r2 = soma2 % 11;
					if((r2 == 0) || (r2 == 1)){
						d2 = 0;
					}
					else {
						d2 = 11 - r2;
					}
				}		
			
			}
	 
			if((d1 == cpfInt[9]) && (d2 == cpfInt[10])) {        // se d1 = a penultima posicao do CPF = True
				 return true;
			} 
			else {
				return false;
			}
			
	 
	 	}
 
 @Override
 public String toString () {
		String saida = "";
		saida += " Cpf: " + this.cpf + " \n Data de Nascimento: " + this.dataNascimento + "\n";
		return saida;
		}
 }
