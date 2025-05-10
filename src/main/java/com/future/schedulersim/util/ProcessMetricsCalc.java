package com.future.schedulersim.util;

import com.future.schedulersim.model.Process;
import java.util.List;

public class ProcessMetricsCalc {
    /*
     * Turnaround Time: endTime – arrivalTime
     * Waiting Time: turnaroundTime - burstTime
     * Response time: startTime − arrivalTime
     * */

    public static int calcWaitingTime(Process process) {
        return calcTurnaroundTime(process) - process.getBurstTime();
    }

    public static int calcTurnaroundTime(Process process) {
        return process.getEndTime() - process.getArrivalTime();
    }

    public static int calcResponseTime(Process process) {
        return process.getStartTime() - process.getArrivalTime();
    }

    public static double calcAverageWaitingTime(List<Process> processes) {
        long total = 0;
        for (Process process : processes) {
            total += calcWaitingTime(process);
        }
        return (double) total / processes.size();
    }

    public static double calcAverageTurnaroundTime(List<Process> processes) {
        long total = 0;
        for (Process process : processes) {
            total += calcTurnaroundTime(process);
        }
        return (double) total / processes.size();
    }

    public static double calcAverageResponseTime(List<Process> processes) {
        long total = 0;
        for (Process process : processes) {
            total += calcResponseTime(process);
        }
        return (double) total / processes.size();
    }
}
