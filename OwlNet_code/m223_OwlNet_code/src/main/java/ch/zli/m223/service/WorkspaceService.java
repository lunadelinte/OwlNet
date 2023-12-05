package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.Workspace;

@ApplicationScoped
public class WorkspaceService {
        @Inject
    private EntityManager entityManager;

    @Transactional
    public Workspace create(Workspace workspace) {
        entityManager.persist(workspace);
        return workspace;
    }

    public List<Workspace> findAll() {
        var query = entityManager.createQuery("FROM Workspace", Workspace.class);
        return query.getResultList();
    }

    @Transactional
    public Response delete(Long id){
        Workspace workspace = entityManager.find(Workspace.class, id);
        entityManager.remove(workspace);
        return Response.status(204).build();
    }

    public Workspace getWorkspace(Long id){
        return entityManager.find(Workspace.class, id);
    }

    public Workspace update(Long id, Workspace workspace){
        workspace.setId(id);
        return entityManager.merge(workspace);
    }
}
