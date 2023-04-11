package service;

import java.util.ArrayList;
import model.LoaiSP;

public interface QuanLyLoaiSP {
    ArrayList<LoaiSP> getList();
    void insert(LoaiSP lsp);
    void update(LoaiSP lsp, Integer id);
    void delete(Integer id);
    ArrayList<String> selectma();
}
