package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import model.ChatLieu;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class ChatLieuRepository {
        private Session session;

    public ChatLieuRepository() {
        this.session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<ChatLieu> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "From ChatLieu where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<ChatLieu> list = (ArrayList<ChatLieu>) q.getResultList();
        return list;
    }

    public void insert(ChatLieu cl) {
        session.beginTransaction();
        session.save(cl);
        session.getTransaction().commit();
    }

    public void update(Integer id, ChatLieu cl) {
        session.beginTransaction();
        String query = "Update ChatLieu set ma=:ma, ten=:ten, ngaySua=:ngaySua where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", cl.getMa());
        q.setParameter("ten", cl.getTen());
        q.setParameter("ngaySua", cl.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public void delete(Integer id) {
        session.beginTransaction();
        String query = "Update ChatLieu set trangThai =:trangThai WHERE id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public ArrayList<String> selectMa() {
        String query = "SELECT s.ma from ChatLieu s";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }

}
