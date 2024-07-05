package com.zhiend.projectms.service;

import com.zhiend.projectms.dto.DevelopmentStatusDTO;
import com.zhiend.projectms.entity.DevelopmentStatus;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiend.projectms.page.BackPage;

/**
 * <p>
 * 研制状态与进展表 服务类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
public interface IDevelopmentStatusService extends IService<DevelopmentStatus> {

    BackPage<DevelopmentStatus> listByBackPage(Long pageNo, Long pageSize);

    boolean isProjectIdExists(Integer projectId);

    void addStatus(DevelopmentStatusDTO statusDTO);

    void updateProject(Long id, DevelopmentStatusDTO statusDTO);
}
