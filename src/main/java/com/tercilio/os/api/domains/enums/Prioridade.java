package com.tercilio.os.api.domains.enums;

public enum Prioridade {

	BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

	private Integer cod;
	private String descricao;

	private Prioridade(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Prioridade toEnum(Integer cod) { // STATIC PRA NÃO PRECISAR INSTANCIAR UMA NOVA PRIORIDADE PRA CHAMAR
													// ESSE MÉTODO
		if (cod == null) {
			return null;
		}

		for (Prioridade x : Prioridade.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Prioridade inválida");
	}

}
