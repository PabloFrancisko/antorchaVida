package com.ant.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the medicamento database table.
 * 
 */
@Entity
@Table(name="medicamento")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="M_ID")
	private int mId;

	@Column(name="M_DOSIS")
	private String mDosis;

	@Column(name="M_HORARIO")
	private Time mHorario;

	@Column(name="M_MEDIC_TELF")
	private int mMedicTelf;

	@Column(name="M_MEDICO")
	private String mMedico;

	@Column(name="M_NOMBRE")
	private String mNombre;

	@Column(name="M_PRESENTACION")
	private String mPresentacion;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="P_ID")
	private Paciente paciente;

	public Medicamento() {
	}

	public int getMId() {
		return this.mId;
	}

	public void setMId(int mId) {
		this.mId = mId;
	}

	public String getMDosis() {
		return this.mDosis;
	}

	public void setMDosis(String mDosis) {
		this.mDosis = mDosis;
	}

	public Time getMHorario() {
		return this.mHorario;
	}

	public void setMHorario(Time mHorario) {
		this.mHorario = mHorario;
	}

	public int getMMedicTelf() {
		return this.mMedicTelf;
	}

	public void setMMedicTelf(int mMedicTelf) {
		this.mMedicTelf = mMedicTelf;
	}

	public String getMMedico() {
		return this.mMedico;
	}

	public void setMMedico(String mMedico) {
		this.mMedico = mMedico;
	}

	public String getMNombre() {
		return this.mNombre;
	}

	public void setMNombre(String mNombre) {
		this.mNombre = mNombre;
	}

	public String getMPresentacion() {
		return this.mPresentacion;
	}

	public void setMPresentacion(String mPresentacion) {
		this.mPresentacion = mPresentacion;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}