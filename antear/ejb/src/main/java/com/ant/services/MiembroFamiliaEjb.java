package com.ant.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.MiembroFamilia;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class MiembroFamiliaEjb  extends GenericDAOImpl<MiembroFamilia, Integer>{

}
