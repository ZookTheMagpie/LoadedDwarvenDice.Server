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
import java.lang.reflect.*;

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
    public Response addCharacterSheet(@QueryParam("name") Long id, String valueID, String value) throws IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException
    {
       
        if (id != null) 
        {
            CharacterSheet cs; 
            
            CharacterSheetList csl = em.find(CharacterSheetList.class, id);
            if (csl == null) 
            {
               cs = new CharacterSheet(id);
            } else
            {
               cs = getCharacterSheet(id);
            }
            
            String setType = "set" + valueID;
            
            Method setCall = cs.getClass().getMethod(setType, String.class);
            setCall.invoke(cs, value);
              
            return Response.ok(cs).build();
        } else 
        {
            return Response.noContent().build();
        }
    }
}
