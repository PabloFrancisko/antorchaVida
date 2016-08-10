package com.ant.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the paciente_area database table.
 * 
 */
@Entity
@Table(name="paciente_area")
@NamedQuery(name="PacienteArea.findAll", query="SELECT p FROM PacienteArea p")
public class PacienteArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PACIENTE_AREA")
	private int idPacienteArea;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="P_ID")
	private Paciente paciente;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="A_ID")
	private Area area;

	public PacienteArea() {
	}

	public int getIdPacienteArea() {
		return this.idPacienteArea;
	}

	public void setIdPacienteArea(int idPacienteArea) {
		this.idPacienteArea = idPacienteArea;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}