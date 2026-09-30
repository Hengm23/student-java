package edu.course.lab02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTaskTest {

    @Test
    @DisplayName("Корректное создание задачи инициализирует все поля")
    void shouldCreateValidTask() {
        ProjectTask task = new ProjectTask("TASK-101", "Разработать модуль", 8);

        assertEquals("TASK-101", task.getId());
        assertEquals("Разработать модуль", task.getTitle());
        assertEquals(8, task.getEstimatedHours());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertFalse(task.taskCompleted());
    }

    @Test
    @DisplayName("Запрет создания задачи с null, пустой строкой или пробелами в id")
    void shouldThrowWhenIdIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask(null, "Заголовок", 5));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Заголовок", 5));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("   ", "Заголовок", 5));
    }

    @Test
    @DisplayName("Запрет создания задачи с null, пустой строкой или пробелами в title")
    void shouldThrowWhenTitleIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", null, 5));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", "", 5));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", "   ", 5));
    }

    @Test
    @DisplayName("Запрет создания задачи с нулевым или отрицательным временем")
    void shouldThrowWhenInitialHoursNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", "Заголовок", -5));
    }

    @Test
    @DisplayName("Успешная смена статуса и проверка taskCompleted()")
    void shouldChangeStatusAndReflectCompletion() {
        ProjectTask task = new ProjectTask("TASK-1", "Заголовок", 3);

        task.changeStatus(TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        assertFalse(task.taskCompleted());

        task.changeStatus(TaskStatus.COMPLETED);
        assertEquals(TaskStatus.COMPLETED, task.getStatus());
        assertTrue(task.taskCompleted());
    }

    @Test
    @DisplayName("Запрет передачи null в changeStatus")
    void shouldThrowWhenStatusIsNull() {
        ProjectTask task = new ProjectTask("TASK-1", "Заголовок", 3);
        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
    }

    @Test
    @DisplayName("Успешное добавление часов через addEstimatedHours")
    void shouldAddEstimatedHours() {
        ProjectTask task = new ProjectTask("TASK-1", "Заголовок", 4);
        task.addEstimatedHours(3);
        assertEquals(7, task.getEstimatedHours());
    }

    @Test
    @DisplayName("Запрет добавления 0 или отрицательного количества часов")
    void shouldThrowWhenAddingNonPositiveHours() {
        ProjectTask task = new ProjectTask("TASK-1", "Заголовок", 4);

        assertThrows(IllegalArgumentException.class, () -> task.addEstimatedHours(0));
        assertThrows(IllegalArgumentException.class, () -> task.addEstimatedHours(-2));
    }
}