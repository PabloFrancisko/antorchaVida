package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Usuario;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class UsuarioEjb  extends GenericDAOImpl<Usuario, Integer>{

	public UsuarioEjb(){
		
	}
	
	public List<Usuario> findByUserName(Usuario usr) throws Exception{
		List<Usuario> list = new ArrayList<Usuario>();
		
		if(usr.getUsuNombre().equals(new String(""))&&usr.getUsuApellido().equals(new String("")))
		{
				list = findAll();
		}
		else
		{
			String query = "SELECT u FROM user u where ";
			if(!usr.getUsuNombre().equals(new String("")))
				query+= "u.usrName like '%"+usr.getUsuNombre()+"%'";
			else{
				if(!usr.getUsuApellido().equals(new String("")))
					query+= "u.usrLastname like '%"+usr.getUsuApellido()+"%'";
				else{
					query+= " and u.usrLastname like '%"+usr.getUsuApellido()+"%'";
				}
			}
			list = find(query);
			
			return list;
		}
		return list;
	}
	
	
	
}
