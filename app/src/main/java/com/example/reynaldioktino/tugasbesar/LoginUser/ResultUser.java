package com.example.reynaldioktino.tugasbesar.LoginUser;

import com.google.gson.annotations.SerializedName;

public class ResultUser {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private ModelUser user;

    public ResultUser(String status, ModelUser user) {
        this.status = status;
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModelUser getUser() {
        return user;
    }

    public void setUser(ModelUser user) {
        this.user = user;
    }
}
