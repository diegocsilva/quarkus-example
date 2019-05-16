package br.com.softplan.resource;

import br.com.softplan.model.Aluno;
import br.com.softplan.service.AlunoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/aluno")
@Produces("application/json")
@Consumes("application/json")
@Transactional
public class AlunoResource {

    @Inject
    private AlunoService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response getByName(@PathParam("name")String name) {
        Aluno aluno = service.findByNome(name);
        return Response.ok(aluno).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Aluno aluno) {
        service.save(aluno);
        return Response.ok(aluno).build();
    }
}
