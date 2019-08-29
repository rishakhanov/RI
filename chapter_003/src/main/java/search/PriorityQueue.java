package search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if (tasks.size() > 0) {
            var count = tasks.size();
            for (var i = 0; i < tasks.size(); i++) {
                if (task.getPriority() < tasks.get(i).getPriority()) {
                    count = i;
                    break;
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
