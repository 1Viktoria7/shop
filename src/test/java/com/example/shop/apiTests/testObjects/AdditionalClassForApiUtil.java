package com.example.shop.apiTests.testObjects;

public class AdditionalClassForApiUtil {
    //Variables
    static Long Id;
    static String name;
    static Boolean Public_status;

    //Methods
    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void  setPublic(boolean Public_status) {
        this.Public_status = Public_status;
    }

    public Boolean isPublic_status() {
        return Public_status;
    }

    public AdditionalClassForApiUtil(Long Id, String name, Boolean Public_status) {
        this.Id = Id;
        this.name = name;
        this.Public_status = Public_status;
    }

}