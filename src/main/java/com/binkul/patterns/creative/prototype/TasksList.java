package com.binkul.patterns.creative.prototype;

import java.util.ArrayList;
import java.util.List;

public class TasksList {
    final private String name;
    final private List<Task> tasks = new ArrayList<>();

    public TasksList(final String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("   List [" + name + "]");
        for(Task task : tasks) {
            s.append("\n").append(task.toString());
        }
        return s.toString();
    }
}
