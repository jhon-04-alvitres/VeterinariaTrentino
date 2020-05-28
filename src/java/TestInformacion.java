
import java.util.List;
import modelo.Mascota;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 * Ejemplo #4 Listar de la base de datos la información de las mascotas cuya
 * raza sea: “pastor alemán”.
 */
public class TestInformacion {

    public static void main(String[] args) {

        List<Mascota> mascotas = buscarMascotaRaza("pastor alemán");
        System.out.println("ESTO ES UNA MANERA DE LISTAR");
        for (int i = 0; i < mascotas.size(); i++) {
            System.out.println("--" + mascotas.get(i));
        }

//        System.out.println("OTRA MENERA-----------------------------");
//        for (Mascota mascota : mascotas) {
//            System.out.println(mascota);
//        }

    }

    public static List<Mascota> buscarMascotaRaza(String razaBuscar) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Mascota where raza='" + razaBuscar + "'";
        Query query = session.createQuery(hql);
        List<Mascota> miLista = query.list();
        return miLista;
    }

}
