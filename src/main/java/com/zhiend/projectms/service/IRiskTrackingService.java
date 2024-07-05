package com.zhiend.projectms.service;

import com.zhiend.projectms.dto.RiskTrackingDTO;
import com.zhiend.projectms.entity.RiskTracking;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 风险跟踪与解决表 服务类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
public interface IRiskTrackingService extends IService<RiskTracking> {

    RiskTracking getProjectMilestones(Long projectId);

    boolean isProjectIdExists(Long projectId);

    void add(RiskTrackingDTO riskTrackingDTO);

    void updateProject(RiskTrackingDTO riskTrackingDTO);

    void deleteByProjectId(Long id);
}
