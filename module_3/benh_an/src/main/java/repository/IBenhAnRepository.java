package repository;

import models.BenhAn;
import models.BenhNhan;

import java.util.List;

public interface IBenhAnRepository {
    List<BenhAn> danhSachBenhAn();

    BenhNhan getBenhNhan(String id);

    BenhAn timBenhAn(String id);

    void capNhapBenhAn(BenhAn benhAn);

    boolean xoaBenhAnTheoId(String id);
}
