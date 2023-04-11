package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.ThuongHieu;
import org.hibernate.Session;

public class ThuongHieuRepository {

    private Session session;

    public ThuongHieuRepository() {
        this.session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<ThuongHieu> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from ThuongHieu where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<ThuongHieu> list = (ArrayList<ThuongHieu>) q.getResultList();
        return list;
    }

    public void insert(ThuongHieu th) {
        session.beginTransaction();
        session.save(th);
        session.getTransaction().commit();
    }

    public void update(Integer id, ThuongHieu th) {
        session.beginTransaction();
        String query = "Update ThuongHieu set ma=:ma, ten=:ten, ngaySua=:ngaySua where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", th.getMa());
        q.setParameter("ten", th.getTen());
        q.setParameter("ngaySua", th.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public void delete(Integer id) {
        session.beginTransaction();
        String query = "update ThuongHieu set trangThai =:trangThai WHERE id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public ArrayList<String> selectMa() {
        String query = "SELECT s.ma from ThuongHieu s";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }

}
