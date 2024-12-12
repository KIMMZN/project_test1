package com.cis.personal_task.repository;

import com.cis.personal_task.dto.PersonalTaskDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface PersonalTaskRepository {

    // 업무 삽입
    void insertTask(PersonalTaskDTO taskDTO);

    // 받은 업무 목록 조회
    List<PersonalTaskDTO> findReceivedTasks(String receive_id);

    // 업무 상세 조회
    PersonalTaskDTO findTaskById(int task_num);

    // 페이징을 지원하는 받은 업무 조회
    List<PersonalTaskDTO> findReceivedTasksByReceiveId(@Param("receive_id") String receive_id);

    // 상태에 따라 페이징된 업무 목록 조회
    List<PersonalTaskDTO> selectTasksByStatus(@Param("task_status") String task_status, @Param("limit") int limit, @Param("offset") int offset);

    // 업무 상태 업데이트 (진행 -> 완료)
    void updateTaskStatus(int task_num, String task_status);

    // 전체 업무 목록 조회 (페이징)
    List<PersonalTaskDTO> selectAllTasks(@Param("limit") int limit, @Param("offset") int offset);

    // 모든 업무 가져오기 (메인)
    List<PersonalTaskDTO> findAllTasks();

    // 상태별 업무 가져오기 (메인)
    List<PersonalTaskDTO> findTasksByStatus(@Param("task_status") String task_status);
//    // 메인화면 업무 목록
//    List<PersonalTaskDTO> getMainList(String task_title, String task_status);


    List <PersonalTaskDTO> getMainTasks(String receive_id);

    //List<PersonalTaskDTO> getTaskMain(@Param("task_status") String task_status);
}
