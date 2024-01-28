import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyInputs {

    //isEmail method is used to verify that the input is indeed an email
    public boolean isValidEmail(String input){
        //Define a regular expression pattern for a simple email validation
        //this may not cover all email cases but should handle most
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        //Compile the pattern
        Pattern pattern = Pattern.compile(emailPattern);

        //Use the pattern to create a Matcher object
        Matcher matcher = pattern.matcher(input);

        //If it is a match, it will return true, else it will return false
        return matcher.matches();
    }

    //Add the other methods
}