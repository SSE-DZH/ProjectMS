package com.zhiend.projectms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiend.projectms.dto.DevelopmentStatusDTO;
import com.zhiend.projectms.entity.DevelopmentStatus;
import com.zhiend.projectms.mapper.DevelopmentStatusMapper;
import com.zhiend.projectms.page.BackPage;
import com.zhiend.projectms.service.IDevelopmentStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 研制状态与进展表 服务实现类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Service
public class DevelopmentStatusServiceImpl extends ServiceImpl<DevelopmentStatusMapper, DevelopmentStatus> implements IDevelopmentStatusService {

    @Override
    public BackPage<DevelopmentStatus> listByBackPage(Long pageNo, Long pageSize) {
        BackPage<DevelopmentStatus> DevelopmentStatusBackPage = new BackPage<>();
        // 设置条件构造器
        QueryWrapper<DevelopmentStatus> wrapper = new QueryWrapper<>();
        // 构造分页信息，其中的Page<>(page, PAGE_RECORDS_NUM)的第一个参数是第几页，而第二个参数是每页的记录数
        Page<DevelopmentStatus> DevelopmentStatusPage = new Page<>(pageNo, pageSize);
        // page(DevelopmentStatusPage, wrapper)这里的第一个参数就是上面定义了的Page对象，第二个参数就是上面定义的条件构造器对象，通过调用这个方法就可以根据你的分页信息以及查询信息获取分页数据
        IPage<DevelopmentStatus> DevelopmentStatusIPage = page(DevelopmentStatusPage, wrapper);
        // 封装数据，其中getRecords()是获取记录数，getCurrent()获取当前页数，getPages()获取总页数，getTotal()获取记录总数，还要其他更多的方法，大家可以自行查看，在这里就不过多赘述了
        DevelopmentStatusBackPage.setContentList(DevelopmentStatusIPage.getRecords());
        DevelopmentStatusBackPage.setCurrentPage(DevelopmentStatusIPage.getCurrent());
        DevelopmentStatusBackPage.setTotalPage(DevelopmentStatusIPage.getPages());
        DevelopmentStatusBackPage.setTotalNum(DevelopmentStatusIPage.getTotal());
        return DevelopmentStatusBackPage;
    }

    @Override
    public boolean isProjectIdExists(Integer projectId) {
        QueryWrapper<DevelopmentStatus> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id", projectId);
        return count(wrapper) > 0;
    }

    @Override
    @Transactional
    public void addStatus(DevelopmentStatusDTO statusDTO) {
        DevelopmentStatus status = new DevelopmentStatus();
        BeanUtils.copyProperties(statusDTO, status);
        status.setCurrentStatus(statusDTO.getCurrentStatus());
        status.setThisWeekProgress(statusDTO.getThisWeekProgress());
        save(status);
    }

    @Override
    @Transactional
    public void updateProject(Long id, DevelopmentStatusDTO statusDTO) {
        DevelopmentStatus status = new DevelopmentStatus();
        BeanUtils.copyProperties(statusDTO, status);
        status.setCurrentStatus(statusDTO.getCurrentStatus());
        status.setThisWeekProgress(statusDTO.getThisWeekProgress());
        updateById(status);
    }
}
