package com.hdj.baseproject.entity;

import com.hdj.baseproject.codeGenerate.BaseBean;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import lombok.Data;

/**
 * (JobQrtzBlobTriggers)实体类
 *
 * @author makejava
 * @since 2020-01-15 16:11:47
 */

@NoArgsConstructor 
@AllArgsConstructor
@Data
public class JobQrtzBlobTriggers  extends BaseBean implements Serializable {
    private static final long serialVersionUID = 468818220480980505L;
    
    private String schedName;
    
    private String triggerName;
    
    private String triggerGroup;
    
    private Object blobData;


}