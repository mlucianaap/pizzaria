/*
 * Nome: Maria Luciana Almeida Pereira
 * Matrícula: 20211103020010
 * */

public class Main {
	
	public static void main(String[] args) {
		
		Pizza pizza1 = new Pizza("Mussarela", 25);
		Pizza pizza2 = new Pizza("Calabreza", 20);
		Pizza pizza3 = new Pizza("Frango", 18);
		Pizza pizza4 = new Pizza("Frango", 17);
		
		Cardapio cardapio = new Cardapio();
		System.out.println(cardapio.cadastrarPizza(pizza1)); 
		System.out.println(cardapio.cadastrarPizza(pizza2)); 
		System.out.println(cardapio.cadastrarPizza(pizza3)); 
		System.out.println(cardapio.cadastrarPizza(pizza4)); 
		
		System.out.println(cardapio.listarPizzas());
		System.out.println(cardapio.excluirPizza(pizza3.getSabor()));
		System.out.println(cardapio.exibirCardapio());
		
		Pedido pedido = new Pedido(cardapio);
		pedido.fazerPedido(pizza1.getSabor());
		pedido.fazerPedido(pizza1.getSabor());
		pedido.fazerPedido(pizza2.getSabor());
		System.out.println(pedido.encerrarPedido());
		
		pedido.fazerPedido(pizza1.getSabor());
		System.out.println(pedido.encerrarPedido());
	}
}
