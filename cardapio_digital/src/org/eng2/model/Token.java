package org.eng2.model;

import java.util.Date;

public class Token {

	private String cod;
	private int mesaId;
	private Date ativadoEm;

	public int getMesaId() {
		return mesaId;
	}

	public void setMesaId(int mesaId) {
		this.mesaId = mesaId;
	}

	public Date getAtivadoEm() {
		return ativadoEm;
	}

	public void setAtivadoEm(Date ativadoEm) {
		this.ativadoEm = ativadoEm;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}
	
}
