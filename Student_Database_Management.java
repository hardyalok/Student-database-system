package Practice.Student_DBMS;
import java.util.Scanner;
import java.util.HashMap;

public class Student_Database_Management {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      HashMap<Integer, student> database = new HashMap<Integer, student>();

      while (true) {
         System.out.println("1. Add Student");
         System.out.println("2. View Student");
         System.out.println("3. Search Student");
         System.out.println("4. Calculate Average Marks");
         System.out.println("5. Exit");

         System.out.print("Enter Your Choise: ");
         int choice = input.nextInt();
         input.nextLine();

         switch (choice) {
            case 1:
               System.out.print("Enter your Name: ");
               String name = input.nextLine();
               System.out.print("Enter Your Roll Number: ");
               int rollNo = input.nextInt();
               System.out.print("Enter Your Age: ");
               int age = input.nextInt();
               System.out.print("Enter Your Marks: ");
               double marks = input.nextDouble();

               if (marks < 0) {
                  System.out.println("Error: Marks cannot be negative.");
               }
               else if (database.containsKey(rollNo)) {
                  System.out.println("Error: Roll number already exists.");
               }
               else {
                  student std = new student(name, rollNo, age, marks);
                  database.put(rollNo, std);
                  System.out.println("Student Added to the Database Successfully.");
               }
               break;
              
            case 2:
               System.out.println("List Of Students: ");
               for(student i : database.values()){
                  i.viewData();
               }
               break;
            case 3:
               System.out.print("Enter your Roll No.: ");
               int roll = input.nextInt();
               student data = database.get(roll);
               if (data != null) {
                  data.viewData();
               }
               else {
                  System.out.println("Student not Found.");
               }
               System.out.println("###################################");
               break;
            case 4:
               int totalStudent = database.size();
               double totalMarks = 0;
               for(student j : database.values()){
                  totalMarks = totalMarks +j.marks ;
               }
               if (totalStudent > 0) {
                  double averageMarks = totalMarks / totalStudent;
                  System.out.println("Average Marks = " + averageMarks);
               }
               else {
                  System.out.println("No students in the database.");
               }
               break;
            case 5:
               System.exit(0);
               input.close();
               break;
            default:
               System.out.println("Enter Proper Choise.");
               break;
         }
      }
   }
}

class student {
   public String name;
   public int rollNo;
   public int age;
   public double marks;

   public student(String name, int rollNo, int age, double marks){
      this.name = name;
      this.rollNo = rollNo;
      this.age = age;
      this.marks = marks;
   }

   public void viewData(){
      System.out.println("Name : "+ name);
      System.out.println("Roll No : "+ rollNo);
      System.out.println("Age : "+ age);
      System.out.println("Marks : "+ marks);
   }
}