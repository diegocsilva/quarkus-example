package br.com.softplan.springexample.resource;

import br.com.softplan.springexample.model.Aluno;
import br.com.softplan.springexample.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<?> list() {
        List<Aluno> aluno = service.list();
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<?> create(Aluno aluno) {
        service.create(aluno);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping
    public ResponseEntity<?> update(Aluno aluno) {
        service.update(aluno);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathParam("id") Integer id) {
        service.delete(id);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/{name}")
    public ResponseEntity getByName(@PathParam("name")String name) {
        Aluno aluno = service.getByName(name);
        return ResponseEntity.ok(aluno);
    }
}
