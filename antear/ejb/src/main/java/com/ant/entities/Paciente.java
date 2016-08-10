package com.ant.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@Table(name="paciente")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="P_ID")
	private int pId;

	@Column(name="P_ALERGIAS")
	private String pAlergias;

	@Column(name="P_APELLIDO")
	private String pApellido;

	@Column(name="P_CARNET")
	private String pCarnet;

	@Column(name="P_CI")
	private int pCi;

	@Column(name="P_DOMICILIO")
	private String pDomicilio;

	@Column(name="P_EMAIL")
	private String pEmail;

	@Temporal(TemporalType.DATE)
	@Column(name="P_FECHA_ING")
	private Date pFechaIng;

	@Temporal(TemporalType.DATE)
	@Column(name="P_FECHA_NAC")
	private Date pFechaNac;

	@Column(name="P_NOMBRE")
	private String pNombre;

	@Column(name="P_TELF")
	private int pTelf;

	@Column(name="P_TIPO_DISC")
	private String pTipoDisc;

	@Column(name="P_TIPO_SANG")
	private String pTipoSang;

	//bi-directional many-to-one association to Escolaridad
	@OneToMany(mappedBy="paciente")
	private List<Escolaridad> escolaridads;

	//bi-directional many-to-one association to Medicamento
	@OneToMany(mappedBy="paciente")
	private List<Medicamento> medicamentos;

	//bi-directional many-to-one association to MiembroFamilia
	@OneToMany(mappedBy="paciente")
	private List<MiembroFamilia> miembroFamilias;

	//bi-directional many-to-one association to PacienteArea
	@OneToMany(mappedBy="paciente")
	private List<PacienteArea> pacienteAreas;

	//bi-directional many-to-one association to Representante
	@OneToMany(mappedBy="paciente")
	private List<Representante> representantes;

	//bi-directional many-to-one association to SituacionEconomica
	@OneToMany(mappedBy="paciente")
	private List<SituacionEconomica> situacionEconomicas;

	public Paciente() {
	}

	public int getPId() {
		return this.pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}

	public String getPAlergias() {
		return this.pAlergias;
	}

	public void setPAlergias(String pAlergias) {
		this.pAlergias = pAlergias;
	}

	public String getPApellido() {
		return this.pApellido;
	}

	public void setPApellido(String pApellido) {
		this.pApellido = pApellido;
	}

	public String getPCarnet() {
		return this.pCarnet;
	}

	public void setPCarnet(String pCarnet) {
		this.pCarnet = pCarnet;
	}

	public int getPCi() {
		return this.pCi;
	}

	public void setPCi(int pCi) {
		this.pCi = pCi;
	}

	public String getPDomicilio() {
		return this.pDomicilio;
	}

	public void setPDomicilio(String pDomicilio) {
		this.pDomicilio = pDomicilio;
	}

	public String getPEmail() {
		return this.pEmail;
	}

	public void setPEmail(String pEmail) {
		this.pEmail = pEmail;
	}

	public Date getPFechaIng() {
		return this.pFechaIng;
	}

	public void setPFechaIng(Date pFechaIng) {
		this.pFechaIng = pFechaIng;
	}

	public Date getPFechaNac() {
		return this.pFechaNac;
	}

	public void setPFechaNac(Date pFechaNac) {
		this.pFechaNac = pFechaNac;
	}

	public String getPNombre() {
		return this.pNombre;
	}

	public void setPNombre(String pNombre) {
		this.pNombre = pNombre;
	}

	public int getPTelf() {
		return this.pTelf;
	}

	public void setPTelf(int pTelf) {
		this.pTelf = pTelf;
	}

	public String getPTipoDisc() {
		return this.pTipoDisc;
	}

	public void setPTipoDisc(String pTipoDisc) {
		this.pTipoDisc = pTipoDisc;
	}

	public String getPTipoSang() {
		return this.pTipoSang;
	}

	public void setPTipoSang(String pTipoSang) {
		this.pTipoSang = pTipoSang;
	}

	public List<Escolaridad> getEscolaridads() {
		return this.escolaridads;
	}

	public void setEscolaridads(List<Escolaridad> escolaridads) {
		this.escolaridads = escolaridads;
	}

	public Escolaridad addEscolaridad(Escolaridad escolaridad) {
		getEscolaridads().add(escolaridad);
		escolaridad.setPaciente(this);

		return escolaridad;
	}

	public Escolaridad removeEscolaridad(Escolaridad escolaridad) {
		getEscolaridads().remove(escolaridad);
		escolaridad.setPaciente(null);

		return escolaridad;
	}

	public List<Medicamento> getMedicamentos() {
		return this.medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Medicamento addMedicamento(Medicamento medicamento) {
		getMedicamentos().add(medicamento);
		medicamento.setPaciente(this);

		return medicamento;
	}

	public Medicamento removeMedicamento(Medicamento medicamento) {
		getMedicamentos().remove(medicamento);
		medicamento.setPaciente(null);

		return medicamento;
	}

	public List<MiembroFamilia> getMiembroFamilias() {
		return this.miembroFamilias;
	}

	public void setMiembroFamilias(List<MiembroFamilia> miembroFamilias) {
		this.miembroFamilias = miembroFamilias;
	}

	public MiembroFamilia addMiembroFamilia(MiembroFamilia miembroFamilia) {
		getMiembroFamilias().add(miembroFamilia);
		miembroFamilia.setPaciente(this);

		return miembroFamilia;
	}

	public MiembroFamilia removeMiembroFamilia(MiembroFamilia miembroFamilia) {
		getMiembroFamilias().remove(miembroFamilia);
		miembroFamilia.setPaciente(null);

		return miembroFamilia;
	}

	public List<PacienteArea> getPacienteAreas() {
		return this.pacienteAreas;
	}

	public void setPacienteAreas(List<PacienteArea> pacienteAreas) {
		this.pacienteAreas = pacienteAreas;
	}

	public PacienteArea addPacienteArea(PacienteArea pacienteArea) {
		getPacienteAreas().add(pacienteArea);
		pacienteArea.setPaciente(this);

		return pacienteArea;
	}

	public PacienteArea removePacienteArea(PacienteArea pacienteArea) {
		getPacienteAreas().remove(pacienteArea);
		pacienteArea.setPaciente(null);

		return pacienteArea;
	}

	public List<Representante> getRepresentantes() {
		return this.representantes;
	}

	public void setRepresentantes(List<Representante> representantes) {
		this.representantes = representantes;
	}

	public Representante addRepresentante(Representante representante) {
		getRepresentantes().add(representante);
		representante.setPaciente(this);

		return representante;
	}

	public Representante removeRepresentante(Representante representante) {
		getRepresentantes().remove(representante);
		representante.setPaciente(null);

		return representante;
	}

	public List<SituacionEconomica> getSituacionEconomicas() {
		return this.situacionEconomicas;
	}

	public void setSituacionEconomicas(List<SituacionEconomica> situacionEconomicas) {
		this.situacionEconomicas = situacionEconomicas;
	}

	public SituacionEconomica addSituacionEconomica(SituacionEconomica situacionEconomica) {
		getSituacionEconomicas().add(situacionEconomica);
		situacionEconomica.setPaciente(this);

		return situacionEconomica;
	}

	public SituacionEconomica removeSituacionEconomica(SituacionEconomica situacionEconomica) {
		getSituacionEconomicas().remove(situacionEconomica);
		situacionEconomica.setPaciente(null);

		return situacionEconomica;
	}

}