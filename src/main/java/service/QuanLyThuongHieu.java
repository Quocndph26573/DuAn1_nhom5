package service;

import java.util.ArrayList;
import model.ThuongHieu;

public interface QuanLyThuongHieu {
    ArrayList<ThuongHieu> getList();
    void insert(ThuongHieu th);
    void update(ThuongHieu th, Integer id);
    void delete(Integer id);
    ArrayList<String> selectMa();
}
