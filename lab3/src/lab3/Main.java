package lab3;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Iterator;
import java.util.LinkedList;
//import java.util.List;
import java.text.*;


public class Main {
	public static void main(String[] args) {
	
		//SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
		//Date dataUsuario=sdf1.parse(stx);
		
		Date dataLicenca = new Date();
		Date dataFundacao = new Date();
		//int contadorId = 10000;
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		ArrayList<Veiculo> veiculosC1 = new ArrayList<Veiculo>();
			Veiculo carro1C1 = new Veiculo("QAA7811", "Toyota", "Etios", 2016);
			Veiculo carro2C1 = new Veiculo("CMG3164", "Chevrolet", "Corsa", 2003);
						
		ArrayList<Veiculo> veiculosC2 = new ArrayList<Veiculo>();
			Veiculo carro1C2 = new Veiculo("OTM2022", "Chevrolet", "Onix", 2020);
			veiculosC2.add(carro1C2);
			
		ArrayList<Veiculo> veiculosC3 = new ArrayList<Veiculo>();
			Veiculo carro1C3 = new Veiculo("DEF3930", "Fiat", "Uno", 2014);
			Veiculo carro2C3 = new Veiculo("DET7740", "Volkswagen", "Saveiro", 2012);
			Veiculo carro3C3 = new Veiculo("EGO7757", "Volkswagen", "Polo", 2019);
			veiculosC3.add(carro1C3);
			veiculosC3.add(carro2C3);
			veiculosC3.add(carro3C3);
			
			
		
		Cliente c1 = new ClientePJ("Fio a Fio", "Av Mato Grosso, Campo Grande-MS", dataLicenca, "Pós Graduação", "feminino", "6 salarios minimos", veiculosC1, "76.145.846/0001-81", dataFundacao);
		Cliente c2 = new ClientePF("Natália Vieira Lima", "Av 1 n°9", dataLicenca, "Superior incompleto", "Feminino", "3 salarios minimos", veiculosC2, "048.973.971-70", dataFundacao);
		Cliente c3 = new ClientePF("Luis Paulo", "Av 3 n°8", dataLicenca, "Superior incompleto", "Masculino", "5 salarios minimos", veiculosC3, "440.776.838-07", dataFundacao);
		Cliente c4 = new ClientePJ("Fio a Fio", "Av Mato Grosso, Campo Grande-MS", dataLicenca, "Pós Graduação", "feminino", "6 salarios minimos", veiculosC1, "76.145.846/0001-81", dataFundacao);
		
		
		c1.adicionaVeiculo(carro1C1);
		c1.adicionaVeiculo(carro2C1);
		c2.adicionaVeiculo(carro1C2);
		c3.adicionaVeiculo(carro1C3);
		c3.adicionaVeiculo(carro2C3);
		c3.adicionaVeiculo(carro3C3);
		
		Seguradora seg1 = new Seguradora("Porto Seguro", "(11) 99999-9999", "portoSeguros@email.br", "São Paulo-SP");
		
		seg1.cadastrarCliente(c1);
		
		boolean cadastro = seg1.cadastrarCliente(c4);
			if(cadastro = true) {
				System.out.println("Cliente cadastrado com sucesso!");
			} else {
				System.out.println("Cliente já cadastrado!");
			}
			System.out.println(seg1.getListaClientes());
			
		boolean remocao = seg1.removerCliente("048.973.971-70");
			if(remocao = true) {
				System.out.println("Cliente removido com sucesso!");
			} else {
				System.out.println("Não foi possível efetuar a remoção!");
			}
			
		//System.out.println(seg1.getListaClientes());
		
		/*
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		
	
		
		System.out.println("Lista contém " + lista.size() + " clientes");
		
		Iterator<Cliente> it = lista.iterator();
		Cliente c;
		System.out.println("Conteúdo:");
		while(it.hasNext()) {
			c = it.next();
			System.out.println("- " + c.toString());
		}
		*/
	}
		
		
	
	
}
