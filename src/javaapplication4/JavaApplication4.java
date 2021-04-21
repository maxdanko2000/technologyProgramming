package javaapplication4;

import entity.Gruppyi;
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
      String hql1 = "from Gruppyi a";
      Query query = (Query) session.createQuery(hql);
      Query query1 = (Query) session.createQuery(hql);
      List <Studentyi> rows;
       rows = query.list();
      List <Gruppyi> rows1;
       rows1 = query1.list();
       
       rows.forEach((row) -> {
           System.out.println(row.getImya() + " " + row.getFamiliya() + " " + row.getOtchestvo());
       });
       rows1.forEach((row) -> {
           System.out.println(row.getNazvanie());
       });
   }
   
}
