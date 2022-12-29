package SchoolSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SchoolSystem {
	
	
	int option;
	int option2;
	static private String DbUrl = "jdbc:sqlserver://localhost:1433//SchoolMgt";
	static private String User = "sa";
	static private String Pass = "said";

	static String firstName;
	static String lastName;
	static String title;
	static String desc;
	static Integer studentId;
	static Integer birthdate;
	static Integer subjectId;
	static Integer pricePerStudent;

	static void mainMenue() {

		Scanner sc = new Scanner(System.in);

		System.out.println("+++++++++++++HELLO+++++++++++++");
		System.out.println("1. Add Student table ");
		System.out.println("2. Add Subject table ");
		System.out.println("3. Select Top Student ");
		System.out.println("4. Select Top Subject ");
		System.out.println("5. Add Fake Students");
		System.out.println("0. Exit ");
		String option = sc.next();

	}

    static void studentTable() {
    	// To create Table of students

    			try (Connection conn = DriverManager.getConnection(DbUrl, User, Pass);

    					Statement stmt = conn.createStatement();) {

    				String sql = "CREATE TABLE Students " + "(studentId INTEGER not NULL, " + " firstName VARCHAR(8), "
    						+ " lastName VARCHAR(8), " + " birthdate date, " + " PRIMARY KEY ( studentId ))";

    				stmt.executeUpdate(sql);
    				System.out.println("Created table in given database...");
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    	
    	
    	
    }
    
    static void subjectTable() {
		
		// To create Table of subjects

				try (Connection conn = DriverManager.getConnection(DbUrl, User, Pass);

						Statement stmt = conn.createStatement();) {

					String sql = "CREATE TABLE Subjects " + "(subjectId INTEGER not NULL, " + " title VARCHAR(8), "
							+ " desc VARCHAR(250), " + " pricePerStudent decimal, " + " PRIMARY KEY ( subjectId ))";

					stmt.executeUpdate(sql);

					System.out.println("Created table in given database...");

				} catch (SQLException e) {

					e.printStackTrace();
				}
		
	}

	static void  selectTopStudents() {
		
		Scanner sc = new Scanner(System.in);
		Student student = new Student();

		System.out.println("ID = " + studentId);
		System.out.println("FirstName = " + firstName);
		System.out.println("LastName = " + lastName);
		System.out.println("Birthdate = " + birthdate);
	}

	static void selectTopSubject() {
		Scanner sc = new Scanner(System.in);
		Subjects subjects = new Subjects();

		System.out.println("ID = " + subjectId);
		System.out.println("FirstName = " + title);
		System.out.println("LastName = " + desc);
		System.out.println("Birthdate = " + pricePerStudent);
	}

	static void addFakeStudents() {
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println(" 1- List Top 100 Students ");
		System.out.println(" 2- List Top 50 Subjects ");
		System.out.println(" 3- Add a new Student ");
		System.out.println(" 4- Add a new Subject ");
		System.out.println(" 5- Load 1000000 student in Students Table ");
		System.out.println(" 6- Load 100000 subjects in Subjects Table ");
		System.out.println(" 7- Exit App ");
		int option2 = sc.nextInt();


	}

	static void option0() {

		System.out.println("* * * * * * *  Exit  * * * * * * * * * *");
		System.out.println("* * * * * *  THANK YOU  * * * * * * * *");

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		Subjects subjects = new Subjects();

		

		

		boolean exit = false;

		int option;

		do {
			

			mainMenue();
			
			int option1 = sc.nextInt();
			
			
			switch (option1) {
			
			
			
			case 1:
				
				studentTable();

				
				break;
				
			case 2:
				subjectTable();
				
				break;
				
				
			case 3:
				selectTopStudents();
				break;

			case 4:
				selectTopSubject();
				break;

			case 5:
				addFakeStudents();
				break;

			case 0:
				
				option0();
				
				exit = false;
				
				break;

			default:

				System.out.println("please chose correct Number");

			}

		} while (exit);

	}

}
