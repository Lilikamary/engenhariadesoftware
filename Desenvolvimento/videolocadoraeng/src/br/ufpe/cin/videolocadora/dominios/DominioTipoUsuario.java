package br.ufpe.cin.videolocadora.dominios;

public enum DominioTipoUsuario {

	ADMINISTRADOR(1,"Administrador"), 
	CLIENTE(2,"Cliente"),
	LOCADORA(3,"Locadora"),;

	private String descricao;
	private int cod;

	private DominioTipoUsuario(int cod,String descricao) {
		this.setCod(cod);
		this.descricao = descricao;

	}

	public static DominioSituacao getByCod(int cod){
		for (DominioSituacao situacao: DominioSituacao.values()){
			if (situacao.getCod()==cod){
				return situacao;
			}
		}
		
		return null;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

}
