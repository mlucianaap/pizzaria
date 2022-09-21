public class Main {
	
	public static void main(String[] args) {
		
		Pizza pizza1 = new Pizza("Mussarela", 25);
		Pizza pizza2 = new Pizza("Calabreza", 20);
		Pizza pizza3 = new Pizza("Frango", 18);
		Pizza pizza4 = new Pizza("Frango", 17);
		
		Cardapio cardapio = new Cardapio();
		cardapio.cadastrarPizza(pizza1);
		cardapio.cadastrarPizza(pizza2);
		cardapio.cadastrarPizza(pizza3);
		
		cardapio.cadastrarPizza(pizza4);
		System.out.println(cardapio.listarPizzas());
		cardapio.excluirPizza(pizza3.getSabor());
		System.out.println(cardapio.exibirCardapio());
		
		Pedido pedido = new Pedido(cardapio);
		pedido.fazerPedido(pizza1.getSabor());
		pedido.fazerPedido(pizza1.getSabor());
		pedido.fazerPedido(pizza2.getSabor());
		System.out.println(pedido.encerrarPedido());
	}
}
