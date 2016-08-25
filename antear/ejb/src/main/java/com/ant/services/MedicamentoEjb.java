package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Medicamento;
import com.ant.entities.Paciente;
import com.ant.entities.SituacionEconomica;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class MedicamentoEjb  extends GenericDAOImpl<Medicamento, Integer>{

	public List<Medicamento> findByMedicamentoName(Medicamento med) throws Exception{
		List<Medicamento> list = new ArrayList<Medicamento>();
		
		if(med.getMNombre().equals(new String("")))
		{
				list = findAll();
		}
		else
		{
			
			String query = "SELECT u FROM Medicamento u where ";
			if(!med.getMNombre().equals(new String("")))
				query+= "u.mNombre like '%"+med.getMNombre()+"%'";
			/*	
			else{
				if(!pac.getPApellido().equals(new String("")))
					query+= " u.pApellido like '%"+pac.getPApellido()+"%'";
				else{
					query+= " and u.pApellido like '%"+pac.getPApellido()+"%'";
				}
			}*/
			list = find(query);
			
			return list;
		}
		return list;
	}

	
	public Medicamento findByPaciente2(Paciente paciente){
		List<Medicamento> list = new ArrayList<Medicamento>();
		Medicamento medicamento = new Medicamento();
		String query = "SELECT u FROM Medicamento u where u.paciente.pId = "+paciente.getPId();
		try {
			list = find(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Medicamento aux : list) {
			medicamento =aux;
		}
		return medicamento;
	}
}


