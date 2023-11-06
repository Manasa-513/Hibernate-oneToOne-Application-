package com.anudip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.onetoone.model.Passport;
import com.onetoone.model.Person;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 
         Configuration cfg=new Configuration();
         cfg.configure("hibernate.cfg.xml");
         SessionFactory factory=cfg.buildSessionFactory();
         Session session =factory.openSession();
         try
         {
        	 Person s1=new Person();
        	 s1.setName("manu");
        	 Passport p1=new Passport();
        	 p1.setPassportnum(8754373);
        	 s1.setPassport(p1);
        	 p1.setPerson(s1);
        	 session.beginTransaction();
        	 session.save(s1);
        	 session.getTransaction().commit();
        	 
        	 Person r1=session.get(Person.class,s1.getId());
        	 Passport r2=r1.getPassport();
        	 System.out.println("Person:"+r1.getName());
        	 System.out.println("Passport:"+r2.getPassportnum());
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
         finally
         {
        	 session.close();
        	 factory.close();
         }
         
         

    }
}
