package com.cis.attendance.repository;

import com.cis.attendance.dto.AttendanceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IF_AttendanceRepository {
    public void attendanceInsert(AttendanceDTO attendanceDTO) throws Exception;
    public List<AttendanceDTO> attendanceSelectAll(int startIndex, int pageSize) throws Exception;
    public void attendanceUpdate(AttendanceDTO attendanceDTO);
    public int attendanceSelectAllCnt() throws Exception;
}
