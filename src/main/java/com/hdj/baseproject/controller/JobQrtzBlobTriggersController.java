package com.hdj.baseproject.controller;

import com.hdj.baseproject.codeGenerate.BaseController;
import com.hdj.baseproject.codeGenerate.BaseService;
import com.hdj.baseproject.entity.JobQrtzBlobTriggers;
import com.hdj.baseproject.service.JobQrtzBlobTriggersService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


/**
 * (JobQrtzBlobTriggers)表控制层
 *
 * @author makejava
 * @since 2020-01-15 16:11:47
 */
@RestController
@RequestMapping("jobQrtzBlobTriggers")
public class JobQrtzBlobTriggersController extends BaseController<JobQrtzBlobTriggers> {
    /**
     * 服务对象
     */
    @Resource(name="jobQrtzBlobTriggersService")
    private JobQrtzBlobTriggersService jobQrtzBlobTriggersService;

    @Override
    public BaseService<JobQrtzBlobTriggers> getService() {
        return  jobQrtzBlobTriggersService;
    }
    
 

 
}