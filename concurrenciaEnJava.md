Introduccion Semaforos:
    Los semáforos son mecanismos de sincronización que se utilizan para controlar el acceso a recursos compartidos en un entorno de concurrencia, evitando condiciones de carrera y garantizando que solo un número específico de hilos pueda acceder a un recurso crítico a la vez. En Java, los semáforos se implementan a través de la clase Semaphore de la biblioteca java.util.concurrent. Un semáforo mantiene un contador interno que representa el número de permisos disponibles. Los hilos deben adquirir un permiso del semáforo antes de poder acceder al recurso protegido, y deben liberar el permiso después de haber terminado de usar el recurso. Si no hay permisos disponibles, el hilo que intenta adquirir uno se bloqueará hasta que otro hilo libere un permiso.

Guía de Uso
Cómo utilizar Semáforos en Java
Para utilizar semáforos en Java, primero se debe importar la clase Semaphore desde la biblioteca java.util.concurrent. A continuación, se muestra un ejemplo de cómo crear y usar un semáforo:

1. Importación de la Clase:
import java.util.concurrent.Semaphore;

2. Creación del Semáforo:
Puede crear un semáforo con un número inicial de permisos. Por ejemplo, si desea que solo un hilo a la vez pueda acceder al recurso, puede crear un semáforo con un permiso:
Semaphore semaphore = new Semaphore(1);

3. Adquisición de Permisos:
Antes de que un hilo pueda acceder al recurso compartido, debe adquirir un permiso del semáforo utilizando el método acquire():
try {
    semaphore.acquire();
    // Código para acceder al recurso compartido
} catch (InterruptedException e) {
    e.printStackTrace();
}

4. Liberación de Permisos:
Una vez que el hilo haya terminado de usar el recurso, debe liberar el permiso usando el método release() para que otros hilos puedan acceder al recurso:
semaphore.release();

El uso de semáforos es especialmente útil en escenarios donde se desea limitar el número de hilos que acceden simultáneamente a un recurso, como en el caso de controlar el acceso a una base de datos o a un archivo.