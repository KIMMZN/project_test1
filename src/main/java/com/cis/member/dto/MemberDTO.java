package com.cis.member.dto;


public class MemberDTO {
    private String emp_id;
    private String resident_num;


    private String emp_pass;
    private String create_at;
    private String post_addr;
    private String road_addr;
    private String jibun_addr;



    public String getJibun_addr() {
        return jibun_addr;
    }

    public void setJibun_addr(String jibun_addr) {
        this.jibun_addr = jibun_addr;
    }

    public String getRoad_addr() {
        return road_addr;
    }

    public void setRoad_addr(String road_addr) {
        this.road_addr = road_addr;
    }

    public String getPost_addr() {
        return post_addr;
    }

    public void setPost_addr(String post_addr) {
        this.post_addr = post_addr;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public String getResident_num() {
        return resident_num;
    }

    public void setResident_num(String resident_num) {
        this.resident_num = resident_num;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "emp_id='" + emp_id + '\'' +
                ", resident_num='" + resident_num + '\'' +
                ", emp_pass='" + emp_pass + '\'' +
                ", create_at='" + create_at + '\'' +
                ", post_addr='" + post_addr + '\'' +
                ", road_addr='" + road_addr + '\'' +
                ", jibun_addr='" + jibun_addr + '\'' +
                '}';
    }

}
