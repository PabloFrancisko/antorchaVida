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

import com.ant.entities.Medicamento;

import com.ant.services.MedicamentoEjb;

@ManagedBean(name = "medicamentoBean")
@SessionScoped

public class MedicamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -416108348623186084L;


	/**
	 * 
	 */
	

	private Medicamento medicamento = new Medicamento();

	
	private Medicamento medicamentoSearch = new Medicamento();
	private String regexText = new String();
	private Boolean isNew = new Boolean(Boolean.TRUE);
	
	private List<Medicamento> medicamentoList = new ArrayList<Medicamento>();
	

	@EJB
	MedicamentoEjb medicamentoAction;

	public void save() {

		try {
			if(isNew){
				medicamentoAction.persist(medicamento);
				medicamento = new Medicamento();
			}
			else{
				medicamentoAction.merge(medicamento);
				medicamento = new Medicamento();
				isNew = Boolean.TRUE;
			}
			RequestContext.getCurrentInstance().update("medicamentoForm:insertDialog");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			medicamentoList = medicamentoAction.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().update("medicamentoForm:medicamentoTable");

	}

	public void search() {

		try {
			medicamentoList = medicamentoAction.findByMedicamentoName(medicamentoSearch);
			RequestContext.getCurrentInstance().update("medicamentoForm:medicamentoTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Medicamento med) {

		try {
			medicamentoAction.remove(med);
			medicamentoList = medicamentoAction.findAll();
			RequestContext.getCurrentInstance().update("medicamentoForm:medicamentoTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clean() {
		medicamentoList = new ArrayList<Medicamento>();
		RequestContext.getCurrentInstance().update("medicamentoForm:medicamentoTable");
	}

	public void edit(Medicamento med) {
		isNew = Boolean.FALSE;
		medicamento = new Medicamento();	
		medicamento = med;	
	
		RequestContext.getCurrentInstance().update("medicamentoForm:insertDialog");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}

	public void handleClose(CloseEvent event) {
		medicamento = new Medicamento();
		RequestContext.getCurrentInstance().update("medicamentoForm:insertDialog");
	}

	public final Medicamento getMedicamento() {
		return medicamento;
	}

	public final void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public final Medicamento getMedicamentoSearch() {
		return medicamentoSearch;
	}

	public final void setMedicamentoSearch(Medicamento medicamentoSearch) {
		this.medicamentoSearch = medicamentoSearch;
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

	public final List<Medicamento> getMedicamentoList() {
		return medicamentoList;
	}

	public final void setMedicamentoList(List<Medicamento> medicamentoList) {
		this.medicamentoList = medicamentoList;
	}

}