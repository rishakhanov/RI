package search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    public int count = 0;

    public void put(Task task) {
        if (tasks.size() > 0) {
            for (int i = 0; i < tasks.size(); i++) {
                if (task.getPriority() < tasks.get(i).getPriority()) {
                    count = i;
                } else {
                    count = i + 1;
                }
            }
            tasks.add(count, task);
        } else {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
