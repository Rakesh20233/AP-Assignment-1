import java.util.*;

class Assignment_2 {
    public static void main(String[] args) {
        Student_Info.Student_Name();
        Instructor_Info.Instructor_Name();
        new show_Menu();
    }
}

class show_Menu{
    Date date = new Date();
    Scanner sc = new Scanner(System.in);
    static int Main_Menu_Choice;
    show_Menu(){
        System.out.println("""
                
                Welcome to IIITD BackPack!!
                1. Enter as Instructor
                2. Enter as Student
                3. Exit
                Choose Option :
                """);

        Main_Menu_Choice = sc.nextInt();
        sc.nextLine();
        if(Main_Menu_Choice == 1){
            Login.Login_Instructor();
        }
        else if (Main_Menu_Choice == 2){
            Login.Login_Student();
        }
        else if (Main_Menu_Choice == 3){
            System.out.println("\nSee ya' next time!!\n\nExiting...");
            System.exit(0);
        }
    }
}

class Login{
    Date date = new Date();
    static Scanner sc = new Scanner(System.in);
    public static int Instructor_Choice;
    public static int Student_Choice;
    static void Login_Instructor(){
        System.out.println("""
                
                Instructors :
                1. Instructor_1
                2. Instructor_2
                
                Choose option :""");
        Instructor_Choice = sc.nextInt();
        sc.nextLine();
        if(Instructor_Choice == 1){
            Menu.Instructor_Menu();
        }
        else if (Instructor_Choice == 2){
            Menu.Instructor_Menu();
        }
    }

    static void Login_Student(){
        System.out.println("""
                
                Students :
                1. Student_1
                2. Student_2
                3. Student_3
                
                Choose Option :""");
        Student_Choice = sc.nextInt();
        sc.nextLine();
        if(Student_Choice == 1){
            //
            Menu.Student_Menu();
        }
        else if (Student_Choice == 2){
            //
            Menu.Student_Menu();
        }
        else if (Student_Choice == 3){
            //
            Menu.Student_Menu();
        }
    }
}

class Menu{
    Date date = new Date();
    public static Scanner sc = new Scanner(System.in);
    public static void Instructor_Menu(){
        System.out.println("""
                
                INSTRUCTOR MENU :
                
                1. Add Class Material
                2. Add Assessments
                3. View Lecture Materials
                4. View Assessments
                5. Grade Assessments
                6. Close Assessment
                7. View Comments
                8. Add Comments
                9. Logout
                
                Choose Option :""");
        int Instructor_Menu_Choice = sc.nextInt();
        sc.nextLine();
        if(Instructor_Menu_Choice == 1){
            Material_Notes.Add_Material_Notes();
        }
        else if (Instructor_Menu_Choice == 2){
            Assessment.Add_Assessment();
        }
        else if (Instructor_Menu_Choice == 3){
            Material_Notes.View_Lecture_Materials();
        }
        else if (Instructor_Menu_Choice == 4){
            Assessment.View_Assessment();
        }
        else if (Instructor_Menu_Choice == 5){
            Assessment.Grade_Assessment();
        }
        else if (Instructor_Menu_Choice == 6){
            Assessment.Close_Assessment();
        }
        else if (Instructor_Menu_Choice == 8){
            Comments.Add_Comment();
        }
        else if (Instructor_Menu_Choice == 7){
            Comments.View_Comment();
        }
        else if (Instructor_Menu_Choice == 9){
            new show_Menu();
        }
    }
    public static void Student_Menu(){
        System.out.println("""
                
                STUDENT MENU :
                1. View lecture materials
                2. View assessments
                3. Submit assessment
                4. View grades
                5. View comments
                6. Add comments
                7. Logout
                
                Choose option :""");
        int Student_Menu_Choice = sc.nextInt();
        sc.nextLine();
        if (Student_Menu_Choice == 1){
            Material_Notes.View_Lecture_Materials();
        }
        else if (Student_Menu_Choice == 2){
            Assessment.View_Assessment();
        }
        else if (Student_Menu_Choice == 3){
            Assessment.Submit_Assessment();
        }
        else if (Student_Menu_Choice == 4){
            Assessment.View_Grades();
        }
        else if (Student_Menu_Choice == 5){
            Comments.View_Comment();
        }
        else if (Student_Menu_Choice == 6){
            Comments.Add_Comment();
        }
        else if (Student_Menu_Choice == 7){
            new show_Menu();
        }
    }
}

