package lab05;


public class Validacao {
	
		public static boolean validarCpf(String cpf) {  
		 	
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
					System.out.println(" é inválido!\n"); 
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
					System.out.println(" é inválido!\n");
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
					System.out.println(" é válido!\n"); 
					return true;
				} 
				else {
					System.out.println(" é inválido!\n"); 
					return false;
				}
				
		 
		 	}
		
		public static boolean validarCnpj(String cnpj) {  // vai retornar verdadeiro ou falso pro cpf
			 
			// tira tudo que nao for numero 
				cnpj = cnpj.replaceAll("[^0-9]+", ""); 
				
				// transforma em um vetor de int
				char[] arrayCnpj = cnpj.toCharArray();        // pega a string e escreve como array
				int[] cnpjInt = new int[arrayCnpj.length];                 // declara um vetor de int no tamanho do cnpj so' numeros
				
				for (int i = 0; i < arrayCnpj.length; i++) {
					cnpjInt[i] = Integer.parseInt(cnpj.substring(i, i+1));  // adiciona numero por numero convertido no vetor de int
				}
				
				// Verifica se tem 14 digitos
				if(cnpjInt.length != 14) {
					System.out.println(" é inválido!\n"); 
					return false;
				}
				
				// Verifica se os digitos sao iguais
				int soma = 0;
				for (int i = 1; i < 14; i++) {
					if(cnpjInt[0] == cnpjInt[i]) {
						soma = soma + 1;
					}
				} 
				
				if(soma == 10) {   // se todos forem iguais a soma da 10 entao ele retorna que o cpf nao e' valido (falso)
					System.out.println(" é inválido!\n");
					return false;
					}

				int d1 = 0;
				int d2 = 0;     // digitos verificadores 		
				// Verifica os digitos verificadores
				for(int x = 0; x<2; x++){
					int j1[] = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
					int j2[] = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
					int soma2 = 0;
					int soma3 = 0;
					int r1 = 0;
					int r2 = 0;     // resto da divisao
					

					if(x == 0) {
						for(int i=0; i < 12; i++){			// aplicacao da formula padrao do CNPJ
							soma2 = soma2 +(j1[i] * cnpjInt[i]);
						}
						
						r1 = soma2 % 11;
						if(r1 < 2){
							d1 = 0;
						}
						else {
							d1 = 11 - r1;
						}
					}
					if(x == 1) {
						for(int i=0; i < 13; i++){			
							soma3 = soma3 +(j2[i] * cnpjInt[i]);
						}
						
						r2 = soma3 % 11;
						if(r2 < 2){
							d2 = 0;
						}
						else {
							d2 = 11 - r2;
						}
					}		
				}
		 
				if((d1 == cnpjInt[12]) && (d2 == cnpjInt[13])) {        // se d1 = a penultima posicao do CNPJ = True
					System.out.println(" é válido!\n"); 
					return true;
				} 
				else {
					System.out.println(" é inválido!\n");
					return false;
				}
				
	 	}
		public static boolean validarNome(String nome) {  
			if(nome.matches("[A-Z]*")) {
				return true;
			}
			else {
				return false;
			}
		}

		
}


