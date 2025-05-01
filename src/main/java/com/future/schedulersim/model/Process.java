package com.future.schedulersim.model;

public class Process {
    private String processName;
    private int numberOfTheProcess;
    private int arrivalTime;
    private int burstTime;
    private int priority;

    public Process() {}

    public Process(String processName, int numberOfTheProcess, int arrivalTime, int burstTime, int priority) {
        this.processName = processName;
        this.numberOfTheProcess = numberOfTheProcess;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    public int getNumberOfTheProcess() {
        return numberOfTheProcess;
    }

    public void setNumberOfTheProcess(int numberOfTheProcess) {
        this.numberOfTheProcess = numberOfTheProcess;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
