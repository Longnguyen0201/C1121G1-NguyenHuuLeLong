package service.impl;

import DTO.TheMuonSachDTO;
import models.HocSinh;
import models.Sach;
import models.TheMuonSach;
import repository.SachRepository;

import java.util.List;

public class SachService implements service.SachService {
    SachRepository sachRepository = new repository.impl.SachRepository();

    @Override
    public List<Sach> getAll() {
        return sachRepository.getAll();
    }


    @Override
    public List<HocSinh> getAllHocSinh() {
        return sachRepository.getAllHocSinh();
    }

    @Override
    public Sach selectById(String id) {
        return sachRepository.selectById(id);
    }

    @Override
    public void muonSach(TheMuonSach theMuonSach) {
        sachRepository.muonSach(theMuonSach);
    }

    @Override
    public List<TheMuonSachDTO> getAllTheMuonSach() {
        return sachRepository.getAllTheMuonSach();
    }


}
