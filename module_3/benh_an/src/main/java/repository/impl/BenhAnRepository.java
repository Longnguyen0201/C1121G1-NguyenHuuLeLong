package repository.impl;

import models.BenhAn;
import models.BenhNhan;
import repository.BaseRepository;
import repository.IBenhAnRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository implements IBenhAnRepository {
    BaseRepository baseRepository =new BaseRepository();
    @Override
    public List<BenhAn> danhSachBenhAn() {
        BenhAnRepository benhAnRepository =new BenhAnRepository();
        List<BenhAn> benhAn = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from benh_an;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                benhAn.add(new BenhAn(resultSet.getInt(1),
                        resultSet.getString(2),
                        benhAnRepository.getBenhNhan(resultSet.getString(3)),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return benhAn;
    }
    public BenhNhan getBenhNhan (String maBenhNhan){
        BenhNhan benhNhan = null;
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from benh_nhan where ma_benh_nhan = ?;");
            preparedStatement.setString(1,maBenhNhan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                benhNhan = new BenhNhan(resultSet.getString(1),resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }return  benhNhan;
    }

    @Override
    public BenhAn timBenhAn(String id) {
        BenhAnRepository benhAnRepository =new BenhAnRepository();
        BenhAn benhAn = null;
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *from benh_an where ma_benh_an=?;");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               benhAn= new BenhAn(resultSet.getInt(1),
                        resultSet.getString(2),
                        benhAnRepository.getBenhNhan(resultSet.getString(3)),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
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
        return benhAn;
    }

    @Override
    public void capNhapBenhAn(BenhAn benhAn) {

    }

    @Override
    public boolean xoaBenhAnTheoId(String id) {
        Connection connection = this.baseRepository.getConnection();
        boolean kiemtra = false;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(" delete from benh_an where ma_benh_an = ?; \n");
            preparedStatement.setString(1, id);
            kiemtra = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return kiemtra;
    }
}
