package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Representante;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class RepresentanteEjb  extends GenericDAOImpl<Representante, Integer>{
	
	public List<Representante> findByRepresentanteName(Representante rep) throws Exception{
		List<Representante> list = new ArrayList<Representante>();
		
		if(rep.getRNombre().equals(new String("")) && rep.getRApellido().equals(new String("")))
		{
				list = findAll();
		}
		else
		{
			
			String query = "SELECT u FROM Representante u where ";
			if(!rep.getRNombre().equals(new String(""))){
				query+= "u.rNombre like '%"+rep.getRNombre()+"%'";
				System.out.println(query);}
			else{
				if(!rep.getRApellido().equals(new String("")))
					query+= " u.rApellido like '%" + rep.getRApellido()+"%'";
				else{
					query+= " and u.rApellido like '%" + rep.getRApellido()+"%'";
				}
			}
			list = find(query);
			
			return list;
		}
		return list;
	}
	

}
