package lab05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class Main {
	public static void main(String[] args) throws ParseException {
		// Listas a serem utilizadas para armazenar todo mundo cadastrado
				ArrayList<Cliente> listaClientesTotal = new ArrayList<Cliente>();
				ArrayList<Seguradora> listaSeguradoraTotal = new ArrayList<Seguradora>();
				ArrayList<Sinistro> listaSinistroTotal = new ArrayList<Sinistro>();
				ArrayList<Veiculo> listaVeiculoTotal = new ArrayList<Veiculo>();
				ArrayList<Condutor> listaCondutorTotal = new ArrayList<Condutor>();
				ArrayList<Seguro> listaSeguroTotal = new ArrayList<Seguro>();
				ArrayList<Frota> listaFrotaTotal = new ArrayList<Frota>();
				
		// ------------------------------------------------------------------------------------
				
		// Instanciar objetos de cada classe:
				
		// Declaracao das Datas no formato dd/MM/yyyy que serao usadas nos clientes e sinistro
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			
			String DSI = "08/02/2013";
			String DSF = "09/03/2014";
			Date dataSI = formato.parse(DSI);
			Date dataSF = formato.parse(DSF);
			
			String DF1 = "12/01/2002";
			String DF2 = "13/02/1993";
			String DF3 = "14/03/1994";
			String DF4 = "15/04/2015";
			
			Date dataN1 = formato.parse(DF1);
			Date dataN2 = formato.parse(DF2);
			Date dataN3 = formato.parse(DF3);
			Date dataN4 = formato.parse(DF4);
			
			
			String DS1 = "12/12/2022";
			String DS2 = "13/11/2023";
			String DS3 = "14/10/2021";
			String DS4 = "15/09/2020";			
			Date dataS1 = formato.parse(DS1);
			Date dataS2 = formato.parse(DS2);
			Date dataS3 = formato.parse(DS3);
			Date dataS4 = formato.parse(DS4);
		
						
		// Cadastro dos clientes (2 PJ's e 2 PF's)
			ClientePJ c1 = new ClientePJ("Fio a Fio", "(67) 99905-1115", "Av Mato Grosso, Campo Grande-MS", "fioafio@email.com", "76.145.846/0001-81", dataN1);
			ClientePF c2 = new ClientePF("Natália Vieira Lima", "(67) 99919-5348"," Avenida 1 n°9","natalia@email.com", "048.973.971-70",dataN2,  "Superior incompleto", "feminino");
			ClientePF c3 = new ClientePF("Luis Paulo","(11) 95306-1628" ,"Av 3 n°8", "luispaulo@email.com", "440.776.838-07", dataN3, "Superior incompleto", "Masculino");
			ClientePJ c4 = new ClientePJ("Clinica VS", "(67) 3222-3280", "Av Dom Aquino, Campo Grande-MS", "VS@email.com", "22 130 543 0001 66", dataN4);
		
		// Condutores
		
			Condutor cond1 = new Condutor("032.778.709-01", "Andre", "(19) 99999-8888", "Campinas-SP", "andre@email.com", dataS1);
			Condutor cond2 = new Condutor("645.322.423-20", "Paula", "(19) 99999-7777", "Itu-SP", "paula@email.com", dataS2);
			Condutor cond3 = new Condutor("518.225.438-51", "Guilherme", "(19) 99999-6666", "São Carlos-SP", "guilherme@email.com", dataS3);
			Condutor cond4 = new Condutor("401.637.345-00", "Heloisa", "(19) 99999-5555", "Sorocaba-SP", "heloisa@email.com", dataS4);
			
			ArrayList<Condutor> listaCondutor = new ArrayList<Condutor>();
				listaCondutor.add(cond1);
				listaCondutor.add(cond2);
				listaCondutor.add(cond3);
				listaCondutor.add(cond4);
			
		// Veiculo
			Veiculo carro1C1 = new Veiculo("QAA7811", "Toyota", "Etios", 2016);
			Veiculo carro2C1 = new Veiculo("CMG3164", "Chevrolet", "Corsa", 2003);
			Veiculo carro1C2 = new Veiculo("OTM2022", "Chevrolet", "Onix", 2020);
			Veiculo carro1C3 = new Veiculo("DEF3930", "Fiat", "Uno", 2014);
			Veiculo carro2C3 = new Veiculo("DET7740", "Volkswagen", "Saveiro", 2012);
			Veiculo carro1C4 = new Veiculo("EGO7757", "Volkswagen", "Polo", 2019);
			Veiculo carro2C4 = new Veiculo("NUI4876", "Toyota", "Corolla", 2014);
				
		
		// Frota
			Frota frota1 = new Frota("code 1");
			Frota frota4a = new Frota("code 4a");
			Frota frota4b = new Frota("code 4b");
			
		// adiciona carros para a lista das frotas
			frota1.adicionaVeiculo(carro1C1);
			frota1.adicionaVeiculo(carro2C1);
			frota4a.adicionaVeiculo(carro1C4);
			frota4b.adicionaVeiculo(carro2C4);
			c1.adicionaFrota(frota1);
			c4.adicionaFrota(frota4a);
			c4.adicionaFrota(frota4b);
		
		// Seguradora
			Seguradora seg1 = new Seguradora("03.818.375/0001-51", "Porto Seguro", "(11) 99999-9999", "portoSeguros@email.br", "São Paulo-SP");
			Seguradora seg2 = new Seguradora("03.818.375/0001-51", "Allianz", "(19) 98888-8888", "allianz@email.br", "Campinas-SP");
		
		// Seguro (PF e PJ)
			seg1.gerarSeguro(dataSI, dataSF, carro1C2, c2); 
			seg1.gerarSeguro(dataSI, dataSF, frota1, c1);
			seg2.gerarSeguro(dataSI, dataSF, frota4a, c4);
			seg2.gerarSeguro(dataSI,dataSF, carro1C2, c3);
			
		// Os seguros ja foram instanciados, aqui so serao atribuidos nomes conforme a posicao na lista:
			SeguroPF seguroPFSeg1 = ((SeguroPF)seg1.getListaSeguro().get(0));
			SeguroPJ seguroPJSeg1 = ((SeguroPJ)seg1.getListaSeguro().get(1));
			SeguroPF seguroPFSeg2 = ((SeguroPF)seg2.getListaSeguro().get(1));
			SeguroPJ seguroPJSeg2 = ((SeguroPJ)seg2.getListaSeguro().get(0));
			
			SeguroPF SeguroPF2Seg1 = new SeguroPF(dataSI, dataSF,seg1, carro1C1, c2);
			seg1.adicionaSeguro(SeguroPF2Seg1);
			
			seguroPFSeg1.setListaCondutores(listaCondutor);
			seguroPJSeg1.setListaCondutores(listaCondutor);
			seguroPFSeg2.setListaCondutores(listaCondutor);
			seguroPJSeg2.setListaCondutores(listaCondutor);
			
		// Instancia sinistro pelo seguro
			seguroPFSeg1.gerarSinistro(dataS1, "Campo Grande", cond1);
			seguroPJSeg1.gerarSinistro(dataS2, "Campo Largo", cond2);
			seguroPFSeg2.gerarSinistro(dataS3, "São Paulo", cond3);
			seguroPJSeg2.gerarSinistro(dataS4, "Campinas", cond4);
		
		// Atribui nome ao sinistro pela posicao da lista do seguro
			Sinistro s1 = ((Sinistro)seguroPFSeg1.getListaSinistro().get(0));
			Sinistro s2 = ((Sinistro)seguroPJSeg1.getListaSinistro().get(0));
			Sinistro s3 = ((Sinistro)seguroPFSeg2.getListaSinistro().get(0));
			Sinistro s4 = ((Sinistro)seguroPJSeg2.getListaSinistro().get(0));
		
		
		// Adicionar os veiculos aos clientes 2 e 3 e frota aos clientes 1 e 4
			c1.adicionaFrota(frota1);
			c2.adicionaVeiculo(carro1C2);
			c3.adicionaVeiculo(carro1C3);
			c3.adicionaVeiculo(carro2C3);
			c4.adicionaFrota(frota4a);
			c4.adicionaFrota(frota4b);
		
		// ------------------------------------------------------------------------------------
			
		// Metodos Seguradora
		
		// Adiciona os clientes
			seg1.cadastrarCliente(c1);
			seg1.cadastrarCliente(c2);
			seg2.cadastrarCliente(c3);
			seg2.cadastrarCliente(c4);
		
		// Remover cliente
			seg2.removerCliente("22 130 543 0001 66"); // remove cliente c4 da lista do seg2
			System.out.println("LISTA DE CLIENTES DA SEGURADORA 2 \n)");
			System.out.println(seg2.getListaClientes()); // imprime a lista com os clientes 1, 2 e 3
			seg2.cadastrarCliente(c4); // adicionei novamente o cliente 4
			
		// listar clientes pelo tipo dele (PF ou PJ)
			System.out.println("LISTA DE CLIENTES PF DA SEGURADORA 1 \n)");
			System.out.println(seg1.listarClientes("PF") + "\n"); // listar clientes PF
			
			System.out.println("LISTA DE CLIENTES PJ DA SEGURADORA 1 \n)");
			System.out.println(seg1.listarClientes("PJ") + "\n"); // listar clientes PJ
			
			
		// Cancela seguro
			seg1.cancelaSeguro(SeguroPF2Seg1); // remove o segundo seguro da seguradora
			System.out.println("LISTA DE SEGUROS DA SEGURADORA 1 DEPOIS DE \"SeguroPF2Seg1\" FOI REMOVIDO\n)");
			System.out.println(seg1.getListaSeguro() + "\n");
			
		// Seleciona seguros de um cliente
			System.out.println("LISTA DE SEGUROS DA CLIENTE 2\n)");
			System.out.println(seg1.getSegurosPorCliente("Natália Vieira Lima") + "\n");
			
		//	Visualizar sinistros
			System.out.println("VISUALIZAR SINISTRO 2\n)");
			seg1.visualizarSinistro(s2.getId());
			
		// Listar sinistros de um cliente
			System.out.println("LISTA DE SEGUROS DA CLIENTE 2\n)");
			System.out.println(seg1.getSegurosPorCliente("Natália Vieira Lima") + "\n");
			
		// --------------------------------------------------------------------------------------
		
		// toString de 1 objeto de cada classe
		System.out.println("Imprimindo o toString de cada classe (1 exemplo cada): \n");
			System.out.println("Cliente PJ:\n" + c1.toString()); 			 // Cliente PJ
			System.out.println("Cliente PF:\n" +c2.toString()); 			 // Cliente PF
			System.out.println("Condutor:\n" +cond1.toString());		 // condutor
			System.out.println("Veiculo:\n" +carro1C1.toString()); 	 // Veiculo
			System.out.println("Frota:\n" +frota1.toString()); 		 // Frota
			System.out.println(seg1.toString()); 		 // Seguradora
			System.out.println(seguroPFSeg1.toString()); // Seguro PF
			System.out.println(seguroPJSeg1.toString()); // Seguro PJ
			System.out.println(s1.toString()); 			 // Sinistro
			
		// --------------------------------------------------------------------------------------
			
		// Listar
		
		
			
			
		
		// ------------------------------------------------------------------------------------
			
		// Menu de operacoes
	}
}
