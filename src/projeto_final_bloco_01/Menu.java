package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Acessorios;
import projeto_final_bloco_01.model.Bicicletas;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.util.Cores;

public class Menu {

	public static <Bicicleta> void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ProdutoController produtos = new ProdutoController();
		int opcao, id = 0, tipo;
		String nome, bicicleta, acessorio;
		int preco;

		// Teste para dados//

		Bicicletas b1 = new Bicicletas(produtos.gerarid(), "OGGI", 1, 3450.00f, "Aro 29");
		produtos.cadastrar(b1);

		Acessorios a1 = new Acessorios(produtos.gerarid(), "GTS ", 2, 200.00f, "Capacete");
		a1.visualizar();

		produtos.listarTodos();

		while (true) {

			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("********************************************************");
			System.out.println("*                                                      *");
			System.out.println("*                        BIKE ONE                      *");
			System.out.println("*                                                      *");
			System.out.println("********************************************************");
			System.out.println("*                                                      *");
			System.out.println("*              1 - Criar Produto                       *");
			System.out.println("*              2 - Listar Todas as Produtos            *");
			System.out.println("*              3 - Buscar Produto por Numero           *");
			System.out.println("*              4 - Atualizar Dados da Produto          *");
			System.out.println("*              5 - Apagar Produto                      *");
			System.out.println("*              6 - Sair                                *");
			System.out.println("*                                                      *");
			System.out.println("********************************************************");
			System.out.println("*              ENTRE COM A OPÇÃO DESEJADA:             *");
			System.out.println("********************************************************" + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 6) {
				System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("********************************************************");
				System.out.println("BIKE ONE, LOJA DE AVENTURAS SOBRE DUAS RODAS - É AQUI!*");
				System.out.println("********************************************************");
				System.out.println(Cores.TEXT_RESET);

				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println("Criar Produto\n\n");

			

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");
				produtos.listarTodos();
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados do Produto - por ID\n\n");

				System.out.println("Digite o ID da Produto:");
				id = leia.nextInt();

				produtos.ProcurarPorId(id);

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do Produto\n\n");

				Optional<Produto> produto = produtos.buscarNaCollection(id);

				System.out.println("\nDigite o Nome do Produto:");
				nome = leia.nextLine();

				tipo = produto.get().getTipo();

				System.out.println("\nDigite o Peço do Produto:");
				preco = leia.nextInt();

				switch (tipo) {
				case 1 -> {
					System.out.println("\nDigite o Material do Quadro:");
					bicicleta = leia.nextLine();
					leia.skip("\\R");
					produtos.cadastrar(new Bicicletas(produtos.gerarid(), nome, tipo, preco, bicicleta));
				}

				case 2 -> {
					System.out.println("\nDigite o Tamanho:");
					leia.skip("\\R");
					bicicleta = leia.nextLine();
					produtos.cadastrar(new Bicicletas(produtos.gerarid(), nome, tipo, preco, bicicleta));
				}
				}

				System.out.printf("\nO Produto ID %d nao existe!");

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar o Produto\n\n");

				System.out.println("Deletar o ID do Produto:");
				id = leia.nextInt();

				produtos.ProcurarPorId(id);

				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");

				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("\n********************************************************");
		System.out.println("PROJETO DESENVOLVIDO POR:                              *");
		System.out.println("Samuel de Jesus Silva - samueldjsferreira@gemail.com   *");
		System.out.println("https://github.com/Samuel-ssf                          *");
		System.out.println("********************************************************");
		System.out.println(Cores.TEXT_RESET);

	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			int input;
			while ((input = System.in.read()) != '\n') {

				if (input == -1) {
					throw new IOException("Entrada encerrada inesperadamente");
				}
			}

		} catch (IOException e) {
			System.err.println("Erro de entrada/saída: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());

		}
	}
}
