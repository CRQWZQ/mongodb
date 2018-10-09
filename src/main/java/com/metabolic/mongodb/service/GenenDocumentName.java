package com.metabolic.mongodb.service;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/09/13.
 */
@Component("genenDocumentName")
public class GenenDocumentName {

    private String value;

    public String getDocumentName(){
        return this.getValue();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
