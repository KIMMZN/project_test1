package com.cis.attendance.service;

import com.cis.attendance.dto.AttendanceDTO;
import com.cis.attendance.repository.IF_AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService implements IF_AttendanceService {

    @Autowired
    IF_AttendanceRepository attendanceRepository;

    @Override
    public void workStart(AttendanceDTO attendanceDTO) throws Exception {
        attendanceRepository.attendanceInsert(attendanceDTO);
    }

    @Override
    public List<AttendanceDTO> attendanceList(int startIndex, int pageSize) throws Exception {
        return attendanceRepository.attendanceSelectAll(startIndex, pageSize);
    }

    @Override
    public void attendanceMod(AttendanceDTO attendanceDTO) throws Exception {
        attendanceRepository.attendanceUpdate(attendanceDTO);;
    }

    @Override
    public int attendanceListCnt() throws Exception {
        return attendanceRepository.attendanceSelectAllCnt();
    }

}
