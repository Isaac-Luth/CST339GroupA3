import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = VerifyInputs.class)
public class VerifyInputsTests {

    @Autowired
    private VerifyInputs verifyInputs;

    @Test
    public void isValidEmailTrueTest() {
        assertTrue(verifyInputs.isValidEmail("asdf@asdf.com"));
    }

    @Test
    public void isValidEmailMissingAtTest() {
        assertFalse(verifyInputs.isValidEmail("asdf.com"));
    }

    @Test
    public void isValidPasswordTrueTest() {
        assertTrue(verifyInputs.isValidPassword("Password1!"));
    }

    @Test
    public void isValidPasswordNoSymbolFalseTest() {
        assertFalse(verifyInputs.isValidPassword("Password1"));
    }

    @Test
    public void isValidPhoneNumberTrueTest() {
        assertTrue(verifyInputs.isValidPhoneNumber("1234567890"));
    }

    @Test
    public void isValidPhoneNumber9DigitFalseTest() {
        assertFalse(verifyInputs.isValidPhoneNumber("123456789"));
    }

    @Test
    public void isValidEmailMissingDotTest() {
        assertFalse(verifyInputs.isValidEmail("asdf@com"));
    }

    @Test
    public void isValidPasswordNoUppercaseFalseTest() {
        assertFalse(verifyInputs.isValidPassword("password1!"));
    }

    @Test
    public void isValidPasswordNoDigitFalseTest() {
        assertFalse(verifyInputs.isValidPassword("Password!"));
    }

    @Test
    public void isValidPhoneNumber11DigitFalseTest() {
        assertFalse(verifyInputs.isValidPhoneNumber("12345678901"));
    }

    @Test
    public void isValidPhoneNumberWithHyphenFalseTest() {
        assertFalse(verifyInputs.isValidPhoneNumber("123-456-7890"));
    }

    @Test
    public void isValidEmailNoDomainFalseTest() {
        assertFalse(verifyInputs.isValidEmail("asdf@asdf."));
    }

    @Test
    public void isValidEmailNoTextPreDotFalseTest() {
        assertFalse(verifyInputs.isValidEmail("asdf@.com"));
    }

}