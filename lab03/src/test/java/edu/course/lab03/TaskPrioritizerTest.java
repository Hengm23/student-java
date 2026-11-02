package edu.course.lab03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskPrioritizerTest {

    @Test
    @DisplayName("EffortPriorityPolicy: выбирает задачу с большей трудоемкостью")
    void shouldPrioritizeTaskWithHigherEffort() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        ProjectTask smallTask = new ProjectTask("1", "Мелкая правка", TaskStatus.IN_PROGRESS, 2);
        ProjectTask bigTask = new ProjectTask("2", "Большой рефакторинг", TaskStatus.NEW, 16);

        ProjectTask result = prioritizer.chooseHigherPriority(smallTask, bigTask);
        assertEquals(bigTask, result);
    }

    @Test
    @DisplayName("EffortPriorityPolicy: выбрасывает исключение при передаче null задачи")
    void shouldThrowWhenTaskIsNullInEffortPolicy() {
        PriorityPolicy policy = new EffortPriorityPolicy();
        assertThrows(IllegalArgumentException.class, () -> policy.calculatePriority(null));
    }

    @Test
    @DisplayName("StatusPriorityPolicy: задача в процессе приоритетнее новой")
    void shouldPrioritizeInProgressOverNew() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        ProjectTask newTask = new ProjectTask("1", "Новая задача", TaskStatus.NEW, 20);
        ProjectTask inProgressTask = new ProjectTask("2", "В работе", TaskStatus.IN_PROGRESS, 2);

        ProjectTask result = prioritizer.chooseHigherPriority(newTask, inProgressTask);
        assertEquals(inProgressTask, result);
    }

    @Test
    @DisplayName("StatusPriorityPolicy: новая задача приоритетнее завершенной")
    void shouldPrioritizeNewOverCompleted() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        ProjectTask completedTask = new ProjectTask("1", "Готово", TaskStatus.COMPLETED, 10);
        ProjectTask newTask = new ProjectTask("2", "Новая", TaskStatus.NEW, 1);

        ProjectTask result = prioritizer.chooseHigherPriority(completedTask, newTask);
        assertEquals(newTask, result);
    }

    @Test
    @DisplayName("Заменяемость стратегий: одна и та же пара задач дает разный результат при смене политики")
    void shouldDemonstratePolymorphicSubstitution() {
        ProjectTask urgentSmallTask = new ProjectTask("1", "Срочная мелочь", TaskStatus.IN_PROGRESS, 2);
        ProjectTask nonUrgentBigTask = new ProjectTask("2", "Большой проект", TaskStatus.NEW, 20);

        TaskPrioritizer byEffort = new TaskPrioritizer(new EffortPriorityPolicy());
        TaskPrioritizer byStatus = new TaskPrioritizer(new StatusPriorityPolicy());

        assertEquals(nonUrgentBigTask, byEffort.chooseHigherPriority(urgentSmallTask, nonUrgentBigTask));

        assertEquals(urgentSmallTask, byStatus.chooseHigherPriority(urgentSmallTask, nonUrgentBigTask));
    }
}