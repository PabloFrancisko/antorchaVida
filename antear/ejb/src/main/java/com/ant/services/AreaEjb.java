package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Area;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class AreaEjb extends GenericDAOImpl<Area, Integer>{
	public List<Area> findByAreaName(Area are) throws Exception{
		List<Area> list = new ArrayList<Area>();
		
		if(are.getACodigo()==0&&are.getANombre().equals(new String("")))
		{
				list = findAll();
		}
		else
		{
			
			String query = "SELECT u FROM Area u where ";
			if(are.getACodigo()!= 0){
				query+= "u.aCodigo = "+are.getACodigo()+" ";
				System.out.println(query);}
			else{
				if(!are.getANombre().equals(new String("")))
					query+= " u.aNombre like '%"+are.getANombre()+"%'";
				else{
					query+= " and u.aNombre like '%"+are.getANombre()+"%'";
				}
			}
			list = find(query);
			
			return list;
		}
		return list;
	}
	
	/*public Area findByCod(Area area){
		Area areaFinded = new Area();
		List<Area> list = new ArrayList<Area>();
		
		String query = "SELECT u FROM Area u where u.area.ACodigo='"+area.getACodigo()+"'";
		try {
			list = find(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Area aux : list){
			areaFinded = aux;
		}
		return areaFinded;
	}*/
}
