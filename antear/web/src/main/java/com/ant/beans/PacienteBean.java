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

import com.ant.entities.Paciente;

import com.ant.services.PacienteEjb;

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
	private String regexText = new String();
	private Boolean isNew = new Boolean(Boolean.TRUE);
	
	private List<Paciente> pacienteList = new ArrayList<Paciente>();
	

	@EJB
	PacienteEjb pacienteAction;

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

	public void handleClose(CloseEvent event) {
		paciente = new Paciente();
		RequestContext.getCurrentInstance().update("pacienteForm:insertDialog");
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

}