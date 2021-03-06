package com.tema2.model;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "person", schema = "personaos")
public class Person {

	private int id;
	private String name;
	private String email;
	private int age;

	public Person() {
	}

	public Person(String name, String email, int age) {

		this.name = name;
		this.email = email;
		this.age = age;
	}

	public Person(Integer id, String email, String name, Integer age) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

	@Id
	@Column(name = "id", nullable = false)

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	@Basic
	@Column(name = "name", nullable = false, length = 45)
	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	@Basic
	@Column(name = "email", nullable = true, length = 45)
	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	@Basic
	@Column(name = "age", nullable = false)

	public int getAge() {

		return age;

	}

	public void setAge(int age) {

		this.age = age;

	}

	@Override

	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Person that = (Person) o;

		return id == that.id &&

				age == that.age &&

				Objects.equals(name, that.name) &&

				Objects.equals(email, that.email);

	}

	@Override

	public String toString() {

		return "Person " +"id=" + id +" , name=" + name +" "+", email=" + email +" "+" , age=" + age;

	}

	@Override

	public int hashCode() {

		return Objects.hash(id, name, email, age);

	}

}