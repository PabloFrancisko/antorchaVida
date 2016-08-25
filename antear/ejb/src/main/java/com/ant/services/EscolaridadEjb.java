package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Escolaridad;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class EscolaridadEjb  extends GenericDAOImpl<Escolaridad, Integer>{
	
	public List<Escolaridad> findByEscolaridadName(Escolaridad esc) throws Exception{
		List<Escolaridad> list = new ArrayList<Escolaridad>();
		
		if(esc.getENombreInstitucion().equals(new String("")) && esc.getENombreProfesora().equals(new String("")))
		{
				list = findAll();
		}
		else
		{
			
			String query = "SELECT u FROM Escolaridad u where ";
			if(!esc.getENombreInstitucion().equals(new String(""))){
				query+= "u.eNombreInstitucion like '%" + esc.getENombreInstitucion() + "%'";
				System.out.println(query);}
			else{
				if(!esc.getENombreProfesora().equals(new String("")))
					query+= " u.eNombreProfesora like '%" + esc.getENombreProfesora()+"%'";
				else{
					query+= " and u.eNombreProfesora like '%" + esc.getENombreProfesora() + "%'";
				}
			}
			list = find(query);
			
			return list;
		}
		return list;
	}
}
