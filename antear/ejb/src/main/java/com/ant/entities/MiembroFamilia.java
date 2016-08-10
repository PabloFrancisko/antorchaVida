package com.ant.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the miembro_familia database table.
 * 
 */
@Entity
@Table(name="miembro_familia")
public class MiembroFamilia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MF_ID")
	private int mfId;

	@Column(name="MF_APELLIDO")
	private String mfApellido;

	@Column(name="MF_CI")
	private int mfCi;

	@Temporal(TemporalType.DATE)
	@Column(name="MF_FECHA_NAC")
	private Date mfFechaNac;

	@Column(name="MF_NIVEL_ACAD")
	private String mfNivelAcad;

	@Column(name="MF_NOMBRE")
	private String mfNombre;

	@Column(name="MF_PARENTESCO")
	private String mfParentesco;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="P_ID")
	private Paciente paciente;

	public MiembroFamilia() {
	}

	public int getMfId() {
		return this.mfId;
	}

	public void setMfId(int mfId) {
		this.mfId = mfId;
	}

	public String getMfApellido() {
		return this.mfApellido;
	}

	public void setMfApellido(String mfApellido) {
		this.mfApellido = mfApellido;
	}

	public int getMfCi() {
		return this.mfCi;
	}

	public void setMfCi(int mfCi) {
		this.mfCi = mfCi;
	}

	public Date getMfFechaNac() {
		return this.mfFechaNac;
	}

	public void setMfFechaNac(Date mfFechaNac) {
		this.mfFechaNac = mfFechaNac;
	}

	public String getMfNivelAcad() {
		return this.mfNivelAcad;
	}

	public void setMfNivelAcad(String mfNivelAcad) {
		this.mfNivelAcad = mfNivelAcad;
	}

	public String getMfNombre() {
		return this.mfNombre;
	}

	public void setMfNombre(String mfNombre) {
		this.mfNombre = mfNombre;
	}

	public String getMfParentesco() {
		return this.mfParentesco;
	}

	public void setMfParentesco(String mfParentesco) {
		this.mfParentesco = mfParentesco;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}