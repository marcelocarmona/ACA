import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;  
import org.primefaces.component.menuitem.MenuItem;  
import org.primefaces.component.submenu.Submenu;  
import org.primefaces.model.DefaultMenuModel;  
import org.primefaces.model.MenuModel;  

@ManagedBean
@RequestScoped
public class MenuBean {  
  
    private MenuModel model; 
    private String name;
    private String activePage="a";
  
    public MenuBean() {  
        model = new DefaultMenuModel();  
        
        //First submenu  
        Submenu submenu = new Submenu();  
        submenu.setLabel("Dynamic Submenu 1");  
          
        MenuItem item = new MenuItem();  
        item.setValue("Dynamic Menuitem 1.1");  
        item.setUrl("google.com");  
        submenu.getChildren().add(item);  
          
        model.addSubmenu(submenu);  
          
        //Second submenu  
        submenu = new Submenu();  
        submenu.setLabel("Dynamic Submenu 2");  
          
        item = new MenuItem();  
        item.setValue("Dynamic Menuitem 2.1");  
        item.setUrl("#");  
        submenu.getChildren().add(item);  
          
        item = new MenuItem();  
        item.setValue("Dynamic Menuitem 2.2");  
        item.setUrl("#");  
        submenu.getChildren().add(item);  
          
        model.addSubmenu(submenu);  
    }  
  
    public MenuModel getModel() {  
        return model;  
    }     
      
    public String getActivePage() {
		return activePage;
	}

	public void setActivePage(String activePage) {
		this.activePage = activePage;
	}

	public String getName(){
    	return name;
    }
    public void save() {  
    	name= "pepe";
    	setActivePage("a");
        addMessage("Data saved");  
    }  
      
    public void update() {  
    	setActivePage("b");
        addMessage("Data updated");  
    }  
      
    public void delete() {  
        addMessage("Data deleted");  
    }  
      
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}  