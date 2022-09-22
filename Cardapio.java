/*
 * Nome: Maria Luciana Almeida Pereira
 * Matrícula: 20211103020010
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cardapio {
	Map<String, Double> pizzas;
	
	public Cardapio () {
		pizzas = new HashMap<>();
	}
	
	public boolean cadastrarPizza(Pizza pizza) {
		boolean resultado = false;
		if(this.pizzas.put(pizza.getSabor(), pizza.getValor()) == null) {
			resultado = true;
		}
		return resultado;
	}
		
	public String listarPizzas() {
		String pizzas = "\nPizzas:";
		for (Entry<String, Double> entry : this.pizzas.entrySet()) {
			String sabor = (String) entry.getKey();
			
			pizzas += "\n - Pizza de "+sabor;
		}
		return pizzas;
	}
	
	public String exibirCardapio() {
		String cardapio = "\nCardápio:";
		for (Entry<String, Double> entry : this.pizzas.entrySet()) {
			String sabor = (String) entry.getKey();
			Double valor = (Double) entry.getValue();
			
			cardapio += "\n - Pizza de "+sabor+" - R$ "+valor;
		}
		return cardapio;
	}
	
	public boolean excluirPizza(String sabor) {
		boolean resultado = false;
		if(pizzas.remove(sabor) != null) {
			resultado = true;
		}
		return resultado;
	}
}
