package test.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import test.service.TestService;
import test.utils.info.TestInfo;

@RestController
@RequestMapping(value = "/api/v1/tests")
public class TestController {

    @Autowired
    private TestService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<TestInfo>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<TestInfo> get(@PathVariable Long id) {
        TestInfo info = service.get(id);
        if (info != null) {
            return ResponseEntity.ok(info);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body((TestInfo) null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody TestInfo info) {
        if (service.create(info)) {
            return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(info.getId()).toUri())
                    .build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TestInfo info) {
        info.setId(id);
        if (service.update(info)) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.notFound().build();
    }
}
