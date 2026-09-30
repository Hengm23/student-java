package edu.course.lab02;

public class ProjectTask {
    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, int estimatedHours) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID задачи не может быть пустым.");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название задачи не может быть пустым.");
        }
        if (estimatedHours < 0) {
            throw new IllegalArgumentException("Рассчетное время работы не может быть меньше нуля");
        }
        this.id = id;
        this.title = title;
        this.status = TaskStatus.NEW;
        this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Статус не может принимать значение null.");
        }
        this.status = newStatus;
    }

    public boolean taskCompleted() {
        return this.status == TaskStatus.COMPLETED;
    }

    public void addEstimatedHours(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Количество часов не может быть меньше или равно нулю.");
        }
        this.estimatedHours += hours;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }
}