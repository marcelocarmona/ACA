package backingBeans;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

import anotations.ExceptionHandler;

public class CrudController<T> {
	
	private Class<T> type;
	
	//State
	private boolean editing = false;
	
	// Domain model related variables
	private T object ;
	private List<T> objects = list();
	
	public CrudController(Class<T> t) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        type = t;
        object = type.newInstance();
        //newObject();
	}
	
	
	public boolean isEditing() {
		return editing;
	}
	public void setEditing(boolean editing) {
		this.editing = editing;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	
	//listo desde este get
	public List<T> getObjects() {
		objects = list();
		return objects;
	}
	public void setObjects(List<T> objects) {
		this.objects = objects;
	}


	public void newObject(){
		try {
			object = type.getConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
    public void edit(T object){
    	this.object = object;
    }


    @ExceptionHandler
	public void save(){
		hookSave();
		newObject();
	}

    //Subclass responsibility
    private void hookSave() {}


	@ExceptionHandler
	public void remove (T object){
		hookRemove(object);
	}

	//Subclass responsibility
    private void hookRemove(T object2) {}


	@ExceptionHandler
	public void merge(){
		hookMerge();
		newObject();
	}

	//Subclass responsibility
    private void hookMerge() {}


	@ExceptionHandler
	public List<T> list(){
		return hookList();
	}

	//Subclass responsibility
	private List<T> hookList() {return null;}

}
