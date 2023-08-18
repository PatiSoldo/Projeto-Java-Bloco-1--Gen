package loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import loja.util.Cores;

public class LojaVirtual {
	
	private List<Produto>produtos;
	private List<Cliente> clientes;
	 
	
	public LojaVirtual() {
		produtos = new ArrayList<>();
		clientes = new ArrayList<>();
	}
	
	
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int opcao;
		
		LojaVirtual loja = new LojaVirtual();
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		//Adicionar produtos à loja
		loja.adicionarProduto(new Produto("Camisa", "Camisa estilizada Fusca 1965", 39.95));
		loja.adicionarProduto(new Produto("Boné", "Boné de com estampa", 24.99));
		loja.adicionarProduto(new Produto("Caneca ", "Caneca Fusca Herbie", 29.89));
		loja.adicionarProduto(new Produto("Chaveiro", "Chaveiro Fusca Preto", 12.89));
		loja.adicionarProduto(new Produto("Moletom", "Moletom Fusca Rosa", 79.99));
		loja.adicionarProduto(new Produto("Ímã Geladeira", "Ímã Geladeira Fusca Vários Modelos", 8.25));
		loja.adicionarProduto(new Produto("Quadro", "Quadro Fusca na Estrada", 46.99));
			
		
		do {
			System.out.println(Cores.TEXT_BLUE_BOLD+Cores.ANSI_BLACK_BACKGROUND+
					           "                                                                                                 ");								
			System.out.println("	  	                                                                                         ");
			System.out.println("	  	                                                                                         ");		
            System.out.println("                  ╔═╗┬ ┬┌─┐┌─┐┌─┐  ╦═╗┌─┐┌┬┐┬─┐┌─┐  ╔═╗┌┬┐┌─┐┬─┐┌─┐                              ");
            System.out.println("                  ╠╣ │ │└─┐│  ├─┤  ╠╦╝├┤  │ ├┬┘│ │  ╚═╗ │ │ │├┬┘├┤                               ");
            System.out.println("                  ╚  └─┘└─┘└─┘┴ ┴  ╩╚═└─┘ ┴ ┴└─└─┘  ╚═╝ ┴ └─┘┴└─└─┘                              ");			                                                                                             
			System.out.println(Cores.TEXT_PURPLE_BOLD+"                      A LOJA PARA QUEM É APAIXONADO POR FUSCAS                                   ");
			System.out.println("                                                                                                 ");
			System.out.println("                                                                                                 ");
			System.out.println("                                                                                                 ");
			System.out.println(Cores.TEXT_WHITE_BOLD+
					           "*************************************************************************************************");
			System.out.println("                                                                                                 ");
			System.out.println("                           1 - Criar Conta                                                       ");
			System.out.println("                           2 - Produtos                                                          ");
			System.out.println("                           3 - Sobre nós                                                         ");
			System.out.println("                           4 - Carrinho de compras                                               ");
			System.out.println("                           5- Finalizar compra                                                   ");
			System.out.println("                           6 - Sair                                                              ");
			System.out.println("                                                                                                 ");
			System.out.println("                                                                                                 ");
			System.out.println("                                                                                                 ");
			System.out.println("*************************************************************************************************");
			System.out.println("Entre com a opção desejada:                                                                      ");
			System.out.println("                                                                                                 "+Cores.TEXT_RESET);
			
			opcao = leia.nextInt();
			
			switch (opcao) {
			
			case 1 : 
				loja.criarConta();
				
				break;
			case 2 :
				loja.mostrarProdutos();
				System.out.println("Escolha o número do produto para adicionar ao carrinho ou  0 para voltar: ");
				int escolhaProduto = leia.nextInt();
				if(escolhaProduto > 0 && escolhaProduto <= loja.produtos.size()) {
				   carrinho.adicionarItem(loja.produtos.get(escolhaProduto - 1));
				   System.out.println("Produto adicionado ao carrinho.");
				}
				
				break;
			case 3:
				loja.mostrarSobreNos();
				
				break;
			case 4 : 
				carrinho.mostrarCarrinho();
				
				break;
			case 5 : 
				double total = carrinho.calcularTotal();
				System.out.println("Valor total da compra: R$ " + total);
				carrinho = new CarrinhoDeCompras();
				
				
				break;
			case 6 : 
				loja.encerrar();
				System.out.println("Obrigado por visitar nossa loja. Volte sempre que quiser!!");
				
				break;
			
			default:
				System.out.println("Opss...Opção Inválida! Tente novamente por favor.");
			}
		}while (opcao !=6);
		
		leia.close();
		

	}
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void mostrarProdutos() {
		System.out.println("Produtos Disponíveis: ");
		int indice = 1;
		for(Produto produto : produtos) {
			System.out.println(indice + ". " + produto.getNome()+ " - " + produto.getDescricao() + " - R$" +produto.getPreco());
			indice++;
		}
	}
	
	public void criarConta() {
		Scanner leia = new Scanner(System.in);
		System.out.println("Digite o nome do cliente: ");
		String nome = leia.nextLine();
		System.out.println("Digite o email do cliente: ");
		String email = leia.nextLine();
		System.out.println("Digite a senha do cliente: ");
		String senha = leia.nextLine();
		
		Cliente novoCliente = new Cliente(nome, email, senha);
		clientes.add(novoCliente);
		
		System.out.println("Conta criada com sucesso!");
			
	}
	
	public void mostrarSobreNos() {
		System.out.println("Sobre Nós:");
		System.out.println("\nBem-vindo à nossa loja dedicada aos amantes de Fuscas! ");
		System.out.println("\nA paixão por fuscas começou  há mais de 20 anos,quando meu pai adquiriu seu primeiro Fusca."
				+ "\nAs lembranças e emoções dos momentos compartilhados dentro daquele carro, permanecem vivas em minha mente."
				+ "\nNossa loja é mais que um lugar para comprar produtos relacionados a Fuscas- é uma homenagem à história automotiva."
				+ "\nJunte-se a nós para manter viva a história dos Fuscas. Seja parte dessa jornada emocionante enquanto exploramos a nostalgia"
				+ "\ne a magia que esses carros trazem às nossas vidas.\n");
	}
	
	public void encerrar() {
		System.out.println("Obrigado por visitar nossa loja. Volte sempre que quiser!!");
		System.exit(0);
	}
	
	public void mostrarHistoricoCompras(Cliente cliente) {
		List<CarrinhoDeCompras> historicoCompras = cliente.getHistoricoCompras();
		
		System.out.println("Histórico de comprar para " + cliente.getNome() + ":");
		for(int i = 0; i < historicoCompras.size(); i++) {
			System.out.println("Compra #" + (i+1) + ":");
			historicoCompras.get(i).mostrarCarrinho();
			System.out.println("Total: R$" + historicoCompras.get(i).calcularTotal());
		}
	}
}
