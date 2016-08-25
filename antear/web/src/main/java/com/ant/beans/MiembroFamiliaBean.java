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

import com.ant.entities.MiembroFamilia;
import com.ant.services.MiembroFamiliaEjb;
import com.ant.utils.SHA;

@ManagedBean(name="miembroFamiliaBean")
@SessionScoped
public class MiembroFamiliaBean implements Serializable{

	private static final long serialVersionUID = -6023334798856763958L;
	
	private MiembroFamilia miembroFamilia = new MiembroFamilia();
	private MiembroFamilia miembroFamiliaSearch = new MiembroFamilia();

	private String regexText = new String();
	private Boolean isNew = new Boolean(Boolean.TRUE);
	private List<MiembroFamilia> miembroFamiliaList = new ArrayList<MiembroFamilia>();
		
	@EJB
	MiembroFamiliaEjb miembroFamiliaAction;
	
	public void save() {

		try {
			if(isNew){
				miembroFamiliaAction.persist(miembroFamilia);
				miembroFamilia = new MiembroFamilia();
			}
			else{
				miembroFamiliaAction.merge(miembroFamilia);
				miembroFamilia = new MiembroFamilia();
				isNew = Boolean.TRUE;
			}
			RequestContext.getCurrentInstance().update("miembroFamiliaForm:insertDialog");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void search() {

		try {
			miembroFamiliaList = miembroFamiliaAction.findByMiembroFamiliaName(miembroFamiliaSearch);
			RequestContext.getCurrentInstance().update("miembroFamiliaForm:miembroFamiliaTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(MiembroFamilia mf) {

		try {
			miembroFamiliaAction.remove(mf);
			miembroFamiliaList = miembroFamiliaAction.findAll();
			RequestContext.getCurrentInstance().update("miembroFamiliaForm:miembroFamiliaTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clean(){
		miembroFamiliaList = new ArrayList<MiembroFamilia>();
		RequestContext.getCurrentInstance().update("miembroFamiliaForm:miembroFamiliaTable");
	}
	
	public void edit(MiembroFamilia mf){
		isNew = Boolean.FALSE;
		miembroFamilia = new MiembroFamilia();	
		miembroFamilia = mf;
		
		RequestContext.getCurrentInstance().update("miembroFamiliaForm:insertDialog");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public void handleClose(CloseEvent event) {
		miembroFamilia = new MiembroFamilia();
		RequestContext.getCurrentInstance().update("miembroFamiliaForm:insertDialog");
	}
	
	public void prueba(){
		System.out.println("prueba");
	}

	public MiembroFamilia getMiembroFamilia() {
		return miembroFamilia;
	}

	public void setMiembroFamilia(MiembroFamilia miembroFamilia) {
		this.miembroFamilia = miembroFamilia;
	}

	public MiembroFamilia getMiembroFamiliaSearch() {
		return miembroFamiliaSearch;
	}

	public void setMiembroFamiliaSearch(MiembroFamilia miembroFamiliaSearch) {
		this.miembroFamiliaSearch = miembroFamiliaSearch;
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

	public List<MiembroFamilia> getMiembroFamiliaList() {
		return miembroFamiliaList;
	}

	public void setMiembroFamiliaList(List<MiembroFamilia> miembroFamiliaList) {
		this.miembroFamiliaList = miembroFamiliaList;
	}
}