class Material_Notes{
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<ArrayList<String>> Slide_Instructor_and_Date = new ArrayList<>();
    public static ArrayList<ArrayList<String>> Video_Instructor_and_Date = new ArrayList<>();
    public static ArrayList<ArrayList<String>> Slide_Content = new ArrayList<>();
    public static ArrayList<String> Slide_Topic = new ArrayList<>();
    public static ArrayList<ArrayList<String>> Lecture_Video = new ArrayList<>();
    static void Add_Material_Notes(){
        System.out.println("""
                1. Add Lecture Slide
                2. Add Lecture Video
                
                Choose Option :""");
        int Add_lecture_Material_Choice = sc.nextInt();
        sc.nextLine();
        if (Add_lecture_Material_Choice == 1){
            Add_Lecture_Slide();
        }
        else if(Add_lecture_Material_Choice == 2){
            Add_lecture_Video();
        }
        else{
            System.out.println("Invalid option!!");
            Add_Material_Notes();
        }
    }

    static void Add_Lecture_Slide(){
        System.out.println("Enter Topic of Slides : ");
        String Topic_of_Slide = sc.nextLine();
        Slide_Topic.add(Topic_of_Slide);
        System.out.println("Enter Number of Slides : ");
        int Slide_number = sc.nextInt();
        sc.nextLine();
        ArrayList<String> Slide_number_content = new ArrayList<>();
        for (int i = 0; i < Slide_number; i++){
            System.out.println("Enter Content for Slide " + i + " : ");
            String Content_of_Slide = sc.nextLine();
            Slide_number_content.add(Content_of_Slide);
        }
        Slide_Content.add(Slide_number_content);
        ArrayList<String> current_teacher_date = new ArrayList<>();
        current_teacher_date.add(Instructor_Info.Instructor_Name.get(Login.Instructor_Choice - 1));
        Date date = new Date();
        current_teacher_date.add(date.toString());
        Slide_Instructor_and_Date.add(current_teacher_date);
        Menu.Instructor_Menu();
    }

    static void Add_lecture_Video(){
        System.out.println("Enter Topic of Video : ");
        String Video_Topic = sc.nextLine();
        System.out.println("Enter Filename of Video (No Space in the Filename) : ");
        String Video_FileName = sc.next();
        sc.nextLine();
        if (!Video_FileName.endsWith(".mp4")){
            System.out.println("Incorrect format of Video File. The filename should end with \".mp4\"."
            + " Please try Again!!");
            Add_lecture_Video();
        }
        else{
            ArrayList<String> Video_lecture = new ArrayList<>();
            Video_lecture.add(Video_Topic);
            Video_lecture.add(Video_FileName);
            Lecture_Video.add(Video_lecture);
            System.out.println("Lecture Video Added");
            ArrayList<String> current_teacher_date = new ArrayList<>();
            current_teacher_date.add(Instructor_Info.Instructor_Name.get(Login.Instructor_Choice - 1));
            Date date = new Date();
            current_teacher_date.add(date.toString());
            Video_Instructor_and_Date.add(current_teacher_date);
            Menu.Instructor_Menu();
        }
    }

    static void View_Lecture_Materials(){
        System.out.println("""
                1. Lecture Slides
                2. Lecture Video
                Choose Option :""");
        int View_lecture_Material_Choice = sc.nextInt();
        sc.nextLine();
        if (View_lecture_Material_Choice == 1){
            View_lecture_Slide();
        }
        else if (View_lecture_Material_Choice == 2){
            View_Lecture_Video();
        }
        else{
            System.out.println("Wrong Option Choosen!!");
            View_Lecture_Materials();
        }
    }

