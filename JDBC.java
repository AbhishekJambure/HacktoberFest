import java.sql.*;
import java.util.*;

public class JDBC {
	public static void main(String[] args) {
		int ch, cno;
		Scanner sc = new Scanner(System.in);
		ResultSet rs;
		Connection con = null;
		Statement st;
		PreparedStatement ps = null;
		try {
				//step1 - Load Driver....
				Class.forName("com.mysql.jdbc.Driver");
				//step2 - Connection to DB
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_name", "username", "password");
				System.out.println("Connection : "+con);
				
				//step3 - Operations on DB
				do {
					System.out.println("Menu\n1.Insert\n2.Delete\n3.Update\n4.Search\n5.Display DB");
					System.out.println("Enter your choice : ");
					ch = sc.nextInt();
					switch(ch)
					{
						case 1 : System.out.println("Enter EmpID, FirstName, LastName of Employee : ");
						 		 ps = con.prepareStatement("INSERT INTO Table1 VALUES(?, ?, ?)");
						 		 ps.setInt(1, sc.nextInt());
						 		 ps.setString(2, sc.next());
						 		 ps.setString(3, sc.next());
						 		 int i = ps.executeUpdate();
						 		 if(i>0)
						 		 {
						 			 System.out.println("Record Inserted...");
						 		 }
						 		 break;
						case 2 : System.out.println("Enter EmpID for Deleting : ");
						 		 ps = con.prepareStatement("DELETE FROM Table1 WHERE EmpID = ?");
						 		 ps.setInt(1, sc.nextInt());
						 		 int j = ps.executeUpdate();
						 		 if(j>0)
						 		 {
						 			 System.out.println("Record Deleted...");
						 		 }
						 		 break;
						case 3 : System.out.println("Enter EmpID and Last Name to update : ");
						 		 ps = con.prepareStatement("UPDATE Table1 SET LName = ? WHERE EmpID = ?");
						 		 ps.setInt(1, sc.nextInt());
						 		 ps.setString(2, sc.next());
						 		 int k = ps.executeUpdate();
						 		 if(k>0)
						 		 {
						 			 System.out.println("Record Updated...");
						 		 }
						case 4 : System.out.println("Enter EmpID of Employee whom to be searched : ");
								 ps = con.prepareStatement("SELECT * FROM Table1 WHERE EmpID = ?");
								 ps.setInt(1, sc.nextInt());
								 rs = ps.executeQuery();
								 rs.next();
								 System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
								 break;
						case 5 : String str = "SELECT * FROM Table1";
								 st = con.createStatement();
								 rs = st.executeQuery(str);
								 while(rs.next())
								 {
									 System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
								 }
						default : System.out.println("Invalid Input");
					}
					System.out.println("\nDo you want to continue?(Yes-1) : ");
					cno = sc.nextInt();
				}while(cno == 1);
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
		}
		sc.close();
	}
}
