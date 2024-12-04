package com.cis.member.controller;

import com.cis.Pagination;
import com.cis.member.dto.*;
import com.cis.member.service.IF_MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Validated
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    IF_MemberService memberService;

    // 시작화면 (로그인 방식 선택.)
    @GetMapping(value="/")
    public String start_page() throws Exception{
        System.out.println("시작화면");
        return "total_login";
    }

    // 사원 로그인 선택시
    @GetMapping(value="/employee_login")
    public String login() throws Exception {
        return "Employee/employee_login";
    }

    // 일반사원 로그인.
    @RequestMapping(value="employee_login_action")
    public String employee_login_action(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("emp_id");
        String userPass = request.getParameter("emp_pass");
        ManagerEmployeeDTO managerEmployeeDTO = memberService.login_employee_info(userId);
        String password = managerEmployeeDTO.getEmp_pass();
        if(userPass.equals(password)){
            HttpSession session = request.getSession(); // 세션 생성
            session.setAttribute("emp_name", managerEmployeeDTO.getEmp_name());
            session.setAttribute("employee_id", userId);
            session.setAttribute("emp_email", managerEmployeeDTO.getEmp_email());
            session.setAttribute("emp_dept", managerEmployeeDTO.getEmp_dept());
            session.setAttribute("emp_rank", managerEmployeeDTO.getEmp_rank());
            session.setMaxInactiveInterval(1000); // 세션 유효 시간을 10 분으로 설정.

            return "main/emp_main";
        }
        return "Employee/employee_login";
    }


    // 로그아웃
    @RequestMapping(value="logout_btn")
    public String logout_btn(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.invalidate(); // 세션 비활성화.
        return "Employee/employee_login";
//        return "main/emp_main"; // 세션 비활성화 성공 여부 확인 코드.
    }


    // 일반 사원 로그인에서 "사원가입" 클릭시
    @GetMapping(value="/join")
    public String join() throws Exception {
        return "Employee/join";
    }

    // 신규 사원 등록.
    @PostMapping(value="employee_join")
    public String add_new_employee(@ModelAttribute EmployeeDTO employeedto) throws Exception {
        System.out.println("입력받은 신규 사원의 정보 확인 : " + employeedto.toString());
        memberService.add_new_employee(employeedto);
        return "redirect:employee_login";
    }

    // "관라자 로그인"에서 "Login"클릭했을때.
    // 관리자 비밀번호 확인 창
    @GetMapping(value="check_manager_pass")
    public String check_manager_pass()throws Exception {
        return "Manager/manager_pass_check";
    }

    @PostMapping(value="check_input_manager_pass")
    public String manager(@RequestParam("manager_pass") String pass) throws Exception {
        // 비밀번호 일치 여부 체크
        boolean check_result = memberService.check_manager_pass(pass);
        if (check_result) {
            return "main/manager_main";
        } else {
            return "redirect:check_manager_pass";
        }
    }

    //    public String manage_page(Model model, @ModelAttribute PageDTO pagedto) throws Exception{
    @GetMapping(value="manager_page")
    public String manage_page(@RequestParam(defaultValue = "1") int page, Model model) throws Exception{
        int totalCount = memberService.total_count_number();
        System.out.println("totalcount : " + totalCount + " / " + page);
//        Pagination pagination = new Pagination(10, totalCount, page);
        Pagination pagination = new Pagination(10, totalCount, page);
        int startIndex = pagination.getStartIndex();
        int pageSize = pagination.getPageSize();
        pagination.setSelectPage(page);
        // 전체 사원 리스트 받기.
        List<ManagerEmployeeDTO> total_employee_list = memberService.total_employee_list(startIndex, pageSize);
        for (ManagerEmployeeDTO member : total_employee_list) {
            System.out.println("사원 정보 : " + member.toString());
        }
        model.addAttribute("pagination", pagination);
        model.addAttribute("employee", total_employee_list);
//        return "Manager/total_list";
        return "Manager/total_list";
    }



    //     전체 사원 리스트에서 사원이름으로 검색한 결과.
    @PostMapping(value="manager_page")
