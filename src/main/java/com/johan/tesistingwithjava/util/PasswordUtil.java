package com.johan.tesistingwithjava.util;

import java.util.NoSuchElementException;

import static com.johan.tesistingwithjava.util.PasswordUtil.SecurityLevel.MEDIUM;
import static com.johan.tesistingwithjava.util.PasswordUtil.SecurityLevel.WEAK;
import static com.johan.tesistingwithjava.util.PasswordUtil.SecurityLevel.STRONG;

public class PasswordUtil {

    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }

    public static SecurityLevel checkPasswordSecurity(String password) {
        boolean isWeakSecurity = password.length() < 8 || password.matches("[a-zA-Z]+") || password.matches("[0-9]+");
        boolean isMediumSecurity = password.matches("[a-zA-Z0-9]+");
        return isWeakSecurity ? WEAK : isMediumSecurity ? MEDIUM : STRONG;
    }

    public static String returnMessage() {
        throw new NoSuchElementException("Check this out");
    }
}

