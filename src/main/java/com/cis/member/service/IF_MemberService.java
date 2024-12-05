package com.cis.member.service;

import com.cis.member.dto.EmployeeDTO;
import com.cis.member.dto.ManagerDTO;
import com.cis.member.dto.ManagerEmployeeDTO;
import com.cis.member.dto.PageDTO;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Map;

public interface IF_MemberService {

    // 관리자 비밀번호 확인.
    public boolean check_manager_pass(String pass) throws Exception;

    // 전체 사원 리스트 조회.
//    public List<ManagerEmployeeDTO> total_employee_list() throws Exception;
//    public List<ManagerEmployeeDTO> total_employee_list(PageDTO pagedto) throws Exception;
    public List<ManagerEmployeeDTO> total_employee_list(int startIndex, int pageSize) throws Exception;

    // 아이디 중복 체크.
    public int count_id(String id) throws Exception;

    // 신규 사원 등록.
    public void add_new_employee(EmployeeDTO employeedto) throws Exception;

    // 전체 직원 리스트에서 검색한 결과.
    public List<ManagerEmployeeDTO> total_search_employee_list(String input_name) throws Exception;

    // 페이징.
    public int total_count_employee_list() throws Exception;

    // 일반 사원 로그인.
    public EmployeeDTO selectOne(String id) throws Exception;

    // 콤보박스에서 부서 선택시.
    public List<ManagerEmployeeDTO> total_dept_list( String department, int startIndex, int pageSize) throws Exception;

    // 콤보박스에서 재직상태 선택시.
    public List<ManagerEmployeeDTO> total_work_status_list( String work_status, int startIndex, int pageSize) throws Exception;

    // 전체 사원 리스트에서 사원에 이름을 클릭했을때, 그 사원에 모든 정보를 조회.
    public ManagerEmployeeDTO one_employee_info(String name) throws Exception;

    // 전체 사원 리스트에서 사원에 이름을 클릭했을때, 그 사원에 모든 정보를 조회.
    public ManagerEmployeeDTO login_employee_info(String id) throws Exception;


    // 관리자가 추가한 사원에 정보.
    public void modify_employee_info(ManagerEmployeeDTO employee) throws Exception;

    // 관리자가 정보를 추가할 필요가 있는 사원 리스트.
    public List<ManagerEmployeeDTO> get_need_complete_employee_list(int startIndex, int pageSize) throws Exception;

    // 관리자가 정보 추가를 필요한 사원 한명에 정보를 조회.
    public ManagerEmployeeDTO select_one_employee_info_need_complete(String id) throws Exception;

    //  관리자가 보충한 데이터를 가공.
    public void complete_info(ManagerEmployeeDTO member) throws Exception;

    // totalCount 가져옴
    public int total_count_number()throws Exception;


}