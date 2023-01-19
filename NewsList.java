package com.example.readit;

import java.util.ArrayList;

public class NewsList {
    public String status;
    public String totalResult;
    public ArrayList <ModelClass> newsList;

    public NewsList(String status, String totalResult, ArrayList<ModelClass> newsList) {
        this.status = status;
        this.totalResult = totalResult;
        this.newsList = newsList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<ModelClass> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<ModelClass> newsList) {
        this.newsList = newsList;
    }
}
