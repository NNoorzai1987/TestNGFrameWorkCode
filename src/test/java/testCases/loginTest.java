package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;

public class loginTest extends CommonMethods {

//    verify that Login Panel text is 'login panel'

    @Test
    public void VerifyLoginPanel(){
        String loginPanelText = login.LoginPanel.getText();
        Assert.assertEquals(loginPanelText,"LOGIN Panel");
    }

//    verify login with multiple credentials

    @DataProvider(name="Credential")
    public Object [][] data(){

        Object[][] loginData={
                {"Admin","abc","Invalid credential"},
                {"Admin","xyz","Invalid credentials"},
                {"Admin","","Password cannot be empty"},
                {"","hum","Username cannot be empty"}
        };
        return  loginData;
    }



    @Test(dataProvider = "Credential")
    public void invalidCredentials(String userName , String password , String errorMsg){

        login.usernameBox.sendKeys(userName);
        login.passwordBox.sendKeys(password);
        login.loginBtn.click();
        String Msg=login.errorMessage.getText();

        Assert.assertEquals(Msg,errorMsg);

    }
    /*
    *   void printIsPalindrome(String str){

        StringBuilder stringBuilder=new StringBuilder(str);
        stringBuilder.reverse();
        String reversedStr=stringBuilder.toString();
        if(str.equals(reversedStr)){
            System.out.println("String is palindrome");
        }else{
            System.out.println("String is Not palindrome");
        }
    }

    public static void main(String[] args) {
        Task3 task3=new Task3();
        task3.printIsPalindrome("dad");
        task3.printIsPalindrome("Aladin");
*/
    //How to remove duplicate elements from an array of integers

       /* int [] numbers = {2,5,3,8,6,2,5,4,10,2,3,5};

        List<Integer> list = new ArrayList<>();
        for(Integer num: numbers){
            list.add(num);
        }
        Set<Integer> set = new HashSet<>(list);
        System.out.println(set);
*/


}
