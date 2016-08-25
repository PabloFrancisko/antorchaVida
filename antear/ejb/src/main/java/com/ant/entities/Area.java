package com.ant.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@Table(name="area")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="A_ID")
	private int aId;

	@Column(name="A_CODIGO")
	private int aCodigo;

	@Column(name="A_NOMBRE")
	private String aNombre;

	//bi-directional many-to-one association to PacienteArea
	@OneToMany(mappedBy="area")
	@Transient
	private List<PacienteArea> pacienteAreas;

	public Area() {
	}

	public int getAId() {
		return this.aId;
	}

	public void setAId(int aId) {
		this.aId = aId;
	}

	public int getACodigo() {
		return this.aCodigo;
	}

	public void setACodigo(int aCodigo) {
		this.aCodigo = aCodigo;
	}

	public String getANombre() {
		return this.aNombre;
	}

	public void setANombre(String aNombre) {
		this.aNombre = aNombre;
	}

	public List<PacienteArea> getPacienteAreas() {
		return this.pacienteAreas;
	}

	public void setPacienteAreas(List<PacienteArea> pacienteAreas) {
		this.pacienteAreas = pacienteAreas;
	}

	public PacienteArea addPacienteArea(PacienteArea pacienteArea) {
		getPacienteAreas().add(pacienteArea);
		pacienteArea.setArea(this);

		return pacienteArea;
	}

	public PacienteArea removePacienteArea(PacienteArea pacienteArea) {
		getPacienteAreas().remove(pacienteArea);
		pacienteArea.setArea(null);

		return pacienteArea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Area other = (Area) obj;
		if (aId != other.aId)
			return false;
		return true;
	}

}