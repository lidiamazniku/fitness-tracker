import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// GUI-Komponenten
public class FitnessTracker extends JFrame {
    //Defining GUI Components like Labels, TextFields, Combobox
    private JPanel JPanel;
    private JLabel trainingsArt;
    private JLabel kalorien;
    private JTextField tfKalorien;
    private JComboBox cbTrainingsArt;
    private JButton btnSpeichern;
    private JTextField tfDauer;
    private JLabel intensitaet;
    private JComboBox cbIntensitaet;
    private JLabel dauer;
    private JComboBox filterCBTrainingsArt;
    private DefaultTableModel tableModel;
    private JComboBox tfFilter;
    private List <Training> trainingList;     // Liste zur Speicherung aller Trainingseinheiten

    //Konstruktor
    public FitnessTracker(){
    trainingList = new ArrayList<>(); //Init of the Training list
    setTitle("Fitness Tracker Programm"); //Program Title
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    //Creating the inputPanel where the user can add or select values
    JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
    inputPanel.setBorder(BorderFactory.createTitledBorder("Neues Training hinzufügen"));
    inputPanel.setBackground(new Color(180, 230, 250));

    inputPanel.add(trainingsArt);
    inputPanel.add(cbTrainingsArt);

    inputPanel.add(kalorien);
    inputPanel.add(tfKalorien);

    inputPanel.add(dauer);
    inputPanel.add(tfDauer);

    inputPanel.add(intensitaet);
    inputPanel.add(cbIntensitaet);

    inputPanel.add(new JLabel(""));
    inputPanel.add(btnSpeichern);
    add(inputPanel, BorderLayout.NORTH);


    //Setting up the Table
    String[] columns = {"Trainingsart", "Kalorien", "Dauer", "Intensität"}; //Defining Coluumns
    tableModel = new DefaultTableModel(columns, 0);
    JTable tabelle = new JTable(tableModel); //Table initliazation
    add(new JScrollPane(tabelle), BorderLayout.CENTER);



    //Creating a new Panel
    JPanel bottomPanel = new JPanel();
    bottomPanel.setBorder(BorderFactory.createTitledBorder("Aktionen"));

    //ComboBox for the Training Type
    bottomPanel.add(new JLabel("Trainingsart"));
    tfFilter = filterCBTrainingsArt;
    bottomPanel.add(tfFilter);

    //Button to trigger the Table Filtering
    JButton btnFilter = new JButton("Filter");
    bottomPanel.add(btnFilter);
    //Button to trigger Show All
    JButton btnAlleAnzeigen = new JButton("Alle Anzeigen");
    bottomPanel.add(btnAlleAnzeigen);
    add(bottomPanel, BorderLayout.SOUTH);

    // ActionListener for the Save Button
    btnSpeichern.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            trainingSpeichern();
        }
    });

    // ActionListener for the Show All Button
    btnAlleAnzeigen.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            showAll(trainingList);
        }
    });
    // ActionListener for the Filter Button
    btnFilter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            filterTabelle();
        }
    });

    initObjekte();
}


//Method that saves a new Training to the application
public void trainingSpeichern() {
    try {
        String trainingsArt = cbTrainingsArt.getSelectedItem().toString(); //Gets the selected Training Type from interface
        double kalorien = Double.parseDouble(tfKalorien.getText()); //Gets the typed Calories from interface
        int dauer = Integer.parseInt(tfDauer.getText());//Gets the typed calories from interface
        String intensitaet = cbIntensitaet.getSelectedItem().toString(); //Gets the selected intesity Type from interface

        Training training = new Training(trainingsArt, kalorien, dauer, intensitaet);//Creates a new instance of the Trainings Class
        trainingList.add(training); //Adds the new Training to the list
        tfKalorien.setText(""); //Reset the Calories
        tfDauer.setText(""); //Resets the duration

    }
    catch (NumberFormatException e) {
        //Error message for wrong number inputs
        JOptionPane.showMessageDialog(this, "Error: Bitte geben Sie gültige Zahlen für Minuten und Kalorien ein.", "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e){
        JOptionPane.showMessageDialog(this, "Error:  " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

//Init Method which gets called on program starts, that creates three different objects of type Training and adds them to the Training list
public void initObjekte() {
//Creating the objects
Training t1 = new Training("Pilates", 250, 60, "Mittel");
Training t2 = new Training("Schwimmen", 375.5, 30, "Hoch");
Training t3 = new Training("Laufen", 300, 85, "Niedrig");

//Adding them to the trainingsList
trainingList.add(t1);
trainingList.add(t2);
trainingList.add(t3);

}

//Method to update the table with the Table which takes as a parameter a list of type Training
private void updateTable(List<Training> data) {
        tableModel.setRowCount(0); //First we set the table to empty

        for (Training t : data) {  //Iterate through the data passed as parameter
            Object[] row = { //create an array of type object with the values TrainingsArt, Calories, Duration and Intesity
                    t.getTrainigsArt(),
                    t.getKalorien(),
                    t.getDauer(),
                    t.getIntensitaet()
            };
            tableModel.addRow(row); // Add the row to the table
        }
}



//Method to filter the table by the TrainingsArt
private void filterTabelle(){
        try{
            String trainingsArt = filterCBTrainingsArt.getSelectedItem().toString(); //First we get the list of TrainingArt from the GUI -> Convert it to string
            ArrayList<Training> filteredList = new ArrayList<>();
            for(Training t : trainingList){ // Iterate through the Trainings List
                if(t.getTrainigsArt().equals(trainingsArt)){ // Filter the list by the choosen TrainingsArt
                    filteredList.add(t); //Update the list
                }
            }
            updateTable(filteredList); // Update the table
        }catch (NumberFormatException e){ //If there's an error, catch and send it to the user
            JOptionPane.showMessageDialog(this, "Bitte wählen Sie eine Options aus", "Filter Error", JOptionPane.WARNING_MESSAGE );
        }
}

//Method that refresh the table and shows all data including the ones added by on initialization
private void showAll(List<Training> data){
        updateTable(data);
}

    //Main Function to start the application and set the visibility to true in order to make the program GUI visible
    public static void main (String[] args){
        FitnessTracker fit = new FitnessTracker();
        fit.setVisible(true);
    }
}



