package org.gnius.hr.util;

public class StringUtils {

    /**
     * SQL LIKE parameter.
     *  @param string the SQL LIKE parameter
     *  @return if string contains no '%' return string + "%"
     *          if string is null return null
     */
    public static String sqlLikeParam(String string) {
        if (string != null && !string.equals("") && string.indexOf('%') < 0 && string.indexOf('_') < 0) {
            string = string + "%";
        }
        return string;
    }

}
