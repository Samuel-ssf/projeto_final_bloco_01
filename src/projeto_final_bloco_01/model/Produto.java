package projeto_final_bloco_01.model;

import java.text.NumberFormat;

import projeto_final_bloco_01.util.Cores;


public abstract class Produto {
	
	private int id;
	private String nome;
	private int tipo;
	private float preco;
	
	public Produto(int id, String nome, int tipo, float preco) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void visualizar() {

		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Bicicleta";
		case 2 -> tipo = "Acessório";
		default -> tipo = "Invalido";
		}

		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("********************************************************");
		System.out.println("*                   DADOS DO PRODUTO                   *");
		System.out.println("********************************************************");
		System.out.println("" + Cores.TEXT_RESET);
		System.out.println("* ID DO PRODUTO: " + this.id);
		System.out.println("* MARCA DO PRODUTO: " + this.nome);
		System.out.println("* TIPO DO PRODUTO: " + tipo);
		System.out.println("* PREÇO DO PRODUTO: " + nfMoeda.format(this.preco));

	}


}
