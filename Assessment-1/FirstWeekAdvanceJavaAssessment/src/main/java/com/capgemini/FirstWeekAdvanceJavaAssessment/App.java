package com.capgemini.FirstWeekAdvanceJavaAssessment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();

            IDCard card = new IDCard("IDC101", "14-02-2026");
            Employee emp = new Employee("Abdul", "abdulyahya9973@gmail.com",card);

            
            

            
            emp.setIdCard(card);
            card.setEmployee(emp);

            
            em.persist(emp);

            em.getTransaction().commit();

            System.out.println("Employee Created Successfully");
            System.out.println();

         
            Employee fetchedEmp = em.find(Employee.class, emp.getId());

            System.out.println("Employee Details:");
            System.out.println("ID: " + fetchedEmp.getId());
            System.out.println("Name: " + fetchedEmp.getName());
            System.out.println("Email: " + fetchedEmp.getEmail());
            System.out.println();

            IDCard fetchedCard = fetchedEmp.getIdCard();

            System.out.println("ID Card Details:");
            System.out.println("Card Number: " + fetchedCard.getCardNumber());
            System.out.println("Issue Date: " + fetchedCard.getIssueDate());
            System.out.println();

            
            IDCard cardFromDb = em.find(IDCard.class, fetchedCard.getId());

            System.out.println("Employee from ID Card:");
            System.out.println("Name: " + cardFromDb.getEmployee().getName());

        } finally {
            em.close();
            emf.close();
        }
    }
}
