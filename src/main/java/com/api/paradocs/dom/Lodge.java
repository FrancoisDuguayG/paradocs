package com.api.paradocs.dom;


public class Lodge implements FirebaseDocument{

  public String id;
  public String idResort;
  public String name;
  public String description;

  public Lodge() {
  }

  public void setId(String id) {
    this.id = id;
  }
}
