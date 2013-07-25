package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Medicamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return super.toString()+
				" [Id="+getId()+
				", Name="+getName()+"]";
	}
}
