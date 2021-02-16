package com.api.paradocs.service;

import com.api.paradocs.dom.SkiResort;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import org.springframework.stereotype.Service;

@Service
public class SkiResortService extends FirebaseService<SkiResort> implements SkiResortRepo{

  private String COLLECTION_NAME = "SkiResort";

  protected CollectionReference getCollection() {
    return super.dbFirestore.collection(COLLECTION_NAME);
  }

  public SkiResort convertDocument(DocumentSnapshot document) {
    return document.toObject(SkiResort.class);
  }
}
