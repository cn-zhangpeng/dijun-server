package com.zp95sky.dijun.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.dijun.user.entity.Department;
import com.zp95sky.dijun.user.mapper.DepartmentMapper;
import com.zp95sky.dijun.user.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}
