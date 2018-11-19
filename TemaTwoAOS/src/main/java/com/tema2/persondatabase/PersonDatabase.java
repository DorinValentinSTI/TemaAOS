package com.tema2.persondatabase;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import com.tema2.model.Person;

import java.util.List;



public class PersonDatabase {

    private EntityManagerFactory entityManagerFactory;

    public PersonDatabase(EntityManagerFactory emf) {

        entityManagerFactory = emf;

    }



    public String insertPerson(Person person){

        String status;

        try {

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            try{

                entityManager.getTransaction().begin();

                entityManager.persist(person);

                entityManager.getTransaction().commit();

                status = "Successfully inserted";

            }catch (Exception ex){

                status = ex.getMessage();

                ex.printStackTrace();

                entityManager.getTransaction().rollback();

            }finally {

                entityManager.close();

            }



        }catch (Exception ex){

            status = ex.getMessage();

            ex.printStackTrace();

        }

        return status;

    }



    public List<Person> getPersons(){

        try {

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            try{

                 return entityManager.createQuery("select person from Person person", Person.class).getResultList();

            }catch (Exception ex){

                ex.printStackTrace();

                entityManager.getTransaction().rollback();

            }finally {

                entityManager.close();

            }



        }catch (Exception ex){

            ex.printStackTrace();

        }

        return null;

    }



    public String removePerson(Person person){

        String status;

        try {

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            try{

                entityManager.getTransaction().begin();

                Person mergedPerson = entityManager.merge(person);

                entityManager.remove(mergedPerson);

                entityManager.getTransaction().commit();

                status = "Successfully removed";

            }catch (Exception ex){

                status = ex.getMessage();

                ex.printStackTrace();

                entityManager.getTransaction().rollback();

            }finally {

                entityManager.close();

            }



        }catch (Exception ex){

            status = ex.getMessage();

            ex.printStackTrace();

        }

        return status;

    }



    public Person getPersonById(Integer id) {

        try {

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            try{

                return entityManager.createQuery("select person from Person person where person.id=:id", Person.class).setParameter("id",id  ).getSingleResult();

            }catch (Exception ex){

                ex.printStackTrace();

                entityManager.getTransaction().rollback();

            }finally {

                entityManager.close();

            }



        }catch (Exception ex){

            ex.printStackTrace();

        }

        return null;

    }

    public String updatePerson(Person person){

        String status;

        try {

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            try{

                entityManager.getTransaction().begin();

                Person oldPerson = entityManager.find(Person.class,person.getId());

                oldPerson.setName(person.getName());

                oldPerson.setEmail(person.getEmail());

                oldPerson.setAge(person.getAge());

                entityManager.persist(oldPerson);

                entityManager.getTransaction().commit();

                status = "Successfully inserted";

            }catch (Exception ex){

                status = ex.getMessage();

                ex.printStackTrace();

                entityManager.getTransaction().rollback();

            }finally {

                entityManager.close();

            }



        }catch (Exception ex){

            status = ex.getMessage();

            ex.printStackTrace();

        }

        return status;

    }

}