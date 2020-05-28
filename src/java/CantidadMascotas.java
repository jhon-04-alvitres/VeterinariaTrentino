
import java.util.ArrayList;
import java.util.List;
import modelo.Mascota;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author USUARIO
 */
public class CantidadMascotas {

    public static void main(String[] args) {



        List<Mascota> lista = new ArrayList<>();
        lista = contadorDeMascotas();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Nombre: " + lista.get(i).getNombre());

        }

    }

    public static List<Mascota> contadorDeMascotas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Mascota";
        Query query = session.createQuery(hql);
        List<Mascota> miLista = query.list();
        return miLista;
    }

//    public Integer contadorDeMascotas(Mascota mascota) throws Exception {
//        String hql = "select count(*) from Cargo";
//        Query query = mascota.createQuery(hql);
//        Long FilasTab = (Long) query.uniqueResult();
//        Integer cont = FilasTab.intValue();
//        return cont;
//    }

}
