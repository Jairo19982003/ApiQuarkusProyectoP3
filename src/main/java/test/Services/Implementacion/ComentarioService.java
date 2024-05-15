package test.Services.Implementacion;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import model.Comentario;
import test.Repository.ComentarioRepository;
import test.Resources.PaginatedReponse;
import test.Services.IComentarioService;

import java.util.List;

@ApplicationScoped
public class ComentarioService implements IComentarioService {

        @Inject
        ComentarioRepository comentarioRepository;

        @Override
        public void save(Comentario com){
            comentarioRepository.saveComment(com);
        }


        public Comentario getComentario(){
            return comentarioRepository.getComentario();
        }

        public List<Comentario> getComentarios(){
            return comentarioRepository.getComentarios();
        }


        public PaginatedReponse<Comentario> paginated (int page){
            Page p = new Page(page -1, 10);
            var query = comentarioRepository.findAll().page(p);
            return new PaginatedReponse<>(query);
        }

}
