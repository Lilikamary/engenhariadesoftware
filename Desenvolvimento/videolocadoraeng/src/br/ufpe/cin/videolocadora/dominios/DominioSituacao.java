package br.ufpe.cin.videolocadora.dominios;

public enum DominioSituacao {
	ATIVO(1,"Ativo"), INATIVO(2,"Inativo");

	private String descricao;
	private int cod;

	private DominioSituacao(int cod,String descricao) {
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
