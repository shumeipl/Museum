package com.pro.service;

import com.pro.pojo.Exhibits;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xhw
 * @since 2022-11-25
 */
@Service
public interface IExhibitsService extends IService<Exhibits> {

    /**
     * 查询所有展览
     * @return
     */
    List<Exhibits> getAllExhibits();


    /**
     * 根据状态查询展览
     * @param state
     * @return
     */
    List<Exhibits> getExhibitsByState(Integer state);

    /**
     * 根据状态分页查询
     * @param state
     * @param currentPage
     * @param pageSize
     * @return
     */
     List<Exhibits> getExhibitsByStatePage(Integer state, Integer currentPage, Integer pageSize);

    /**
     * 根据id查询展览
     * @param exhibitId
     * @return
     */
     Exhibits getExhibitById(Integer exhibitId);

    /**
     * 条件查询
     * @return
     */
    List<Exhibits> getExhibitsByStateRange();

}
