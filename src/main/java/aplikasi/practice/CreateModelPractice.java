package main.java.aplikasi.practice;

public class CreateModelPractice {

    public static void main(String[] args) {

        AlatTulis pulpen = new AlatTulis();
        pulpen.setMerk("JOYKO");

        AlatTulis pensil = new AlatTulis();
        pensil.setUkuran(20);

        System.out.println("INI PRINT PULPEN : "+pulpen);
        System.out.println("INI PRINT PENSIL : "+pensil);

        System.out.println("INI MERK PULPEN : "+pulpen.getMerk());
        System.out.println("INI MERK PENSIL : "+pensil.getMerk());

        System.out.println("INI UKURAN PULPEN : "+pulpen.getUkuran() + " cm");
        System.out.println("INI UKURAN PENSIL : "+pensil.getUkuran() + " cm");
    }

}

class AlatTulis {
    private String merk;
    private Integer ukuran;
    private Boolean isProduktif;

    public AlatTulis(String merk, Integer ukuran, Boolean isProduktif) {
        this.merk = merk;
        this.ukuran = ukuran;
        this.isProduktif = isProduktif;
    }

    public AlatTulis() {
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public Integer getUkuran() {
        return ukuran;
    }

    public void setUkuran(Integer ukuran) {
        this.ukuran = ukuran;
    }

    public Boolean getProduktif() {
        return isProduktif;
    }

    public void setProduktif(Boolean produktif) {
        isProduktif = produktif;
    }
}
