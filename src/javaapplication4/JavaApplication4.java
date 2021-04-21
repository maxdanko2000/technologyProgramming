package javaapplication4;

import entity.Studentyi;
import java.util.List;
import javax.persistence.Query;
import utils.NewHibernateUtil;
import org.hibernate.Session;
public class JavaApplication4 {
  
   public static void main(String[] args){
      Session session = NewHibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      String hql = "from Studentyi a where s.gruppyi.shifr = :param";
      Query query = (Query) session.createQuery(hql);
      
      List <Studentyi> rows = query.getResultList();
    
       rows.forEach((row) -> {
           System.out.println(row.getImya() + " " + row.getFamiliya() + " " + row.getOtchestvo());
       });
      
   }
   
}
