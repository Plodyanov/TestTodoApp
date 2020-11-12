package peter.TodoApp.service;

import peter.TodoApp.model.Assignment;

import java.util.List;

public interface AssignmentService {
    List<Assignment> allAssignments();
    void addAssignment(Assignment assignment);
    void updateAssignment(Assignment assignment);
    void deleteAssignment(Assignment assignment);
    Assignment getAssignmentById(int id);
}
