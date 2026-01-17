package scheduling;

import java.util.Scanner;

class Task {
    int pid;
    int arrivalTime;
    int burstTime;
    Integer priority;

    Task(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = null;
    }

    Task(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    @Override
    public String toString() {
        if (priority == null)
            return "{ pid: " + pid + " , arrivalTime: " + arrivalTime + " , burstTime: " + burstTime + " }";
        return "{ pid: " + pid + " , arrivalTime: " + arrivalTime + " , burstTime: " + burstTime + " , priority: " + priority + " }";
    }

    private static Task inputOne(Scanner sc, int pid) {
        System.out.print("Enter arrival time and burst time: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        return new Task(pid, a, b);
    }

    private static Task inputOneWithPriority(Scanner sc, int pid) {
        System.out.print("Enter arrival time, burst time and priority: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int p = sc.nextInt();
        return new Task(pid, a, b, p);
    }

    static Task[] inputMany() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of tasks: ");
        int n = sc.nextInt();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = inputOne(sc, i);
        }
        System.out.println();
        return tasks;
    }

    static Task[] inputManyWithPriority() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of tasks: ");
        int n = sc.nextInt();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = inputOneWithPriority(sc, i);
        }
        System.out.println();
        return tasks;
    }

}
