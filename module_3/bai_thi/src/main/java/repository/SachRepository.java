package repository;

import DTO.TheMuonSachDTO;
import models.HocSinh;
import models.Sach;
import models.TheMuonSach;

import java.util.List;

public interface SachRepository {
    List<Sach> getAll();

    List<HocSinh> getAllHocSinh();

    Sach selectById(String id);

    void muonSach(TheMuonSach theMuonSach);

    List<TheMuonSachDTO> getAllTheMuonSach();
}
