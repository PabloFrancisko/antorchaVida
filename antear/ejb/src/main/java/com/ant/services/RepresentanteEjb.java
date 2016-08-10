package com.ant.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Representante;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class RepresentanteEjb  extends GenericDAOImpl<Representante, Integer>{

}
