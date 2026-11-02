package edu.course.lab03;

public class StatusPriorityPolicy implements PriorityPolicy {

    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("Задача не может быть null");
        }
        return switch (task.getStatus()) {
            case IN_PROGRESS -> 100;
            case NEW -> 50;
            case COMPLETED -> 0;
        };
    }
}