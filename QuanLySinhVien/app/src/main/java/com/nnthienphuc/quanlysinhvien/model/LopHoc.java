package com.nnthienphuc.quanlysinhvien.model;

public class LopHoc {
    private Integer id;
    private String tenlophoc;

    public LopHoc(Integer id, String tenlophoc) {
        this.id = id;
        this.tenlophoc = tenlophoc;
    }

    public LopHoc() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenlophoc() {
        return tenlophoc;
    }

    public void setTenlophoc(String tenlophoc) {
        this.tenlophoc = tenlophoc;
    }
}
