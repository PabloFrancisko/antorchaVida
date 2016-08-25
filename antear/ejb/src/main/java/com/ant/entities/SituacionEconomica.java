package com.ant.entities;

import java.io.Serializable;
import java.math.BigDecimal;

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
	private BigDecimal seAguaPotable;

	@Column(name="SE_ALCANTARILLADO")
	private int seAlcantarillado;

	@Column(name="SE_LUZ")
	private BigDecimal seLuz;

	@Column(name="SE_MADRE")
	private BigDecimal seMadre;

	@Column(name="SE_OTROS")
	private BigDecimal seOtros;

	@Column(name="SE_PADRE")
	private BigDecimal sePadre;

	@Column(name="SE_TELF")
	private BigDecimal seTelf;

	@Column(name="SE_VIVIENDA")
	private BigDecimal seVivienda;

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

	public BigDecimal getSeAguaPotable() {
		return this.seAguaPotable;
	}

	public void setSeAguaPotable(BigDecimal seAguaPotable) {
		this.seAguaPotable = seAguaPotable;
	}

	public int getSeAlcantarillado() {
		return this.seAlcantarillado;
	}

	public void setSeAlcantarillado(int seAlcantarillado) {
		this.seAlcantarillado = seAlcantarillado;
	}

	public BigDecimal getSeLuz() {
		return this.seLuz;
	}

	public void setSeLuz(BigDecimal seLuz) {
		this.seLuz = seLuz;
	}

	public BigDecimal getSeMadre() {
		return this.seMadre;
	}

	public void setSeMadre(BigDecimal seMadre) {
		this.seMadre = seMadre;
	}

	public BigDecimal getSeOtros() {
		return this.seOtros;
	}

	public void setSeOtros(BigDecimal seOtros) {
		this.seOtros = seOtros;
	}

	public BigDecimal getSePadre() {
		return this.sePadre;
	}

	public void setSePadre(BigDecimal sePadre) {
		this.sePadre = sePadre;
	}

	public BigDecimal getSeTelf() {
		return this.seTelf;
	}

	public void setSeTelf(BigDecimal seTelf) {
		this.seTelf = seTelf;
	}

	public BigDecimal getSeVivienda() {
		return this.seVivienda;
	}

	public void setSeVivienda(BigDecimal seVivienda) {
		this.seVivienda = seVivienda;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}