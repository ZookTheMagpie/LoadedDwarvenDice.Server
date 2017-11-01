package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Alexander Eilert Berg
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@XmlRootElement @XmlAccessorType(XmlAccessType.FIELD)
public class LDDUser implements Serializable
{
    /**
     * TODO: Add encryption god dammit!
     */
    @Id @GeneratedValue
    String userid;
    
    String email;

    /**
     * TODO: Add encryption god dammit!
     */
    @XmlTransient
    String username;
    
    /**
     * TODO: Add encryption god dammit!
     */
    @XmlTransient
    String password;
}
