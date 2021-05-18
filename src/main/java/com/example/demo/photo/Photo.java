package com.example.demo.photo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity				// tells JPA, this is mapped to DB schema
@Table(name="photo")
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;

	/* Constructors */
	public Photo() 						{super();this.name = ""; }
	public Photo(String name) 			{ super();this.name = name;}
		
	/* Getters and Setters */
	public Long getId() 				{ return id; }
	// setId is not defined as its auto generated	
	public String getName() 			{ return name; }
	public void setName(String name) 	{ this.name = name; }

	@Override
	public String toString() 			{ return "Photo [id=" + id + ", name=" + name + "]"; }
}
