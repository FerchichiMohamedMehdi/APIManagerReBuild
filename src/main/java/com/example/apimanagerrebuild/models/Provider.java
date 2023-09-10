package com.example.apimanagerrebuild.models;

import java.util.ArrayList;
import java.util.List;

public class Provider extends Organization {

    private int numberOfAuthorisation;
    private List<Api> listApiProvided = new ArrayList<Api>();
}
