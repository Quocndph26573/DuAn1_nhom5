package hibernateConfig;

import java.util.Properties;
import model.Account;
import model.ChatLieu;
import model.ChiTietSanPham;
import model.ChucVu;
import model.GioHang;
import model.GioHangChiTiet;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.ThuongHieu;
import model.LoaiSP;
import model.NguoiDung;
import model.Size;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=DuAn1_BanQuanAo_1");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(LoaiSP.class);
        conf.addAnnotatedClass(Size.class);
        conf.addAnnotatedClass(NguoiDung.class);
        conf.addAnnotatedClass(ThuongHieu.class);
        conf.addAnnotatedClass(ChatLieu.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(ChiTietSanPham.class);
        conf.addAnnotatedClass(Account.class);


        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }

}
