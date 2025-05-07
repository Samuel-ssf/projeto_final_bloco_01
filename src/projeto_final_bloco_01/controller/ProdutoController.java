package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;
import projeto_final_bloco_01.util.Cores;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> ListaProdutos = new ArrayList<Produto>();

	int id = 0;

	@Override
	public void ProcurarPorId(int id) {

		Optional<Produto> produto = buscarNaCollection(id);

		if (produto.isPresent())
			produto.get().visualizar();
		else
			System.out.printf("\nO Produto Número %d não foi Encontrado!", id);
	}

	@Override
	public void listarTodos() {
		for (var produto : ListaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void cadastrar(Produto Produto) {
		ListaProdutos.add(Produto);
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("********************************************************");
		System.out.println("*          O PRODUTO FOI CRIADO COM SUCESSO !          *");
		System.out.println("********************************************************" + Cores.TEXT_RESET);

	}

	@Override
	public void atualizar(Produto Produto) {
		Optional<Produto> buscaProduto = buscarNaCollection(id);

		if (buscaProduto.isPresent()) {
			System.out.printf("\nO Produto com o ID %d foi Atualizado com sucesso!", id);

		} else
			System.out.printf("\nO Produto com o ID %d não foi Encontrado!", id);

	}

	@Override
	public void deletar(int id) {
		Optional<Produto> produto = buscarNaCollection(id);

		if (produto.isPresent()) {
			if (ListaProdutos.remove(produto.get()) == true)
				System.out.printf("\nA Produto número %d foi excluida com sucesso!", id);
		} else
			System.out.printf("\nA Produto Número %d não foi Encontrada!", id);

	}

	public int gerarid() {
		return ++id;

	}

	public Optional<Produto> buscarNaCollection(int id) {
		for (var produto : ListaProdutos) {
			if (produto.getId() == id)
				return Optional.of(produto);
		}

		return Optional.empty();
	}

}
