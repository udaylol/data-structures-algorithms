package scheduling;

class ShortestJobFirst {

    static void SJF(Task[] tasks) {

        int n = tasks.length;
        int completed = 0;
        boolean[] done = new boolean[n];

        int currTime = 0;
        int idleTime = 0;
        int totalWT = 0;
        int totalTAT = 0;

        System.out.println("=== Scheduling Timeline ===");

        while (completed < n) {

            int idx = -1;
            int minBurst = Integer.MAX_VALUE;
            int nextArrival = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {

                if (done[i]) continue;

                if (tasks[i].arrivalTime <= currTime) {
                    // pick the shortest task
                    if (tasks[i].burstTime < minBurst) {
                        minBurst = tasks[i].burstTime;
                        idx = i;
                    }
                } else {
                    // if no task has arrived yet
                    // keep track of the earliest time at which
                    // the next incomplete task that will arrive
                    nextArrival = Math.min(nextArrival, tasks[i].arrivalTime);
                }
            }


            // No process available → CPU idle
            if (idx == -1) {
                System.out.printf("Time %d → %d : CPU IDLE\n", currTime, nextArrival);

                idleTime += nextArrival - currTime;
                currTime = nextArrival;
                continue;
            }

            // Execute chosen process
            Task task = tasks[idx];
            int start = currTime;
            int end = currTime + task.burstTime;

            System.out.printf("Time %d → %d : Executing Task %d\n", start, end, task.pid);

            int waitingTime = start - task.arrivalTime;
            int turnaroundTime = waitingTime + task.burstTime;

            totalWT += waitingTime;
            totalTAT += turnaroundTime;

            currTime = end;
            done[idx] = true;
            completed++;
        }

        System.out.println("\n=== Statistics ===");

        System.out.printf("Average Waiting Time = %.2f\n", (double) totalWT / n);
        System.out.printf("Average Turnaround Time = %.2f\n", (double) totalTAT / n);
        System.out.println("CPU Idle Time = " + idleTime);
        System.out.println("Total Time Elapsed = " + currTime);
    }

    public static void main(String[] args) {
        Task[] tasks = Task.inputMany();
        SJF(tasks);
    }
}
