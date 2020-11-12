package peter.TodoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import peter.TodoApp.model.Assignment;
import peter.TodoApp.service.AssignmentService;
import peter.TodoApp.service.AssignmentServiceImpl;

import java.util.List;

@Controller
public class AssignmentController {

    private AssignmentService assignmentService;

    @Autowired
    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allAssignments() {
        List<Assignment> assignments = assignmentService.allAssignments();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("assignments");
        modelAndView.addObject("assignmentList",assignments);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        Assignment assignment = assignmentService.getAssignmentById(id);
        modelAndView.addObject("assignment", assignment);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editAssignment(@ModelAttribute("assignment") Assignment assignment) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        assignmentService.updateAssignment(assignment);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addAssignment(@ModelAttribute("assignment") Assignment assignment) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        assignmentService.addAssignment(assignment);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAssignment(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Assignment assignment = assignmentService.getAssignmentById(id);
        assignmentService.deleteAssignment(assignment);
        return modelAndView;
    }
}
