package com.ant.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the escolaridad database table.
 * 
 */
@Entity
@Table(name="escolaridad")
public class Escolaridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="E_ID")
	private int eId;

	@Column(name="E_DIRECCION")
	private String eDireccion;

	@Column(name="E_GRADO")
	private String eGrado;

	@Column(name="E_NOMBRE_INSTITUCION")
	private String eNombreInstitucion;

	@Column(name="E_NOMBRE_PROFESORA")
	private String eNombreProfesora;

	@Column(name="E_TELF")
	private int eTelf;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="P_ID")
	private Paciente paciente;

	public Escolaridad() {
	}

	public int getEId() {
		return this.eId;
	}

	public void setEId(int eId) {
		this.eId = eId;
	}

	public String getEDireccion() {
		return this.eDireccion;
	}

	public void setEDireccion(String eDireccion) {
		this.eDireccion = eDireccion;
	}

	public String getEGrado() {
		return this.eGrado;
	}

	public void setEGrado(String eGrado) {
		this.eGrado = eGrado;
	}

	public String getENombreInstitucion() {
		return this.eNombreInstitucion;
	}

	public void setENombreInstitucion(String eNombreInstitucion) {
		this.eNombreInstitucion = eNombreInstitucion;
	}

	public String getENombreProfesora() {
		return this.eNombreProfesora;
	}

	public void setENombreProfesora(String eNombreProfesora) {
		this.eNombreProfesora = eNombreProfesora;
	}

	public int getETelf() {
		return this.eTelf;
	}

	public void setETelf(int eTelf) {
		this.eTelf = eTelf;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}