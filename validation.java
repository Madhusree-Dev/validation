package MobileNoValidation;

import java.util.Scanner;
import java.util.regex.*;

import javax.management.InvalidAttributeValueException;

/**
 * @author madhusree
 *
 */
class InvalidMobileNumberException extends Exception {
	public InvalidMobileNumberException(String s) {
		super(s);
	}
}

public class MobileNoValidation {
	void checkMobileNo(String MobileNo) throws InvalidMobileNumberException {
		if (!ValidateMobileNumber(MobileNo)) {
			throw new InvalidMobileNumberException("Invalid Mobile number " + MobileNo);
		}
	}

	public static void main(String args[]) {
		MobileNoValidation obj = new MobileNoValidation();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("\nEnter the mobile number: \n");
			String MobileNo = sc.next();
			obj.checkMobileNo(MobileNo);
			System.out.println("Valid Mobile Number");
		} catch (InvalidMobileNumberException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static boolean ValidateMobileNumber(String mobileNo) {
		Pattern p = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");
		Matcher m = p.matcher(mobileNo);
		return m.matches();
	}
}