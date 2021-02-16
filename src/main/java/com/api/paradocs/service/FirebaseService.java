package com.api.paradocs.service;

import com.api.paradocs.dom.FirebaseDocument;
import com.api.paradocs.exception.NotFoundException;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;

@Service
public abstract class FirebaseService <T extends FirebaseDocument> {

  protected final Firestore dbFirestore = FirestoreClient.getFirestore();

  public T save(T skiResort) throws InterruptedException, ExecutionException {
    ApiFuture<DocumentReference> documentReference = getCollection().add(skiResort);
    skiResort.setId(documentReference.get().getId());
    return skiResort;
  }

  protected abstract CollectionReference getCollection();

  public abstract T convertDocument(DocumentSnapshot document);

  public T get(String id) throws InterruptedException, ExecutionException {
    DocumentReference documentReference = getCollection().document(id);

    ApiFuture<DocumentSnapshot> future = documentReference.get();
    DocumentSnapshot document = future.get();

    T skiResort = null;

    if(document.exists()) {
      skiResort = convertDocument(document);
      skiResort.setId(documentReference.getId());
      return skiResort;
    }else {
      throw new NotFoundException();
    }
  }

  public List<T> getAll() throws ExecutionException, InterruptedException {
    ApiFuture<QuerySnapshot> future = getCollection().get();

    List<QueryDocumentSnapshot> documents = future.get().getDocuments();

    List<T> skiResortList = new ArrayList<>();
    T skiResort = null;

    for (QueryDocumentSnapshot document : documents) {
      skiResort = convertDocument(document);
      skiResort.setId(document.getId());
      skiResortList.add(skiResort);
    }

    return skiResortList;
  }

  public T update(String id, T skiResort) throws InterruptedException, ExecutionException {
    DocumentReference documentReference = getCollection().document(id);

    ApiFuture<DocumentSnapshot> future = documentReference.get();
    DocumentSnapshot document = future.get();

    if(document.exists()) {
      documentReference.set(skiResort);
      skiResort.setId(document.getId());
      return skiResort;
    }else {
      throw new NotFoundException();
    }
  }

  public void delete(String id) throws ExecutionException, InterruptedException {
    DocumentReference documentReference = getCollection().document(id);

    ApiFuture<DocumentSnapshot> future = documentReference.get();
    DocumentSnapshot document = future.get();

    if(document.exists()) {
      documentReference.delete();
    }else {
      throw new NotFoundException();
    }
  }
}
