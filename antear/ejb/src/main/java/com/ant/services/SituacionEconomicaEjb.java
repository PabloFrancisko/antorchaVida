package com.ant.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.SituacionEconomica;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class SituacionEconomicaEjb  extends GenericDAOImpl<SituacionEconomica, Integer>{

}
