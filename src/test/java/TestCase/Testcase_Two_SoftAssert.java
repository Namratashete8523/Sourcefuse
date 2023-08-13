package TestCase;

import java.awt.AWTException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testcase_Two_SoftAssert extends TestCase_five_submitdata_DB {
	

	@Test
	public void candidate_Registration_soft_assert() throws InterruptedException, AWTException, SQLException {
		super.submiting_data();
		SoftAssert softassert=new SoftAssert();
		

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

		softassert.assertEquals(first_str, super.firstname);
		softassert.assertEquals(emp_lname, super.lastname);
		softassert.assertEquals(empailid, super.empemail);
		softassert.assertEquals(empmobno, super.empmob);
		softassert.assertEquals(emp_current_company,super.cur_company);
		softassert.assertEquals(current_position_name,super.positionname );
		softassert.assertEquals(portfolio_ip, super.portfolioinp);
		softassert.assertEquals(salary_ip,super.salaryinp );
		softassert.assertEquals(emp_cstartdate,super.satartdate );
		softassert.assertEquals(emp_address,super.empaddress );
		
		
		
		softassert.assertAll();
		Thread.sleep(2000);
	}

}
