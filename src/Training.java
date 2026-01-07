import java.util.Objects;

public class Training {

    // Attribute für die Trainingseinheit
    private String trainigsArt;
    private double kalorien;
    private int dauer;
    private String intensitaet;

    //Konstruktor
    public Training (String trainigsArt, double kalorien, int dauer, String intensitaet){
        this.trainigsArt = trainigsArt;
        this.kalorien = kalorien;
        this.dauer = dauer;
        this.intensitaet = intensitaet;
    }

    // Getters
    public  String getTrainigsArt() { return trainigsArt; }
    public double getKalorien() { return kalorien; }
    public int getDauer() { return  dauer; }
    public String getIntensitaet() { return intensitaet; }
}
