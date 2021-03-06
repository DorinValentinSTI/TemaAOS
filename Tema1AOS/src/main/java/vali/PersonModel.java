package vali;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class PersonModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;

	public int getId() {

		return this.id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public String getEmail() {

		return this.email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getName() {

		return this.name;

	}

	public void setName(String name) {

		this.name = name;

	}
}