    static void View_lecture_Slide(){
        for(int i = 0; i < Slide_Topic.size(); i++){
            System.out.println("Slide Topic : " + Slide_Topic.get(i));
            for(int j = 0; j < Slide_Content.get(i).size(); j++){
                System.out.println("Content for Slide " + j + " : " + Slide_Content.get(i).get(j));
            }
            System.out.println("By : " + Slide_Instructor_and_Date.get(i).get(0) + ";\tOn : " + Slide_Instructor_and_Date.get(i).get(1) + "\n");
        }
        if(show_Menu.Main_Menu_Choice == 1){
            Menu.Instructor_Menu();
        }
        else if (show_Menu.Main_Menu_Choice == 2){
            Menu.Student_Menu();
        }
    }

    static void View_Lecture_Video(){
        for (int i = 0; i < Lecture_Video.size(); i++) {
            System.out.println("Lecture Topic : " + Lecture_Video.get(i).get(0) + "\nLecture Video : " + Lecture_Video.get(i).get(1));
            System.out.println("By : " + Video_Instructor_and_Date.get(i).get(0) + ";\tOn : " + Video_Instructor_and_Date.get(i).get(1) + "\n");
        }
        if(show_Menu.Main_Menu_Choice == 1){
            Menu.Instructor_Menu();
        }
        else if (show_Menu.Main_Menu_Choice == 2){
            Menu.Student_Menu();
        }
    }
}

class Assessment {
    Date date = new Date();
    public static ArrayList<String> Assignment_Statement = new ArrayList<>();
    public static ArrayList<Integer> Assignment_Max_Marks = new ArrayList<>();
    public static ArrayList<String> Quiz_Statement = new ArrayList<>();
    public static ArrayList<Boolean> Assignment_Open_Close = new ArrayList<>();
    public static ArrayList<Boolean> Quiz_Open_Close = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static void Add_Assessment(){
        System.out.println("""
                1. Add Assignment
                2. Add Quiz
                
                Choose Option :""");
        int Add_Assessment_Choice = sc.nextInt();
        sc.nextLine();
        if (Add_Assessment_Choice == 1){
            Add_Assignment();
        }
        else if (Add_Assessment_Choice == 2){
            Add_Quiz();
        }
    }

    static void Add_Assignment(){
        System.out.println("Enter Problem Statement : ");
        String Problem_Assignment = sc.nextLine();
        Assignment_Statement.add(Problem_Assignment);
        System.out.println("Enter Maximum Marks : ");
        int Max_marks_Assignment = sc.nextInt();
        Assignment_Max_Marks.add(Max_marks_Assignment);
        sc.nextLine();
        System.out.println("The Assignment has been Added!!");
        Menu.Instructor_Menu();
    }

    static void Add_Quiz(){
        System.out.println("Enter Quiz Question : ");
        String Quiz_Question = sc.nextLine();
        Quiz_Statement.add(Quiz_Question);
        System.out.println("The Quiz has been Added!!");
        Menu.Instructor_Menu();
    }

    static void View_Assessment(){
        System.out.println("Assignments : ");
        if (Assignment_Statement.size() != 0) {
            for (int i = 0; i < Assignment_Statement.size(); i++) {
                System.out.println("Assignment ID : " + i + "; Problem Statement : " + Assignment_Statement.get(i) +
                "; Maximum Marks : " + Assignment_Max_Marks.get(i));
            }
        }
        else {
            System.out.println("There are currently No Assignments!!");
        }
        System.out.println("\nQuizzes : ");
        if (Quiz_Statement.size() == 0){
            System.out.println("There are currently no Quizzes!!");
        }
        else{
            for (int i = 0; i < Quiz_Statement.size(); i++){
                System.out.println("Quiz ID : " + i + "; Problem Statement : " + Quiz_Statement.get(i));
            }
        }
        if (show_Menu.Main_Menu_Choice == 1){
            Menu.Instructor_Menu();
        }
        else {
            Menu.Student_Menu();
        }
    }

    static void Submit_Assessment(){
        System.out.println("""
                What do you want to Submit :
                1. Assignment
                2. Quiz""");

        int Assessment_Choice = sc.nextInt();
        sc.nextLine();

        if(Assessment_Choice == 1){
            Submit_Assignment();
        }
        else if(Assessment_Choice == 2){
            Submit_Quiz();
        }
        else{
            System.out.println("Wrong Choice Entered!!");
            Menu.Student_Menu();
        }
    }

