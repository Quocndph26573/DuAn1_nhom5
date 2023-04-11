package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "ChiTietSanPham")
public class ChiTietSanPham {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column (name = "Ma")
    private String ma;
    
    @Column (name = "Ten")
    private String Ten;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdLoaiSP")
    private LoaiSP idLoaiSP;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdThuongHieu")
    private ThuongHieu IdThuongHieu;
    
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "IdChatLieu")
   private ChatLieu IdChatLieu;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSize")
    private Size IdSize;
    
    @Column (name = "TrangThai")
    private int trangThai;
    @Column (name = "Gia")
    private int gia;
    @Column (name = "soLuong")
    private int soLuong;
    @Column (name = "NgayThem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThem;
    
    @Column (name = "NgaySua")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySua;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(Integer id, String ma, String Ten, LoaiSP idLoaiSP, ThuongHieu IdThuongHieu, ChatLieu IdChatLieu, Size IdSize, int trangThai, int gia, int soLuong, Date ngayThem, Date ngaySua) {
        this.id = id;
        this.ma = ma;
        this.Ten = Ten;
        this.idLoaiSP = idLoaiSP;
        this.IdThuongHieu = IdThuongHieu;
        this.IdChatLieu = IdChatLieu;
        this.IdSize = IdSize;
        this.trangThai = trangThai;
        this.gia = gia;
        this.soLuong = soLuong;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public LoaiSP getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(LoaiSP idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public ThuongHieu getIdThuongHieu() {
        return IdThuongHieu;
    }

    public void setIdThuongHieu(ThuongHieu IdThuongHieu) {
        this.IdThuongHieu = IdThuongHieu;
    }

    public ChatLieu getIdChatLieu() {
        return IdChatLieu;
    }

    public void setIdChatLieu(ChatLieu IdChatLieu) {
        this.IdChatLieu = IdChatLieu;
    }

    public Size getIdSize() {
        return IdSize;
    }

    public void setIdSize(Size IdSize) {
        this.IdSize = IdSize;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    
}
