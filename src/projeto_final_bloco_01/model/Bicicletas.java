package projeto_final_bloco_01.model;

public class Bicicletas extends Produto{

	private String modelo;

	public Bicicletas(int id, String nome, int tipo, float preco, String modelo) {
		super(id, nome, tipo, preco);
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	} 
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("* MODELO DO PRODUTO: " + this.modelo);
		
	}
}
