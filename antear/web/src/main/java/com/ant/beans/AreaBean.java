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
import com.ant.entities.Usuario;
import com.ant.services.AreaEjb;

@ManagedBean(name = "areaBean")
@SessionScoped

public class AreaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4342510455248792416L;

	/**
	 * 
	 */

	private Area area = new Area();

	private Area areaSearch = new Area();
	private String regexText = new String();
	private Boolean isNew = new Boolean(Boolean.TRUE);
	
	private List<Area> areaList = new ArrayList<Area>();
	

	@EJB
	AreaEjb areaAction;

	public void save() {

		try {
			if(isNew){
				areaAction.persist(area);
				area = new Area();
			}
			else{
				areaAction.merge(area);
				area = new Area();
				isNew = Boolean.TRUE;
			}
			RequestContext.getCurrentInstance().update("areaForm:insertDialog");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			areaList = areaAction.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().update("areaForm:areaTable");


	}

	public void search() {

		try {
			areaList = areaAction.findByAreaName(areaSearch);
			RequestContext.getCurrentInstance().update("areaForm:areaTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Area are) {

		try {
			areaAction.remove(are);
			areaList = areaAction.findAll();
			RequestContext.getCurrentInstance().update("areaForm:areaTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clean() {
		areaList = new ArrayList<Area>();
		RequestContext.getCurrentInstance().update("areaForm:areaTable");
	}

	public void edit(Area are) {
		isNew = Boolean.FALSE;
		area = new Area();	
		area = are;	
	
		RequestContext.getCurrentInstance().update("areaForm:insertDialog");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}

	public void handleClose(CloseEvent event) {
		area = new Area();
		RequestContext.getCurrentInstance().update("areaForm:insertDialog");
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getRegexText() {
		return regexText;
	}

	public void setRegexText(String regexText) {
		this.regexText = regexText;
	}

	public Area getAreaSearch() {
		return areaSearch;
	}

	public void setAreaSearch(Area areaSearch) {
		this.areaSearch = areaSearch;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

}