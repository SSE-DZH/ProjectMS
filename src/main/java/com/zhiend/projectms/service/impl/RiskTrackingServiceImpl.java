package com.zhiend.projectms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhiend.projectms.dto.RiskTrackingDTO;
import com.zhiend.projectms.entity.ProjectMilestones;
import com.zhiend.projectms.entity.RegistrationProgress;
import com.zhiend.projectms.entity.RiskTracking;
import com.zhiend.projectms.mapper.RiskTrackingMapper;
import com.zhiend.projectms.service.IRiskTrackingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 风险跟踪与解决表 服务实现类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Service
public class RiskTrackingServiceImpl extends ServiceImpl<RiskTrackingMapper, RiskTracking> implements IRiskTrackingService {

    @Override
    public RiskTracking getProjectMilestones(Long projectId) {
        return getOne(new QueryWrapper<RiskTracking>().eq("project_id", projectId));
    }

    @Override
    public boolean isProjectIdExists(Long projectId) {
        return count(new QueryWrapper<RiskTracking>().eq("project_id", projectId)) > 0;
    }

    @Override
    @Transactional
    public void add(RiskTrackingDTO riskTrackingDTO) {
        RiskTracking riskTracking = new RiskTracking();
        BeanUtils.copyProperties(riskTrackingDTO, riskTracking);
        save(riskTracking);
    }

    @Override
    @Transactional
    public void updateProject(RiskTrackingDTO riskTrackingDTO) {
        QueryWrapper<RiskTracking> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", riskTrackingDTO.getProjectId());
        RiskTracking riskTracking = getOne(queryWrapper);

        if (riskTracking != null) {
            // 复制属性到现有对象
            BeanUtils.copyProperties(riskTrackingDTO, riskTracking);
            // 更新对象
            updateById(riskTracking);
        } else {
            throw new RuntimeException("项目不存在，无法更新");
        }
    }

    @Override
    public void deleteByProjectId(Long id) {
        remove(new QueryWrapper<RiskTracking>().eq("project_id", id));
    }
}
