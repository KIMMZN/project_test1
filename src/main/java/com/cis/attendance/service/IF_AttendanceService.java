package com.cis.attendance.service;

import com.cis.Pagination;
import com.cis.attendance.dto.AttendanceDTO;

import java.util.List;

public interface IF_AttendanceService {

    public void workStart(AttendanceDTO attendanceDTO) throws Exception;
    public List<AttendanceDTO> attendanceList(Object login_emp, Pagination pagination) throws Exception;
    public void attendanceMod(AttendanceDTO attendanceDTO) throws Exception;
    public int attendanceListCnt(Object login_emp) throws Exception;

}
