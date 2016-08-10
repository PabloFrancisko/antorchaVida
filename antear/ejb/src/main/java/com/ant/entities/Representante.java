package com.ant.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the representante database table.
 * 
 */
@Entity
@Table(name="representante")
public class Representante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="R_ID")
	private int rId;

	@Column(name="R_APELLIDO")
	private String rApellido;

	@Column(name="R_CI")
	private int rCi;

	@Temporal(TemporalType.DATE)
	@Column(name="R_FECHA_NAC")
	private Date rFechaNac;

	@Column(name="R_INSTRUCCION")
	private String rInstruccion;

	@Column(name="R_NOMBRE")
	private String rNombre;

	@Column(name="R_OCUPACION")
	private String rOcupacion;

	@Column(name="R_TELF")
	private int rTelf;

	@Column(name="R_TIPO")
	private String rTipo;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="P_ID")
	private Paciente paciente;

	public Representante() {
	}

	public int getRId() {
		return this.rId;
	}

	public void setRId(int rId) {
		this.rId = rId;
	}

	public String getRApellido() {
		return this.rApellido;
	}

	public void setRApellido(String rApellido) {
		this.rApellido = rApellido;
	}

	public int getRCi() {
		return this.rCi;
	}

	public void setRCi(int rCi) {
		this.rCi = rCi;
	}

	public Date getRFechaNac() {
		return this.rFechaNac;
	}

	public void setRFechaNac(Date rFechaNac) {
		this.rFechaNac = rFechaNac;
	}

	public String getRInstruccion() {
		return this.rInstruccion;
	}

	public void setRInstruccion(String rInstruccion) {
		this.rInstruccion = rInstruccion;
	}

	public String getRNombre() {
		return this.rNombre;
	}

	public void setRNombre(String rNombre) {
		this.rNombre = rNombre;
	}

	public String getROcupacion() {
		return this.rOcupacion;
	}

	public void setROcupacion(String rOcupacion) {
		this.rOcupacion = rOcupacion;
	}

	public int getRTelf() {
		return this.rTelf;
	}

	public void setRTelf(int rTelf) {
		this.rTelf = rTelf;
	}

	public String getRTipo() {
		return this.rTipo;
	}

	public void setRTipo(String rTipo) {
		this.rTipo = rTipo;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}