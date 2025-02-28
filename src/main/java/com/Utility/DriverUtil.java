package com.Utility;


import com.Utility.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverUtil {

   
    private WebDriver driver;

    public DriverUtil(WebDriver driver){ this.driver=driver;}
    public WebDriver getDriver(){return this.driver;}
    public void setDriver(){ this.driver=driver;}

   ///"get the url {url}"///
    public void get(String url){
        this.driver.get(url);
    }

    ////"get Current url"////
    public String getCurrentUrl(){
     return this.driver.getCurrentUrl();
    }

  ///"find all the elements")
   public List<WebElement> findElements(By by){
        List<WebElement> elements=waitForElementsVisible(by);
        if(elements!=null){
            return elements;
        }
        return driver.findElements(by);

    }

    private List<WebElement> waitForElementsVisible(By by) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            Log.info(e.getMessage());
        }
        return null;

    }


  ///""find the element")
    public WebElement findElement(By by){
        WebElement element= waitForElementVisible(by);
        if(element!=null){
            return element;
        }
        return driver.findElement(by);
    }

  ///"get the page source")
    public String getPageSource(){
        return this.driver.getPageSource();
    }
  ///"Close the driver")
    public void close(){
        this.driver.close();
    }
  ///""quit the driver")
    public void quit(){
    this.driver.quit();
    }
  ///""get Window handles")
    public Set<String> getWindowHandles(){
       return this.driver.getWindowHandles();
    }

  ///""get Window handle")
    public String getWindowHandle(){
    return this.driver.getWindowHandle();
    }

  ///""Switch to Recent opened Window")
    public void switchToRecentOpenedWindow() {
        try {
            String strPrntWnd = driver.getWindowHandle();
            Set<String> strWnds = driver.getWindowHandles();
            for (String a : strWnds) {
                if (!a.equalsIgnoreCase(strPrntWnd))
                    driver.switchTo().window(a);
            }
        } catch (Throwable e) {
            Log.error(e.getMessage());
        }
    }

  ///""Navigate to the back page")
    public  void goBack() {
        driver.navigate().back();
        Log.info("Navigates to the back page");
    }

  ///""Navigate to the Forward page")
    public  void goForward() {
        driver.navigate().forward();
        Log.info("Navigates to the forward page");
    }
  ///""Refresh page")
    public  void refresh() {
        driver.navigate().refresh();
        Log.info("Refresh the page");
    }

  ///""clear the text from the Element")
    public  void clear(By by) {
        try {
            findElement(by).clear();

        } catch (Throwable e) {
        	Log.error("text is not cleared");
        }
    }

  ///""remove spl Chars from {s}")
    public  String removeSplChar(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "");
        Log.info("Special Char has been removed from the String " + s);
        return s;

    }

  ///""is Enabled")
    public  boolean isEnabled(By by) {
        WebElement webElement=findElement(by);
        if (webElement.isEnabled()) {
        	Log.info("This WebElement is enabled : " + webElement.getText());
            return true;
        } else {
        	Log.info("This WebElement is not enabled : " + webElement.getText());
            return false;
        }

    }

  ///""is Displayed")
    public  boolean isDisplayed(By by) {
        WebElement element=waitForElementVisible(by);
        try {
            element.isDisplayed();

            return true;
        } catch (Exception e) {
            return false;
        }

    }


  ///"\"Get the Element text")
    public  String getText(By by) {
        WebElement element=waitForElementVisible(by);
        if (null == element) {
        	Log.info("weblement is null");
            return null;
        }
        String elementText = null;
        try {
            elementText = element.getText();
        } catch (Exception ex) {
        	Log.info("Element not found " + ex);
        }
        return elementText;
    }

  ///""click on the element")
    public void click(By by) {
        WebElement element=findElement(by);
        try {
            element.click();
        } catch (Exception e) {
        	Log.error(e.getMessage());
        }


    }

  ///""Type the value in the element")
    public  void type(By by, String value) {
        WebElement element=waitForElementVisible(by);
        try {
         //   element.clear();
            click(by);
            element.sendKeys(value);

        } catch (NoSuchElementException e) {
        	Log.error("Data typing action is not perform on  with data is " + value);
        }
        catch (StaleElementReferenceException e){
            System.out.println(e.getMessage());
            element=waitForElementVisible(by);
            element.sendKeys(value);

        }
    }


  ///""Select the value by Index")
    public  void selectByIndex(By by, int index) {
        WebElement element= findElement(by);
        try {
            Select s = new Select(element);
            s.selectByIndex(index);
            Log.info("Option at index " + index + " is Selected from the DropDown");
        } catch (NoSuchElementException e) {
        	Log.error("Option at index " + index + " is  not Selected from the DropDown");
        } catch (Exception e) {
        	Log.error(e.getMessage());
        }

    }

  ///""Select By value from the dropdown")
    public  void selectByValue(By by, String value) {
        WebElement element=findElement(by);
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByValue(value);
            Log.info("Option with value attribute " + value + " is  Selected from the DropDown ");
        } catch (NoSuchElementException e) {
        	Log.error("Option with value attribute " + value + " is not Selected from the DropDown ");

        } catch (Exception e) {
        	Log.error(e.getMessage());
        }

    }

  ///""Select the dropdown by visible text")
    public  void selectByVisibleText(By by, String visibleText) {
        WebElement element=findElement(by);
        try {
            Select s = new Select(element);
            s.selectByVisibleText(visibleText);
            Log.info(visibleText + "  is Selected from the DropDown " );
        } catch (NoSuchElementException  e) {
        	Log.error(visibleText + " is Not Select from the DropDown ");
        } catch (Exception e) {
        	Log.error(e.getMessage());
        }

    }

  ///""Click using the Javascript executor")
    public  void jSClick(By by) {
        WebElement element= findElement(by);
        JavascriptExecutor js=(JavascriptExecutor) driver;

        try {
            js.executeScript("arguments[0].click();", element);
            Log.info("Element is clicked");
        } catch (Throwable e) {
        	Log.error("Element is not clicked");
        }
    }

  ///""Click using the Javascript executor")
    public  void jSClick(WebElement element) {

        JavascriptExecutor js=(JavascriptExecutor) driver;

        try {
            js.executeScript("arguments[0].click();", element);
            Log.info("Element is clicked");
        } catch (Throwable e) {
        	Log.error("Element is not clicked");
        }
    }

  ///""Mouse hover on the element")
    public void mouseHover(By by) {
        WebElement element=findElement(by);
        try {
            new Actions(driver).moveToElement(element).build().perform();
            Log.info("Able to perform mouse over on to the element");
        } catch (Exception e) {
        	Log.error("Unable to perform mouse over on  the element");
        }
    }

  ///""Perform the right click on the element")
    public  void rightClick(By by) {
        WebElement element=findElement(by);
        try {
            Actions clicker = new Actions(driver);
            clicker.contextClick(element).perform();
            Log.info("Able to perfom right click on the element" );

        } catch (Exception e) {
        	Log.error("Unable to perform right click on the element");
        }
    }



  ///""Accept the alert")
    public  void acceptAlert() {

        Alert alert = null;

        try {
            // Check the presence of alert
            alert = driver.switchTo().alert();
            // if present consume the alert
            alert.accept();

            Log.info("Alert is presented and accepted");
        } catch (NoAlertPresentException ex) {
        	Log.error("Alert is not presented");
        }

    }



  ///""is Checkbox checked")
    public boolean isChecked(By by) {
        boolean flag = false;
        WebElement element=findElement(by);
        try {
            if (element.isSelected()) {
            	Log.info("the checkbox is checked");
                flag = true;
            }

        } catch (Exception e) {
        	Log.error("Checkbox is not checked");
            flag = false;
        }
        return flag;
    }


  ///""Get the Title")
    public  String getTitle() {
        String text = "";
        try {
            text = driver.getTitle();
        } catch (WebDriverException e) {
        	Log.error(e.getMessage());
        }
        return text;
    }

  ///""Get the Attribute")
    public  String getAttribute(By by, String attribute) {

        String value = "";
        try {
               driver.findElement(by).getAttribute(attribute);
        } catch (Throwable e) {
        }
        return value;
    }


  ///""Get the Value")
    public  String getValue(By by) {
        String text = "";
        WebElement element=findElement(by);
        try {
            if (element.isDisplayed()) {
                text = element.getAttribute("value");

            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return text;
    }

  ///""Switch to the frame by index {index}")
    public void switchToFrameByIndex(int index) {

        try {
            driver.switchTo().frame(index);
            Log.info("Switched to frame by index" + index);

        } catch (NoSuchFrameException e) {
        	Log.error("Frame is not displayed");
        } catch (Throwable e) {
        	Log.error(e.getMessage());
        }
    }

  ///""Switch to the frame by Id {idValue}")
    public void switchToFrameById(String idValue) {
        try {
            driver.switchTo().frame(idValue);
            Log.info("Switched to frame by index" + idValue);

        } catch (NoSuchFrameException e) {
        	Log.error("Frame is not displayed");
        } catch (Throwable e) {
        	Log.error(e.getMessage());

        }
    }

  ///""Switch to the frame by element")
    public  void switchToFrameByElement(By by){
        WebElement ele=findElement(by);
        try{
            driver.switchTo().frame(ele);
            Log.info("Switched to frame by elex" + ele);

        } catch (NoSuchFrameException e) {
        	Log.error("Frame is not displayed");
        } catch (Throwable e) {
            Log.error(e.getMessage());

        }

    }

  ///""Switch to the frame by Name")
    public  void switchToFrameByName(String nameValue) {
        try {
            driver.switchTo().frame(nameValue);
            Log.info("Switched to frame by Name" + nameValue);

        } catch (NoSuchFrameException e) {
        	Log.error("Frame is not displayed");
        } catch (Throwable e) {
        	Log.error(e.getMessage());

        }
    }


  ///""Switch to the default frame")
    public  void switchToDefaultFrame() {
        try {
            driver.switchTo().defaultContent();
            Log.info("Switched to the default content");

        } catch (NoSuchFrameException e) {
        	Log.error("Unable to switch to default content");
        } catch (Throwable e) {
        	Log.error(e.getMessage());
        }
    }



  ///"Implicit wait")
    public  void ImplicitWait() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


  ///""Get the elements")
    public  List<WebElement> getElements(By locator) {
        List<WebElement> ele = driver.findElements(locator);
        return ele;
    }

  ///""Execute Javascript on Element")
    public  void executeJavaScriptOnElement(String script) {
        ((JavascriptExecutor)driver).executeScript(script);
    }

  ///""Close the browser")
    public  void closeBrowser() {
        driver.close();
        driver.quit();
    }

  ///""Switch to Parent with Child Close")
    public  void switchToParentWithChildClose() {
        switchToParentWindow();

        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandles());

        for (int i = 1; i < windowsId.size(); i++) {
            Log.info(windowsId.get(i));
            driver.switchTo().window(windowsId.get(i));
            driver.close();
        }

        switchToParentWindow();
    }
  ///""Verify multiple texts ")
    public  void verifyMultipleTexts(List<WebElement> element, String expectedText) {
    	Log.info("Inside multiple txt.......");
        String[] expectedTextArray = expectedText.split("@");
        SoftAssert sa = new SoftAssert();
        for (int i = 0; i < element.size(); i++) {
            String actualText = element.get(i).getText().trim();
            String expected = expectedTextArray[i].trim();
            Log.info("Actual : " + actualText + " Expected : " + expected);
            sa.assertEquals(actualText, expected);
        }
        sa.assertAll();
    }

  ///""Switch to the Window based on the index")
    public void switchToWindow(int index) {
        try {
            LinkedList<String> windowsId = new LinkedList<String>(
                    getWindowHandles());

            if (index < 0 || index > windowsId.size())
                throw new IllegalArgumentException("Invalid Index : " + index);

            driver.switchTo().window(windowsId.get(index));
            //Log.info(index);
        } catch (NoSuchWindowException e) {
        	Log.error("Unable to switch to the window , window is not present");
        } catch (Throwable e) {
        	Log.error(e.getMessage());
        }
    }

  ///""Switch to the Parent window")
    public  void switchToParentWindow() {
        try {
            LinkedList<String> windowsId = new LinkedList<String>(
                    getWindowHandles());
            driver.switchTo().window(windowsId.get(0));
            Log.info("");
        } catch (NoSuchWindowException e) {
        	Log.error("Window is not present ");
        }
    }


  ///""Scroll to element")
    public  void scrollToElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element= driver.findElement(by);
        js.executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
        Log.info("+element+");
    }
  ///"Scroll to element")
    public  void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
        Log.info(" ' + element + ' ");
    }


  ///"Vertical Scroll")
    public  void scrollUpVertically() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }



  ///"Horizontal Scroll")
    public  void scrollHorizontally() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.querySelector('table th:last-child').scrollIntoView();");
    }



  ///"Dismiss the alert")
    public  void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

  ///"Get Alert text")
    public  String getAlertText() {
        String text = "";
        try {
            text = driver.switchTo().alert().getText();
            Log.info(text);
        } catch (NoAlertPresentException e) {
        	Log.error("No Alert Exception");
        }
        return text;
    }


  ///"is Alert present")
    public  boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            Log.info("true");
            return true;
        } catch (NoAlertPresentException e) {
            // Ignore
        	Log.info("false");
            return false;
        }
    }

  ///""Click on the Stale element")
    public  void clickStaleElement(By by) {
        int count = 0;
        boolean clicked = false;
        while (count < 4 || !clicked) {
            try {
                WebElement yourSlipperyElement = findElement(by);
                yourSlipperyElement.click();
                clicked = true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }

  ///""Select Check box")
    public void selectCheckBox(By by) {
        try {
            if (!isChecked(by)) {
                findElement(by).click();
            }

        } catch (Exception e) {

        }


    }

  ///""is Value present in Drop down ")
    public  boolean isValuePresentInDropDown(By by, String option) {
        try {
            Select select = new Select(findElement(by));
            List<WebElement> allOptions = select.getOptions();
            for (WebElement eoption : allOptions) {
                if (eoption.getText().equals(option)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
        	Log.error(e.getMessage());
        } catch (Throwable e) {
        	Log.error(e.getMessage());
        }
        return false;

    }
  ///""Get CSS Attribute")
    public  String getCssAttribute(By by, String attribute) {
        String value = findElement(by).getAttribute(attribute);
        if (value != null) {
        	Log.info( "Attribute:" + attribute + "value:" + value);
        } else {
        	Log.error("Attribute:" + attribute + "value:" + value);
        }
        return value;
    }

  ///"("Get Fist selected Option from the Drop Down")
    public  String getFirstSelectedOption(By by) {
        try {
            Select select = new Select(findElement(by));

            WebElement option = select.getFirstSelectedOption();

            String defaultItem = option.getText();
            Log.info(defaultItem + " is selected by default ");
            return defaultItem;

        } catch (Exception e) {
        	Log.error(e.getMessage());
            return null;
        }
    }



    public WebElement waitForElementVisible(By by) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (NoSuchElementException | TimeoutException e){
        	Log.error(e.getMessage());
        }
        return null;
    }
//
//    public WebElement waitForElementClickable(By by) {
//        try {
//           return new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));
//        } catch (Exception e) {
//        	Log.info(e.getMessage());
//        }
//        return null;
//
//    }
//
//    public WebElement waitForElementSelectable(By by) {
//        try {
//      //      return new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementSelectionStateToBe(by,true));
//        } catch (Exception e) {
//        	Log.info(e.getMessage());
//        }
//        return null;
//
//    }
//
////    public  WebElement waitForElementPresent(By by) {
////        try {
//            return new WebDriverWait(driver, Duration.ofSeconds(2)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(by));
//        }
//        catch (NoSuchElementException | TimeoutException e){
//        	Log.error(e.getMessage());
//        }
//        return null;
//
//    }
//
//    public void waitForTitlePresent(String title) {
//        try {
//            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.titleContains(title));
//        } catch (Exception e) {
//        	Log.error("Title is not present");
//        }
//
//    }

//    @Attachment(value="Page screenshot" ,type="image/png")
//    public byte[] takeScreenshot(){
//        TakesScreenshot ts=(TakesScreenshot) DriverFactory.getDriver().getDriver();
//        return ts.getScreenshotAs(OutputType.BYTES);
//    }


  ///""No of values in dropdown")
    public int getNumberOfValuesInDropDown(By by) {
        WebElement element= findElement(by);
        try {
            Select s = new Select(element);
           int count= s.getOptions().size();
           Log.info("No of options in the dropdown:"+count);
         return count;
        } catch (Exception e) {
        	Log.error(e.getMessage());
        }
        return -1;
    }

    public String selectByRandom(By by){
        String locator=by.toString();
        WebElement element=null;
        Select s=null;
        String id=null;
        String value=null;
      //  if(!getAttribute(by,"title").equals("")) {
            if (locator.contains("id")) {
                id=by.toString().replaceAll("By.id: ", "");
                element = findElement(By.id(id.split("_chzn")[0]));
            }
            try {
                s = new Select(element);
                int count = s.getOptions().size()-1;
                int random = (int) Math.floor(Math.random() * (count) + 1) - 1;
                value=s.getOptions().get(random).getText();

              //  int index = random > 0 ? random : 1;
              //  String value = s.getOptions().get(index).getText();
                //    Thread.sleep(5000);
                click(by);
                findElements(By.xpath("//li[starts-with(@id,'"+id+"')]")).get(random).click();
                //   Thread.sleep(3000);

            } catch (Throwable e) {
                click(by);
                findElements(By.xpath("//li[starts-with(@id,'"+id+"')]")).get(0).click();
                value=s.getOptions().get(0).getText();

            }
            return value;
   //     }
    }

   /* public void selectByRandom(By by){
        String locator=by.toString();
        WebElement element=null;
        Select s=null;

        //  if(!getAttribute(by,"title").equals("")) {
        if (locator.contains("id")) {
            element = findElement(By.id(by.toString().replaceAll("By.id: ", "").split("_chzn")[0]));
        }
        try {
            s = new Select(element);
            int count = s.getOptions().size();
            int random = (int) Math.floor(Math.random() * (count - 1 + 1) + 1) - 1;
            int index = random > 0 ? random : 1;
            String value = s.getOptions().get(index).getText();
            //    Thread.sleep(5000);
            click(by);
            //   Thread.sleep(3000);
            WebElement ele=findElement(By.xpath("//li[contains(text(),'" + value + "')]"));
            if(ele==null){
                click(By.xpath("//span[contains(text(),'" + value + "')]/parent::li"));
            }
            else {
                click(By.xpath("//li[contains(text(),'" + value + "')]"));
            }

        } catch (Exception e) {
            click(by);
            click(By.xpath("//span[contains(text(),'" + s.getOptions().get(1) + "')]"));
            log.error(e.getMessage());
        }
        //     }
    }*/
  ///"("JS Type")
    public void jsType(By by,String inputText){
        WebElement myElement=findElement(by);
        String js = "arguments[0].setAttribute('value','"+inputText+"')";
        ((JavascriptExecutor) driver).executeScript(js, myElement);
    }

    public void sendKeys(By by, String value) {
        click(by);
        new Actions(driver).sendKeys(value).build().perform();
        //click(by);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void scrollDown(int height) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+height+")");
    }

    public void selectComboBoxValue(By by, String value) {
        String locator=by.toString();
        String id=null;
        //  if(!getAttribute(by,"title").equals("")) {
        if (locator.contains("id")) {
            id=by.toString().replaceAll("By.id: ", "");
        }
        try {
            driver.findElement(by).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//li[starts-with(@id,'"+id+"')][contains(text(),'"+value+"')]")).click();            //   Thread.sleep(3000);

        } catch (Throwable e) {
            driver.findElement(by).click();
            driver.findElement(By.xpath("//li[starts-with(@id,'"+id+"')][contains(text(),'"+value+"')]")).click();        }
    }


//    public void click(By by, int wait) {
//        WebElement element=waitForElementClickable(by,wait);
//        try {
//            element.click();
//        } catch (Exception e) {
//            Log.error(e.getMessage());
//        }
//    }

    

    
    
//    public  void waitForTextTobePresentInElement(WebElement element, String text) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        try {
//            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
//        } catch (Exception e) {
//            Log.error("Text is not present");
//        }
//
//    }
//    public List<WebElement> waitForElementsVisible(By by,int timeout) {
//        try {
//            return new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//        }
//        return null;
//
//    }
//
//    public void waitForElementsClickable(By by,int timeout) {
//        try {
//             new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//        }
//
//
//    }

//    public void waitUntilDataLoadsInTable(By by) {
//        try {
//            Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class);
//            WebElement table = driver.findElement(by);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    int elementCount = table.findElements(By.xpath(".//tr")).size();
//                    if (elementCount >= 2)
//                        return true;
//                    else
//                        return false;
//                }
//            });
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void waitForElementClickable(WebElement ele) {
//        try {
//             new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(ele));
//        } catch (Exception e) {
//        	Log.info(e.getMessage());
//        }
//    }
}






