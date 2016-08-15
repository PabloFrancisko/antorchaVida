package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.RolUsuario;
import com.ant.entities.Usuario;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class RolUsuarioEjb extends GenericDAOImpl<RolUsuario, Integer>{

	public RolUsuarioEjb(){
		
	}
	
	public RolUsuario findByUser(Usuario user){
		RolUsuario userFinded = new RolUsuario();
		List<RolUsuario> list = new ArrayList<RolUsuario>();
		
		String query = "SELECT u FROM RolUsuario u where u.usuario.usuNombre ='"+user.getUsuNombre()+"'";
		try {
			list = find(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(RolUsuario aux : list){
			userFinded = aux;
		}
		return userFinded;
	}
}
