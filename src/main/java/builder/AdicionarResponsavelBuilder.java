package builder;

import entity.AdicionarResponsavelEntity;

public class AdicionarResponsavelBuilder {
	
	private AdicionarResponsavelEntity entity = new AdicionarResponsavelEntity();
	
	public static AdicionarResponsavelBuilder get() {
		return new AdicionarResponsavelBuilder();
	}

	public AdicionarResponsavelBuilder setNome(String nome) {
		entity.setNome(nome);
		return this;
	}

	public AdicionarResponsavelBuilder setDescricao(String descricao) {
		entity.setDescricao(descricao);
		return this;
	}

	public AdicionarResponsavelBuilder setTipo(String tipo) {
		entity.setTipo(tipo);
		return this;
	}

	public AdicionarResponsavelBuilder setLotacao(String lotacao) {
		entity.setLotacao(lotacao);
		return this;
	}
	
	public AdicionarResponsavelEntity build() {
		return this.entity;
	}
}
