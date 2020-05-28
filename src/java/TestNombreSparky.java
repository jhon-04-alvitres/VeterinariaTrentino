
import java.util.ArrayList;
import java.util.List;
import modelo.Mascota;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * Ejemplo #5 Encontrar de la base de datos la información de la mascota cuyo
 * nombre sea: “sparky”.
 */
public class TestNombreSparky {

    public static void main(String[] args) {
        // obtener el nombre sparky
//        List<Mascota> nameMascota = buscarMascotaNombre("sparky");
//        for (int i = 0; i < nameMascota.size(); i++) {
//            System.out.println("se encontro:" + nameMascota.get(i));
//        }

        List<Mascota> listaSparky = new ArrayList<>();
       listaSparky = buscarMascotaNombre();
        for (int i = 0; i < listaSparky.size(); i++) {
            System.out.println("Nombre:" + listaSparky.get(i).getNombre());
        }

    }

//    public static List<Mascota> buscarMascotaNombre(String nombreBuscar) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        String hql = "from Mascota where nombre='" + nombreBuscar + "'";
//        Query query = session.createQuery(hql);
//        List<Mascota> miLista = query.list();
//        return miLista;
//    }
    public static List<Mascota> buscarMascotaNombre() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Mascota where nombre ='sparky'";
        Query query = session.createQuery(hql);
        List<Mascota> miLista = query.list();
        return miLista;

    }
}
