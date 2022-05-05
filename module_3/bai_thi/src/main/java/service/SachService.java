package service;

import DTO.TheMuonSachDTO;
import models.HocSinh;
import models.Sach;
import models.TheMuonSach;

import java.util.List;

public interface SachService {

    List<Sach> getAll();

    List<HocSinh> getAllHocSinh();


    Sach selectById(String id);

    void muonSach(TheMuonSach theMuonSach);

    List<TheMuonSachDTO> getAllTheMuonSach();
}
