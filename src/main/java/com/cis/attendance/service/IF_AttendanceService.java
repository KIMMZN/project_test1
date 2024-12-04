package com.cis.attendance.service;

import com.cis.attendance.dto.AttendanceDTO;

import java.util.List;

public interface IF_AttendanceService {
    public void workStart(AttendanceDTO attendanceDTO) throws Exception;
    public List<AttendanceDTO> attendanceList(int startIndex, int pageSize) throws Exception;
    public void attendanceMod(AttendanceDTO attendanceDTO) throws Exception;
    public int attendanceListCnt() throws Exception;
}
