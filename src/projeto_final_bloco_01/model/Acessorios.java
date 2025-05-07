package projeto_final_bloco_01.model;

public class Acessorios extends Produto{
	
	private String marca;

	public Acessorios(int id, String nome, int tipo, float preco, String marca) {
		super(id, nome, tipo, preco);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("* MODELO DO PRODUTO: " + this.marca);
		
	}

}
