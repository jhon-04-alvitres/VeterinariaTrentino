
import java.util.ArrayList;
import java.util.List;
import modelo.Mascota;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 Ejemplo #2
Listar desde la base de datos la información de todas las  mascotas.
 */
public class TestListar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Mascota> lista = new ArrayList<>();
        lista = listarMascotas();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("nombre: " + lista.get(i).getNombre()
                    + " NombreDueño: " + lista.get(i).getNombreDueno()
                    + " Raza: " + lista.get(i).getRaza()
                    + " Edad: " + lista.get(i).getEdad());
        }
    }

    public static List<Mascota> listarMascotas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Mascota";
        Query query = session.createQuery(hql);
        List<Mascota> miLista = query.list();
        return miLista;
    }

}
