package tapastop.utils;

class StrTypes {
    public static final String STR_ALPHABETIC = "^[a-zA-Z ]*$";
    public static final String STR_MAILS = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
    public static final String STR_DECNUMBER = "^[0-9]";
    public static final String STR_RUT = "^[0-9]{7,8}+[A-Z]{1}$";
    public static final String STR_NUMBER = "^[0-9]{9}";

    public static final String STR_DATE = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
}
