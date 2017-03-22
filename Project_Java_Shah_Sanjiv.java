package Shah_Sanjiv;
//import JAVA libraries
import java.io.*;
import java.sql.*;
//import java.util.*;
import java.util.Scanner;



public class Future 
{

	public static void main(String[] args) 
	{
		// Local variables
		boolean validChoice;
		Scanner in = new Scanner (System.in);
		int choice = -1;
		
		//Show Available Options
		while(true)
		{
			//Call method to display options
			UtilityMethodsClass.DisplayOptions();
			
			//Read and validate user choice
			validChoice = false;
			while(!validChoice)
			{
				try
				{
					//Read user choice as integer
					choice = Integer.parseInt(in.nextLine());
					if (choice > 0 && choice <=20)
					{
						//when choice is valid, break the loop to handle the choice
						validChoice = true;
						break;
					} else {
						System.out.println("Please make a valid choice between 1 and 20!!!");
					}
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
				//System.out.println("Please make a valid choice between 1 and 20!!!");
			}
			switch(choice)
			{
			//Query 1: Add a new employee
			case 1: System.out.println("You have chosen Option 1");
					UtilityMethodsClass.AddEmployee();
					break;
			
			//Query 2: Ender a new product
			case 2: System.out.println("You have chosen Option 2");
					UtilityMethodsClass.AddProduct();
					break;
					
			//Query 3: Enter a customer associate with some products
			case 3: System.out.println("You have chosen Option 3");
					UtilityMethodsClass.AddCustomer();
					break;
					
			//Query 5: Enter a complaint associated with a customer
			case 5: System.out.println("You have chosen Option 5");
					UtilityMethodsClass.AddComplaint();
					break;
					
			//Query 6: Enter an accident associated with an employee and a product
			case 6: System.out.println("You have chosen Option 6");
					UtilityMethodsClass.AddAccident();
					break;
					
			//Query 7: Retrieve the date produced and time spent on producing a product
			case 7: System.out.println("You have chosen Option 7");
					UtilityMethodsClass.FindTimeDate();
					break;
			
			//Query 8: Retrieve all products made by a particular worker
			case 8: System.out.println("You have chosen Option 8");
			UtilityMethodsClass.ProductsWorker();
			break;
			
			//Query 9: Errors by a particular quality controller
			case 9: System.out.println("You have chosen Option 9");
			UtilityMethodsClass.ControllerErrors();
			break;
			
			/*Query 10: Retrieve the total costs of products repaired in product3 category\n 
			requested by a specific controller */
			case 10: System.out.println("You have chosen Option 10");
			UtilityMethodsClass.TotalCostRepairsProduct3OneQC();
			break;
			
			//Query 11: All customers who purchased all products of a particular color.
			case 11: System.out.println("You have chosen Option 11");
			UtilityMethodsClass.CustomersOneColor();
			break;
			
			//Query 12: Work Days Lost due to accidents - Repairs from Complaints
			case 12: System.out.println("You have chosen Option 12");
			UtilityMethodsClass.DaysLostRepairsComplaints();
			break;
			
			//Query 13: Find all customers who are also workers
			case 13: System.out.println("You have chosen Option 13");
			UtilityMethodsClass.FindCustWorkers();
			break;
			
			//Query 14: Customer name who made/checked/repaired the product he bought
			case 14: System.out.println("You have chosen Option 14");
			UtilityMethodsClass.findCust14();
			break;
			
			//Query 15: Retrieve the average cost of all products made in a particular year
			case 15: System.out.println("You have chosen Option 15");
			UtilityMethodsClass.AvgCost();
			break;
			
			//Query 16: Switch the position between a technical staff and a quality controller
			case 16: System.out.println("You have chosen Option 16");
			UtilityMethodsClass.SwitchPosition();
			break;
			
			//Query 17: Delete all accidents whose dates are in some range
			case 17: System.out.println("You have chosen Option 17");
			UtilityMethodsClass.DeleteAccidents();
			break;
			
			//Query 18: Import New Customer from a file
			case 18: System.out.println("You have chosen Option 18");
			UtilityMethodsClass.CsvFileReader();
			break;
			
			//Query 19: Export. Retrieve all customers in (name order)and output them to a data file
			case 19: System.out.println("You have chosen Option 19");
			UtilityMethodsClass.SaveCustomersToFile();
			break;
			
			
			case 20: System.out.println("You have chosen Option 20.\n"
					+ "The Application is Terminated");
					System.exit(0);
			
			}
			System.out.println("***********************************************");
			//in.close();
		}
		
	}
//---------------------------------------------------------------------------------------
	//Static class with all method definitions
	protected static class UtilityMethodsClass
	{
		//DisplayChoices Method: display all the available options
		public static void DisplayOptions()
		{
			System.out.println("Welcome to FUTURE, Inc.");
			System.out.println("Please Type One Of the Following Options:");
			System.out.println("PLEASE NOTE THAT OPTION 4 IS NOT AVAILABLE");
			System.out.println("Welcome to FUTURE, Inc.");
			System.out.println("1. Enter a new Employee");
			System.out.println("2. Enter a New Product");
			System.out.println("3. Enter a Customer Assoicated with some Products");
			System.out.println("5. Enter a Complaint");
			System.out.println("6. Enter an Accident");
			System.out.println("7. Retrieve Date Produced and Time Spent on a Product");
			System.out.println("8. Retrieve all Products Produced by a Worker");
			System.out.println("9. Retrieve Total Number of Errors Made by a Quality Controller");
			System.out.println("10. Retrieve Total Cost of products in Product 3 Category Which were \n    "
					+ "Repaired at the Request of a Particular Quality Controller");
			System.out.println("11. Retrieve all Customers who purchased Products of a Specific Color");
			System.out.println("12. Retrieve Total Workdays Lost due to Accidents in Repairing\n"
					+ "    Products that Receieved Complaints");
			System.out.println("13. Retrieve all Customers who are also Workers");
			System.out.println("14. Retrieve All Customers Who Have Purchased Products Made or Certified or\n"
					+ "Repaired by Themelves");
			System.out.println("15. Retrive the Average cost of all Products made in a Particular Year");
			System.out.println("16. Switch the position Between a Technical Staff an a Quality Controller");
			System.out.println("17. Delete All Accidents in a Date Range");
			System.out.println("18. Import: Enter New Customers From a Data File Until the File is Empty");
			System.out.println("19. Export: Retrieve All Customers (in Name Order) and Output them to a Datafile");
			System.out.println("20. Quit the Program");
			System.out.println("Please Enter the Number Corrosponding to Your Choice");
		}
//------------------------------------------------------------------------------------------
		//Method to Create Database Connection
		public static Connection dbconnect()  //create method database connection
		{
			Connection dbConnection = null;
			try
			{
				Class.forName("oracle.jdbc.OracleDriver"); //check if class exists else catch exception
			}
			catch(Exception x)
			{
				System.out.println("unable to load the driver class");
			}
			
			
			try
			{
				dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu","shah0542","YUru6Nq3");
			}
			catch(Exception e)
			{
				System.out.println("Connection Error!");
			}
			return dbConnection;
		}
//---------------------------------------------------------------------------------------
		//Query No. 1: Add a new Employee
		public static void AddEmployee()
		{
			try
			{
				Connection dbConnection = dbconnect(); //initialize database connection
								
				System.out.println("Please Enter Employee Name");
				Scanner scan_1 = new Scanner(System.in);
				String emp_name = scan_1.nextLine();
				
				System.out.println("Please Enter Employee Address:");
				Scanner scan_2 = new Scanner(System.in);
				String emp_address = scan_2.nextLine();
				
				System.out.println("Please Enter Employee Type:\n Enter '1' for Worker\n Enter '2' for Quality Controller And\n"
						+ " '3' for Technical Worker");
				Scanner scan_3 = new Scanner(System.in);
				int emp_type = scan_3.nextInt();
				
				System.out.println(emp_name + emp_address);
				switch(emp_type)
				{
				//Production Employee
				case 1: System.out.println("Please enter number of products per hour for this worker");
						Scanner scan_4 = new Scanner(System.in);
						int num_products = scan_4.nextInt();
						//call stored procedure for new worker
						CallableStatement storproccall_1 = dbConnection.prepareCall("call ENTER_NEW_WORKER(?,?,?,?)");
						storproccall_1.setString(1, emp_name);
						storproccall_1.setString(2, emp_address);
						storproccall_1.setInt(3, emp_type);
						storproccall_1.setInt(4, num_products);
						//Execute procedure
						storproccall_1.execute();
						//Display Success Message
						System.out.println("\n\nWorker " +emp_name +" added\n\n");
						break;
				//QC Employee
				case 2: System.out.println("Please Enter Type of Product This Worker Tests\n"
						+ "Please Enter '1', '2' or '3' ");
						Scanner scan_5 = new Scanner(System.in);
						int prod_type = scan_5.nextInt();
						//call stored procedure for new worker
						CallableStatement storproccall_2 = dbConnection.prepareCall("call ENTER_NEW_QC(?,?,?,?)");
						storproccall_2.setString(1, emp_name);
						storproccall_2.setString(2, emp_address);
						storproccall_2.setInt(3, emp_type);
						storproccall_2.setInt(4, prod_type);
						//Execute procedure
						storproccall_2.execute();
						//Display Success Message
						System.out.println("\n\nQuality Controller " +emp_name +" added\n\n");
						break;
				//Technical Employee
				case 3: System.out.println("Please Enter Level of Education for this Employee\n"
						+ "Enter 'B' for a Bachelor's Degree,\n 'M' of Master's Degree or\n 'P' for Docterate Degree");
						Scanner scan_6 = new Scanner(System.in); 
						String emp_degree = scan_6.nextLine();
						//call stored procedure for new worker
						CallableStatement storproccall_3 = dbConnection.prepareCall("call ENTER_NEW_TECH(?,?,?,?)");
						storproccall_3.setString(1, emp_name);
						storproccall_3.setString(2, emp_address);
						storproccall_3.setInt(3, emp_type);
						storproccall_3.setString(4, emp_degree);
						//Execute procedure
						storproccall_3.execute();
						//Display Success Message
						System.out.println("\n\nTechnical Staff " +emp_name +" added\n\n");
						break;
				}
				
			}
			//Catch Exception if fail
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
//---------------------------------------------------------------------------------------
		//Query #2: Add a new Product
		public static void AddProduct()
		{
			try
			{
				Connection dbConnection = dbconnect(); //initialize database connection
								
				System.out.println("Please Enter the Product Type\n"
						+ "Enter '1'if Product Type = Product1\n"
						+ "Enter '2'if Product Type = Product2\n"
						+ "Enter '3'if Product Type = Product3\n");
				Scanner scan1 = new Scanner(System.in);
				int prod_type = scan1.nextInt();
				
				System.out.println("Please enter the date product was produced in the 'dd-MON-yy' format\n"
						+ "For example: for Nov 1, 2016, please enter '01-NOV-16' ");
				Scanner scan2 = new Scanner(System.in);
				String prod_date = scan2.nextLine();
				
				System.out.println("Please Enter Time Spent on making this product in minutes");
				Scanner scan3 = new Scanner(System.in);
				double time_spent = scan3.nextDouble();
				
				System.out.println("Please Enter Size of the Product\n"
						+ "For Small, Enter 'S'\n"
						+ "For Medium, Enter 'M'\n"
						+ "For Large, Enter 'L'\n");
				Scanner scan4 = new Scanner(System.in);
				String prod_size = scan4.nextLine();
				
				System.out.println("Please Enter the Name of Employee Who Made the Product");
				Scanner scan5 = new Scanner(System.in);
				String mk_emp_name = scan5.nextLine();
				
				System.out.println("Please Enter the Name of Employee Who Checked the Product");
				Scanner scan6 = new Scanner(System.in);
				String chk_emp_name = scan6.nextLine();
				
				System.out.println("Please Enter Results of QC Check\n"
						+ "Please Enter 'P' for Pass and 'F' for Fail");
				Scanner scan7 = new Scanner(System.in);
				String chk_result = scan7.nextLine();
				
				//System.out.println(chk_result);
				//System.out.println(chk_result.equals("F"));
				
				String rep_emp_name = "NONE";
				if (chk_result.equals("F"))
				{
					System.out.println("Please Enter Employee Name who Repaired the Product");
					Scanner scan8 = new Scanner(System.in);
					rep_emp_name = scan8.nextLine();
				}
				System.out.println("Please Enter Total Cost for Producting This Product");
				Scanner scan9 = new Scanner(System.in);
				double prod_cost = scan9.nextDouble();
				
				String prod_type_data = "";
				switch(prod_type)
				{
				case 1: System.out.println("Please enter Name of the Software used to Manufacture this Product");
						Scanner scan10 = new Scanner(System.in);
						prod_type_data = scan10.nextLine();
						break;
				case 2: System.out.println("Please enter Color this Product");
						Scanner scan11 = new Scanner(System.in);
						prod_type_data = scan11.nextLine();
						break;
				case 3: System.out.println("Please enter the Weight (in Pounds) of this Product");
						Scanner scan12 = new Scanner(System.in);
						prod_type_data = scan12.nextLine();
						break;
				}
				CallableStatement storproccall_4 = dbConnection.prepareCall("call ENTER_NEW_PROD(?,?,?,?,?,?,?,?,?,?)");
				storproccall_4.setInt(1, prod_type);
				//storproccall_4.setDate(2, java.sql.Date.valueOf(prod_date));
				storproccall_4.setString(2, prod_date);
				storproccall_4.setDouble(3, time_spent);
				storproccall_4.setString(4, prod_size);
				storproccall_4.setString(5, mk_emp_name);
				storproccall_4.setString(6, chk_emp_name);
				storproccall_4.setString(7, chk_result);
				storproccall_4.setString(8, rep_emp_name);
				storproccall_4.setDouble(9, prod_cost);
				storproccall_4.setString(10, prod_type_data);
				//Execute Procedure
				storproccall_4.execute();
				
				//Display Success
				System.out.println("Product added to Product, Makes, Checks, Repairs and Account Data Tables");
				
			}
			//Catch Exception if fail
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
//---------------------------------------------------------------------------------------
		//Query 3: Add a Customer Associated with some products
		public static void AddCustomer()
		{
			try
			{
				Connection dbConnection = dbconnect(); //initialize database connection
								
				System.out.println("Please Enter a Customer Name");
				Scanner scan31 = new Scanner(System.in); 
				String cust_name = scan31.nextLine();
				
				System.out.println("Please Enter Customer Address");
				Scanner scan32 = new Scanner(System.in); 
				String cust_address = scan32.nextLine();
				
				CallableStatement storproccall_5 = dbConnection.prepareCall("call ENTER_NEW_CUSTOMER(?,?)");
				storproccall_5.setString(1, cust_name);
				storproccall_5.setString(2, cust_address);
				
				//Execute Procedure
				storproccall_5.execute();
				
				//Display Success
				System.out.println("New Customer " + cust_name + " successfully added.");
				
				//Add Products
				System.out.println("Please Add a Product ID for this Customer");
				Scanner scan33 = new Scanner(System.in); 
				int purchase_id = scan33.nextInt();
				
				//Add to Purchase
				CallableStatement storproccall_6 = dbConnection.prepareCall("call ENTER_NEW_PURCHASE(?,?)");
				storproccall_6.setInt(1, purchase_id);
				storproccall_6.setString(2, cust_name);
				storproccall_6.execute();
				
				//Display Success
				System.out.println("Product "+ purchase_id + " added to Customer " +cust_name + "'s purchase record.");
				
				while(purchase_id != 0)
				{
					System.out.println("Please Enter Another Product ID for This Customer\n"
							+ " or Enter '0' If Customer Purchase is Complete");
					Scanner scan34 = new Scanner(System.in); 
					purchase_id = scan34.nextInt();
					if (purchase_id != 0)
					{
						storproccall_6.setInt(1, purchase_id);
						storproccall_6.setString(2, cust_name);
						storproccall_6.execute();
						
						//Display Success
						System.out.println("Product "+ purchase_id + " added to Customer " +cust_name + "'s purchase record.");
					}
					else break;
				
				}
				
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
//---------------------------------------------------------------------------------------
		//Query 5: Enter a Complaint
		public static void AddComplaint()
		{
			try
			{
				Connection dbConnection = dbconnect(); //initialize database connection
				
				System.out.println("Enter Customer Name");
				Scanner scan51 = new Scanner(System.in);
				String comp_cust_name = scan51.nextLine();
				
				System.out.println("Enter Product ID");
				Scanner scan52 = new Scanner(System.in);
				int comp_prod_id = scan52.nextInt();
				
				System.out.println("Enter Date of Complaint in 'dd-MON-yy' Format");
				Scanner scan56 = new Scanner(System.in);
				String comp_date = scan56.next();
				
				System.out.println("Describe Complaint");
				Scanner scan53 = new Scanner(System.in);
				String comp_description = scan53.next();
				
				System.out.println("Enter Complaint Resolution\n"
						+ "Enter 'R' for Refund\n"
						+ "Enter 'E' for Exchange\n");
				Scanner scan54 = new Scanner(System.in);
				String comp_resolution = scan54.nextLine();
				
				System.out.println("Enter an Employee Name Who will be Assigned to Repair this Product");
				Scanner scan55 = new Scanner(System.in);
				String rep_emp_name = scan55.nextLine();
				
				CallableStatement storproccall_7 = dbConnection.prepareCall("call ENTER_NEW_COMPLAINT(?,?,?,?,?,?)");
				storproccall_7.setString(1,comp_cust_name);
				storproccall_7.setInt(2, comp_prod_id);
				storproccall_7.setString(3, comp_date);
				storproccall_7.setString(4, comp_description);
				storproccall_7.setString(5, comp_resolution);
				storproccall_7.setString(6, rep_emp_name);
				
				storproccall_7.execute();
				
				//Display Success
				System.out.println("New Complaint for Customer: " +comp_cust_name +" for product ID: " +comp_prod_id + " added.");
				
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
//---------------------------------------------------------------------------------------
		//Query 6: Enter an accident
		public static void AddAccident()
		{
			try
			{
				Connection dbConnection = dbconnect(); //initialize database connection
				Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
				
				System.out.println("Enter Product ID that was Invloved in the Accident");
				Scanner scan61 = new Scanner(System.in);
				int acc_prod_id = scan61.nextInt();
				
				System.out.println("Please Enter the date of Accident 'dd-MON-YY' format\n"
						+ "For example: for Nov 1, 2016, please enter '01-NOV-16' ");
				Scanner scan62 = new Scanner(System.in);
				String acc_date = scan62.nextLine();
				
				System.out.println("Enter Number of Days Lost Due to Accident");
				Scanner scan63 = new Scanner(System.in);
				int days_lost = scan63.nextInt();
				
				CallableStatement storproccall_8 = dbConnection.prepareCall("call ENTER_NEW_ACCIDENT(?,?,?)");
				storproccall_8.setInt(1, acc_prod_id);
				storproccall_8.setString(2, acc_date);
				storproccall_8.setInt(3, days_lost);
				
				
				storproccall_8.execute();
				
				//Display Success
				System.out.println("A new Accident involving Product ID: " +acc_prod_id +" was recorded.");
				
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
//---------------------------------------------------------------------------------------
		//Query 7: Retrieve the Date and Time Spent to produce a particular product.
		public static void FindTimeDate()
		{
			try
			{
				Connection dbConnection = dbconnect(); //initialize database connection
				Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
				
				Scanner in = new Scanner(System.in); //Scanner object to read input parameters
				
				System.out.println("Enter a product ID");
				int query_id = in.nextInt();
				ResultSet rset = stmt.executeQuery("select prod_date, time_spent from Products where prod_id =" + query_id);
				
				ResultSetMetaData rset_md =rset.getMetaData();
				System.out.println("Querying to Find Production Date and Time Spent on Producing Product ID: " + query_id);
				int columnsNumber = rset_md.getColumnCount();
				while(rset.next())
				{
					for (int i = 1; i <= columnsNumber; i++)
					{
						if (i > 1)System.out.print(", ");
						String columnValue = rset.getString(i);System.out.print(columnValue + " " + rset_md.getColumnName(i));
					}
				System.out.println("");		
				}
				
				in.close();
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

//------------------------------------------------------------------------------------------------------------
		//Query 8: Retrieve all products made by a particular worker
		public static void ProductsWorker()
		{
			try
			{
				Connection dbConnection = dbconnect(); //initialize database connection
				Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
				
				System.out.println("Enter a Production Worker's Name");
				Scanner scan81 = new Scanner(System.in);
				String query_name = scan81.nextLine();
				
				ResultSet rset = stmt.executeQuery("SELECT mk_prod_id FROM MAKES WHERE mk_emp_name = '" +query_name+ "'");
				
				ResultSetMetaData rset_md =rset.getMetaData();
				System.out.println("Querying to Find All Products made by " + query_name);
				int columnsNumber = rset_md.getColumnCount();
				while(rset.next())
				{
											
					for (int i = 1; i <= columnsNumber; i++)
					{
						if (i > 1)System.out.print(", ");
						String columnValue = rset.getString(i);System.out.print(columnValue + " " + rset_md.getColumnName(i));
					}
				System.out.println("");		
				}
				
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
//-----------------------------------------------------------------------------------------------------------
		//Query 9: Errors by a particular quality controller
		public static void ControllerErrors()
		{
			try
			{
				Connection dbConnection = dbconnect(); //initialize database connection
				Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
				
				System.out.println("Please Enter Controller Name");
				Scanner scan9_1 = new Scanner(System.in);
				String query_controller = scan9_1.nextLine();
				
				ResultSet rset = stmt.executeQuery("select comp_prod_id from Complaint inner join CHK_PROD on Complaint.comp_prod_id = "
						+ "CHK_PROD.chk_prod_id WHERE CHK_PROD.chk_emp_name = '" + query_controller+ "'");
				
				ResultSetMetaData rset_md =rset.getMetaData();
				System.out.println("Querying to Find Defective Products Checked by " + query_controller);
				int columnsNumber = rset_md.getColumnCount();
				while(rset.next())
				{
					for (int i = 1; i <= columnsNumber; i++)
					{
						if (i > 1)System.out.print(", ");
						String columnValue = rset.getString(i);System.out.print(columnValue + " " + rset_md.getColumnName(i));
					}
				System.out.println("");		
				}
				
				
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
//-------------------------------------------------------------------------------------------------------------
		//Query 10: Retrieve the total costs of products repaired in product3 category requested by a specific controller
		public static void TotalCostRepairsProduct3OneQC()
		{
			try
			{
				Connection dbConnection = dbconnect(); //initialize database connection
				Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
				
				
				System.out.println("Please Enter Controller Name");
				Scanner scan10_1 = new Scanner(System.in); 
				String query_controller = scan10_1.next();
				
				ResultSet rset = stmt.executeQuery("select sum(cost_3) from ACCT_3 inner join CHK_PROD on "
						+ "ACCT_3.acct3_id = CHK_Prod.chk_prod_id WHERE CHK_PROD.chk_emp_name ='" + query_controller+ "'");
				
				ResultSetMetaData rset_md =rset.getMetaData();
				System.out.println("Querying to Find Cost of Repairs Request by" + query_controller);
				int columnsNumber = rset_md.getColumnCount();
				while(rset.next())
				{
					for (int i = 1; i <= columnsNumber; i++)
					{
						if (i > 1)System.out.print(", ");
						String columnValue = rset.getString(i);System.out.print(columnValue + " " + rset_md.getColumnName(i));
					}
				System.out.println("");		
				}
				
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
//-------------------------------------------------------------------------------------------------------------------
			//Query 11: All customers who purchased all products of a particular color.
			public static void CustomersOneColor()
			{
				try
				{
					Connection dbConnection = dbconnect(); //initialize database connection
					Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
					
					System.out.println("Please Enter the Color of Products");
					Scanner scan11_1 = new Scanner(System.in); //Scanner object to read input parameters
					String query_color = scan11_1.next();
					
					ResultSet rset = stmt.executeQuery("select purchase_cust_name FROM PURCHASE NATURAL join PRODUCT_2 "
							+ "WHERE prod2_clr ='" + query_color+ "'");
					
					ResultSetMetaData rset_md =rset.getMetaData();
					System.out.println("Querying to Find Customers Who Bought Products that are " + query_color);
					int columnsNumber = rset_md.getColumnCount();
					while(rset.next())
					{
						for (int i = 1; i <= columnsNumber; i++)
						{
							if (i > 1)System.out.print(", ");
							String columnValue = rset.getString(i);System.out.print(columnValue + " " + rset_md.getColumnName(i));
						}
					System.out.println("");		
					}
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
//--------------------------------------------------------------------------------------------------------------------
			//Query 12: Work Days Lost due to accidents - Repairs from Complaints
			public static void DaysLostRepairsComplaints()
			{
				try
				{
					Connection dbConnection = dbconnect(); //initialize database connection
					Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
					
					ResultSet rset = stmt.executeQuery("SELECT sum(days_lost) FROM ACCIDENTS WHERE EXISTS"
							+ "(SELECT comp_prod_id FROM COMPLAINT)");
					
					ResultSetMetaData rset_md =rset.getMetaData();
					System.out.println("Querying to Find Work Days Lost Due to Accidents Repairing Sold Products");
					int columnsNumber = rset_md.getColumnCount();
					while(rset.next())
					{
						for (int i = 1; i <= columnsNumber; i++)
						{
							if (i > 1)System.out.print(", ");
							String columnValue = rset.getString(i);System.out.print(columnValue + " " + rset_md.getColumnName(i));
						}
					System.out.println("");		
					}
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
//-------------------------------------------------------------------------------------------------------------
			//Query 13: Find all customers who are also workers
			public static void FindCustWorkers()
			{
				try
				{
					Connection dbConnection = dbconnect(); //initialize database connection
					Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
					
					ResultSet rset = stmt.executeQuery("SELECT cust_name from CUSTOMER WHERE cust_name IN (SELECT empw_name FROM EMPLOYEE_W)");
					
					ResultSetMetaData rset_md =rset.getMetaData();
					System.out.println("Querying to Find Workers who are also Customers");
					int columnsNumber = rset_md.getColumnCount();
					while(rset.next())
					{
						for (int i = 1; i <= columnsNumber; i++)
						{
							if (i > 1)System.out.print(", ");
							String columnValue = rset.getString(i);System.out.print(columnValue + " " + rset_md.getColumnName(i));
						}
					System.out.println("");		
					}
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
//---------------------------------------------------------------------------------------------------------------
			//Query 14: Customer name who made/checked/repaired the product he bought
			public static void findCust14()
			{
				try
				{
					Connection dbConnection = dbconnect(); //initialize database connection
					Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
					ResultSet rset = stmt.executeQuery("select * from Purchase Where EXISTS"
							+ "(select * from Makes WHERE PURCHASE.purchase_id = Makes.mk_prod_id"
							+ "AND PURCHASE.purchase_cust_name = MAKES.mk_emp_name)"
							+ "UNION ALL select * from Purchase Where EXISTS"
							+ "(select * from REPAIRS WHERE PURCHASE.purchase_id = REPAIRS.rep_prod_id"
							+ "AND PURCHASE.purchase_cust_name = REPAIRS.rep_emp_name)"
							+ "UNION ALL select * from Purchase Where EXISTS"
							+ "(select * from CHK_PROD WHERE PURCHASE.purchase_id = CHK_PROD.chk_prod_id"
							+ "AND PURCHASE.purchase_cust_name = CHK_PROD.chk_emp_name)");
							
							
					
					ResultSetMetaData rset_md =rset.getMetaData();
					System.out.println("Querying to Find Customers Who Made/Checked/Repaired the Products they bought");
					int columnsNumber = rset_md.getColumnCount();
					while(rset.next())
					{
						for (int i = 1; i <= columnsNumber; i++)
						{
							if (i > 1)System.out.print(", ");
							String columnValue = rset.getString(i);System.out.print(columnValue + " " + rset_md.getColumnName(i));
						}
					System.out.println("");		
					}
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
//---------------------------------------------------------------------------------------
			//Query 15: Retrieve the average cost of all products made in a particular year
			public static void AvgCost()
			{
				try
				{
					Connection dbConnection = dbconnect(); //initialize database connection
					Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
					
					
					System.out.println("Please Enter the 2 digit year");
					Scanner scan15_1 = new Scanner(System.in);
					String query_year = scan15_1.nextLine();
					
					ResultSet rset = stmt.executeQuery("SELECT AVG(acct_cost) FROM ACCT WHERE to_date('01-JAN-"+query_year +
							"') <= Acct.date_created AND ACCT.date_created <= to_date('31-DEC-"+query_year+"')");
					//Print Results
					ResultSetMetaData rset_md =rset.getMetaData();
					System.out.println("Querying to Find Average Cost of All Products Made in Year 20"+query_year);
					int columnsNumber = rset_md.getColumnCount();
					while(rset.next())
					{
						for (int i = 1; i <= columnsNumber; i++)
						{
							if (i > 1)System.out.print(", ");
							String columnValue = rset.getString(i);System.out.print(columnValue + " " + rset_md.getColumnName(i));
						}
					System.out.println("");		
					}
					
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
//--------------------------------------------------------------------------------------
			//Query 16: Switch the position between a technical staff and a quality controller
			public static void SwitchPosition()
			{
				try
				{
					Connection dbConnection = dbconnect(); //initialize database connection
					
					System.out.println("Please Enter QUALITY CONTROLLER's Name");
					Scanner scan16_1 = new Scanner(System.in);
					String empq_name_q16 = scan16_1.next();
					
					System.out.println("Please Enter TCHNICAL STAFF's NAME");
					Scanner scan16_2 = new Scanner(System.in);
					String empt_name_q16 = scan16_2.next();
					
					CallableStatement storproccall_9 = dbConnection.prepareCall("call SWITCH_POSITIONS(?,?)");
					storproccall_9.setString(1, empq_name_q16);
					storproccall_9.setString(2, empt_name_q16);
										
					storproccall_9.execute();
					
					//Display Success
					System.out.println("Qulity Controller: " +empq_name_q16 +" is now a Technical Staff.\n");
					System.out.println("Technical Staff: " +empt_name_q16 +" is now a Qulity Controller.\n");
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
//-------------------------------------------------------------------------------------------------------------
			//Query 17: Delete all accidents whose dates are in some range
			public static void DeleteAccidents()
			{
				try
				{
					Connection dbConnection = dbconnect(); //initialize database connection
					Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
					
					System.out.println("Please Enter the Start Date of Accidents in dd-MON-yy format\n"
							+ "For example: for Nov 1, 2016, please enter 01-NOV-16");
					Scanner scan17_1 = new Scanner(System.in);
					String start_date = scan17_1.nextLine();
					
					System.out.println("Please Enter the End Date of Accidents in dd-MON-yy format\n"
							+ "For example: for Nov 1, 2016, please enter 01-NOV-16");
					Scanner scan17_2 = new Scanner(System.in);
					String end_date = scan17_2.nextLine();
					
					ResultSet rset = stmt.executeQuery("DELETE * FROM ACCIDENTS where acc_date between to_date('"+start_date +
							"') AND to_date('"+start_date +"')");
					
					//Print Results
					ResultSetMetaData rset_md =rset.getMetaData();
					System.out.println("Querying to Find Deleted Accidents");
					int columnsNumber = rset_md.getColumnCount();
					while(rset.next())
					{
						for (int i = 1; i <= columnsNumber; i++)
						{
							if (i > 1)System.out.print(", ");
							String columnValue = rset.getString(i);System.out.print(columnValue + " " + rset_md.getColumnName(i));
						}
					System.out.println("");		
					}
					
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
//-------------------------------------------------------------------------------------------------------
			//Query 18: Import New Customer from  a file
			public static void CsvFileReader()
			{
				BufferedReader fileReader = null;
				final String COMMA_DELIMITER = "," ;
				String line = "";
				try
				{
					Connection dbConnection = dbconnect(); //initialize database connection
					Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
					
					Scanner in = new Scanner(System.in); //Scanner object to read input parameters
					System.out.println("Please enter the CSV file name Example: myfile.csv"
							+ "Please Be sure to have this file in the Same directory as Java File");
					String myfile = in.next();
					
					//create file reader
					fileReader = new BufferedReader(new FileReader(myfile));
					
					//read the csv file header to skip it
					fileReader.readLine();
					
					//Read the file Line by Line starting from line 2
					while ((line = fileReader.readLine()) != null)
					{
						//Get All tokens on a line
						String[] tokens = line.split(COMMA_DELIMITER);
						if(tokens.length > 0)
						{
							ResultSet rset = stmt.executeQuery("INSERT INTO CUSTOMER VALUES("+tokens[0] +
									","+tokens[1]+")");
						}
					}

					//Display Success
					System.out.println("File" +myfile +"was uploaded to Table 'Customer'\n");
					in.close();
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
//-----------------------------------------------------------------------------------------------------------------
			//Query 19: Export. Retrieve all customers in (name order)and output them to a data file
			public static void SaveCustomersToFile()
			{
				FileWriter fw;
				try
				{
					Connection dbConnection = dbconnect(); //initialize database connection
					Statement stmt = dbConnection.createStatement(); // init statement to execute SQL statements
					
					ResultSet rset = stmt.executeQuery("SELECT * FROM CUSTOMER ORDER BY cust_name");
					
					//Get Metadata
					ResultSetMetaData rset_md = rset.getMetaData();
					
					//Count number of Columns
					int columnCount = rset_md.getColumnCount();
					fw = new FileWriter("customer.csv");
					
					//Add column names to file
					for (int i = 1; i <= columnCount; i++)
					{
						fw.append(rset_md.getColumnName(i));
						if (i < columnCount) 
						{
							fw.append(",");
						}
					}
					fw.append(System.getProperty("line.separator"));
					
					//Now Add Individual row of data
					while (rset.next())
					{
						for (int i = 1; i <= columnCount; i++)
						{
							String data = rset.getObject(i).toString();
							fw.append(data);
							if (i < columnCount) 
								{
									fw.append(",");
								}
							else
								{
									//Append Line Break
									fw.append(System.getProperty("line.separator"));
								}
						}			
					}
					//Finish Populating and Close the File connection
					fw.flush();
					fw.close();
					//Display Success
					System.out.println("File customer.csv was saved to current workspace\n");
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
	}
	
}

