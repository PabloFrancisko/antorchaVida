package com.ant.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.PacienteArea;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class PacienteAreaEjb extends GenericDAOImpl<PacienteArea, Integer>{

}
