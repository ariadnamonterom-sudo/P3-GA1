package com.desarrolloweb.entornoservidor.tema3practica.models;

import java.util.Date;

public class Error {
    private String message; 
    private String description; 
    private int status; 
    private Date timestamp;

    public Error() {
    }

    public Error(String message, String description, int status, Date timestamp) {
        this.message = message;
        this.description = description;
        this.status = status;
        this.timestamp = timestamp;
    }

    //Getter y Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
