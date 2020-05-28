
import modelo.Mascota;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author USUARIO
 */
public class TestAgregar {

    public static void main(String[] args) {
        Mascota miMascota = new Mascota();
        miMascota.setIdMascota(6);
        miMascota.setNombre("peluche");
        miMascota.setEdad(10);
        miMascota.setNombreDueno("Jhon");
        miMascota.setRaza("chusco");
        String mensaje = insertarMascota(miMascota);
        System.out.println(mensaje);
    }

    public static String insertarMascota(Mascota mascota) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(mascota);
        transaction.commit();
        session.close();  
        return "Se inserto una nueva mascota";
    }
}
