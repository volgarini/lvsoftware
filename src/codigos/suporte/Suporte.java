/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.suporte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Lucas
 */
public class Suporte {

    public static MaskFormatter mascara(String formato) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(formato);
            formatter.setPlaceholderCharacter('_');
        } catch (java.text.ParseException exc) {
            System.err.println(exc.getMessage());
        }
        return formatter;
    }

    public static long date_to_milisec(String pattern, String data) throws ParseException {
        SimpleDateFormat format = new java.text.SimpleDateFormat(pattern);
        Date date = format.parse(data);

        return date.getTime();
    }
}
