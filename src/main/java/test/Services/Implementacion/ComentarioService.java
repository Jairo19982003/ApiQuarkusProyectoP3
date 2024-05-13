package test.Services.Implementacion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Comentario;
import test.Repository.ComentarioRepository;
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

}
