package lab2;

import java.util.Scanner;
import java.util.List;

public class main {
	public static void main(String[] args) {
	
	// Declarar variaveis a serem usadas no cadastro e na selecao do Menu
		
		int opcao = 0;  // sera a opcao que o usuario ira selecionar no menu
		
		String nomeCliente;
		String cpfCliente;
		String dataNascimentoCliente;
		int idadeCliente;
		String enderecoCliente;
		
		String nomeSeguradora;
		String telefoneSeguradora;
		String emailSeguradora;
		String enderecoSeguradora;
		 
		String placaVeiculo;
		String marcaVeiculo;
		String modeloVeiculo;

		int idSinistro;
		String dataSinistro;
		String enderecoSinistro;
		
		String cpfValidar;
		boolean validacao;
		
		Scanner usuario = new Scanner(System.in);  // informa que o usuario ira digitar e a biblioteca scanner ira pegando suas entradas

		
		
		do { 
		// Menu para Cadastro
			System.out.println("--------------------------");
			System.out.println("Digite para cadastrar:");
			System.out.println("Cliente: 1 ");
			System.out.println("Veículo: 2 ");
			System.out.println("Seguradora: 3 ");
			System.out.println("Acionamento de Seguro: 4 ");  // Sinistro
			System.out.println("--------------------------");
			System.out.println("Digite para Validar CPF: 5 ");
			System.out.println("Digite para Sair: 6 ");
			System.out.println("--------------------------");
			System.out.println("\n");
		
		// Selecao do usuario
			System.out.println("Opção selecionada: ");
			opcao = usuario.nextInt();
			usuario.nextLine();// limpa o scanner
			
			switch(opcao) {
				case 1:   // Cadastro de Cliente
					
					System.out.println("Digite o nome do cliente: ");
					nomeCliente = usuario.nextLine();   // Recebe o que o usuario digitou e insere na variavel respectiva
					
					System.out.println("Digite o CPF do cliente: ");
					cpfCliente = usuario.nextLine();
					
					System.out.println("Digite a data de nascimento do cliente: ");
					dataNascimentoCliente = usuario.nextLine();
					
					System.out.println("Digite a idade do cliente: ");
					idadeCliente = usuario.nextInt();
					usuario.nextLine();// limpa o scanner
					
					System.out.println("Digite o endereço do cliente: ");
					enderecoCliente = usuario.nextLine();
					
					System.out.println("\nDados cadastrados do cliente: \n");
					Cliente c1 = new Cliente(nomeCliente, cpfCliente, dataNascimentoCliente, idadeCliente, enderecoCliente);  // coloca todas as variaveis que o usuario digitou e manda para a classe 
					System.out.println(c1.toString()); // chama a funcao de printar os dados da classe para mostrar o que foi inserido
					break;
				
				case 2:   // Cadastro de Veiculo
					System.out.println("Digite a placa do Veiculo: ");
					placaVeiculo = usuario.nextLine();
					
					System.out.println("Digite a marca do Veiculo: ");
					marcaVeiculo = usuario.nextLine();
					
					System.out.println("Digite o modelo do Veiculo: ");
					modeloVeiculo = usuario.nextLine();
					
					System.out.println("\nDados cadastrados do Veiculo: \n");
					Veiculo v1 = new Veiculo(placaVeiculo,marcaVeiculo, modeloVeiculo);
					System.out.println(v1.toString());
					break;
					
				case 3:   // Cadastro de Seguro
					System.out.println("Digite o nome da Seguradora: ");
					nomeSeguradora = usuario.nextLine();
					
					System.out.println("Digite o telefone da Seguradora: ");
					telefoneSeguradora = usuario.nextLine();
					
					System.out.println("Digite o email da Seguradora: ");
					emailSeguradora = usuario.nextLine();
					
					System.out.println("Digite o endereço da Seguradora: ");
					enderecoSeguradora = usuario.nextLine();
					
					System.out.println("\nDados cadastrados da Seguradora: \n");
					Seguradora seg1 = new Seguradora(nomeSeguradora , telefoneSeguradora, emailSeguradora ,enderecoSeguradora);
					System.out.println(seg1.toString());
					break;
					
				case 4:   // Cadastro de Sinistro
										
					System.out.println("Digite a data do ocorrido: ");
					dataSinistro = usuario.nextLine();
					
					System.out.println("Digite o endereço do ocorrido: ");
					enderecoSinistro = usuario.nextLine();
					
					System.out.println("\nDados cadastrados do Veiculo: \n");
					Sinistro s1 = new Sinistro(dataSinistro,enderecoSinistro); // vai printar a ID gerada no sinistro
					System.out.println(s1.toString());
					break;
					
				case 5:   // validar cpf
					System.out.println("Digite o CPF do cliente: ");
					cpfCliente = usuario.nextLine();
					validacao = Cliente.validarCpf(cpfCliente);
					
					if(validacao == false) {
						System.out.println("CPF inválido!\n");
					}
					if(validacao == true) {
						System.out.println("CPF válido! \n");
					}
					break;
					
				case 6:   // Sair
					break;
					
			}
		} while (opcao != 6);
		
	}	
}
