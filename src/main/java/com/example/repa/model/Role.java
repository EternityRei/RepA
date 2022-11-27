package com.example.repa.model;

public enum Role {
    UNREGISTERED(1),
    USER(2),
    EMPLOYEE(3),
    MANAGER(4);

    private final long accessLevel;

    Role(int accessLevel){
        this.accessLevel = accessLevel;
    }

    public long getAccessLevel(){
        return accessLevel;
    }
}
