package scheduling;

import java.util.Arrays;

class FirstComeFirstServe {

    static void FCFS(Task[] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            if (a.arrivalTime != b.arrivalTime) return Integer.compare(a.arrivalTime, b.arrivalTime);
            return Integer.compare(a.pid, b.pid);
        });

        int currTime = 0;
        int idleTime = 0;
        double totalWT = 0;
        double totalTAT = 0;

        System.out.println("=== Scheduling Timeline ===");

        for (Task task : tasks) {

            // CPU idle
            if (currTime < task.arrivalTime) {
                System.out.printf("Time %d → %d : CPU IDLE\n", currTime, task.arrivalTime);

                idleTime += task.arrivalTime - currTime;
                currTime = task.arrivalTime;
            }

            int start = currTime;
            int end = currTime + task.burstTime;

            System.out.printf("Time %d → %d : Executing Task %d\n", start, end, task.pid);

            int waitingTime = start - task.arrivalTime;
            int turnAroundTime = waitingTime + task.burstTime;

            totalWT += waitingTime;
            totalTAT += turnAroundTime;

            currTime = end;
        }

        System.out.println("\n=== Statistics ===");

        System.out.printf("Average Waiting Time = %.2f\n", totalWT / tasks.length);
        System.out.printf("Average Turnaround Time = %.2f\n", totalTAT / tasks.length);
        System.out.println("CPU Idle Time = " + idleTime);
        System.out.println("Total Time Elapsed = " + currTime);
    }

    public static void main(String[] args) {
        Task[] tasks = Task.inputMany();
        FCFS(tasks);
    }
}
