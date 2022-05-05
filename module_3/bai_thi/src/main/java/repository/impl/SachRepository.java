package repository.impl;

import DTO.TheMuonSachDTO;
import models.HocSinh;
import models.Sach;
import models.TheMuonSach;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachRepository implements repository.SachRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Sach> getAll() {

        List<Sach> sachList = new ArrayList<>();
        String query = " select  * from sach;";
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sachList.add(new Sach(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sachList;
    }

    @Override
    public List<HocSinh> getAllHocSinh() {
        List<HocSinh> hocSinhs = new ArrayList<>();
        HocSinh hocSinh = null;
        String query = "select * from hoc_sinh;";
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hocSinhs.add(new HocSinh(resultSet.getString(1),
                        resultSet.getString(2),resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return hocSinhs;
    }

    @Override
    public Sach selectById(String id) {
        Sach sach = null;
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from sach where ma_sach = ?;");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               sach =  new Sach(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sach;
    }

    @Override
    public void muonSach(TheMuonSach theMuonSach) {
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into the_muon_sach(ma_muon_sach, " +
                    "ma_sach,ma_hoc_sinh,trang_thai,ngay_muon,ngay_tra) value (?,?,?,?,?,?);");
            preparedStatement.setString(1, theMuonSach.getMaMuonSach());
            preparedStatement.setString(2, theMuonSach.getMaSach());
            preparedStatement.setString(3, theMuonSach.getMaHocSinh());
            preparedStatement.setInt(4, theMuonSach.getTrangThai());
            preparedStatement.setString(5, theMuonSach.getNgayMuonSach());
            preparedStatement.setString(6, theMuonSach.getNgayTraSach());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<TheMuonSachDTO> getAllTheMuonSach() {
        List<TheMuonSachDTO> theMuonSachList = new ArrayList<>();
        String query = "select  ma_muon_sach,sach.ten_sach,sach.tac_gia,hoc_sinh.ho_ten ,hoc_sinh.lop,ngay_muon,ngay_tra from the_muon_sach\n" +
                "   join hoc_sinh on hoc_sinh.ma_hoc_sinh = the_muon_sach.ma_hoc_sinh\n" +
                " join sach on sach.ma_sach = the_muon_sach.ma_sach;";
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                theMuonSachList.add(new TheMuonSachDTO(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return theMuonSachList;
    }


}
