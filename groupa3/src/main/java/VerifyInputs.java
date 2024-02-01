import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyInputs {

	//isEmail method is used to verify that the input is indeed an email
	public boolean isValidEmail(String input)
	{
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



	/**
	* Verifies if the given password meets the specified security criteria.
	* 
	* Criteria include:
	* - Minimum length of 8 characters
	* - At least one uppercase letter
	* - At least one lowercase letter
	* - At least one digit
	* - At least one special character from the set (!@#$%^&*)
	* 
	* @param password The password string to be verified.
	* @return true if the password meets all the criteria, false otherwise.
	*/
	public boolean verifyPassword(String password) 
	{
		// Check if the password is at least 8 characters long
		if (password.length() < 8) 
		{
		    return false;
		}
		// Check if the password contains at least one uppercase letter
		if (!password.matches(".*[A-Z].*")) 
		{
		    return false;
		}
		// Check if the password contains at least one lowercase letter
		if (!password.matches(".*[a-z].*")) 
		{
		    return false;
		}
		// Check if the password contains at least one digit
		if (!password.matches(".*\\d.*")) 
		{
		    return false;
		}
		// Check if the password contains at least one special character (!@#$%^&*)
		if (!password.matches(".*[!@#$%^&*].*")) 
		{
		    return false;
		}
		// If all checks pass, the password meets the criteria
		return true;
	}

	// Method to verify if the phone number entered is a true phone number
	public boolean isValidPhoneNumber(String input)
	{
		// Phone number pattern
		// The number should be 10 digits
		String phoneNumberPattern = "^\\d{10}$";
		
		// Compile method used to validate the pattern
		Pattern p = Pattern.compile(phoneNumberPattern);
		
		// Uses the pattern to make a matcher
		Matcher m = p.matcher(input);
		
		// Returns true if the input matches the pattern, if not returns false
		return (m.matches());
	}

}
