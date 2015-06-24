/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.telas.relatorio;

import codigos.telas.modal.ModalityInternalFrame;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDesktopPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Lucas
 */
public class Relatorio extends ModalityInternalFrame {

    public Relatorio(JDesktopPane main, String titulo) {

        super(main, titulo, false, true);
    }

    protected void emitirRelatorio(List dados, String arquivo, String relatorio) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            // compilacao do JRXML
            JasperReport report = JasperCompileManager
                    .compileReport(relatorio);

            JasperPrint print = JasperFillManager.fillReport(report, params,
                    new JRBeanCollectionDataSource(dados));

            // exportacao do relatorio para outro formato, no caso PDF
            JasperExportManager.exportReportToPdfFile(print,
                    arquivo);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
}
