package com.inferno43.findme.toolbox;

import com.inferno43.findme.exceptions.EmptyTextException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Utils on 1/30/17.
 */

public class Utils {
    private static Utils ourInstance = new Utils();

    public static Utils getInstance() {
        return ourInstance;
    }

    private Utils() {
    }
    private static Pattern validUser = Pattern.compile("^[A-Za-z_]\\w{7,29}$");
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     *
     * Validates the string with the above and throws exception if the string is empty
     *
     * @param username
     * @return boolean
     * @throws EmptyTextException
     */
    public boolean validUserName(String username) throws EmptyTextException{

        return validUser.matcher(username).matches();
    }

    /**
     * Validates the password string and throws exception if the string is empty
     * @param password
     * @return boolean
     * @throws EmptyTextException
     */
    public boolean validpassword(String password) throws EmptyTextException {

        return password.length()>0;
    }


    /**
     * Validates the email string and throws exception if the string is empty
     * @param emailStr
     * @return
     */
    public boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
}
