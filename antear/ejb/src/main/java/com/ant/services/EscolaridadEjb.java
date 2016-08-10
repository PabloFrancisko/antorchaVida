package com.ant.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Escolaridad;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class EscolaridadEjb  extends GenericDAOImpl<Escolaridad, Integer>{

}
