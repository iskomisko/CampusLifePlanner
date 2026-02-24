import java.util.ArrayList;

public class CampusLifeApp {

    public static void main(String[] args) {

        // Create courses

        Course oop = new Course("OOP", "Dr.Lee", 6);
        Course discrete = new Course("Discrete Math", "Dr.Sherali", 5);
        Course english = new Course("German language", "Ms.Erika", 3);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(oop);
        courses.add(discrete);
        courses.add(english);

        // Create assignments

        ArrayList<AssignmentTask> tasks = new ArrayList<>();
        tasks.add(new AssignmentTask("Lab 1", oop, 3, 1));
        tasks.add(new AssignmentTask("Project", oop, 8, 5));
        tasks.add(new AssignmentTask("HW Logic", discrete, 4, 2));
        tasks.add(new AssignmentTask("Essay", english, 2, 0));
        tasks.add(new AssignmentTask("Reading", english, 1, 4));

        // Create study sessions

        ArrayList<StudySession> sessions = new ArrayList<>();
        sessions.add(new StudySession(oop, 120));
        sessions.add(new StudySession(discrete, 90));
        sessions.add(new StudySession(english, 60));
        sessions.add(new StudySession(oop, 60));

        // Print courses

        System.out.println("\n \f [COURSES] \n");
        for (Course c : courses) {
            System.out.println(c);
        }

        // Print assignments + urgent

        System.out.println("\n \f [ASSIGNMENTS] \n");
        for (AssignmentTask t : tasks) {
            System.out.println(t);
            if (t.isUrgent()) {
                System.out.println("  -> URGENT!");
            }
        }

        // Total estimated hours remaining

        int totalRemaining = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                totalRemaining += t.getEstimatedHours();
            }
        }
        System.out.println("\n   -> Total estimated hours remaining: " + totalRemaining);
        // Total study time per course
        System.out.println("\n \f [STUDY TIME PER COURSE] \n");
        for (Course c : courses) {
            double totalHours = 0;
            for (StudySession s : sessions) {
                if (s.getCourse().equals(c)) {
                    totalHours += s.hours();
                }
            }
            System.out.println(c.getName() + ": " + totalHours + " hours");
        }

        // Mark one assignment completed

        System.out.println("\n \f [MARK COMPLETED] \n ");
        AssignmentTask taskToComplete = tasks.get(0);
        taskToComplete.markCompleted();

        System.out.println("  -> Updated assignment: \n");
        System.out.println(taskToComplete);

        // Recalculate remaining hours

        totalRemaining = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                totalRemaining += t.getEstimatedHours();
            }
        }

        System.out.println("\n  -> New remaining estimated hours: " + totalRemaining);

    }

}
