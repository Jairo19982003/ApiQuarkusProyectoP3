package test.Resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Comentario;
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
    public Response saveComentario( Comentario com) {
        try{
            System.out.printf("Comentario: %s\n", com);
            comentario.save(com);
        return Response.ok("Comentario guardado").build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity("Error al guardar el comentario").build();
        }
    }
}
