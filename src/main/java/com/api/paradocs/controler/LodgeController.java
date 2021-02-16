package com.api.paradocs.controler;

import com.api.paradocs.dom.Lodge;
import com.api.paradocs.service.LodgeService;
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
@RequestMapping(path = "/skiResort/{id_r}/lodge")
public class LodgeController {

  @Autowired
  LodgeService lodgeService;

  @GetMapping("/")
  public List<Lodge> getAllLodgeService() throws InterruptedException, ExecutionException{
    return lodgeService.getAll();
  }

  @GetMapping("/{id}")
  public Lodge getLodgeService(@PathVariable String id) throws InterruptedException, ExecutionException{
    return lodgeService.get(id);
  }

  @PostMapping(path="/", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> createLodgeService(@RequestBody Lodge lodge, @PathVariable String id_r) throws InterruptedException, ExecutionException {
    lodge.idResort = id_r;
    lodgeService.save(lodge);
    return new ResponseEntity<>(lodge, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public Lodge updateLodgeService(@PathVariable String id, @RequestBody Lodge lodge) throws InterruptedException, ExecutionException {
    return lodgeService.update(id, lodge);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteLodgeService(@PathVariable String id) throws ExecutionException, InterruptedException {
    lodgeService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
