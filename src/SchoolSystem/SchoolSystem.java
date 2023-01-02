package SchoolSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SchoolSystem {
	
//sql
	static String Url = "jdbc:sqlserver://localhost : 1433; databaseName= SchoolMgt ;encrypt = true ; trustServerCertificate = true";
	static String User = "sa";
	static String Pass = "root";
	
	int option;
	int option2;
	//localhost:1433//SchoolMgt";
//	static private String DbUrl = "jdbc: sqlserver // localhost : ; databaseName = SchoolMgt;encrypt = true ; trustServerCertificate = true";
	
	

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

//    			try (Connection conn = DriverManager.getConnection(Url, User, Pass);
//
//    					Statement stmt = conn.createStatement();) {
//
//    				String sql = "CREATE TABLE Students " + "(studentId INTEGER , " + " firstName VARCHAR(8), "
//    						+ " lastName VARCHAR(8), " + " birthdate date, " + " PRIMARY KEY ( studentId ))";
//
//    				stmt.executeUpdate(sql);
//    				System.out.println("Created table in given database...");
//    			} catch (SQLException e) {
//    				e.printStackTrace();
//    			}
    	
    	 try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
             // Registering drivers
             DriverManager.registerDriver(driver);

             // Reference to connection interface
             Connection conn = DriverManager.getConnection(Url, User,
            		 Pass);

             // Creating a statement
             Statement st = conn.createStatement();

             String sql = null;
			// Executing query
             int m = st.executeUpdate(sql);
             if (m >=  1)
                 System.out.println(
                         "inserted successfully : " + sql);
             else
                System.out.println("insertion failed");

             // Closing the connections
             conn.close();
         }

        // Catch block to handle exceptions
         catch (Exception ex) {
             // Display message when exceptions occurs
             System.err.println(ex);
         }
   	
   	
   	
    }
    
    static void subjectTable() {
		
		// To create Table of subjects

//				try (Connection conn = DriverManager.getConnection(Url, User, Pass);
//
//						Statement stmt = conn.createStatement();) {
//
//					String sql = "CREATE TABLE Subjects " + "(subjectId INTEGER , " + " title VARCHAR(8), "
//							+ " desc VARCHAR(250), " + " pricePerStudent decimal, " + " PRIMARY KEY ( subjectId ))";
//
//					stmt.executeUpdate(sql);
//
//					System.out.println("Created table in given database...");
//
//				} catch (SQLException e) {
//
//					e.printStackTrace();
//				}
//		
//	}
    	
    	 try {

             Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
              // Registering drivers
              DriverManager.registerDriver(driver);

              // Reference to connection interface
              Connection conn = DriverManager.getConnection(Url, User,
             		 Pass);

              // Creating a statement
              Statement st = conn.createStatement();

              String sql = null;
 			// Executing query
              int m = st.executeUpdate(sql);
              if (m >=  1)
                  System.out.println(
                          "inserted successfully : " + sql);
              else
                 System.out.println("insertion failed");

              // Closing the connections
              conn.close();
          }

         // Catch block to handle exceptions
          catch (Exception ex) {
              // Display message when exceptions occurs
              System.err.println(ex);
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

		System.out.println("subjectId = " + subjectId);
		System.out.println("title = " + title);
		System.out.println("desc = " + desc);
		System.out.println("price Per Student = " + pricePerStudent);
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

		String Url = "jdbc:sqlserver://localhost : 1433; databaseName= SchoolMgt ;encrypt = true ; trustServerCertificate = true";
		String User = "sa";
		String Pass = "root";

		

		boolean exit = false;

		int option;
		
		mainMenue();

		do {
			

			
			
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
