package no.ntnu.berg.loadeddwarvendice.server;

import domain.CharacterSheet;
import domain.CharacterSheetList;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * TODO: Add documentation
 *
 * @author Alexander Eilert Berg
 */
@Path("characterSheets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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
            //Is there supposed to be a ":" before the id at the end?
            TypedQuery<CharacterSheet> q = em.createQuery("SELECT cs FROM CharacterSheet cs WHERE cs.characterSheetList.id = :id",
                    CharacterSheet.class);
            result = q.setParameter("id", name).getResultList();
        }
        return result != null ? result : Collections.EMPTY_LIST;
    }

    @GET
    @Path("characterSheetList")
    public List<CharacterSheetList> getCharacterSheetList()
    {
        return em.createNamedQuery(CharacterSheetList.QUERY_FINDALL, CharacterSheetList.class).getResultList();
    }
    
    
    @POST
    @Path("add")
    public Response addCharacterSheet(@QueryParam("name") Long id, CharacterSheet characterSheet)
    {
        //The problem we are having is that id is null for some reason
        //primitive long can't be null, and needs to be checked for long != 0
        //the wrapper class Long can be null
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
