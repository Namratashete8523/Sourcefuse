package TestCase;

import java.awt.AWTException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Testcase_three_HardAssert extends TestCase_five_submitdata_DB {
	public String firstname = " ", lastname = " ", empemail = " ", empmob = " ";
	public String first_str = " ", emp_lname = " ", empailid = " ", empmobno = " ";

	@Test
	public void candidate_Registration_hard_assert() throws InterruptedException, AWTException, SQLException {
		super.submiting_data();
	
		

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details", "root",
				"Namrata@2029");
		Statement stmt = con.createStatement();
		
		
		ResultSet rs = stmt.executeQuery("select * from sourcefuse where mob_number='7744008734'");
		while (rs.next()) {
			first_str = rs.getString("firstname");
			emp_lname = rs.getString("lastname");
			empailid = rs.getString("emailid");
			empmobno = rs.getString("mob_number");
			 emp_current_company = rs.getString("current_company");
	   		current_position_name = rs.getString("apply_position");
		    portfolio_ip = rs.getString("portfolio_website");
			salary_ip = rs.getString("Salary_requrirements");
			 emp_cstartdate = rs.getString("when_to_start");
			 emp_address = rs.getString("address");
		
		
		}

		Assert.assertEquals(first_str, super.firstname);
		Assert.assertEquals(emp_lname, super.lastname);
		Assert.assertEquals(empailid, super.empemail);
		Assert.assertEquals(empmobno, super.empmob);
		Assert.assertEquals(emp_current_company,super.cur_company);
		Assert.assertEquals(current_position_name,super.positionname );
		Assert.assertEquals(portfolio_ip, super.portfolioinp);
		Assert.assertEquals(salary_ip,super.salaryinp );
		Assert.assertEquals(emp_cstartdate,super.satartdate );
	    Assert.assertEquals(emp_address,super.empaddress );
		
		
		

	}
}
