package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Paciente;
import com.ant.entities.SituacionEconomica;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class SituacionEconomicaEjb  extends GenericDAOImpl<SituacionEconomica, Integer>{
	public List<SituacionEconomica> findBySituacionEconomicaName(SituacionEconomica sit) throws Exception{
		List<SituacionEconomica> list = new ArrayList<SituacionEconomica>();
		
		if(sit.getSeMadre().equals(new String(""))&&sit.getSePadre().equals(new String("")))
		{
				list = findAll();
		}
		else
		{
			
			String query = "SELECT u FROM SituacionEconomica u where ";
			if(!sit.getSeMadre().equals(new String("")))
				query+= "u.seMadre like '%"+sit.getSeMadre()+"%'";
				
			else{
				if(!sit.getSePadre().equals(new String("")))
					query+= " u.sePadre like '%"+sit.getSePadre()+"%'";
				else{
					query+= " and u.sePadre like '%"+sit.getSePadre()+"%'";
				}
			}
			list = find(query);
			
			return list;
		}
		return list;
	}
	
	
	public SituacionEconomica findByPaciente(Paciente paciente){
		List<SituacionEconomica> list = new ArrayList<SituacionEconomica>();
		SituacionEconomica situacionEconomica = new SituacionEconomica();
		String query = "SELECT u FROM SituacionEconomica u where u.paciente.pId = "+paciente.getPId();
		try {
			list = find(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (SituacionEconomica aux : list) {
			situacionEconomica =aux;
		}
		return situacionEconomica;
	}

}
