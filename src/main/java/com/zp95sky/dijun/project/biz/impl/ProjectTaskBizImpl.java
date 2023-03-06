package com.zp95sky.dijun.project.biz.impl;

import com.zp95sky.dijun.project.biz.ProjectKanbanBiz;
import com.zp95sky.dijun.project.domain.ProjectKanbanListDo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectTaskBizImpl implements ProjectKanbanBiz {

    @Override
    public List<ProjectKanbanListDo> getKanbanList(Long projectId) {
        return null;
    }

}
