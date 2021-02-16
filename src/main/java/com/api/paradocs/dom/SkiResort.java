package com.api.paradocs.dom;

import com.google.firebase.database.Exclude;

public class SkiResort implements FirebaseDocument {

  @Exclude
  private String id;
  private String name;
  private String description;

  public SkiResort() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
