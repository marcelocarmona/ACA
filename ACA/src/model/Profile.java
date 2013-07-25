package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
abstract public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue private long id;
	
	public Profile(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
