package test.Repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import model.Comentario;
import test.Implementacion.IComentarioRepo;

import java.util.List;
import java.util.ServiceLoader;

@ApplicationScoped
public class ComentarioRepository implements IComentarioRepo {

    @Inject
    EntityManager em;

    @Override
    public void saveComment(Comentario com) {
        persist(com);
    }


    public Comentario getComentario(){
        return find("id", 1).firstResult();
    }

    @Override
    public List<Comentario> getComentarios() {
        return listAll();
    }

}
