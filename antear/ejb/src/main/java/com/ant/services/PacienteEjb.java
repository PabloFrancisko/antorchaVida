package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import com.ant.entities.Paciente;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class PacienteEjb  extends GenericDAOImpl<Paciente, Integer>{
	public List<Paciente> findByPacienteName(Paciente pac) throws Exception{
		List<Paciente> list = new ArrayList<Paciente>();
		
		if(pac.getPNombre().equals(new String(""))&&pac.getPApellido().equals(new String("")))
		{
				list = findAll();
		}
		else
		{
			
			String query = "SELECT u FROM Paciente u where ";
			if(!pac.getPNombre().equals(new String("")))
				query+= "u.pNombre like '%"+pac.getPNombre()+"%'";
				
			else{
				if(!pac.getPApellido().equals(new String("")))
					query+= " u.pApellido like '%"+pac.getPApellido()+"%'";
				else{
					query+= " and u.pApellido like '%"+pac.getPApellido()+"%'";
				}
			}
			list = find(query);
			
			return list;
		}
		return list;
	}

}
