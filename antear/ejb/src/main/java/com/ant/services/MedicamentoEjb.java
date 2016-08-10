package com.ant.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Medicamento;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class MedicamentoEjb  extends GenericDAOImpl<Medicamento, Integer>{

}
