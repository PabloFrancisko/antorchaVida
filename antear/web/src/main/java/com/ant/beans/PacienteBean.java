package com.ant.beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;

import com.ant.entities.Area;
import com.ant.entities.Medicamento;
import com.ant.entities.Paciente;
import com.ant.entities.PacienteArea;
import com.ant.entities.Representante;
import com.ant.entities.SituacionEconomica;
import com.ant.services.AreaEjb;
import com.ant.services.MedicamentoEjb;
import com.ant.services.PacienteAreaEjb;
import com.ant.services.PacienteEjb;
import com.ant.services.RepresentanteEjb;
import com.ant.services.SituacionEconomicaEjb;

@ManagedBean(name = "pacienteBean")
@SessionScoped

public class PacienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7112471807576768928L;

	/**
	 * 
	 */


	private Paciente paciente = new Paciente();

	private Paciente pacienteSearch = new Paciente();
	private PacienteArea pacienteArea = new PacienteArea();
	private SituacionEconomica situacionEconomica = new SituacionEconomica();
	private Medicamento medicamento = new Medicamento();
	private Representante representante = new Representante();
	
	
	private String regexText = new String();
	private Boolean isNew = new Boolean(Boolean.TRUE);
	
	private List<Area> areaList = new ArrayList<Area>();
	private List<Paciente> pacienteList = new ArrayList<Paciente>();
	private List<PacienteArea> pacienteAreaList = new ArrayList<PacienteArea>();
	

	@EJB
	PacienteEjb pacienteAction;
	
	@EJB
	SituacionEconomicaEjb situacionEconomicaAction;
	
	@EJB
	PacienteAreaEjb pacienteAreaAction;
	
	@EJB
	AreaEjb areaAction;
	
	@EJB
	MedicamentoEjb medicamentoAction;
	
	@EJB
    RepresentanteEjb representanteAction;
	
	public void save() {

		try {
			if(isNew){
				
				pacienteAction.persist(paciente);
				paciente = new Paciente();
			}
			else{
				pacienteAction.merge(paciente);
				paciente = new Paciente();
				isNew = Boolean.TRUE;
			}
			RequestContext.getCurrentInstance().update("pacienteForm:insertDialog");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pacienteList = pacienteAction.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().update("pacienteForm:pacienteTable");

	}
	
	public void saveSituacionEconomica(){
		
		if(situacionEconomica.getSeId()!=0){
			try {
				
				situacionEconomicaAction.merge(situacionEconomica);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			situacionEconomica = new SituacionEconomica();
		}
		else{
			try {
				situacionEconomicaAction.persist(situacionEconomica);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			situacionEconomica = new SituacionEconomica();
		}
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialogSituacionEconomica");
	}
	
	public void savePacienteArea(){
		try {
			pacienteArea.setIdPacienteArea(0);
			pacienteAreaAction.persist(pacienteArea);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AreasPorPaciente(pacienteArea.getPaciente());
	}
	
	public void saveMedicamento(){
		
		if(medicamento.getMId()!=0){
			try {
				
				medicamentoAction.merge(medicamento);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			medicamento = new Medicamento();
		}
		else{
			try {
				medicamentoAction.persist(medicamento);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			medicamento = new Medicamento();
		}
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialogMedicamento");
	}
	
	public void saveRepresentante(){
		
		if(representante.getRId()!=0){
			try {
				
				representanteAction.merge(representante);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			representante = new Representante();
		}
		else{
			try {
				representanteAction.persist(representante);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			representante = new Representante();
		}
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialogRepresentante");
	}
	
	public void AreasPorPaciente(Paciente pac){
		try {
			pacienteAreaList = pacienteAreaAction.findByAreaPaciente(pac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().update("pacienteForm:pacienteAreaTable");
	}
	
	

	public void search() {

		try {
			pacienteList = pacienteAction.findByPacienteName(pacienteSearch);
			RequestContext.getCurrentInstance().update("pacienteForm:pacienteTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Paciente pac) {

		try {
			pacienteAction.remove(pac);
			pacienteList = pacienteAction.findAll();
			RequestContext.getCurrentInstance().update("pacienteForm:pacienteTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletePacienteArea(PacienteArea pacArea) {

		try {
			pacienteAreaAction.remove(pacArea);
			AreasPorPaciente(pacienteArea.getPaciente());
			RequestContext.getCurrentInstance().update("pacienteForm:pacienteAreaTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clean() {
		pacienteList = new ArrayList<Paciente>();
		RequestContext.getCurrentInstance().update("pacienteForm:pacienteTable");
	}

	public void edit(Paciente pac) {
		isNew = Boolean.FALSE;
		paciente = new Paciente();	
		paciente = pac;	
	
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialog");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public void openSituacionEconomica(Paciente pac){
		
		situacionEconomica = situacionEconomicaAction.findByPaciente(pac);
		if(situacionEconomica.getPaciente()==null){
			situacionEconomica.setPaciente(pac);
		}
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialogSituacionEconomica");
		RequestContext.getCurrentInstance().execute("PF('dlg3').show();");
	}
	
	
	public void openAreas(Paciente pac){
		pacienteArea.setPaciente(pac);
		AreasPorPaciente(pacienteArea.getPaciente());
		RequestContext.getCurrentInstance().update("pacienteForm:pacienteAreaTable");
		RequestContext.getCurrentInstance().execute("PF('dlg4').show();");
	}
	
	
	public void openMedicamento(Paciente pac){
		
		medicamento = medicamentoAction.findByPaciente2(pac);
		if(medicamento.getPaciente()==null){
			medicamento.setPaciente(pac);
		}
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialogMedicamento");
		RequestContext.getCurrentInstance().execute("PF('dlg5').show();");
	}
	
	public void openRepresentante(Paciente pac){
		
		representante = representanteAction.findByPaciente3(pac);
		if(representante.getPaciente()==null){
			representante.setPaciente(pac);
		}
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialogRepresentante");
		RequestContext.getCurrentInstance().execute("PF('dlg6').show();");
	}

	public void handleClose(CloseEvent event) {
		paciente = new Paciente();
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialog");
	}
	
	public void handleClose1(CloseEvent event) {
		situacionEconomica = new SituacionEconomica();
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialogSituacionEconomica");
	}
	
	public void handleClose2(CloseEvent event) {
		
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialogAreas");
	}

	
	public void handleClose3(CloseEvent event) {
		medicamento = new Medicamento();
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialogMedicamento");
	}
	
	public void handleClose4(CloseEvent event) {
		representante= new Representante();
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialogRepresentante");
	}
	
	public final Paciente getPaciente() {
		return paciente;
	}

	public final void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public final Paciente getPacienteSearch() {
		return pacienteSearch;
	}

	public final void setPacienteSearch(Paciente pacienteSearch) {
		this.pacienteSearch = pacienteSearch;
	}

	public final String getRegexText() {
		return regexText;
	}

	public final void setRegexText(String regexText) {
		this.regexText = regexText;
	}

	public final Boolean getIsNew() {
		return isNew;
	}

	public final void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public final List<Paciente> getPacienteList() {
		return pacienteList;
	}

	public final void setPacienteList(List<Paciente> pacienteList) {
		this.pacienteList = pacienteList;
	}

	public final SituacionEconomica getSituacionEconomica() {
		return situacionEconomica;
	}

	public final void setSituacionEconomica(SituacionEconomica situacionEconomica) {
		this.situacionEconomica = situacionEconomica;
	}

	public final List<PacienteArea> getPacienteAreaList() {
		return pacienteAreaList;
	}

	public final void setPacienteAreaList(List<PacienteArea> pacienteAreaList) {
		this.pacienteAreaList = pacienteAreaList;
	}

	public final List<Area> getAreaList() {
		try {
			areaList = areaAction.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaList;
	}

	public final void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public final PacienteArea getPacienteArea() {
		return pacienteArea;
	}

	public final void setPacienteArea(PacienteArea pacienteArea) {
		this.pacienteArea = pacienteArea;
	}
	
	public final Medicamento getMedicamento() {
		return medicamento;
	}

	public final void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public final Representante getRepresentante() {
		return representante;
	}

	public final void setRepresentante(Representante representante) {
		this.representante = representante;
	}
}