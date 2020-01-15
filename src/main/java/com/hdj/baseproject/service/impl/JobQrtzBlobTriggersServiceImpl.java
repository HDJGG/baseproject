package com.hdj.baseproject.service.impl;

import com.hdj.baseproject.codeGenerate.BaseMapper;
import com.hdj.baseproject.codeGenerate.BaseServiceImpl;
import com.hdj.baseproject.entity.JobQrtzBlobTriggers;
import com.hdj.baseproject.mapper.JobQrtzBlobTriggersMapper;
import com.hdj.baseproject.service.JobQrtzBlobTriggersService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * (JobQrtzBlobTriggers)表服务实现类
 *
 * @author makejava
 * @since 2020-01-15 16:11:47
 */
@Service("jobQrtzBlobTriggersService")
public class JobQrtzBlobTriggersServiceImpl  extends BaseServiceImpl<JobQrtzBlobTriggers> implements JobQrtzBlobTriggersService {

    @Resource(name="jobQrtzBlobTriggersMapper")
    private JobQrtzBlobTriggersMapper jobQrtzBlobTriggersMapper;

    @Override
    protected BaseMapper<JobQrtzBlobTriggers> getMapper() {
        return jobQrtzBlobTriggersMapper;
    }

}