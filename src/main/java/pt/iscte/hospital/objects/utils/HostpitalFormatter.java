package pt.iscte.hospital.objects.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class HostpitalFormatter {
    public static final String PHONE = "###,###";

    public static String formatValue(Number value, String formatString) {
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
        formatSymbols.setDecimalSeparator('.');
        formatSymbols.setGroupingSeparator(' ');
        DecimalFormat formatter = new DecimalFormat(formatString, formatSymbols);
        return formatter.format(value);
    }
}
