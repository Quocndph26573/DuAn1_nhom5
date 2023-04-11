package service.ServiceImpl;

import java.util.ArrayList;
import model.LoaiSP;
import reopsitory.LoaiSPRepository;
import service.QuanLyLoaiSP;

public class LoaiSPServiceImpl implements QuanLyLoaiSP{
    private LoaiSPRepository lspR;
    
    public LoaiSPServiceImpl(){
        this.lspR = new LoaiSPRepository();
    }

    @Override
    public ArrayList<LoaiSP> getList() {
        return this.lspR.getList();
    }

    @Override
    public void insert(LoaiSP lsp) {
        this.lspR.insert(lsp);
    }

    @Override
    public void update(LoaiSP lsp, Integer id) {
        this.lspR.update(id, lsp);
    }

    @Override
    public void delete(Integer id) {
        this.lspR.delete(id);
    }

    @Override
    public ArrayList<String> selectma() {
        return this.lspR.selectMa();
    }
}
