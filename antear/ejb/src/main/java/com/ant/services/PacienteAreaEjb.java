package com.ant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Paciente;
import com.ant.entities.PacienteArea;
import com.ant.entities.SituacionEconomica;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class PacienteAreaEjb extends GenericDAOImpl<PacienteArea, Integer> {

	public List<PacienteArea> findByAreaPaciente(Paciente paciente) throws Exception {
		List<PacienteArea> list = new ArrayList<PacienteArea>();

		String query = "SELECT u FROM PacienteArea u where u.paciente.pId = "+paciente.getPId();

		list = find(query);

		return list;
	}

}
