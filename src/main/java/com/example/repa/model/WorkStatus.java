package com.example.repa.model;

public enum WorkStatus {
    NOT_STARTED(1),
    IN_PROCCESS(2),
    DONE(3);

    private final long workStatus;

    WorkStatus(long workStatus){
        this.workStatus = workStatus;
    }

    public long getWorkStatus() {
        return workStatus;
    }
}
