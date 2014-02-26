package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.User;
import acceso.HiberjpaFactoryDAO;
import acceso.UserDAO;

@FacesConverter(value = "userConverter")
public class UserConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		UserDAO userDAO = HiberjpaFactoryDAO.getInstance().getUser();
		return userDAO.encontrar(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		System.out.println(value);
		return String.valueOf(((User) value).getId());
	}

}
