package utitilities;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(parallel=true)
	public Object[][] getTableData() {
		Object[][] test=new Object[2][3];
		test[0][0]="Johne";
		test[0][1]="Doe";
		test[0][2]="chrome";
		test[1][0]="Sihle";
		test[1][1]="Mbeki";
		test[1][2]="chrome";
		return test;
	}
}
