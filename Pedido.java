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

	public void fazerPedido(String saborPizza) {
		for (Entry<String, Double> entry : cardapio.pizzas.entrySet()) {
			String sabor = (String) entry.getKey();
			Double valor = (Double) entry.getValue();
			
			if(sabor.equals(saborPizza)) {
				Pizza pizza = new Pizza(sabor, valor);
				pedidos.add(pizza);
			}
		}
	}
	
	public String encerrarPedido() {
		String pedidos = "\nPedidos:";
		for (int i = 0; i < this.pedidos.size(); i++) {
			Pizza pizza = this.pedidos.get(i);
			pedidos += "\n - Pizza de "+pizza.getSabor()+" - R$ "+pizza.getValor();
			total += pizza.getValor();
		}
		pedidos += "\nValor total: R$ "+total;
		return pedidos;
	}
}
