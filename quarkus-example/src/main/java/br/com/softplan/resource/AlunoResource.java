package br.com.softplan.resource;

import br.com.softplan.model.Aluno;
import br.com.softplan.service.AlunoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


@Path("alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class AlunoResource {

    @Inject
    private AlunoService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response list() {
        List<Aluno> aluno = service.list();
        return Response.ok(aluno).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Aluno aluno) {
        service.create(aluno);
        return Response.ok(aluno).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(Aluno aluno) {
        service.update(aluno);
        return Response.ok(aluno).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        service.delete(id);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    @Transactional
    public Response getByName(@PathParam("name")String name) {
        Aluno aluno = service.getByName(name);
        return Response.ok(aluno).build();
    }
}
