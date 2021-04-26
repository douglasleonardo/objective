package br.com.objective.model;

import java.io.Serializable;

public class Prato implements Serializable {

	private static final long serialVersionUID = 1L;

	private String caracteristica;
	private Prato pratoRelacionado;
	private Prato pratoCorreto;

	public Prato(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	
	public boolean isTemPratoRelacionado() {
		return this.pratoRelacionado != null;
	}
	
	public boolean isPratoCorreto() {
		return this.pratoCorreto != null;
	}

	public boolean isFimArvorePratos() {
		return this.pratoRelacionado == null && this.pratoCorreto == null;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Prato getPratoRelacionado() {
		return pratoRelacionado;
	}

	public void setPratoRelacionado(Prato pratoRelacionado) {
		this.pratoRelacionado = pratoRelacionado;
	}

	public Prato getPratoCorreto() {
		return pratoCorreto;
	}

	public void setPratoCorreto(Prato pratoCorreto) {
		this.pratoCorreto = pratoCorreto;
	}
}
