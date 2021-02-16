package com.api.paradocs.DBInitialize;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class FireBaseInitialize {
  @PostConstruct
  public void initialize() throws IOException {
    FileInputStream serviceAccount =
        new FileInputStream("src/main/java/com/api/paradocs/DBInitialize/key.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();

    FirebaseApp.initializeApp(options);
  }
}
