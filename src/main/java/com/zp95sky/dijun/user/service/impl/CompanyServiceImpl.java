package com.zp95sky.dijun.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.dijun.user.entity.Company;
import com.zp95sky.dijun.user.mapper.CompanyMapper;
import com.zp95sky.dijun.user.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

}
