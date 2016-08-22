package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Representante;
import com.ant.entities.Usuario;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class RepresentanteEjb  extends GenericDAOImpl<Representante, Integer>{
	
	public List<Representante> findByRepresentanteName(Representante rep) throws Exception{
		List<Representante> list = new ArrayList<Representante>();
		
		if(rep.getRNombre().equals(null) && rep.getRApellido().equals(null))
		{
				list = findAll();
		}
//		else
//		{
//			String query = "SELECT u FROM representante u where ";
//			if(!rep.getRNombre().equals(new String("")))
//				query+= "u.repName like '%"+rep.getRNombre()+"%'";
//			else{
//				if(!rep.getRApellido().equals(new String("")))
//					query+= "u.repLastname like '%"+rep.getRApellido()+"%'";
//				else{
//					query+= " and u.repLastname like '%"+rep.getRApellido()+"%'";
//				}
//			}
//			list = find(query);
//			
//			return list;
//		}
		return list;
	}

}
