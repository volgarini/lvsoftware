/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.suporte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
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
        if (data.trim().isEmpty()) {
            return 0;
        }
        SimpleDateFormat format = new java.text.SimpleDateFormat(pattern);
        Date date = format.parse(data);

        return date.getTime();
    }

    public static String limpar_caracteres(String entrada) {
        return entrada.replaceAll("[\\s()-._/]", "").trim();
    }

    public static void aviso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
    }
    /**
     * Método que formata data do banco de dados no segunte formato yyyy-MM-dd para o formato ddMMyyyy
     * @param data entrada no formato yyyy-MM-dd
     * @return retorna data no formato ddMMyyyy
     */
    public static String formataData(String data){
        return data.substring(8,10) + data.substring(5,7) + data.substring(0,4);
    }
}
