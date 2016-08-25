package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.MiembroFamilia;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class MiembroFamiliaEjb  extends GenericDAOImpl<MiembroFamilia, Integer>{
	
	public List<MiembroFamilia> findByMiembroFamiliaName(MiembroFamilia mf) throws Exception{
		List<MiembroFamilia> list = new ArrayList<MiembroFamilia>();
		
		if(mf.getMfNombre().equals(new String("")) && mf.getMfApellido().equals(new String("")))
		{
				list = findAll();
		}
		else
		{
			
			String query = "SELECT u FROM MiembroFamilia u where ";
			if(!mf.getMfNombre().equals(new String(""))){
				query+= "u.mfNombre like '%"+mf.getMfNombre()+"%'";
				System.out.println(query);}
			else{
				if(!mf.getMfApellido().equals(new String("")))
					query+= " u.mfApellido like '%" + mf.getMfApellido()+"%'";
				else{
					query+= " and u.mfApellido like '%" + mf.getMfApellido()+"%'";
				}
			}
			list = find(query);
			
			return list;
		}
		return list;
	}
	

}
