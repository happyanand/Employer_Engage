package Pages;

import static org.testng.Assert.assertTrue;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class EnrollmentSummary_Page extends Base_Class {
	Base_Class Base_Class = new Base_Class();	
	private static By close = By.linkText("Close");
	private static By L_Close_Button = By.xpath("//*[@class='btn btn-primary closeBtn'][text()='Close']");
	private static By downloadSummaryDocument = By.linkText("Download Summary Document");
	private static By L_CoustomerNumber=By.xpath("(//*[contains(text(),'Customer Number')]//parent::td//parent::tr//td)[2]");
	
	////////////////Validations///////////////
	
	///////////////Change Plan///////////////
	private static By oldPlanName = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[3]/td[1]");
	
	private static By newPlanName = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[2]/td[1]");

	public String oldPlanname;
	public String newPlanname;
	
	///////////////QE Enrollment///////////////
	public static By coveredStartDate = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[2]/td[3]");

	public String date;
	
	//////////////Enroll And Maintainence with Rate Edit Plan///////////
	
    public static By selectedPlanAmount = By.xpath("//*[@id=\"printArea\"]/div[2]/div/div[1]/table/tbody/tr[2]/td[5]");
	
	public String strchangedMonthlyRate;
	
	///////////////ReEnroll Plans///////////////
	/////ReEnroll Medicare/////
	public static By txtselectedPlan = By.xpath("//*[@id=\"printArea\"]/div[2]/div/div[1]/table/tbody/tr[2]/td[1]");

    String selectedPlan;
    
    /////ReEnroll Ancillary/////
    public static By FBMCcoveredStartDateAncillary= By.xpath("//*[@id=\"printArea\"]/div[2]/div/div[1]/table/tbody/tr[8]/td[3]");
    public static By SperidiancoveredStartDateAncillary= By.xpath("//*[@id=\"printArea\"]/div[2]/div/div[1]/table/tbody/tr[4]/td[3]");
    
    /////////////////////////Change Coverage Amount//////////////////////
    public String strnewCoverageAmount;
	public String stroldCoverageAmount;
    
	////////////////////////Terminate Medical///////////////////////L̥
	private static By coveredEndDate = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[2]/td[4]");
	
	///////////////////////Combined Flow Validations////////////////
	private static By Membername = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[2]/td[2]/span");
	private static By PlanName = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[2]/td[1]");
	private static By TerminationDate = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[6]/td[4]");
	public static By ReEnrollStartDateDental= By.xpath("//*[@id=\"printArea\"]/div[2]/div/div[1]/table/tbody/tr[6]/td[3]");
	private static By QEPlanDetails = By.xpath("//*[@id='printArea']/div[2]/div/div[1]/table/tbody/tr[3]/td[1]");
	private static By ChangeCoverageAmount = By.xpath("//*[@id=\"printArea\"]/div[2]/div/div[1]/table/tbody/tr[10]/td[1]/span");
	private static By ChangePlanRate = By.xpath("//*[@id=\"printArea\"]/div[2]/div/div[1]/table/tbody/tr[12]/td[5]");

	public String oldname;
	public String newname;


	
	//"Verify Enrolled plan info displayed"
	public void verifyEnrolledPlanInfoDisplayed(List<Map<String, String>> planInfo) {
    	try {

    		WaitForPageLoad();
    		waitForElementClickable(downloadSummaryDocument);
    		/*  try{
        Thread.sleep(12000);
    }
    catch (Exception e){

    }*/
    		waitForElementPresent(downloadSummaryDocument);
    		SoftAssert sa=new SoftAssert();
    		String pageSource=driver.getPageSource();
    		for(int i=0;i<planInfo.size();i++){
    			Map<String,String> actPlanValues= planInfo.get(i);
    			sa.assertTrue(pageSource.contains(actPlanValues.get("category").split("&")[0]));
    			sa.assertTrue(pageSource.contains(actPlanValues.get("totalRate")));
    			sa.assertTrue(pageSource.contains(actPlanValues.get("coverageLevel")));
    			sa.assertTrue(pageSource.contains(actPlanValues.get("planName").split("&")[0]));
    			
    		}
    		sa.assertAll();
    	}catch (Exception e) {
    		// Handle the exception
    		System.out.println("An exception occurred: " + e.getMessage());
    		e.printStackTrace();
    	}

    }

	


	public String CustomerNumberReturn() throws InterruptedException {
		WaitForPageLoad();
		return GetElementText(L_CoustomerNumber).trim();

	}

	//"Verify coverage end date for all the plans {date} {plans}")
	public void verifyCoverageEndDate(String date, List<String> plans) {
		SoftAssert softAssert = new SoftAssert();
		for (String plan : plans) {
			WebElement element = Base_Class
					.waitForElementPresent(By.xpath("//td[contains(text(),'" + plan.trim() + "')]/parent::tr/td[4]"));
			softAssert.assertEquals(element.getText().replaceAll("/", ""), date);
		}
		softAssert.assertAll();
	}

	//"Close the Enrollment Summary"
	public void closeEnrollmentSummary() throws InterruptedException {
		scrollDown();
		click(close);
		Log.info("Successfully closed Enrollment Summary");
		ExtentSuccessMessage("Successfully closed Enrollment Summary");
		WaitForLoadAnimationDisappear();
		
	}

	// "Verify Coverage End Date after re Hire oldPlans: {oldPlans}
	// newPlan:{newPlan} terminationDate:{terminateDate}")
	//"Verify Coverage End Date after re Hire oldPlans: {oldPlans} newPlan:{newPlan} terminationDate:{terminateDate}")
	public void verifyCoverageEndDateAfterReHire(List<Map<String, String>> selectedPlanDetails, String newPlan,
			String terminateDate) {
		/*
		 * try{ Thread.sleep(5000); } catch (Exception e){
		 * 
		 * }
		 */

		String terminationDate = terminateDate.substring(0, 2) + "/" + terminateDate.substring(2, 4) + "/"
				+ terminateDate.substring(4);
		String newDate = String.valueOf(Integer.parseInt(terminateDate.substring(2, 4)) + 1);
		if (newDate.length() != 2) {
			newDate = "0" + newDate;
		}
		String activationDate_newPlan = terminateDate.substring(0, 2) + "/" + newDate + "/"
				+ terminateDate.substring(4);
		SoftAssert softAssert = new SoftAssert();

		for (Map<String, String> oldPlan : selectedPlanDetails) {
			String actTermDate = waitForElementPresent(
					By.xpath("//b[contains(text(),'" + oldPlan + "')]/ancestor::tr/following-sibling::tr[1]//td[4]"))
					.getText();
			softAssert.assertEquals(actTermDate, terminationDate);
		}

		String actActivationDate = findElement(
				By.xpath("//b[contains(text(),'" + newPlan + "')]/ancestor::tr/following-sibling::tr[1]//td[3]"))
				.getText();
		softAssert.assertEquals(actActivationDate, activationDate_newPlan);
		softAssert.assertAll();
	}

	//"Download Summary document"
	public void downloadSummaryDocument() {
		try 
		{	
		    WaitForPageLoad();
		    waitForElementClickable(downloadSummaryDocument);
		    scrollDown();
		    click(downloadSummaryDocument);
		    ExtentSuccessMessage("Successfully Clicked On Download Summary Document Button");
		}
	 catch (InterruptedException e) {
		e.printStackTrace();
	}


}
	////////////////////////////////////Improvement Enrollment Summary Page////////////////////////////////////////
	
	//Close Summary Document
	public void ClickOnClose_Button() throws InterruptedException {
//		waitForElementVisible(L_Close_Button);
		WaitForPageLoad();
		Thread.sleep(5000);
		scrollDown();
		if(ElementDisplayed(L_Close_Button)) {
			click(L_Close_Button);
			Log.info("Successfully Clicked ON Close Button");
			ExtentSuccessMessage("Successfully Clicked ON Close Button");
		}else {
			Log.error("Unsuccessfully Clicked ON Close Button");
			ExtentErrorMessage("Unsuccessfully Clicked ON Close Button");
		}
		WaitForPageLoad();
	}
		////////////////////////Validations///////////////////////////
		
		///////////////////////Change Plan///////////////////////////
		// Verify Old Plan Name Medical
		public String VerifyoldPlanName(String oldname) {
			WaitForPageLoad();
			String ele = findElement(oldPlanName).getText();
			this.oldPlanname = ele;
			return ele;
		}

		// Verify New Plan Name Medical
		public String VerifynewPlanName(String newname) {
			WaitForPageLoad();
			String ele = findElement(newPlanName).getText();
			this.newPlanname = ele;
			return ele;
		}
	
		///////////////////////QE Enrollment///////////////////////////
		// "Check Enrollment Date")
		public String checkEnrollmentDate(Map<Object, Object> testdata) throws InterruptedException {
			WaitForLoadAnimationDisappear();
			return testdata.get("VerifyEffectiveDate").toString();
		}

		// "Verify Enrollment Date")
		public String VerifyEnrollmentDate(String date) {
			String ele = findElement(coveredStartDate).getText();
			this.date = ele;
			return ele;
		}
		
		///////////////////////Enroll And Maintainence with Rate Edit Plan///////////////////////////
		
		///"Selected Plan"///
		public String monthlyrateChanged() throws InterruptedException {
			strchangedMonthlyRate = GetElementText(selectedPlanAmount).toString().replace("$", "");
			return strchangedMonthlyRate;
			
		}
		
		///"Verify Changed Rate"///
		public void verifyChangedRate(String oldPlan, String newPlan) {
			Assert.assertEquals(oldPlan, newPlan, "Assert Passed");
			
		}
		
		///////////////ReEnroll Plans///////////////
		
		////////////ReEnroll Medicare////////////
		///Selected Plan///
		public String selectedPlan() throws InterruptedException
		{	
			selectedPlan = GetElementText(txtselectedPlan).toString().toLowerCase();
			return selectedPlan;
			
		}
		
		///Verify Plan Name///
		public void verifyPlanName(String oldPlan, String newPlan) {
			Assert.assertEquals(oldPlan, newPlan, "Assert Passed");
			
		}
		
		/////////ReEnroll Ancillary//////////
		//"Check Enrollment Date")
	    public String checkReEnrollmentDate(Map<Object, Object> testdata){
	    	return testdata.get("VerifyeffectiveDate").toString();
	    }    
	    
	    //"Verify Enrollment Date")
	    public String VerifyReEnrollmentDate(String date){
	    	if (TenanatName.contains("FBMC")) {
	    	String fbmcDate =findElement(FBMCcoveredStartDateAncillary).getText(); 
	        this.date = fbmcDate ;
	        return fbmcDate ;   
	    	} else if (TenanatName.contains("Speridian")) {
	        String speridianDate =findElement(SperidiancoveredStartDateAncillary).getText(); 
	        this.date = speridianDate ;
	        return speridianDate ;
	    	}else {
	            // Handle the case when the URL doesn't match any known values.
	            // You can throw an exception or return a default value here.
	            throw new IllegalArgumentException("Unsupported URL: " + URL);
	    	}
	    }
	    
	    //////////////////Change Coverage Amount///////////////
	    
	    public String VerifyOldCoverageAmount(String oldCoverageAmount){   
	        String ele=findElement(By.xpath("//*[@id=\"printArea\"]/div[2]/div/div[1]/table/tbody/tr[2]/td[1]/span")).getText(); 
	        this.stroldCoverageAmount = ele;
	        return ele;   
	    }
	    
	    public String VerifyNewCoverageAmount(String newCoverageAmount){      
	        String ele=findElement(By.xpath("//*[@id=\"printArea\"]/div[2]/div/div[1]/table/tbody/tr[2]/td[1]/span")).getText();
	        this.strnewCoverageAmount = ele;
	        return ele;   
	    }
	    
	    /////////////////Terminate Medical/////////////////
	    
	    //Check Termination Date
			public String checkTerminationDate(Map<Object, Object> testdata) {
				return testdata.get("VerifyterminationDate").toString();
			}
	
		//Verify Termination Date")
			public String VerifyTerminationDate(String date) throws InterruptedException {
				String ele = GetElementText(coveredEndDate);
				this.date = ele;
				return ele;
			}
			
			//Validate Termination Date
			public String ValidateTerminationDate() throws InterruptedException {
				String ele = GetElementText(coveredEndDate);
				String date = ele.replaceAll("/", "");
				return date;							
			}
			
			public static int CheckValuePresentUnderTableRow(String PlanName,String Date) throws InterruptedException, ParseException {
				WaitForPageLoad();
				WaitForLoadAnimationDisappear();
				String Dates=null;
				if(Date.contains("/")) {
					 Dates=Date;
				}else {
					Dates= ChangeDateformate(Date);
				}
				System.out.println("Dates:- "+Dates);
				
				List<WebElement> rows = driver.findElements(By.xpath("(//table[@class='table'])[1]/tbody/tr"));
				int count = 0;
				boolean flag=false;
				for (WebElement row : rows) {
					count = count + 1;
					String getText = row.getText().replace("\n", " ");
					System.out.println("Debug Table row no "+count+" Value :" + getText);
					Log.info("Debug Table row no "+count+" Value :" + getText);
					if (getText.contains(PlanName) && getText.contains(Dates) ) {
						Log.info("Row Details: Plan Name :- " + PlanName  + ", Date :- " + Dates+" , Row Number :- "+count);
						ExtentSuccessMessage("Row Details: Plan Name :- " + PlanName  + ", Date :- " + Dates+" , Row Number :- "+count);
						flag= true;
						break;
						
					} else {
						Log.error("Value not found under the Row ");
						
					}
				}
				if(!flag) {
					ExtentErrorMessage("Unsuccessfully not able to find the record :- Plan Name :- " + PlanName  + ", Date :- " + Dates);			
				}
				
				return count;
			}
			
			public static int ValidateValuePresentUnderTableRow(String PlanCategory,String Date,String Amount) throws InterruptedException, ParseException {
				String Amonuts = null;
				if(Amount.contains("$")) {
					String Amounting=Amount.replace("$", "");
					double d = Double.parseDouble(Amounting);
					NumberFormat nf	= NumberFormat.getInstance(Locale.US);
					 Amonuts = nf.format(d);
					System.out.println("US  " + Amonuts);
					}else {
						double d = Double.parseDouble(Amount);
						NumberFormat nf	= NumberFormat.getInstance(Locale.US);
						 Amonuts = nf.format(d);
						System.out.println("US  " + Amonuts);
					}
				System.out.println("Amounts:- "+Amonuts);
				String Dates=null;
				if(Date.contains("/")) {
					 Dates=Date;
				}else {
					Dates= ChangeDateformate(Date);
				}
				System.out.println("Dates:- "+Dates);
				
				List<WebElement> rows = driver.findElements(By.xpath("(//table[@class='table'])[1]/tbody/tr"));
				int count = 0;
				boolean flag=false;
				for (WebElement row : rows) {
					count = count + 1;
					String getText = row.getText().replace("\n", " ");
					System.out.println("Debug Table row no "+count+" Value :" + getText);
					if (getText.contains(PlanCategory) && getText.contains(Dates) && getText.contains(Amonuts) ) {
						Log.info("Row Details: Plan Category :- " + PlanCategory  + ", Date :- " + Dates+", Amount :- " + Amonuts+" , Row Number :- "+count);
						ExtentSuccessMessage("Row Details: Plan Category :- " + PlanCategory  + ", Date :- " + Dates+", Amount :- " + Amonuts+" , Row Number :- "+count);
						flag= true;
						break;
						
					} else {
						Log.error("Value not found under the Row ");
						
					}
				}
				if(!flag) {
					ExtentErrorMessage("Unsuccessfully not able to find the record :- Plan Category :- " + PlanCategory  + ", Date :- " + Dates+", Amount :- " + Amonuts);			
				}
				
				return count;
			}
		
		//////////////////////////FBMC Combined Flow Validations//////////////////
		
		//Fetch the Address
			public String getAddress() {
		        // Find the element containing the address information using a more detailed XPath
		        WebElement addressElement = driver.findElement(By.xpath("//div[@id='divContactDet']//td[label[contains(text(), 'Address:')]]/following-sibling::td"));
		        // Get the text content of the element
		        String addressText = addressElement.getText();
		        // Perform any additional processing if needed (e.g., splitting lines)
		        String[] lines = addressText.split("\\n");
		        // Construct the final address string
		        StringBuilder address = new StringBuilder();
		        for (String line : lines) {
		            address.append(line.trim()).append(" ");
		        }
		        Log.info("Address details: " + address.toString().trim());
		        // Log success message using ExtentReports or any other reporting mechanism
		        ExtentSuccessMessage("Successfully fetched address details");
		        return address.toString().trim();
		    }

			//Validate the Address
			public void ValidateAddress(String newAddress, String oldAddress) {
				// Print the addresses
		        ExtentSuccessMessage("New Address: " + newAddress);
		        ExtentSuccessMessage("Old Address: " + oldAddress);
		        
		        // Compare the addresses
		        if (!newAddress.equals(oldAddress)) {
		            Log.info("Success! Address is updated does not match with old Address.");
		            ExtentSuccessMessage("Success! Address is updated does not match with old Address.");
		        } else {
		            Log.error("Failure! Address is not updated and matches with old Address..");
		            ExtentErrorMessage("Failure! Address is not updated and matches with old Address..");
		        }
		    }
			
			//Verify Old Name Remove
			public String fetchMemberName() throws InterruptedException {
				Thread.sleep(5000);
				ScrolltillElementOnmiddlepage(Membername);
				String ele = findElement(Membername).getText();
				this.oldname = ele;
				return ele;
			}
		
		//Validate the Member names before and after UCM Flow
			public void ValidateMemberNames(String newmembers, String oldmembers) {
				
				// Print the addresses
		        ExtentSuccessMessage("New Members: " + newmembers);
		        ExtentSuccessMessage("Old Members: " + oldmembers);
		        // Compare the Member Names
		        if (!newmembers.equals(oldmembers)) {
		            Log.info("Success! Member is updated does not match with old Member List.");
		            ExtentSuccessMessage("Success! Member is updated does not match with old Member List.");
		        } else {
		            Log.error("Failure! Member is not updated and matches with old Member List..");
		            ExtentErrorMessage("Failure! Member is not updated and matches with old Member List..");
		        }
		    }
			
		//Fetch the Plan Name.
			public String fetchPlanName() throws InterruptedException {
				Thread.sleep(5000);
				ScrolltillElementOnmiddlepage(PlanName);
				String ele = findElement(PlanName).getText();
				this.newname = ele;
				return ele;
			}
			
		//Validate the Plan Name
			public void ValidatePlanNames(String newPlan, String oldPlan) {
	
				// Print the Plan Names
		        ExtentSuccessMessage("New Plan: " + newPlan);
		        ExtentSuccessMessage("Old Plan: " + oldPlan);
		        // Compare the Plan Names
		        if (!newPlan.equals(oldPlan)) {
		            Log.info("Success! Plan is updated does not match with old Plan");
		            ExtentSuccessMessage("Success! Plan is updated does not match with old Plan");
		        } else {
		            Log.error("Failure! Plan is not updated and matches with Plan..");
		            ExtentErrorMessage("Failure! Plan is not updated and matches with Plan..");
		        }
		    }
			
			//Verify New Name Remove
			public String fetchDentalTerminationDate() throws InterruptedException {
				Thread.sleep(5000);
				ScrolltillElementOnmiddlepage(TerminationDate);
				String ele = findElement(TerminationDate).getText();
				this.newname = ele;
				return ele;
			}
			
			//Validate the Plan Name
			public void ValidateEndDates(String newDate, String oldDate) {
	
				// Print the Plan Names
		        ExtentSuccessMessage("New End Date: " + newDate);
		        ExtentSuccessMessage("Old End Date: " + oldDate);
		        // Compare the End Dates
		        if (!newDate.equals(oldDate)) {
		            Log.info("Success! Termination Date is updated does not match with old Date");
		            ExtentSuccessMessage("Success! Termination Date is updated does not match with old Date");
		        } else {
		            Log.error("Failure! Termination Date is not updated and matches with the old Date..");
		            ExtentErrorMessage("Failure! Termination Date is not updated and matches with old date..");
		        }
		    }
			
			//Verify New Name Remove
			public String fetchDentalReEnrollDate() throws InterruptedException {
				Thread.sleep(5000);
				ScrolltillElementOnmiddlepage(ReEnrollStartDateDental);
				String ele = findElement(ReEnrollStartDateDental).getText();
				this.newname = ele;
				return ele;
			}
			
			//Validate the Plan Name
			public void ValidateReEnrollDates(String newDate, String oldDate) {
	
				// Print the Plan Names
		        ExtentSuccessMessage("New Start Date: " + newDate);
		        ExtentSuccessMessage("Old Start Date: " + oldDate);
		        // Compare the Start Dates
		        if (!newDate.equals(oldDate)) {
		            Log.info("Success! ReEnroll Date is updated does not match with old Date");
		            ExtentSuccessMessage("Success! ReEnroll Date is updated does not match with old Date");
		        } else {
		            Log.error("Failure! ReEnroll Date is not updated and matches with the old Date..");
		            ExtentErrorMessage("Failure! ReEnroll Date is not updated and matches with old date..");
		        }
		    }
			
			//Fetch the QE Plan Details
			public String fetchQEPlanDetails() throws InterruptedException {
			    Thread.sleep(5000);
			    ScrolltillElementOnmiddlepage(QEPlanDetails);

			    // Find the element
			    WebElement element = findElement(QEPlanDetails);

			    // Extract text
			    String eleText = element.getText();

			    // Trim the extracted text to "Medicare Advantage & Part D"
			    int endIndex = eleText.indexOf(" -");  // Assuming the text format is consistent
			    if (endIndex != -1) {
			        this.newname = eleText.substring(0, endIndex);
			        
			        // Print the extracted text
			        System.out.println("Extracted Text: " + this.newname);
			        
			        return this.newname;
			    } else {
			        // Handle the case when the expected substring is not found
			        // You can throw an exception or return an appropriate value
			        System.out.println("Substring not found");
			        return "Substring not found";
			    }
			}
			
			//Validate the Plan Name
			public void ValidateQEPlanDetails(String QEPlanName, String Value) {

		        // Compare the Plan names in Application and the Data passed.
		        if (QEPlanName.equals(Value)) {
		            Log.info("Success! QE Plan Name matches and it is Enrolled");
		            ExtentSuccessMessage("Success! QE Plan Name matches and it is Enrolled");
		        } else {
		            Log.error("Failure! QE Plan Name Not Found..");
		            ExtentErrorMessage("Failure! QE Plan Name Not Found..");
		        }
		    }
			
			//Verify New Name Remove
			public String fetchChangeCoverageAmount() throws InterruptedException {
				Thread.sleep(5000);
				scrollDown();
				String ele = findElement(ChangeCoverageAmount).getText();
				this.newname = ele;
				return ele;
			}
			
			//Validate the Plan Name
			public void ValidateChangeCoverageAmount(String newAmount, String oldAmount) {
				
				// Print the Plan Names
		        ExtentSuccessMessage("New Subscriber Amount: " + newAmount);
		        ExtentSuccessMessage("Old Subscriber Amount: " + oldAmount);
		        // Compare the Plan names in Application and the Data passed.
		        if (!newAmount.equals(oldAmount)) {
		            Log.info("Success! Changed Covearge Amount is updated and does not match the old Amount");
		            ExtentSuccessMessage("Success! Changed Covearge Amount is updated and does not match the old Amount");
		        } else {
		            Log.error("Failure! Changed Covearge Amount is not updated and does match the old Amount..");
		            ExtentErrorMessage("Failure! Changed Covearge Amount is not updated and does match the old Amount..");
		        }
		    }
			
			//Verify New Name Remove
			public String fetchChangePlanRate() throws InterruptedException {
				Thread.sleep(5000);
				scrollDown();
				String ele = findElement(ChangePlanRate).getText();
				this.newname = ele;
				return ele;
			}
			
			//Validate the Plan Name
			public void ValidateChangePlanRate(String newAmount, String oldAmount) {
				
				// Print the Plan Names
		        ExtentSuccessMessage("New Subscriber Amount: " + newAmount);
		        ExtentSuccessMessage("Old Subscriber Amount: " + oldAmount);
		        // Compare the Plan names in Application and the Data passed.
		        if (!newAmount.equals(oldAmount)) {
		            Log.info("Success! Changed Plan Rate is updated and does not match the old Amount");
		            ExtentSuccessMessage("Success! Changed Plan Rate is updated and does not match the old Amount");
		        } else {
		            Log.error("Failure! Changed Plan Rate is not updated and does match the old Amount..");
		            ExtentErrorMessage("Failure! Changed Plan Rate is not updated and does match the old Amount..");
		        }
		    }
			
		public void  PlanTerminationDateValidator (String terminationDate) {
	        // Flag to track if termination date is found
	        boolean terminationDateFound = false;
	        // Iterate through each plan row
	        for (WebElement row : driver.findElements(By.xpath(".//tbody/tr[not(@style=' font-size: 15px;')]"))) {
	            try {
	                // Extract the plan termination date from the row
	                String planTerminationDate = row.findElement(By.xpath("//td[4]")).getText();

	                // Compare the plan termination date with the provided termination date
	                if (planTerminationDate.equals(terminationDate)) {
	                    // If termination date matches, set the flag to true
	                    terminationDateFound = true;
	                    // Print the plan name and break the loop
	                    String planName = row.findElement(By.xpath("./td[1]")).getText();
	                    System.out.println("Termination date matches for plan: " + planName);
	                    break; // No need to continue iterating
	                }
	            } catch (NoSuchElementException e) {
	                // Handle case where termination date cell is not found in the row
	                System.err.println("Termination date cell not found for this plan row.");
	            }
	        }

	        // If termination date not found for any plan, print message accordingly
	        if (!terminationDateFound) {
	            System.out.println("Termination date not found for any plan.");
	        }
	}

}


