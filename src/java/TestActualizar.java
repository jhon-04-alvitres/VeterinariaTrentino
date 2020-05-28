
import modelo.Mascota;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;



/**
 *
 * Ejemplo #3
Actualizar en la base de datos la información de una mascota.
 */
public class TestActualizar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Mascota miMascota = new Mascota();
        miMascota.setIdMascota(2);
        miMascota.setNombre("peluche");
        miMascota.setEdad(10);
        miMascota.setNombreDueno("Jhulissa");
        miMascota.setRaza("pequines");
        String mensaje = modificarMascota(miMascota);
        System.out.println(mensaje);
    }
     public static String modificarMascota(Mascota mascota) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(mascota);
        transaction.commit();
        session.close();  
        return "Se Actualizo a una  mascota";
    }
}
