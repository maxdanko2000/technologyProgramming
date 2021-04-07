

package javaapplication4;


import entity.Gruppyi;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;




@Entity
public class NewEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;
    private int id;
    @Column(name = "FIRST_NAME")
    
    private String firstName;
    @Column(name = "LAST_NAME")
    
    private String lastName;

     String hql = "from Gruppyi";
 
    
}
