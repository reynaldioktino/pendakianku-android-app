package com.example.reynaldioktino.tugasbesar.AppCerita;

import com.example.reynaldioktino.tugasbesar.AppGunung.ModelGunung;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultCerita {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<ModelCerita> result = new ArrayList<ModelCerita>();
    @SerializedName("message")
    private String message;

    public ResultCerita() {

    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<ModelCerita> getResult() {
        return result;
    }
    public void setResult(List<ModelCerita> result) {
        this.result = result;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
