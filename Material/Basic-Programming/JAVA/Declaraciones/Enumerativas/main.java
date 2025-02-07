public class main {
    public static void main(String[] args) {
        WeekDays dia = WeekDays.GLUGLUNES;

        System.out.println(dia);

        System.out.println("List days of the year");
        for(WeekDays day: WeekDays.values()) {
            System.out.println(day);
        }
        
    }
    
    public enum WeekDays {
        GLUGLUNES, MAMARTES, MIERCOLITROS, JUEVEBES, VIERNEBRIOS, SABADRINCK, DOMINGOMA
    }
}
