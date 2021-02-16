package com.api.paradocs.service;

import com.api.paradocs.dom.SkiResort;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface SkiResortRepo {

  SkiResort save(SkiResort skiResortRepo) throws InterruptedException, ExecutionException;

  SkiResort get(String id) throws InterruptedException, ExecutionException;

  List<SkiResort> getAll() throws ExecutionException, InterruptedException;

  SkiResort update(String id, SkiResort skiResortRepo) throws InterruptedException, ExecutionException;

  void delete(String id) throws ExecutionException, InterruptedException;
}
