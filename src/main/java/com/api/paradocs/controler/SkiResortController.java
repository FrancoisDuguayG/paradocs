package com.api.paradocs.controler;

import com.api.paradocs.dom.SkiResort;
import com.api.paradocs.service.SkiResortService;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/skiResort")
public class SkiResortController {

  @Autowired
  SkiResortService skiResortService;

  @GetMapping("/")
  public List<SkiResort> getAllSkiResort() throws InterruptedException, ExecutionException{
    return skiResortService.getAll();
  }

  @GetMapping("/{id}")
  public SkiResort getSkiResort(@PathVariable String id) throws InterruptedException, ExecutionException{
    return skiResortService.get(id);
  }

  @PostMapping(path="/", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> createSkiResort(@RequestBody SkiResort skiResort) throws InterruptedException, ExecutionException {
    skiResortService.save(skiResort);
    return new ResponseEntity<>(skiResort, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public SkiResort updateSkiResort(@PathVariable String id, @RequestBody SkiResort skiResort) throws InterruptedException, ExecutionException {
    return skiResortService.update(id, skiResort);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteSkiResort(@PathVariable String id) throws ExecutionException, InterruptedException {
    skiResortService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
