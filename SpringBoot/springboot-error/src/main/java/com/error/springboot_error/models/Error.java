package com.error.springboot_error.models;

import java.util.Date;

public class Error {

  private String message;
  private String error;
  private int status;
  private Date date;

  //Getters:
  public String getMessage() {  return message; }
  public String getError() {  return error; }
  public int getStatus() {  return status;  }
  public Date getDate() { return date; }

  //Setters:
  public void setMessage(String message) {  this.message = message; }
  public void setError(String error) {  this.error = error; }
  public void setDate(Date date) {  this.date = date; }
  public void setStatus(int status) { this.status = status; }
}