    static void Submit_Assignment(){
        if (Assignment_Statement.size() == 0){
            System.out.println("There are currently no Assignments!!");
        }

        else {
            System.out.println("Assignments yet to be submitted : ");
            if (Student_Info.Student_Assignment_Submission.size() == 0){
                Student_Info.Initialise_Submit_Assignment();
            }

            while (Assignment_Open_Close.size() != Assignment_Statement.size()){
                Assignment_Open_Close.add(false);
            }

            for (int i = 0; i < Assignment_Statement.size(); i++) {
                if (Assignment_Open_Close.get(i) == false && 1 != Student_Info.Student_Assignment_Submission.get((Login.Student_Choice) - 1).get(i)) {
                    System.out.println("ID : " + i + ";\tProblem Statement : "
                            + Assignment_Statement.get(i) + ";\tMaximum Marks : " + Assignment_Max_Marks.get(i));
                }
            }
            System.out.println("Choose ID : ");
            int Submission_Assignment_Choice = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Filename of Assignment : ");
            String Assignment_Submission_File = sc.next();
            sc.nextLine();
            if (Assignment_Submission_File.endsWith(".zip")) {
                System.out.println("The assignment has been Submitted!!");
                Student_Info.Student_Assignment_Submission.get((Login.Student_Choice) - 1).set(Submission_Assignment_Choice, 1);
                if (Student_Info.Student_Assignment_Submission_file.size() == 0) {
                    Student_Info.Assignment_Submission_File();
                }
                Student_Info.Student_Assignment_Submission_file.get((Login.Student_Choice) - 1).set(Submission_Assignment_Choice, Assignment_Submission_File);
            }
            else {
                System.out.println("The format of the submitted File is INCORRECT!! Submit in .zip format!!");
            }
        }
        Menu.Student_Menu();
    }

    static void Submit_Quiz(){
        if (Quiz_Statement.size() == 0){
            System.out.println("There are currently no Quizzes!!");
        }
        else {
            System.out.println("Quizzes yet to be Submitted are :");
            if (Student_Info.Student_Quiz_Submission.size() == 0) {
                Student_Info.Initialise_Submit_Quiz();
            }

            while (Quiz_Open_Close.size() != Quiz_Statement.size()){
                Quiz_Open_Close.add(false);
            }
            for (int i = 0; i < Quiz_Statement.size(); i++) {
                if (Quiz_Open_Close.get(i) == false && 1 != Student_Info.Student_Quiz_Submission.get((Login.Student_Choice) - 1).get(i)) {
                    System.out.println("ID : " + i + ";\tProblem Statement : "
                            + Quiz_Statement.get(i) + ";\tMaximum Marks : 1");
                }
            }

            System.out.println("Choose ID : ");
            int Submission_Quiz_Choice = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Quiz Answer : ");
            String Quiz_Submission_Answer = sc.next();
            sc.nextLine();
            System.out.println("The Answer to the Quiz has been Submitted!!!" );
            Student_Info.Student_Quiz_Submission.get((Login.Student_Choice) - 1).set(Submission_Quiz_Choice, 1);
            if (Student_Info.Student_Quiz_Submission_Answer.size() == 0) {
                Student_Info.Quiz_Submission_Answer();
            }
            Student_Info.Student_Quiz_Submission_Answer.get((Login.Student_Choice) - 1).set(Submission_Quiz_Choice, Quiz_Submission_Answer);
        }
        Menu.Student_Menu();
    }

    static void Grade_Assessment(){
        System.out.println("""
                What would you like to grade :
                1. Assignments
                2. Quizzes
                Enter Option :""");

        int Grade_Assessment_choice = sc.nextInt();
        sc.nextLine();
        if (Grade_Assessment_choice == 1){
            Grade_Assignment();
        }
        else if (Grade_Assessment_choice == 2){
            Grade_Quiz();
        }
        else {
            System.out.println("Invalid option!! Try Again!!");
            Grade_Assessment();
        }
    }

