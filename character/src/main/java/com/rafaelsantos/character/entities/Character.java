package com.rafaelsantos.character.entities;

import java.io.Serializable;
import java.util.Objects;

public class Character implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String world;
	
	public Character() {
		
	}
	
	public Character(Long id, String name, String world) {
		super();
		this.id = id;
		this.name = name;
		this.world = world;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorld() {
		return world;
	}

	public void setWorld(String world) {
		this.world = world;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		return Objects.equals(id, other.id);
	}
}
