package constants;

public class Constants {

    public static String NUMBER = "#";

    public interface PageName{
        String MY_PROFILE = "My Profile";
        String CHANGE_PASSWORD = "Change Password";

        String MENTOR_EDIT = "Mentor Editing";
        String MENTOR_DETAILS = "Mentor Details";
        String MENTOR_LIST = "Mentors";

        String STUDENT_EDIT_DETAILS = "Edit student details";
        String STUDENT_DETAILS = "Student details";
        String STUDENT_LIST = "Students";

        String SECRETARY_EDIT = "Edit Secretary's details";
        String SECRETARY_DETAILS = "Secretary's details";
        String SECRETARY_LIST = "Secretaries";

        String LESSON_EDIT = "Edit a Lesson";
        String LESSON_DETAILS = "Lesson details";
        String LESSON_LIST = "Lessons";

        String GROUP_EDIT = "Group Editing";
        String GROUP_DETAILS = "Group:";
        String GROUP_LIST = "Groups";

        String COURSE_EDIT = "Course Editing";
        String COURSE_DETAILS = "Course Details";
        String COURSE_LIST = "Courses";
    }

    public interface LessonDetails{
        String LESSON_NAME = "Lesson Theme:";
        String MENTOR_NAME  = "Mentor name:";

        String GROUP_NAME = "Group name:";
        String LESSON_DATE = "Lesson Date:";
        String LESSON_TIME = "Lesson Time:";
    }

    public interface DetailsAboutUser{
        String FIRST_NAME = "First Name:";
        String LAST_NAME = "Last Name:";

        String EMAIL = "Email:";
        String EMAIL_ADDRESS = "Email address:";

        String GROUP = "Group('s):";
        String COURSE = "Course('s):";
    }

    public interface ListUser{
        String NAME = "Name";
        String SURNAME = "Surname";

        String EMAIL = "Email";

        String ROLE = "Choose role";
    }

    public interface ListFeatures{
        String EDIT = "Edit";

        String GROUP_NAME = "Group Name";
        String LESSON_NAME = "Theme Name";
        String COURSE_NAME = "Title";

        String QUANTITY_STUDENTS = "Quantity of students";

        String DATE = "Date";
        String DATE_START = "Date of start";
        String DATE_END = "Date of finish";

        String TIME = "Time";
    }

    public interface UnassignedUsersSelectRole {
        String CHOOSE = "Choose role";
        String STUDENT = "student";
        String MENTOR = "mentor";
        String SECRETARY = "secretary";
    }

    public interface UnassignedUsersSort {
        String SYMBOL = "0";
        String NAME = "1";
        String SURNAME = "2";
        String EMAIL = "3";
    }

}