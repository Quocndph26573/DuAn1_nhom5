package service;

import java.util.ArrayList;
import model.ChatLieu;

public interface QuanLyChatLieu {
    ArrayList<ChatLieu> getList();
    void insert(ChatLieu cl);
    void update(ChatLieu cl, Integer id);
    void delete(Integer id);
    ArrayList<String> selectMa();
}
