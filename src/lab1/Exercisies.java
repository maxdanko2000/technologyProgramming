

package lab1;

import java.util.Date;
import entity.Gruppyi;
import entity.Studentyi;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;


public class Exercisies {
    private Session session;
    
    public Exercisies(Session session){
        this.session = session;
    }
    
    public List<Studentyi> exercise1(){
        String sql = "from Studentyi s";
        Query query = session.createQuery(sql);
        
        List<Studentyi> rows = query.list();
        return rows;
    }
    
    public HashMap exercise2(){
        String sql = "from Gruppyi g";
        Query query = session.createQuery(sql);
        
        List<Gruppyi> rowsg = query.list();
        HashMap m = new HashMap();
        for(Gruppyi row : rowsg){
            sql = "from Studentyi s where s.gruppyi.shifr = :param";
            query = session.createQuery(sql);
            query.setParameter("param", row.getShifr());
            List<Studentyi> rows = query.list();
            String[] words = row.getNazvanie().split("-");
            if(m.containsKey(words[0])){
                int amount = (int)m.get(words[0]);
                m.remove(words[0]);
                m.put(words[0], rows.size() + amount);
            } else if(words.length != 0) m.put(words[0], rows.size());
        }
        return m;
    }
    
//    public void exercise3(){
//        String sql = "from Gruppyi g";
//        Query query = session.createQuery(sql);
//        
//        List<Gruppyi> groups = query.list();
//        for(Gruppyi g : groups){
//            Date dt = new Date();
//            if(dt.getYear() - g.getDataFormir().getYear() >= 4){
//                g.setStatus("rasform");
//                g.setStatusDate(dt);
//                Set<Studentyi> studs = g.getStudentyis();
//                for(Studentyi s : studs){
//                    s.setStatus("vipusk");
//                    s.setStatusDate(dt);
//                    session.update(s);
//                }
//                session.update(g);
//            }
//        }
//    }
}
