package lab3;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Iterator;
import java.util.LinkedList;
//import java.util.List;


public class Main {
	public static void main(String[] args) {
		Date dataLicenca = new Date();
		int contadorId = 10000;
		List<Cliente> lista = new LinkedList<Cliente>();
		
		/* 10002 */ Cliente c1 = new Cliente("João", "Av 2 n°878", dataLicenca, "ensino fundamental", "masculino", "3 salarios minimos");
		/* 10001 */ Cliente c2 = new Cliente("Nati", "Av 1 n°9", dataLicenca, "ensino sup", "F", "5 salarios minimos");
		/* 10000 */ Cliente c3 = new Cliente("Lu", "Av 3 n°8", dataLicenca, "ensino mediol", "masculino", "9 salarios minimos");
		
		// Atribui um Id e depois manda pra classe
		c3.id = contadorId++;
		c2.id = contadorId++;
		c1.id = contadorId++;
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		
		Collections.sort(lista, Comparator.comparing(Cliente:: getId)); // ordena a lista a partir do Id do cliente
		System.out.println("Lista contém " + lista.size() + " clientes");
		
		/*
		Iterator<Cliente> it = lista.iterator();
		Cliente p;
		System.out.println("Conteúdo:");
		while(it.hasNext()) {
			p = it.next();
			System.out.println("- " + p.toString());
		}
		*/
		System.out.println(lista);
		
		
		
	}
}