package com.future.schedulersim.core;

import com.future.schedulersim.model.Process;
import com.future.schedulersim.model.ProcessNodeData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

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
        processList.add(process);
    }

    public ObservableList<Process> getProcessList() {
        return processList;
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

    public List<ProcessNodeData> getGanttChartList() {
        Queue<Process> processQueue = new LinkedList<>(processList.sorted(Comparator.comparingInt(Process::getArrivalTime)));
        PriorityQueue<Process> readyQueue = new PriorityQueue<>(Comparator.comparingInt(Process::getPriority));
        List<ProcessNodeData> ganttChartList = new ArrayList<>();

        assignFirstProcess(processQueue, ganttChartList);

        int time = 0;
        while (!processQueue.isEmpty() || !readyQueue.isEmpty()) {
            // Receive all the available processes at this time in the ready queue
            while (!processQueue.isEmpty() && processQueue.peek().getArrivalTime() <= time) {
                readyQueue.add(processQueue.poll());
            }

            if (!readyQueue.isEmpty() && ganttChartList.getLast().getEndTime() <= time) {
                Process process = readyQueue.poll();
                assert process != null;
                ganttChartList.add(new ProcessNodeData(
                        process.getProcessName(),
                        time,
                        time + process.getBurstTime()
                ));
            }

            time++;
        }

        return ganttChartList;
    }

    private void assignFirstProcess(Queue<Process> processQueue, List<ProcessNodeData> ganttChartList) {
        Process firstProcess = processQueue.poll();
        assert firstProcess != null;
        ganttChartList.add(new ProcessNodeData(
                firstProcess.getProcessName(),
                firstProcess.getArrivalTime(),
                firstProcess.getArrivalTime() + firstProcess.getBurstTime()
        ));
    }

}
