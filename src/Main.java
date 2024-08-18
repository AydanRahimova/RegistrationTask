public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    Please,choose operation:\

                    1-For registration of students\

                    2-For viewing the information about students\

                    3-For searching for students\

                    4-For updating students' information\

                    5-Exit""");
            Operation.menu();
        }
    }
}
