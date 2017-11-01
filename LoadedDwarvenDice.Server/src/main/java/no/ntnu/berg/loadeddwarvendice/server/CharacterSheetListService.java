package no.ntnu.berg.loadeddwarvendice.server;

import domain.CharacterSheet;
import domain.CharacterSheetList;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * TODO: Add documentation
 *
 * @author Alexander Eilert Berg
 */
@Path("characterSheets")
public class CharacterSheetListService
{

    @PersistenceContext
    EntityManager em;

    /**
     *
     * @param name
     * @return
     */
    @GET
    public List<CharacterSheet> getCharacterSheets(@QueryParam("name") String name)
    {
        List<CharacterSheet> result = null;
        if (name != null) {
            TypedQuery<CharacterSheet> q = em.createQuery("SELECT cs FROM CharacterSheet cs WHERE cs.characterSheetList.id = :id",
                    CharacterSheet.class);
            result = q.setParameter("id", name).getResultList();
        }
        return result != null ? result : Collections.EMPTY_LIST;
    }

    @POST
    @Path("add")
    public Response addCharacterSheet(@QueryParam("name") Long id, CharacterSheet characterSheet)
    {
        if (id != null) 
        {
            CharacterSheetList csl = em.find(CharacterSheetList.class, id);
            if (csl == null) 
            {
                csl = new CharacterSheetList(id);
                em.persist(csl);
            }
            characterSheet.setCharacterSheetList(csl);
            em.persist(characterSheet);
            
            return Response.ok(characterSheet).build();
        } else 
        {
            return Response.noContent().build();
        }
    }
}