    static void Grade_Assignment(){
        System.out.println("Select Assignment : ");
        for (int j = 0; j < Assignment_Statement.size(); j++) {
            System.out.println("ID : " + j + "; Problem : " + Assignment_Statement.get(j) + "; Maximum Marks : "
            + Assignment_Max_Marks.get(j));
        }
        System.out.println("Select ID : ");
        int Grade_Assignment_Choice = sc.nextInt();
        sc.nextLine();

        System.out.println("Select Student : ");
        for (int i = 0; i < 3; i++){
            System.out.println("Student ID : " + i + "; Name : " + Student_Info.Student_Name.get(i));
        }
        System.out.println("Select Student ID : ");
        int Student_Assignment_Choice = sc.nextInt();
        sc.nextLine();
        if (Student_Info.Student_Assignment_Submission.get(Student_Assignment_Choice).get(Grade_Assignment_Choice) == 1) {
            System.out.println("The Submitted File is : " + Student_Info.Student_Assignment_Submission_file.
            get(Student_Assignment_Choice).get(Grade_Assignment_Choice));
            System.out.println("Maximum Marks : " + Assignment_Max_Marks.get(Grade_Assignment_Choice) +
            "\nMarks to be Given(Only Integers Allowed) : ");
            int Student_Assignment_Marks = sc.nextInt();
            sc.nextLine();
//            Assignment_Marks.set(Grade_Assignment_Choice, Student_Assignment_Marks);
            if (Student_Info.Student_Assignment_Marks.size() == 0) {
                Student_Info.Student_Assignment_Marks_initialisation();
            }
            Student_Info.Student_Assignment_Marks.get(Student_Assignment_Choice).set(Grade_Assignment_Choice, Student_Assignment_Marks);
            System.out.println("Marks Given!!");
        }
        else{
            System.out.println("Not Submitted by Student!!");
        }
        Menu.Instructor_Menu();
    }

    static void Grade_Quiz(){
        System.out.println("Select Quiz :");
        for (int i = 0; i < Quiz_Statement.size(); i++){
            System.out.println("ID : " + i + "; Problem : " + Quiz_Statement.get(i));
        }
        System.out.println("Select ID : ");
        int Grade_Quiz_Choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Select Student : ");
        for (int j = 0; j < 3; j++){
            System.out.println("Student ID : " + j + "; Name : " + Student_Info.Student_Name.get(j));
        }
        System.out.println("Select Student ID : ");
        int Student_Quiz_Choice = sc.nextInt();
        sc.nextLine();
        if (Student_Info.Student_Quiz_Submission.get(Student_Quiz_Choice).get(Grade_Quiz_Choice) == 1){
            System.out.println("The Submitted Answer is : " + Student_Info.Student_Quiz_Submission_Answer.
            get(Student_Quiz_Choice).get(Grade_Quiz_Choice));
            System.out.println("Marks to be Given (Either 0 or 1) : ");
            int Student_Quiz_Marks = sc.nextInt();
            sc.nextLine();
//            Quiz_Marks.set(Grade_Quiz_Choice, Student_Quiz_Marks);
            if (Student_Info.Student_Quiz_Marks.size() == 0){
                Student_Info.Student_Quiz_marks_Initialisation();
            }
            Student_Info.Student_Quiz_Marks.get(Student_Quiz_Choice).set(Grade_Quiz_Choice, Student_Quiz_Marks);
            System.out.println("Marks Given!!");
        }
        else{
            System.out.println("Not Submitted by Student!!");
        }
        Menu.Instructor_Menu();
    }

    static void Close_Assessment(){
        System.out.println("""
                What do you want to close :
                1. Assignment
                2. Quiz""");

        int Close_Assessment_Choice = sc.nextInt();
        sc.nextLine();
        if (Close_Assessment_Choice == 1){
            Close_Assignment();
        }
        else if (Close_Assessment_Choice == 2){
            Close_Quiz();
        }
        else{
            System.out.println("Wrong Option Entered!! Try Again!!");
            Close_Assessment();
        }
    }

    static void Close_Assignment(){
        while (Assignment_Open_Close.size() != Assignment_Statement.size()){
                Assignment_Open_Close.add(false);
        }

        for (int i = 0; i < Assignment_Statement.size(); i++){
            if(Assignment_Open_Close.get(i) == false){
                System.out.println("ID : " + i + "; Problem Statement : " + Assignment_Statement.get(i) + "; Maximum Marks : "
                + Assignment_Max_Marks.get(i));
            }
        }

        System.out.println("Enter the ID of Assignment which you want to close : ");
        int Assignment_Close_Choice = sc.nextInt();
        sc.nextLine();

        Assignment_Open_Close.set(Assignment_Close_Choice, true);
        Menu.Instructor_Menu();
    }

