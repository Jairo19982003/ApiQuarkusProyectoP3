package test.Resources;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Comentario;
import model.Request;
import test.Services.Implementacion.ComentarioService;

import java.util.List;

@Path("/Comentario")
public class ComentarioResource {

    @Inject
    ComentarioService comentario;

    @GET
    @Path("/comentarioId")
    //se utiliza para obtener un comentario
    public Comentario getComentario() {
        System.out.println("Comentario: " + comentario.getComentario());
        return comentario.getComentario();
    }

    @GET
    public List<Comentario> getComentarios(){
        return comentario.getComentarios();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    //se utiliza para guardar un comentario
    public Response createComentario(Request comentarioRequest) {
        try{
            System.out.printf("Comentario: %s\n", comentarioRequest);
                Comentario comentarior = new Comentario();
                comentarior.setComentario(comentarioRequest.getComentario());
                comentarior.setFecha(comentarioRequest.getFecha());
                comentarior.setUsuario(comentarioRequest.getUsuario());
                comentarior.setProject(comentarioRequest.getProject());

                comentario.save(comentarior);


        return Response.ok("Comentario guardado"+ comentarior).build();
        }catch (PersistenceException e){
            throw e;
//            return Response.status(Response.Status.BAD_REQUEST).entity("Error al guardar el comentario").build();
        }
    }

    @GET
    @Path("/paginated")
    //http://localhost:8080/Comentario/paginated?page=2
    public PaginatedReponse<Comentario> list(@QueryParam("page")@DefaultValue("1") int page) {
        return comentario.paginated(page);
    }
}
