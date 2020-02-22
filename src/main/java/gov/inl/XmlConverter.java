package gov.inl;

import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class XmlConverter extends JFrame{
    DataAccessObject dao;

    public void setInputFilename(String inputFilename) {
        this.inputFilename = inputFilename;
    }

    public void setCommunicationOutputFilename(String communicationOutputFilename) {
        CommunicationOutputFilename = communicationOutputFilename;
    }

    public void setTopologyOutputFilename(String topologyOutputFilename) {
        TopologyOutputFilename = topologyOutputFilename;
    }

    String inputFilename;
    String CommunicationOutputFilename;
    String TopologyOutputFilename;
    FileSelectDialog dialog;

    public XmlConverter() {
        super("Test using JFilePicker");
        
        dao = new DataAccessObject(inputFilename);
         
        setLayout(new FlowLayout());
 
        dialog = new FileSelectDialog(this);
        
        add(dialog);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 170);
        setLocationRelativeTo(null);
        

    }

    public void run() {
        inputFilename = dialog.getInputFile();
        dao.setInputFilename(inputFilename);
        File file = new File(inputFilename);
        if (file.exists()) {
            CommunicationOutputFilename = file.getParentFile().getAbsolutePath() + "/Comunication.csv";
            TopologyOutputFilename = file.getParentFile().getAbsolutePath() + "/Topology.csv";
            generateCommunicationTable();
            generateTopologyTable();
        }
    }

    public void generateCommunicationTable() {
        List<String> communicationTable = getCommunicationTable();

        writeToFile(communicationTable, CommunicationOutputFilename);

    }

    private List<String> getCommunicationTable() {
        CommunicationTableGenerator generator = new CommunicationTableGenerator(dao);

        return generator.generate();
    }

    public void generateTopologyTable() {
        List<String> topologyTable = getTopologyTable();

        writeToFile(topologyTable, TopologyOutputFilename);
    }

    private List<String> getTopologyTable() {
        TopologyTableGenerator generator = new TopologyTableGenerator(dao);

        return generator.generate();
    }

    private static void writeToFile(List<String> lines, String outputFileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
















    public static void main(String[] args) {
//        XmlConverter converter = new XmlConverter();
//
////        converter.generateCommunicationTable();
////        converter.generateTopologyTable();
////        converter.run();
//        FileSelectDialog dialog = new FileSelectDialog();
//        System.out.println("Done!");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new XmlConverter().setVisible(true);
            }
        });
        
    }
}
