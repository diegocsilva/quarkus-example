package br.com.softplan.resource;

import br.com.softplan.model.Aluno;
import br.com.softplan.service.AlunoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/aluno")
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

}
