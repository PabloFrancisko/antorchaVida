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

import com.ant.entities.SituacionEconomica;

import com.ant.services.SituacionEconomicaEjb;

@ManagedBean(name = "situacionEconomicaBean")
@SessionScoped

public class SituacionEconomicaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7112471807576768928L;

	/**
	 * 
	 */


	private SituacionEconomica situacionEconomica = new SituacionEconomica();

	private SituacionEconomica situacionEconomicaSearch = new SituacionEconomica();
	private String regexText = new String();
	private Boolean isNew = new Boolean(Boolean.TRUE);
	
	private List<SituacionEconomica> situacionEconomicaList = new ArrayList<SituacionEconomica>();
	

	@EJB
	SituacionEconomicaEjb situacionEconomicaAction;

	public void save() {

		try {
			if(isNew){
				situacionEconomicaAction.persist(situacionEconomica);
				situacionEconomica = new SituacionEconomica();
			}
			else{
				situacionEconomicaAction.merge(situacionEconomica);
				situacionEconomica = new SituacionEconomica();
				isNew = Boolean.TRUE;
			}
			RequestContext.getCurrentInstance().update("situacionEconomicaForm:insertDialog");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			situacionEconomicaList = situacionEconomicaAction.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().update("situacionEconomicaForm:situacionEconomicaTable");


	}

	public void search() {

		try {
			situacionEconomicaList = situacionEconomicaAction.findBySituacionEconomicaName(situacionEconomicaSearch);
			RequestContext.getCurrentInstance().update("situacionEconomicaForm:situacionEconomicaTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(SituacionEconomica sit) {

		try {
			situacionEconomicaAction.remove(sit);
			situacionEconomicaList = situacionEconomicaAction.findAll();
			RequestContext.getCurrentInstance().update("situacionEconomicaForm:situacionEconomicaTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clean() {
		situacionEconomicaList = new ArrayList<SituacionEconomica>();
		RequestContext.getCurrentInstance().update("situacionEconomicaForm:situacionEconomicaTable");
	}

	public void edit(SituacionEconomica sit) {
		isNew = Boolean.FALSE;
		situacionEconomica = new SituacionEconomica();	
		situacionEconomica = sit;	
	
		RequestContext.getCurrentInstance().update("situacionEconomicaForm:insertDialog");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}

	public void handleClose(CloseEvent event) {
		situacionEconomica = new SituacionEconomica();
		RequestContext.getCurrentInstance().update("situacionEconomicaForm:insertDialog");
	}

	public final SituacionEconomica getSituacionEconomica() {
		return situacionEconomica;
	}

	public final void setSituacionEconomica(SituacionEconomica situacionEconomica) {
		this.situacionEconomica = situacionEconomica;
	}

	public final SituacionEconomica getSituacionEconomicaSearch() {
		return situacionEconomicaSearch;
	}

	public final void setSituacionEconomicaSearch(SituacionEconomica situacionEconomicaSearch) {
		this.situacionEconomicaSearch = situacionEconomicaSearch;
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

	public final List<SituacionEconomica> getSituacionEconomicaList() {
		return situacionEconomicaList;
	}

	public final void setSituacionEconomicaList(List<SituacionEconomica> situacionEconomicaList) {
		this.situacionEconomicaList = situacionEconomicaList;
	}


}