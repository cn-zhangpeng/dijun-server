package com.zp95sky.dijun.project.biz.impl;

import com.zp95sky.dijun.project.biz.ProjectKanbanBiz;
import com.zp95sky.dijun.project.domain.ProjectKanbanListDo;
import com.zp95sky.dijun.project.entity.ProjectKanban;
import com.zp95sky.dijun.project.service.ProjectKanbanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectKanbanBizImpl implements ProjectKanbanBiz {

    private final ProjectKanbanService kanbanService;

    @Override
    public List<ProjectKanbanListDo> getKanbanList(Integer projectId) {
        List<ProjectKanban> kanbanList = kanbanService.listByProjectId(projectId);
        if (CollectionUtils.isEmpty(kanbanList)) {
            return Collections.emptyList();
        }

        return kanbanList.stream().map(this::buildKanbanListDo).collect(Collectors.toList());
    }

    private ProjectKanbanListDo buildKanbanListDo(ProjectKanban kanban) {
        return ProjectKanbanListDo.builder()
                .id(kanban.getId()).name(kanban.getName())
                .build();
    }

}
