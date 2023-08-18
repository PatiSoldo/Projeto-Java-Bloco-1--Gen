package loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras{
  private List<Produto> itens;
  

	
	public CarrinhoDeCompras() {
		itens = new ArrayList<>();
	}
	
	public void adicionarItem(Produto produto) {
		itens.add(produto);
	
	}
	public void mostrarCarrinho() {
		System.out.println("Itens no Carrinho:");
		for(Produto produto : itens) {
			System.out.println(produto.getNome() + " - R$" + produto.getPreco());
		}
	}

	public double calcularTotal() {
		double total = 0;
		for(Produto produto : itens) {
			total += produto.getPreco();
		}
		return total;
		
	}
	
}
