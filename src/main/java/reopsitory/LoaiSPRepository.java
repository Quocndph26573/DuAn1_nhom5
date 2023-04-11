package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import model.LoaiSP;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoaiSPRepository {

    private Session session;

    public LoaiSPRepository() {
        this.session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<LoaiSP> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "From LoaiSP where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<LoaiSP> list = (ArrayList<LoaiSP>) q.getResultList();
        return list;
    }

    public void insert(LoaiSP lsp) {
        session.beginTransaction();
        session.save(lsp);
        session.getTransaction().commit();
    }

    public void update(Integer id, LoaiSP lsp) {
        session.beginTransaction();
        String query = "Update LoaiSP set ma=:ma, ten=:ten, ngaySua=:ngaySua where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", lsp.getMa());
        q.setParameter("ten", lsp.getTen());
        q.setParameter("ngaySua", lsp.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public void delete(Integer id) {
        session.beginTransaction();
        String query = "Update LoaiSP set trangThai =:trangThai WHERE id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public ArrayList<String> selectMa() {
        String query = "SELECT s.ma from LoaiSP s";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }

}
