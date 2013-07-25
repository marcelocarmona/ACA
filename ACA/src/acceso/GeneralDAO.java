package acceso;

import java.util.List;

public interface GeneralDAO<T>{
	
	public  List <T> listar();
	
	public void guardar(T t);
	
	public void eliminar(long id); 
	
	public T encontrar(long id);

	public void modificar(T t);

}