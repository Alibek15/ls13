package org.alibek.ls13.service;

import org.alibek.ls13.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DbServiceImpl {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");
    //работа с entity
    public static void createStudent(String name, Integer age){

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction =null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            Student student = new Student(); //new student(null, name,age); через конструктор
            //делать через сетеры если сущность будет расширятся
            student.setName(name);
            student.setAge(age);

            manager.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            manager.close();
        }
    }

    public static List<Student> getAllStudents(){
        List<Student> students = new ArrayList<Student>();

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        //создаем фабрику которая будет генерировать и стыковать студентов с нашей бд



        //ACID

        EntityTransaction transaction = null;

        try{
            //Get a transaction
            transaction=manager.getTransaction();
            //Begin transaction
            transaction.begin();

            //get a list of students
            students = manager.createQuery("Select s From Student s", Student.class).getResultList();
            // commit out transaction
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally{
            manager.close();
        }
        return students;
    }

    public static void deleteStudent(Long id){
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction =null;

        try{
            transaction = manager.getTransaction();

            transaction.begin();

            Student student = manager.find(Student.class, id);

            if(student != null){
                manager.remove(student);
                transaction.commit();
            }

        } catch (Exception e) {

            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            manager.close();
        }
    }
    public static void updateStudent(Long id, String name, Integer age){

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction =null;


        try{
            transaction = manager.getTransaction();

            transaction.begin();

            Student student = manager.find(Student.class, id);

            if(student != null){
                student.setName(name);
                student.setAge(age);
                manager.persist(student);
                transaction.commit();
            }

        } catch (Exception e) {

            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            manager.close();
        }
    }

}
//CRUD full
