package com.ant.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Paciente;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class PacienteEjb  extends GenericDAOImpl<Paciente, Integer>{

}
