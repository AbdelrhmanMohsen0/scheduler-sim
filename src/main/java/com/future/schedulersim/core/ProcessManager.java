package com.future.schedulersim.core;

import com.future.schedulersim.model.Process;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProcessManager {

    private final ObservableList<Process> processList = FXCollections.observableArrayList();

    // Singleton Pattern
    private static ProcessManager processManager;
    private ProcessManager(){}

    public static synchronized ProcessManager getInstance() {
        if (processManager == null)
            processManager = new ProcessManager();
        return processManager;
    }

    public void addProcess(Process process) {
        process.setNumberOfTheProcess(processList.isEmpty() ? 1 : processList.getLast().getNumberOfTheProcess() + 1);
        processList.add(process);
    }

    public ObservableList<Process> getProcessList() {
        return processList;
    }

    public void clearProcesses() {
        processList.clear();
    }

    public String getRecommendedProcessName() {
        return "P" + (processList.size() + 1);
    }

    public boolean isProcessNameExist(String name) {
        for (Process process : processList) {
            if (process.getProcessName().equals(name))
                return true;
        }
        return false;
    }
}
