package com.ant.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ant.beans.PacienteBean;
import com.ant.entities.Area;

@FacesConverter("areaConverter")
public class AreaConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
			Area car = new Area();
			try {
				PacienteBean service = (PacienteBean)fc.getExternalContext().getSessionMap().get("pacienteBean");
				for(Area aux: service.getAreaList())
				{
					if(!value.equals("Seleccione Uno")){
						if(aux.getAId()==Integer.parseInt(value))
							car = aux;
					}
					else
						car = null;
				}
				return car;
			} catch(NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
			}
		}
		else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if(object != null) {
			return String.valueOf(((Area) object).getAId());
		}
		else {
			return null;
		}
	}   
}
