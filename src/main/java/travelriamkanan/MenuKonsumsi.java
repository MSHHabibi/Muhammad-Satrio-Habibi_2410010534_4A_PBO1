package travelriamkanan;

// No.1 CLASS
public class MenuKonsumsi {
    // No.3 ATRIBUT + No.7 ENCAPSULATION 
    private String labelMenu;
    private double tarifPerKepala;

    // [No.4] CONSTRUCTOR 
    public MenuKonsumsi(String labelMenu, double tarifPerKepala) {
        this.labelMenu = labelMenu;
        this.tarifPerKepala = tarifPerKepala;
    }

    // No.6 ACCESSOR 
    public String getLabelMenu()      { return labelMenu; }
    public double getTarifPerKepala() { return tarifPerKepala; }

    // No.5 MUTATOR 
    public void setLabelMenu(String labelMenu)           { this.labelMenu = labelMenu; }
    public void setTarifPerKepala(double tarifPerKepala) { this.tarifPerKepala = tarifPerKepala; }
}