package service.ServiceImpl;

import java.util.ArrayList;
import model.ChatLieu;

import reopsitory.ChatLieuRepository;
import service.QuanLyChatLieu;


public class ChatLieuServiceImpl implements QuanLyChatLieu{
    private ChatLieuRepository clR;
    
    public ChatLieuServiceImpl(){
        this.clR = new ChatLieuRepository();
    }

    @Override
    public ArrayList<ChatLieu> getList() {
        return this.clR.getList();
    }

    @Override
    public void insert(ChatLieu cl) {
        this.clR.insert(cl);
    }

    @Override
    public void update(ChatLieu cl, Integer id) {
        this.clR.update(id, cl);
    }

    @Override
    public void delete(Integer id) {
        this.clR.delete(id);
    }

    @Override
    public ArrayList<String> selectMa() {
        return this.clR.selectMa();
    }
}
