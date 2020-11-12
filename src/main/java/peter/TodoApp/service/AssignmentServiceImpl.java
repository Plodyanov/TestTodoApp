package peter.TodoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peter.TodoApp.dao.AssignmentDao;
import peter.TodoApp.dao.AssignmentDaoImpl;
import peter.TodoApp.model.Assignment;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentDao assignmentDao;

    @Autowired
    public void setAssignmentDao(AssignmentDao assignmentDao) {
        this.assignmentDao = assignmentDao;
    }

    @Transactional
    public List<Assignment> allAssignments() {
        return assignmentDao.allAssignments();
    }

    @Transactional
    public void addAssignment(Assignment assignment) {
        assignmentDao.addAssignment(assignment);
    }

    @Transactional
    public void updateAssignment(Assignment assignment) {
        assignmentDao.updateAssignment(assignment);
    }

    @Transactional
    public void deleteAssignment(Assignment assignment) {
        assignmentDao.deleteAssignment(assignment);
    }

    @Transactional
    public Assignment getAssignmentById(int id) {
        return assignmentDao.getAssignmentById(id);
    }
}
