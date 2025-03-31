package org.example.task1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PersonDAO {
    private static EntityManagerFactory emf;

    static {
        int retries = 5;
        while (retries > 0) {
            try {
                emf = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
                System.out.println("Успешное подключение к базе данных.");
                break;
            } catch (Exception e) {
                retries--;
                System.err.println("Не удалось подключиться к базе данных. Повторная попытка...");
                if (retries == 0) {
                    e.printStackTrace();
                    throw new ExceptionInInitializerError("Не удалось инициализироваться после нескольких попыток.");
                }
                try {
                    Thread.sleep(5000); // Ожидание 5 секунд, прежде чем повторить попытку
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Метод добавления person в базу данных
    public void addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Метод вывода списка всех person из базы данных
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    // Метод удаления person по идентификатору ID
    public boolean deletePerson(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Person person = em.find(Person.class, id);
            if (person != null) {
                em.remove(person);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    // Метод выхода из программы
    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}