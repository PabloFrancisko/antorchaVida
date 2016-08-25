package com.ant.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;

import com.ant.entities.Escolaridad;
import com.ant.services.EscolaridadEjb;
import com.ant.utils.SHA;

@ManagedBean(name="escolaridadBean")
@SessionScoped
public class EscolaridadBean implements Serializable{


	private static final long serialVersionUID = -6509238418028308036L;
	
	private Escolaridad escolaridad = new Escolaridad();
	private Escolaridad escolaridadSearch = new Escolaridad();

	private String regexText = new String();
	private Boolean isNew = new Boolean(Boolean.TRUE);
	private List<Escolaridad> escolaridadList = new ArrayList<Escolaridad>();
		
	@EJB
	EscolaridadEjb escolaridadAction;
	
	
	public void save() {

		try {
			if(isNew){
				escolaridadAction.persist(escolaridad);
				escolaridad = new Escolaridad();
			}
			else{
				escolaridadAction.merge(escolaridad);
				escolaridad = new Escolaridad();
				isNew = Boolean.TRUE;
			}
			RequestContext.getCurrentInstance().update("escolaridadForm:insertDialog");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void search() {

		try {
			escolaridadList = escolaridadAction.findByEscolaridadName(escolaridadSearch);
			RequestContext.getCurrentInstance().update("escolaridadForm:escolaridadTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(Escolaridad esc) {

		try {
			escolaridadAction.remove(esc);
			escolaridadList = escolaridadAction.findAll();
			RequestContext.getCurrentInstance().update("escolaridadForm:escolaridadTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clean(){
		escolaridadList = new ArrayList<Escolaridad>();
		RequestContext.getCurrentInstance().update("escolaridadForm:escolaridadTable");
	}
	
	public void edit(Escolaridad esc){
		isNew = Boolean.FALSE;
		escolaridad = new Escolaridad();	
		escolaridad = esc;
		
		RequestContext.getCurrentInstance().update("escolaridadForm:insertDialog");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public void handleClose(CloseEvent event) {
		escolaridad = new Escolaridad();
		RequestContext.getCurrentInstance().update("escolaridadForm:insertDialog");
	}
	
	public void prueba(){
		System.out.println("prueba");
	}

	public Escolaridad getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(Escolaridad escolaridad) {
		this.escolaridad = escolaridad;
	}

	public Escolaridad getEscolaridadSearch() {
		return escolaridadSearch;
	}

	public void setEscolaridadSearch(Escolaridad escolaridadSearch) {
		this.escolaridadSearch = escolaridadSearch;
	}

	public String getRegexText() {
		return regexText;
	}

	public void setRegexText(String regexText) {
		this.regexText = regexText;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public List<Escolaridad> getEscolaridadList() {
		return escolaridadList;
	}

	public void setEscolaridadList(List<Escolaridad> escolaridadList) {
		this.escolaridadList = escolaridadList;
	}
}
