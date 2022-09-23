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
	
	public String cadastrarPizza(Pizza pizza) {
		String resultado;
		if(pizza.getValor() >= 10 && pizza.getValor() <= 1000) {
			if(this.pizzas.put(pizza.getSabor(), pizza.getValor()) == null) {
				resultado = "Pizza cadastrada com sucesso!";
			} else {
				resultado = "Pizza já cadastrada!";
			}
		} else {
			resultado = "Valor da pizza inválido!";
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
	
	public String excluirPizza(String sabor) {
		String resultado;
		if(pizzas.remove(sabor) != null) {
			resultado = "Pizza de "+sabor+" excluída com sucesso!";
		} else {
			resultado = "Sabor da pizza inválido!";
		}
		return resultado;
	}
}
