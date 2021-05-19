

package lab1;

import entity.Studentyi;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;
import utils.NewHibernateUtil;


public class Lab1 {

    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Exercisies exercises = new Exercisies(session);
        List<Studentyi> students = exercises.exercise1();
        for(Studentyi student : students){
            System.out.println(student.toString());
        }
        System.out.println();
        HashMap map = exercises.exercise2();
        System.out.println(map);
//        exercises.exercise3();
        session.getTransaction().commit();
    }
    
}