    static void Close_Quiz(){
        while (Quiz_Open_Close.size() != Quiz_Statement.size()){
            Quiz_Open_Close.add(false);
        }

        for (int i = 0; i < Quiz_Statement.size(); i++){
            if(Quiz_Open_Close.get(i) == false){
                System.out.println("ID : " + i + "; Problem Statement : " + Quiz_Statement.get(i));
            }
        }

        System.out.println("Enter the ID of Quiz which you want to close : ");
        int Quiz_Close_Choice = sc.nextInt();
        sc.nextLine();

        Assignment_Open_Close.set(Quiz_Close_Choice, true);
        Menu.Instructor_Menu();
    }

    static void View_Grades(){
        System.out.println("""
                1. Assignments
                2. Quizzes
                Choose Option :""");
        int View_Grades_Choice = sc.nextInt();
        sc.nextLine();
        if (View_Grades_Choice == 1){
            View_Assignment_Grades();
        }
        else if (View_Grades_Choice == 2){
            View_Quiz_Grades();
        }
        else{
            System.out.println("Wrong Choice Entered!!");
            View_Grades();
        }
    }

    static void View_Assignment_Grades(){
        for (int i = 0; i < Assignment_Statement.size(); i++){
            System.out.println("ID : " + i + "; Problem : " + Assignment_Statement.get(i) + "; Max Marks : " + Assignment_Max_Marks.get(i));
        }
        System.out.println("Select ID : ");
        int Assignment_Choice_Grades = sc.nextInt();
        sc.nextLine();
        if (Student_Info.Student_Assignment_Marks.get(Login.Student_Choice - 1).get(Assignment_Choice_Grades) == null){
            System.out.println("Assignment Ungraded!!");
        }
        else {
            System.out.println("Marks Scored : " + Student_Info.Student_Assignment_Marks.get(Login.Student_Choice - 1).get(Assignment_Choice_Grades)
             + "\nMaximum Marks : " + Assignment_Max_Marks.get(Assignment_Choice_Grades));
        }
        Menu.Student_Menu();
    }

    static void View_Quiz_Grades(){
        for (int i = 0; i < Quiz_Statement.size(); i++){
            System.out.println("ID : " + i + "; Problem : " + Quiz_Statement.get(i));
        }
        System.out.println("Select ID : ");
        int Quiz_Choice_Grades = sc.nextInt();
        sc.nextLine();
        if (Student_Info.Student_Quiz_Marks.get(Login.Student_Choice - 1).get(Quiz_Choice_Grades) == null){
            System.out.println("Quiz Ungraded!!");
        }
        else {
            System.out.println("Marks Scored : " + Student_Info.Student_Quiz_Marks.get(Login.Student_Choice - 1).get(Quiz_Choice_Grades));
        }
        Menu.Student_Menu();
    }
}

class Instructor_Info{
    Date date = new Date();
    public static ArrayList<String> Instructor_Name = new ArrayList<>();
    public static void Instructor_Name(){
        Instructor_Name.add("Instructor_1");
        Instructor_Name.add("Instructor_2");
    }
}

class Student_Info{
    Date date = new Date();
    public static ArrayList<String> Student_Name = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> Student_Assignment_Submission = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> Student_Quiz_Submission = new ArrayList<>();

    public static ArrayList<ArrayList<String>> Student_Assignment_Submission_file = new ArrayList<>();
    public static ArrayList<ArrayList<String>> Student_Quiz_Submission_Answer = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> Student_Quiz_Marks = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> Student_Assignment_Marks = new ArrayList<>();

