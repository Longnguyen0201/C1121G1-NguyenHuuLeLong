package model;

public class Catelogy {
    private Integer catelogyId;
    private  String catelogyName;

    public Catelogy(Integer catelogyId, String catelogyName) {
        this.catelogyId = catelogyId;
        this.catelogyName = catelogyName;
    }

    public Catelogy(Integer catelogyId) {
        this.catelogyId = catelogyId;
    }

    public Integer getCatelogyId() {
        return catelogyId;
    }

    public void setCatelogyId(Integer catelogyId) {
        this.catelogyId = catelogyId;
    }

    public String getCatelogyName() {
        return catelogyName;
    }

    public void setCatelogyName(String catelogyName) {
        this.catelogyName = catelogyName;
    }
}

