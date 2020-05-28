
import java.util.ArrayList;
import java.util.List;
import modelo.Mascota;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * Ejemplo #6 Encontrar de la base de datos la información de la mascota cuya
 * edad sea: “3” y su raza sea “pastor alemán”.
 */
public class TestEdadRaza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Mascota> miMasota = new ArrayList<>();
        miMasota = buscarEdadRaza("pastor aleman", "3");
        for (int i = 0; i < miMasota.size(); i++) {
            System.out.println(" Raza: " + miMasota.get(i).getRaza()
                    + " Edad: " + miMasota.get(i).getEdad());
        }
    }

    public static List<Mascota> buscarEdadRaza(String razaBuscar, String edadBuscar) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Mascota where edad='" + edadBuscar + "'and raza='" + razaBuscar + "'";
        Query query = session.createQuery(hql);
        List<Mascota> miLista = query.list();
        return miLista;
    }

}