//    public String search(@RequestParam("search_employee") String input_name, Model model) throws Exception{
    public String search(@RequestParam(defaultValue = "1") int page , @RequestParam("select_big_part") String big_part, @RequestParam("department") String department, @RequestParam("select_work_status") String work_status, @RequestParam("search_employee") String input_name , Model model) throws Exception{
        int totalCount = memberService.total_count_number();
        Pagination pagination = new Pagination(10, totalCount, page);
        int startIndex = pagination.getStartIndex();
        int pageSize = pagination.getPageSize();
        pagination.setSelectPage(page);
        List<ManagerEmployeeDTO> list = null;
        // 검색창에 입력한 내용이 없을때.
        if(input_name.isEmpty()){
            if(big_part.equals("select_dept") && work_status.equals("select_status")){
                // 부서 선택.
                list = memberService.total_dept_list( department, startIndex, pageSize);
                for(ManagerEmployeeDTO member : list){
                    System.out.println("부서 선택한 사원 정보 : " + member.toString());
                }
            }else if(big_part.equals("select_work_status") && department.equals("select_dept")){
                // 재직상태 선택.
                list = memberService.total_work_status_list( work_status,startIndex, pageSize);
                for(ManagerEmployeeDTO member : list){
                    System.out.println("재직상태 선택한 사원 정보 : " + member.toString());
                }
            }
        }else{
            // 검색창에 입력한 내용이 있을때.
            list = memberService.total_search_employee_list(input_name);
            for(ManagerEmployeeDTO member : list){
                System.out.println("검색한 사원 정보 : " + member.toString());
            }
        }
        model.addAttribute("pagination", pagination);
        model.addAttribute("employee",list);
        return "Manager/total_list";
    }



    @GetMapping(value="manager_modify_employee_info.html")
    public String employee_info(@RequestParam("emp_name") String click_id, Model model) throws Exception{
        // 이름이 "click_id"인 사원에 모든 정보 조회.
        ManagerEmployeeDTO member = memberService.one_employee_info(click_id);
        model.addAttribute("one_employee_info", member);
        return "Manager/manager_modify_employee_info";
    }

    @PostMapping(value="send_modify_employee_info")
    public String changed_employee_info(@ModelAttribute ManagerEmployeeDTO member) throws Exception{
        memberService.modify_employee_info(member);
        return "redirect:manager_page";
    }



    // 관리자 사원 정보 수정화면 중 부서 콤보박스에서 사용.
    @ModelAttribute("departmentCodes")
    public List<DepartmentCode> departmentCodes() {
        List<DepartmentCode> departmentCodes = new ArrayList<>();
        departmentCodes.add(new DepartmentCode("business", "영업팀"));
        departmentCodes.add(new DepartmentCode("program", "개발팀"));
        departmentCodes.add(new DepartmentCode("technology", "기술팀"));
        departmentCodes.add(new DepartmentCode("planning", "기획팀"));
        departmentCodes.add(new DepartmentCode("accounting", "회계팀"));
        departmentCodes.add(new DepartmentCode("human_resources", "인사팀"));
        return departmentCodes;
    }

    // 관리자 직원 정보 추가가 필요한 사원에 리스트 조회.
    @GetMapping(value="complete_employee_info")
//    @GetMapping(value="manager_page")
    public String complete_employee_info(@RequestParam(defaultValue = "1") int page, Model model) throws Exception{
        int totalCount = memberService.total_count_number();
        System.out.println("totalcount : " + totalCount + " / " + page);
        List<ManagerEmployeeDTO> list = memberService.get_need_complete_employee_list();
        for (ManagerEmployeeDTO member : list) {
            System.out.println("추가 필요한 사원의 리스트 : " + member.toString());
            System.out.println("추가 필요한 사원의 아이디 정보 : " + member.getEmp_id());
        }
        model.addAttribute("need_complete_list", list);
        return "Manager/total_employee_list_need_add_info";
    }

    // 관리자가 직원 정보를 완성시킬 수 있게하는 정보 입력 화면으로 이동.
    @GetMapping(value="manager_complete_employee_info.html")
    public String add_complete_employee_info(@RequestParam("emp_id") String id, Model model) throws Exception{
        ManagerEmployeeDTO one_employee_info = memberService.select_one_employee_info_need_complete(id);
        System.out.println("***_MemberController : " + one_employee_info.toString());
        model.addAttribute("need_complete_one_employee_info", one_employee_info);
        return "Manager/add_new_employee_info";
    }

    // 관리자가 입력후 보충된 사원에 정보.
    @PostMapping(value="add_new_employee")
    public String complete_info(@ModelAttribute ManagerEmployeeDTO member) throws Exception{
        System.out.println("관리자가 입력한 정보 : " + member.toString());
//        return "redirect:manager_complete_employee_info.html";
        memberService.complete_info(member);
        return "null";
    }

}
