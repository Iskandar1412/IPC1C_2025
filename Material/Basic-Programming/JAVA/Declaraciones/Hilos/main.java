// Extendiendo clase Thread
class HiloThread extends Thread {
    public void run() {
        System.out.println("Hilo Thread en Ejecución");
    }
}

// Implementando Runnable
class HiloRunnable implements Runnable {
    public void run() {
        System.out.println("Hilo Runable en Ejecución");
    }
}

public class main {
    public static void main(String[] args) {
        // Hilo con Thread
        HiloThread hilo1 = new HiloThread();
        hilo1.start();

        

        Thread hilo2 = new Thread(new HiloRunnable());
        hilo2.start();
    }
}
