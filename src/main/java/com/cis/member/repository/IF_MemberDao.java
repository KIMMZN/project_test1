package com.cis.member.repository;

import com.cis.member.dto.EmployeeDTO;
import com.cis.member.dto.ManagerDTO;
import com.cis.member.dto.ManagerEmployeeDTO;
import com.cis.member.dto.PageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface IF_MemberDao {

    // 전체 사원 리스트 조회.
//    public List<ManagerEmployeeDTO> selectAll() throws Exception;
//    public List<ManagerEmployeeDTO> selectAll(PageDTO pagedto) throws Exception;
    public List<ManagerEmployeeDTO> selectAll(int startIndex, int pageSize) throws Exception;

    // 아이디 중복 체트.
    public int check_id(String id) throws Exception;

    // 신규 사원 등록.
    public void insert_employee(EmployeeDTO employeedto) throws Exception;

    // 관리자가 가지고 있는 전체 사원의 정보 조회.
    public List<ManagerDTO> select_all_manager_info(EmployeeDTO employeedto) throws Exception;

    // 로그인
    public EmployeeDTO selectOne(String id) throws Exception;

    // 전체 사원 리스트에서 검색한 결과.
    public List<ManagerEmployeeDTO> selectSearch(String input_name) throws Exception;

    // 전체 사원수 count (페이징)
    public int count_employee() throws Exception;

    // 부서 선택.
    public List<ManagerEmployeeDTO> select_dept_list( String department) throws Exception;

    // 재직상태 선택.
    public List<ManagerEmployeeDTO> select_work_status_list(String work_status) throws Exception;

    // 전체 사원 리스트에서 이름을 클릭해 한명에 사원에 모든 정보를 조회.
    public ManagerEmployeeDTO select_one_employee_info (String emp_name) throws Exception;

    // 로그인한 사원에 전체정보 조회.
    public ManagerEmployeeDTO select_login_employee_info(String id) throws Exception;



    public void modify_employee_info(ManagerEmployeeDTO managerEmployeeDTO) throws Exception;

    // 관리자가 정보를 추가할 사원에 리스트.
    public List<ManagerEmployeeDTO>select_manager_add_info(int startIndex, int pageSize) throws Exception;

    // 관리자가 정보를 추가할 한명에 사원에 정보를 조회.
    public ManagerEmployeeDTO select_one_employee_info_need_complete(String id) throws Exception;

    // 관리자가 보충한 사원 정보를 update.
    public void update_complete_employee_info(ManagerEmployeeDTO member) throws Exception;


    // totalcount 가져오기.
    public int total_employee_count() throws Exception;

}
