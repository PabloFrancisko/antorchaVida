package com.ant.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ant.entities.Area;
import com.ant.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class AreaEjb extends GenericDAOImpl<Area, Integer>{

}
