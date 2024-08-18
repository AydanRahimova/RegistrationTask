import java.sql.Struct;
import java.util.Arrays;
import java.util.Scanner;

public class Operation {
    static Scanner sc = new Scanner(System.in);

    public static void menu() {
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Operation.registrationOfStudents();
                break;
            case 2:
                Operation.viewInfoOfStudents();
                break;
            case 3:
                Operation.searchForStudent();
                break;
            case 4:
                Operation.updateInfoWithSplit();
//                Operation.updateInfoWithSetMethod();
                break;
            case 5:
                Operation.exit();
                break;
            default:
                System.out.println("Try again");
        }
    }

    public static Student fillStudent(Student student) {
        String name = requireMessage("Enter name:");
        student.setName(name);
        String surname = requireMessage("Enter surname:");
        student.setSurname(surname);
        int age = requireText("Enter age:");
        student.setAge(age);
        String groupName = requireMessage("Enter group name:");
        student.setGroupName(groupName);
        String id = requireMessage("Enter id:");
        student.setId(id);
        return student;
    }

    public static void registrationOfStudents() {
        System.out.println("Please,enter a number of students:");
        Data.students = new Student[sc.nextInt()];
        for (int i = 0; i < Data.students.length; i++) {
            System.out.println("Registration of " + (i + 1) + " student:");
            Student student = new Student();//create new object for each iteration
            Data.students[i] = fillStudent(student);
        }
    }

    public static String requireMessage(String message) {
        System.out.println(message);
        return sc.next();

    }

    public static int requireText(String message) {
        System.out.println(message);
        return sc.nextInt();
    }

    public static void viewInfoOfStudents() {
        System.out.println(Arrays.toString(Data.students));
    }

    public static void viewInfoOfStudent1() {
        System.out.println(Arrays.toString(Data.students));
    }

    public static void searchForStudent() {
        String choice = requireMessage("Enter,how you want to search for a student:" +
                "\nname,surname,age,group name,id").toLowerCase();
        switch (choice) {
            case "name":
                String name = requireMessage("Please,enter a name:");
                boolean isNameFound = false;
                for (int i = 0; i < Data.students.length; i++) {
                    if (Data.students[i].getName().equals(name)) {
                        System.out.println(Data.students[i].toString());
                        isNameFound = true;
                    }
                }
                if (!isNameFound){//mentiqi?isFound == false
                    // If no student was found, print the message
                    System.out.println("No student with the name " + name + " found.");
                }
                break;
            case "surname":
                String surname = requireMessage("Please,enter a surname:");
                boolean isSurnameFound = false;
                for (int i = 0; i < Data.students.length; i++) {
                    if (Data.students[i].getSurname().equals(surname)) {
                        System.out.println(Data.students[i].toString());
                        isSurnameFound = true;
                    }
                }
                if (!isSurnameFound){//mentiqi?isFound == false
                    // If no student was found, print the message
                    System.out.println("No student with the surname " + surname + " found.");
                }
                break;
            case "age":
                int age = requireText("Please,enter an age:");
                boolean isAgeFound = false;
                for (int i = 0 ; i < Data.students.length; i++) {
                    if (Data.students[i].getAge() == age) {
                        System.out.println(Data.students[i].toString());
                        isAgeFound = true;
                    }
                }
                if (!isAgeFound){//mentiqi?isFound == false
                    // If no student was found, print the message
                    System.out.println("No student with the age " + age + " found.");
                }
                break;
            case "group name"://group name yazanda exception verir(require message-i nextLine verende sehv iwleyir)
                String groupName = requireMessage("Please,enter a groupName:");
                boolean isGroupNameFound = false;
                for (int i = 0; i < Data.students.length; i++) {
                    if (Data.students[i].getGroupName().equals(groupName)) {
                        System.out.println(Data.students[i].toString());
                        isGroupNameFound = true;
                    }
                }
                if (!isGroupNameFound){//mentiqi?isFound == false
                    // If no student was found, print the message
                    System.out.println("No student with the group name " + groupName + " found.");
                }
                break;
            case "id":
                String id = requireMessage("Please,enter a id:");
                boolean isIDFound = false;
                for (int i = 0; i < Data.students.length; i++) {
                    if (Data.students[i].getId().equals(id)) {
                        System.out.println(Data.students[i].toString());
                        isIDFound = true;
                    }
                }
                if (!isIDFound){//mentiqi?isFound == false
                    // If no student was found, print the message
                    System.out.println("No student with the id " + id + " found.");
                }
                break;
            default:
                System.out.println("Try again");
        }


    }

    public static void updateInfoWithSplit() {
        System.out.println("Enter an ID of student whose info you want to change:");
        String id1 = sc.next();
        for (int i = 0; i < Data.students.length; i++) {
            if (Data.students[i].getId().equals(id1)) {
                String choice = Operation.requireMessage("What you want to change?:" +
                        "\nname,surname,age,group name,id");
                String[] choices = choice.split(",");
                for (String s : choices) {
                    if (s.equals("name")) {
                        String name = requireMessage("Enter new name:");
                        Data.students[i].setName(name);
                    } else if (s.equals("surname")) {
                        String surname = requireMessage("Enter new surname:");
                        Data.students[i].setSurname(surname);
                    } else if (s.equals("age")) {
                        int age = requireText("Enter new age:");
                        Data.students[i].setAge(age);
                    } else if (s.equals("group name")) {
                        String groupName = requireMessage("Enter new group name:");
                        Data.students[i].setGroupName(groupName);
                    } else {
                        System.out.println("Try again");
                    }
                }

            } else {
                System.out.println("We can't find student with this ID.Try again.");
            }
        }
    }

    public static void updateInfoWithSetMethod() {
        System.out.println("Enter an ID of student whose info you want to change:");
        String id1 = sc.next();
        for (int i = 0; i < Data.students.length; i++) {
            if (Data.students[i].getId().equals(id1)) {
                String choice = Operation.requireMessage("What you want to change?:" +
                        "\nname,surname,age,group name,id");
                switch (choice) {
                    case "name":
                        Data.students[i].setName(Operation.requireMessage("Enter new name:"));
                        break;
                    case "surname":
                        Data.students[i].setSurname(Operation.requireMessage("Enter new surname:"));
                        break;
                    case "age":
                        Data.students[i].setAge(Operation.requireText("Enter new age"));
                        break;
                    case "group name":
                        Data.students[i].setGroupName(Operation.requireMessage("Enter new group name:"));
                        break;
                    case "id":
                        Data.students[i].setId(Operation.requireMessage("Enter new id:"));
                }
            }
        }
    }

    public static void exit() {
        System.exit(0);
    }
}
