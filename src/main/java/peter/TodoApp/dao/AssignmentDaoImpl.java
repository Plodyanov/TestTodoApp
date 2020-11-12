package peter.TodoApp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peter.TodoApp.model.Assignment;
import java.util.List;

@Repository
public class AssignmentDaoImpl implements AssignmentDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Assignment> allAssignments() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Assignment").list();
    }

    @Override
    public void addAssignment(Assignment assignment) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(assignment);
    }

    @Override
    public void updateAssignment(Assignment assignment) {
        Session session = sessionFactory.getCurrentSession();
        session.update(assignment);
    }

    @Override
    public void deleteAssignment(Assignment assignment) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(assignment);
    }

    @Override
    public Assignment getAssignmentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Assignment.class, id);
    }
}
