package cn.itedus.lottery.erp.application;

import cn.itedus.lottery.erp.domain.activity.model.ActivityListPageReq;
import cn.itedus.lottery.erp.infrastructure.common.EasyResult;
import cn.itedus.lottery.rpc.activity.deploy.req.ActivityPageReq;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-05 15:47
 * @description: 活动服务接口
 */
public interface IActivityService {
    /**
     * 查询活动分页数据
     *
     * @param req 入参
     * @return 结果
     */
    EasyResult queryActivityListPage(ActivityListPageReq req);
}
