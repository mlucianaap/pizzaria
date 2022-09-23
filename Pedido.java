/*
 * Nome: Maria Luciana Almeida Pereira
 * Matrícula: 20211103020010
 * */

import java.util.ArrayList;
import java.util.Map.Entry;

public class Pedido {
	private double total;
	private ArrayList<Pizza> pedidos;
	private Cardapio cardapio;
	
	public Pedido(Cardapio cardapio) {
		this.total = 0;
		this.pedidos = new ArrayList<Pizza>();
		this.cardapio = cardapio;
	}

	public boolean fazerPedido(String saborPizza) {
		boolean resultado = false;
		for (Entry<String, Double> entry : cardapio.pizzas.entrySet()) {
			String sabor = (String) entry.getKey();
			Double valor = (Double) entry.getValue();
			
			if(sabor.toLowerCase().equals(saborPizza.toLowerCase())) {
				Pizza pizza = new Pizza(sabor, valor);
				pedidos.add(pizza);
				resultado = true;
			}
		}
		return resultado;
	}
	
	public double calcularValorTotal(){
		for (int i = 0; i < this.pedidos.size(); i++) {
			total += this.pedidos.get(i).getValor();
		}
		return total;
	}
	
	public String encerrarPedido() {
		String pedidos = "\nPedido encerrado com sucesso!\n\nPedido:";
		for (int i = 0; i < this.pedidos.size(); i++) {
			Pizza pizza = this.pedidos.get(i);
			pedidos += "\n - Pizza de "+pizza.getSabor()+" - R$ "+pizza.getValor();
		}
		pedidos += "\nValor total: R$ "+calcularValorTotal();
		total = 0;
		this.pedidos.clear();
		return pedidos;
	}
}