    public static void Initialise_Submit_Assignment(){
        ArrayList<Integer> s_Assignment_Submission = new ArrayList<>();
        for(int j = 0; j < 10; j++){
            s_Assignment_Submission.add(0);
        }

        for (int k =0; k < 3; k++){
            ArrayList student_assignment_submission;
            student_assignment_submission = (ArrayList) s_Assignment_Submission.clone();
            Student_Assignment_Submission.add(student_assignment_submission);
        }
    }
    public static void Student_Name(){
        Student_Name.add("Student_1");
        Student_Name.add("Student_2");
        Student_Name.add("Student_3");
    }
    public static void Initialise_Submit_Quiz(){
        ArrayList<Integer> s_Quiz_Submission = new ArrayList<>();
        while (s_Quiz_Submission.size()<10){
            s_Quiz_Submission.add(0);
        }

        for (int k = 0; k < 3; k++){
            ArrayList student_quiz_submission;
            student_quiz_submission = (ArrayList) s_Quiz_Submission.clone();
            Student_Quiz_Submission.add(student_quiz_submission);
        }
    }

    public static void Assignment_Submission_File(){
        ArrayList<String> s_Assignment_Submission_File = new ArrayList<>();
        while (s_Assignment_Submission_File.size() < 10){
            s_Assignment_Submission_File.add(null);
        }
        while (Student_Assignment_Submission_file.size() < 3){
            ArrayList student_assignment_submission_file;
            student_assignment_submission_file = (ArrayList) s_Assignment_Submission_File.clone();
            Student_Assignment_Submission_file.add(student_assignment_submission_file);
        }
    }

    public static void Quiz_Submission_Answer(){
        ArrayList<String> s_Quiz_Submission_Answer = new ArrayList<>();
        while (s_Quiz_Submission_Answer.size() < 10){
            s_Quiz_Submission_Answer.add(null);
        }
        while (Student_Quiz_Submission_Answer.size() < 3){
            ArrayList student_quiz_submission_answer;
            student_quiz_submission_answer = (ArrayList) s_Quiz_Submission_Answer.clone();
            Student_Quiz_Submission_Answer.add(student_quiz_submission_answer);
        }
    }

    public static void Student_Quiz_marks_Initialisation(){
        ArrayList<String> s_Quiz_Marks = new ArrayList<>();
        while (s_Quiz_Marks.size() < 10){
            s_Quiz_Marks.add(null);
        }
        while (Student_Quiz_Marks.size() < 3){
            ArrayList student_Quiz_Marks_demo;
            student_Quiz_Marks_demo = (ArrayList) s_Quiz_Marks.clone();
            Student_Quiz_Marks.add(student_Quiz_Marks_demo);
        }
    }

    public static void Student_Assignment_Marks_initialisation(){
        ArrayList<String> s_Quiz_Submission_Answer = new ArrayList<>();
        while (s_Quiz_Submission_Answer.size() < 10){
            s_Quiz_Submission_Answer.add(null);
        }
        while (Student_Assignment_Marks.size() < 3){
            ArrayList Student_Assignment_Marks_Demo;
            Student_Assignment_Marks_Demo = (ArrayList) s_Quiz_Submission_Answer.clone();
            Student_Assignment_Marks.add(Student_Assignment_Marks_Demo);
        }
    }
}

class Comments{
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<ArrayList<String >> Comment_Info = new ArrayList<>();
    public static void Add_Comment(){
        System.out.println("Enter Comment : ");
        String Enter_Comment = sc.nextLine();
        Date date = new Date();
        ArrayList<String> Comment_comment = new ArrayList<>();
        Comment_comment.add(Enter_Comment);
        if (show_Menu.Main_Menu_Choice == 1){
            Comment_comment.add(Instructor_Info.Instructor_Name.get(Login.Instructor_Choice - 1));
            Comment_comment.add(date.toString());
            Comment_Info.add(Comment_comment);
            Menu.Instructor_Menu();
        }
        else if (show_Menu.Main_Menu_Choice == 2){
            Comment_comment.add(Student_Info.Student_Name.get(Login.Student_Choice - 1));
            Comment_comment.add(date.toString());
            Comment_Info.add(Comment_comment);
            Menu.Student_Menu();
        }
    }

    public static void View_Comment(){
        for (int i = 0; i < Comment_Info.size(); i++){
            System.out.println(Comment_Info.get(i).get(0) + "\nBy : " + Comment_Info.get(i).get(1) + ";\tOn : " + Comment_Info.get(i).get(2) + "\n");
        }
        if(show_Menu.Main_Menu_Choice == 1){
            Menu.Instructor_Menu();
        }
        else if (show_Menu.Main_Menu_Choice == 2){
            Menu.Student_Menu();
        }
    }
}

