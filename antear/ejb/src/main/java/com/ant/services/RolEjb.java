package com.ant.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Rol;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class RolEjb  extends GenericDAOImpl<Rol, Integer>{

}
