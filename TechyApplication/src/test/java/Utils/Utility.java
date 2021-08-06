package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utility {
	
	
	
	public static void screeShot(WebDriver driver, String methodName) throws IOException {
		
		Date date = new Date();
		
		DateFormat d = new SimpleDateFormat("MM-dd-yyyy & HH-mm-ss");
		String dateName= d.format(date);
			
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("E:\\Screenshot\\Amazon" + methodName + dateName + ".jpg"	);
		
		FileUtils.copyFile(source, dest);
	}
	
	public static String getData(int a, int b) throws EncryptedDocumentException, IOException {
		
		String path = "E:\\\\Input Data\\\\Login_Details.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		String value = WorkbookFactory.create(file).getSheet("Sheet").getRow(a).getCell(b).getStringCellValue();
		
		return value;
	}
	
//	public static void main(String[] args) {
//		
//		Date date = new Date();
//		
//		System.out.println(date);
//		
//		DateFormat d = new SimpleDateFormat("MM-dd-yyyy & HH-mm-ss");
//		String dateName= d.format(date);
//		
//		System.out.println(dateName);
//		
//	}

}
