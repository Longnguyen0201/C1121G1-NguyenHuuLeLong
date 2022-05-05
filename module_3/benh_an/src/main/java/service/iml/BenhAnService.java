package service.iml;

import models.BenhAn;
import models.BenhNhan;
import repository.IBenhAnRepository;
import repository.impl.BenhAnRepository;
import service.IBenhAnService;

import java.util.List;

public class BenhAnService implements IBenhAnService {
    IBenhAnRepository benhAnRepository = new BenhAnRepository();
    @Override
    public List<BenhAn> danhSachBenhAn() {
        return benhAnRepository.danhSachBenhAn();
    }

    @Override
    public BenhAn timBenhAn(String id) {
        return benhAnRepository.timBenhAn(id);
    }

    @Override
    public void capNhapBenhAn(BenhAn benhAn) {
        benhAnRepository.capNhapBenhAn(benhAn);
    }

    @Override
    public boolean xoaBenhAnTheoId(String id) {
        return benhAnRepository.xoaBenhAnTheoId(id);
    }
}
