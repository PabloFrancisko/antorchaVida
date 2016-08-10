package com.ant.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the situacion_economica database table.
 * 
 */
@Entity
@Table(name="situacion_economica")
public class SituacionEconomica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SE_ID")
	private int seId;

	@Column(name="SE_AGUA_POTABLE")
	private byte seAguaPotable;

	@Column(name="SE_ALCANTARILLADO")
	private byte seAlcantarillado;

	@Column(name="SE_LUZ")
	private byte seLuz;

	@Column(name="SE_MADRE")
	private String seMadre;

	@Column(name="SE_OTROS")
	private String seOtros;

	@Column(name="SE_PADRE")
	private String sePadre;

	@Column(name="SE_TELF")
	private byte seTelf;

	@Column(name="SE_VIVIENDA")
	private String seVivienda;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="P_ID")
	private Paciente paciente;

	public SituacionEconomica() {
	}

	public int getSeId() {
		return this.seId;
	}

	public void setSeId(int seId) {
		this.seId = seId;
	}

	public byte getSeAguaPotable() {
		return this.seAguaPotable;
	}

	public void setSeAguaPotable(byte seAguaPotable) {
		this.seAguaPotable = seAguaPotable;
	}

	public byte getSeAlcantarillado() {
		return this.seAlcantarillado;
	}

	public void setSeAlcantarillado(byte seAlcantarillado) {
		this.seAlcantarillado = seAlcantarillado;
	}

	public byte getSeLuz() {
		return this.seLuz;
	}

	public void setSeLuz(byte seLuz) {
		this.seLuz = seLuz;
	}

	public String getSeMadre() {
		return this.seMadre;
	}

	public void setSeMadre(String seMadre) {
		this.seMadre = seMadre;
	}

	public String getSeOtros() {
		return this.seOtros;
	}

	public void setSeOtros(String seOtros) {
		this.seOtros = seOtros;
	}

	public String getSePadre() {
		return this.sePadre;
	}

	public void setSePadre(String sePadre) {
		this.sePadre = sePadre;
	}

	public byte getSeTelf() {
		return this.seTelf;
	}

	public void setSeTelf(byte seTelf) {
		this.seTelf = seTelf;
	}

	public String getSeVivienda() {
		return this.seVivienda;
	}

	public void setSeVivienda(String seVivienda) {
		this.seVivienda = seVivienda;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}