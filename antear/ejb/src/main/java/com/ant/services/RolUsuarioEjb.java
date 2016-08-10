package com.ant.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.RolUsuario;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class RolUsuarioEjb extends GenericDAOImpl<RolUsuario, Integer>{

}
