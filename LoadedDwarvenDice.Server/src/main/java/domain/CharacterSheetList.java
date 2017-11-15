package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.AllArgsConstructor;

/**
 *
 * @author Alexander Eilert Berg
 */
@Entity
@Data
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = CharacterSheetList.QUERY_FINDALL, query = "SELECT csl FROM CharacterSheetList csl")})
public class CharacterSheetList implements Serializable
{

    public static final String QUERY_FINDALL = "findAll";
    @Id
    @GeneratedValue
    Long id;

    @OneToMany(mappedBy = "characterSheetList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<CharacterSheet> characterSheets;

    public CharacterSheetList()
    {
    }

    public CharacterSheetList(Long id)
    {
        this.id = id;
    }

    public List<CharacterSheet> getCharacterSheets()
    {
        if (characterSheets == null) {
            characterSheets = new ArrayList<>();
        }
        return characterSheets;
    }
}
