package service;

import models.BenhAn;
import models.BenhNhan;

import java.util.List;

public interface IBenhAnService {
    List<BenhAn> danhSachBenhAn();

    BenhAn timBenhAn(String id);

    void capNhapBenhAn(BenhAn benhAn);

    boolean xoaBenhAnTheoId(String id);
}
