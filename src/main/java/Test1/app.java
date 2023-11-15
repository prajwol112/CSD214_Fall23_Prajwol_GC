package Test1;

import java.util.Date;

public class app extends course {
    // addCourse will create a new course object and add it to the list of courses
    public static void addCourse(String name, String code, Date startDate, Integer numberOfStudents){
        course course = new course(name, code, startDate, numberOfStudents);
    }
    public static void editCourse(course course, String name, String code, Date startDate, Integer numberOfStudents){
        course.setName(name);
        course.setCode(code);
        course.setStartDate(startDate);
        course.setNumberOfStudents(numberOfStudents);
    }

    }


