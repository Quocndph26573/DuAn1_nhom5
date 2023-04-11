package service.ServiceImpl;

import java.util.ArrayList;
import model.ThuongHieu;
import reopsitory.ThuongHieuRepository;
import service.QuanLyThuongHieu;

public class ThuongHieuServiceImpl implements QuanLyThuongHieu{
    private ThuongHieuRepository thR;
    
    public ThuongHieuServiceImpl(){
        this.thR = new ThuongHieuRepository();
    }

    @Override
    public ArrayList<ThuongHieu> getList() {
        return this.thR.getList();
    }

    @Override
    public void insert(ThuongHieu th) {
        this.thR.insert(th);
    }

    @Override
    public void update(ThuongHieu th, Integer id) {
        this.thR.update(id, th);
    }

    @Override
    public void delete(Integer id) {
        this.thR.delete(id);
    }

    @Override
    public ArrayList<String> selectMa() {
        return this.thR.selectMa();
    }
}
