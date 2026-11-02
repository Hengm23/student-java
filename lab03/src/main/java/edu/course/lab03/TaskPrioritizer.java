package edu.course.lab03;

public class TaskPrioritizer {

    private final PriorityPolicy priorityPolicy;

    public TaskPrioritizer(PriorityPolicy priorityPolicy) {
        if (priorityPolicy == null) {
            throw new IllegalArgumentException("Политика приоритетов не может быть null");
        }
        this.priorityPolicy = priorityPolicy;
    }

    public ProjectTask chooseHigherPriority(ProjectTask task1, ProjectTask task2) {
        if (task1 == null || task2 == null) {
            throw new IllegalArgumentException("Сравниваемые задачи не могут быть null");
        }
        int priority1 = priorityPolicy.calculatePriority(task1);
        int priority2 = priorityPolicy.calculatePriority(task2);

        return (priority1 >= priority2) ? task1 : task2;
    }
}