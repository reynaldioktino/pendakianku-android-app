package com.example.reynaldioktino.tugasbesar.AppGunung;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultGunung {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<ModelGunung> result = new ArrayList<ModelGunung>();
    @SerializedName("message")
    private String message;

    public ResultGunung() {

    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<ModelGunung> getResult() {
        return result;
    }
    public void setResult(List<ModelGunung> result) {
        this.result = result;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
