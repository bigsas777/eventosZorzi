package web;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named("userSessionBean")
@SessionScoped
public class UserSessionBean implements Serializable {
    private String rol;
    private String nombre;
    private String rolTemporaneo;
    

    public UserSessionBean() {
	}

	public String getRol() {
        return rol;
    }

    public String getRolTemporaneo() {
        return rolTemporaneo;
    }

    public void setRolTemporaneo(String pendingRole) {
        this.rolTemporaneo = pendingRole;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String username) {
        this.nombre = username;
    }

    public void login() {
        this.rol = this.rolTemporaneo;
        System.out.println("NEW LOGIN: " + nombre + " logged in as " + rol);
        
        checkSession();
    }

    public String logout() {
        rol = null;
        rolTemporaneo = null;
        nombre = null;
        return "/index.xhtml?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return rol != null;
    }
    
    @PostConstruct
    public void checkSession() {
        if (rol != null) {
            try {
                if ("propietario".equals(rol)) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/area_propietario.xhtml");
                } else if ("organizador".equals(rol)) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/area_organizador.xhtml");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void authorize(String requiredRole) {
        if (rol == null || !rol.equals(requiredRole)) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
