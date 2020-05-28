
import java.util.List;
import modelo.Mascota;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;


/**
 *
 * Ejemplo #1 Teniendo estos datos en la base de datos realizar los siguientes
 * ejercicios
 *
 * Eliminar una mascota de la base de datos.
 */
public class TestEliminar {

    public static void main(String[] args) {
        Mascota mascota = buscarMascota(3);
        String mensaje = eliminarMascota(mascota);
        System.out.println(mensaje);
    }

    public static String eliminarMascota(Mascota mascota) {
        if (mascota != null) {
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(mascota);
            sesion.getTransaction().commit();
            sesion.close();
            return "Se elimino una mascota";
        } else {
            return "No se encontró la mascota";
        }
    }

    public static Mascota buscarMascota(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Mascota) session.get(Mascota.class, id);

    }

}
