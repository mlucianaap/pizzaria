/*
 * Nome: Maria Luciana Almeida Pereira
 * Matrícula: 20211103020010
 * */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testes {
	
	@Test
	void testarCadastroDePizza() {
		String sabor = "Mussarela";
		double valor = 20.0;
		Cardapio cardapio = new Cardapio();
		
		boolean resultado = cardapio.cadastrarPizza(new Pizza(sabor, valor));
		
		assertEquals(true, resultado);
	}
	
	@Test
	void testarSeConsegueCadastrarDuasPizzasIguais() {
		String sabor = "Mussarela";
		double valor = 20.0;
		Cardapio cardapio = new Cardapio();
		
		boolean resultado1 = cardapio.cadastrarPizza(new Pizza(sabor, valor));
		boolean resultado2 = cardapio.cadastrarPizza(new Pizza(sabor, valor));
		
		assertEquals(true, resultado1);
		assertEquals(false, resultado2);
	}
	
	@Test
	void testarListarTodasAsPizzas() {
		String sabor1 = "Mussarela";
		double valor1 = 20.0;
		String sabor2 = "Calabreza";
		double valor2 = 18.0;
		Cardapio cardapio = new Cardapio();
		cardapio.cadastrarPizza(new Pizza(sabor1, valor1));
		cardapio.cadastrarPizza(new Pizza(sabor2, valor2));
		
		String resultado = cardapio.listarPizzas();
		
		assertEquals("\nPizzas:"
				+ "\n - Pizza de Mussarela"
				+ "\n - Pizza de Calabreza", resultado);
	}
	
	@Test
	void testarExibirCardapio() {
		String sabor1 = "Mussarela";
		double valor1 = 20.0;
		String sabor2 = "Calabreza";
		double valor2 = 18.0;
		Cardapio cardapio = new Cardapio();
		cardapio.cadastrarPizza(new Pizza(sabor1, valor1));
		cardapio.cadastrarPizza(new Pizza(sabor2, valor2));
		
		String resultado = cardapio.exibirCardapio();
		
		assertEquals("\nCardápio:"
				+ "\n - Pizza de Mussarela - R$ 20.0"
				+ "\n - Pizza de Calabreza - R$ 18.0", resultado);
	}

	@Test
	void testarExcluiPizzaDoCardapio() {
		String sabor = "Mussarela";
		double valor = 20.0;
		Cardapio cardapio = new Cardapio();
		cardapio.cadastrarPizza(new Pizza(sabor, valor));
		
		boolean resultado = cardapio.excluirPizza(sabor);
		
		assertEquals(true, resultado);
	}
	
	@Test
	void testarFazerPedido() {
		String sabor = "Mussarela";
		double valor = 20.0;
		Cardapio cardapio = new Cardapio();
		cardapio.cadastrarPizza(new Pizza(sabor, valor));
		Pedido pedido = new Pedido(cardapio);
		
		boolean resultado = pedido.fazerPedido(sabor);
		
		assertEquals(true, resultado);
	}
	
	@Test
	void testarPedirUmaPizzaMaisDeUmaVez() {
		String sabor = "Mussarela";
		double valor = 20.0;
		Cardapio cardapio = new Cardapio();
		cardapio.cadastrarPizza(new Pizza(sabor, valor));
		Pedido pedido = new Pedido(cardapio);
		
		boolean resultado1 = pedido.fazerPedido(sabor);
		boolean resultado2 = pedido.fazerPedido("mussarela");
		boolean resultado3 = pedido.fazerPedido("MUSSARELA");
		
		assertEquals(true, resultado1);
		assertEquals(true, resultado2);
		assertEquals(true, resultado3);
	}
	
	@Test
	void testarCalcularValorTotalPedido() {
		String sabor = "Mussarela";
		double valor = 20.0;
		Cardapio cardapio = new Cardapio();
		cardapio.cadastrarPizza(new Pizza(sabor, valor));
		Pedido pedido = new Pedido(cardapio);
		pedido.fazerPedido(sabor);
		pedido.fazerPedido("mussarela");
		pedido.fazerPedido("MUSSARELA");
		
		double resultado = pedido.calcularValorTotal();
		
		assertEquals(60.0, resultado);
	}
	
	@Test
	void testarEncerrarPedido() {
		String sabor = "Mussarela";
		double valor = 20.0;
		Cardapio cardapio = new Cardapio();
		cardapio.cadastrarPizza(new Pizza(sabor, valor));
		Pedido pedido = new Pedido(cardapio);
		pedido.fazerPedido(sabor);
		pedido.fazerPedido("mussarela");
		pedido.fazerPedido("MUSSARELA");
		
		String resultado = pedido.encerrarPedido();
		
		assertEquals("\nPedidos:"
				+ "\n - Pizza de Mussarela - R$ 20.0"
				+ "\n - Pizza de Mussarela - R$ 20.0"
				+ "\n - Pizza de Mussarela - R$ 20.0"
				+ "\nValor total: R$ 60.0", resultado);
	}
	
	@Test
	void testarBuscarNomeDaPizza() {
		String sabor = "Mussarela";
		double valor = 20.0;
		Pizza pizza = new Pizza(sabor, valor);
		
		String resultado = pizza.getSabor();
		
		assertEquals("Mussarela", resultado);
	}
	
	@Test
	void testarBuscarValorDaPizza() {
		String sabor = "Mussarela";
		double valor = 20.0;
		Pizza pizza = new Pizza(sabor, valor);
		
		double resultado = pizza.getValor();
		
		assertEquals(20.0, resultado);
	}
}
