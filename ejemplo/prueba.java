import java.util.concurrent.Semaphore;

public class EjemploSemaforo {
    // Creamos un semáforo con 1 permiso, lo que significa que solo un hilo
    // puede acceder al recurso compartido a la vez.
    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        // Creamos y lanzamos 5 hilos que intentarán acceder al recurso compartido.
        for (int i = 1; i <= 5; i++) {
            new Thread(new Tarea(i)).start();
        }
    }

    // Clase que representa una tarea realizada por un hilo.
    static class Tarea implements Runnable {
        private int id;

        public Tarea(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                // Intentamos adquirir un permiso del semáforo.
                semaphore.acquire();

                // Simulamos el acceso al recurso compartido.
                System.out.println("El hilo " + id + " está accediendo al recurso.");
                Thread.sleep(2000); // Simula una operación que tarda 2 segundos.

                // Terminamos la operación y liberamos el permiso.
                System.out.println("El hilo " + id + " ha terminado.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Aseguramos que el permiso se libera incluso si ocurre una excepción.
                semaphore.release();
            }
        }
    }
}
