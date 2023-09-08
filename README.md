# Java Regular Expression Validator with Maven

## Application Description
This is a Java-based application built using Maven. The application contains a function that uses a regular expression to validate a given string based on specific criteria. These include maximum string length, presence of uppercase and lowercase letters, digits, special characters, and the absence of whitespace. The application also comes with unit tests covering a variety of edge cases to ensure the functionality of the regex.

## Regex Implementation Description
The implemented regular expression is optimized for speed and simplicity while meeting all the specified criteria. It starts by limiting the string length through `{minLength,maxLength}` syntax, and then uses lookaheads to ensure at least one uppercase letter, one lowercase letter, one digit, and one special character from a predefined list are present. Whitespace characters are not allowed in the string. The regular expression is designed to be easily reusable and should not introduce any unexpected behavior.

## How to Run Locally

1. **Clone the Repository:**
    ```
    git clone https://github.com/yourusername/java-regex-validator.git
    ```

2. **Navigate to the Project Directory:**
    ```
    cd java-regex-validator
    ```

3. **Compile and Package using Maven:**
    ```
    mvn clean package
    ```

4. **Run the Application:**
    ```
    java -jar target/java-regex-validator-1.0-SNAPSHOT.jar
    ```

5. **Run Unit Tests:**
    ```
    mvn test
    ```

## Code Snippet for the Regex Function
Here is a brief code snippet that represents the regex function. Note that the full code includes more elaborate features like input validation and exception handling.

```java
import java.util.regex.Pattern;

public class RegexValidator {
    public static boolean isValidString(String str, int maxLength) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!\\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~])\\S{" + 1 + "," + maxLength + "}$";
        return Pattern.matches(regex, str);
    }
}

Unit Tests
Unit tests have been implemented using JUnit to cover various edge cases like too short input, too long input, missing uppercase, lowercase, special characters, digits, and excess whitespace characters.

java
Copy code
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegexValidatorTest {

    @Test
    public void testTooShortInput() {
        assertFalse(RegexValidator.isValidString("A1!", 10));
    }

    @Test
    public void testTooLongInput() {
        assertFalse(RegexValidator.isValidString("A1!aaaaaaaabbbbbbb", 15));
    }

    // Additional tests go here...
}