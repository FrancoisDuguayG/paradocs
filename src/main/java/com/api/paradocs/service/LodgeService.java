package com.api.paradocs.service;

import com.api.paradocs.dom.Lodge;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import org.springframework.stereotype.Service;

@Service
public class LodgeService extends FirebaseService<Lodge>{

  private String COLLECTION_NAME = "Lodge";

  protected CollectionReference getCollection() {
    return super.dbFirestore.collection(COLLECTION_NAME);
  }

  public Lodge convertDocument(DocumentSnapshot document) {
    return document.toObject(Lodge.class);
  }
}
