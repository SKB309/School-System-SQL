package MainSqlDb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;





public class Main {
	
	
	
	public static void main(String a[]) throws NumberFormatException {
        // Creating the connection using Oracle DB
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:sqlserver://localhost:1433/SQLtaskDatabase";
        // Username and password to access DB
        // Custom initialization
        String user = "sa";
        String pass = "alblushi";
        // Entering the data
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter first name");
        String firstName = scanner.next();
        
        System.out.println("enter Second name");
        String secondName = scanner.next();
        
        System.out.println("enter Phone Number no");
        Integer phoneNumber = scanner.nextInt();
        System.out.println("enter Age");
        String age = scanner.next();
        // Inserting data using SQL query
        String sql = "insert into Studentss values('" + firstName
                + "','" + secondName + "'," + phoneNumber + ",'" + age + "')";
        // Connection class object
        Connection con = null;
        // Try block to check for exceptions
        try {
            Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Registering drivers
            DriverManager.registerDriver(driver);
            // Reference to connection interface
            con = DriverManager.getConnection(url, user,
                    pass);
            // Creating a statement
            Statement st = con.createStatement();
            // Executing query
            int m = st.executeUpdate(sql);
            if (m >=  1)
                System.out.println(
                        "inserted successfully : " + sql);
            else
                System.out.println("insertion failed");
            // Closing the connections
            con.close();
        }
        // Catch block to handle exceptions
        catch (Exception ex) {
            // Display message when exceptions occurs
            System.err.println(ex);
        }
	}
}
