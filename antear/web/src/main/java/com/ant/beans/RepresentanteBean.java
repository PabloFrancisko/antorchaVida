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

import com.ant.entities.Representante;
import com.ant.services.RepresentanteEjb;
import com.ant.utils.SHA;

@ManagedBean(name="representanteBean")
@SessionScoped
public class RepresentanteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2951457943873626400L;
	/**
	 * 
	 */
	
	

	
	
	private Representante representante = new Representante();
	private Representante representanteSearch = new Representante();

	private String regexText = new String();
	
	private List<Representante> representanteList = new ArrayList<Representante>();
		
	@EJB
	RepresentanteEjb representanteAction;
	
//	@PostConstruct
//    public void init() {
//		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//		RequestContext requestContext = RequestContext.getCurrentInstance();
//		requestContext.execute("PF('subscriber').connect('/" + ec.getUserPrincipal().getName() + "')");
//    }
	
	
	
	public void save(){
		try 
		{
			representanteAction.persist(representante);
			representante = new Representante();
			
			RequestContext.getCurrentInstance().update("representanteForm:insertDialog");
		} 
		
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void search(){
		
		try {
			representanteList = representanteAction.findByRepresentanteName(representanteSearch);
			RequestContext.getCurrentInstance().update("representanteForm:representanteTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(Representante rep){
	
		try {
			representanteAction.remove(rep);
			representanteList = representanteAction.findAll();
			RequestContext.getCurrentInstance().update("representanteForm:representanteTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clean(){
		representanteList = new ArrayList<Representante>();
		RequestContext.getCurrentInstance().update("representanteForm:representanteTable");
	}
	
	public void edit(Representante rep){
		representante = new Representante();	
		representante = rep;
		
		RequestContext.getCurrentInstance().update("representanteForm:insertDialog");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public void prueba(){
		System.out.println("prueba");
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public Representante getRepresentanteSearch() {
		return representanteSearch;
	}

	public void setRepresentanteSearch(Representante representanteSearch) {
		this.representanteSearch = representanteSearch;
	}

	public String getRegexText() {
		return regexText;
	}

	public void setRegexText(String regexText) {
		this.regexText = regexText;
	}

	public List<Representante> getRepresentanteList() {
		return representanteList;
	}

	public void setRepresentanteList(List<Representante> representanteList) {
		this.representanteList = representanteList;
	}
}
//	
//	

//	
//	

//	
//	

//	
//	
//	
