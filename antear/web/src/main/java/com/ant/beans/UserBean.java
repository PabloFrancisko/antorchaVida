package com.ant.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
//
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;

import com.ant.entities.Rol;
import com.ant.entities.RolUsuario;
import com.ant.entities.Usuario;
import com.ant.services.RolEjb;
import com.ant.services.RolUsuarioEjb;
import com.ant.services.UsuarioEjb;
import com.ant.utils.SHA;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7927820995066852655L;
	/**
	 * 
	 */
	

	
	
	private Usuario user = new Usuario();
	private Usuario userSearch = new Usuario();
	private String passwordWSSH1 = new String();
	private String passwordWSSH2 = new String();
	private SHA sha = new SHA();
	private Calendar cal = Calendar.getInstance();
	private RolUsuario userRole = new RolUsuario();
	
	private String regexText = new String();
	
	private List<Rol> roleList = new ArrayList<Rol>();
	private List<Usuario> userList = new ArrayList<Usuario>();
	
	private Boolean isNew = new Boolean(Boolean.TRUE);
	
	@EJB
	UsuarioEjb userAction;
	
	@EJB
	RolEjb roleAction;
	
	@EJB
	RolUsuarioEjb userRoleAction;
	
//	@PostConstruct
//    public void init() {
//		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//		RequestContext requestContext = RequestContext.getCurrentInstance();
//		requestContext.execute("PF('subscriber').connect('/" + ec.getUserPrincipal().getName() + "')");
//    }
	
	
	
	public void save(){
		
		if(verifyPassword()){
			if(isNew){
				try {
					
					user.setUsuPass(sha.encrypt(passwordWSSH1));					
					userAction.persist(user);
					userRole.setUsuario(user);					
					userRoleAction.persist(userRole);					
					user = new Usuario();
					userRole = new RolUsuario();
					
					RequestContext.getCurrentInstance().update("userForm:insertDialog");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//PIRUJA
			else{
				try {
					userAction.merge(user);
					userRole.setUsuario(user);					
					userRoleAction.merge(userRole);
					isNew = Boolean.TRUE;
					user = new Usuario();
					userRole = new RolUsuario();
					RequestContext.getCurrentInstance().update("userForm:insertDialog");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				userList = userAction.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestContext.getCurrentInstance().update("userForm:userTable");
		}
		
		
	}
	
	public void prueba(){
		System.out.println("prueba");
	}
	
	public boolean verifyPassword(){
		if(passwordWSSH1.isEmpty()||!passwordWSSH1.equals(passwordWSSH2)){
			RequestContext.getCurrentInstance().update("userForm:insertDialog");
			return false;
		}
		else 
			return true;
	}
	
	public void search(){
		
		try {
			userList = userAction.findByUserName(userSearch);
			RequestContext.getCurrentInstance().update("userForm:userTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void delete(Usuario usr){
		
		RolUsuario usrole = new RolUsuario();
		try {
			usrole = userRoleAction.findByUser(usr);
			userRoleAction.remove(usrole);
			userAction.remove(usr);
			userList = userAction.findAll();
			RequestContext.getCurrentInstance().update("userForm:userTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clean(){
		userList = new ArrayList<Usuario>();
		RequestContext.getCurrentInstance().update("userForm:userTable");
	}
	
	public void edit(Usuario usr){
		isNew = Boolean.FALSE;
		user = new Usuario();	
		user = usr;
		userRole = userRoleAction.findByUser(usr);
		
		passwordWSSH1 = new String();
		passwordWSSH1 = new String();
		RequestContext.getCurrentInstance().update("userForm:insertDialog");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public void handleClose(CloseEvent event) {
		user = new Usuario();
		userRole = new RolUsuario();
		isNew = Boolean.TRUE;
		RequestContext.getCurrentInstance().update("userForm:insertDialog");
    }

	public List<Rol> getRoleList() {
		try {
			roleList = roleAction.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleList;
	}

	public void setRoleList(List<Rol> roleList) {
		this.roleList = roleList;
	}

	public List<Usuario> getUserList() {
		return userList;
	}

	public void setUserList(List<Usuario> userList) {
		this.userList = userList;
	}
	

	
}
