package cn.itedus.lottery.erp.domain.activity.service;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.erp.application.IActivityService;
import cn.itedus.lottery.erp.domain.activity.model.ActivityListPageReq;
import cn.itedus.lottery.erp.infrastructure.common.EasyResult;
import cn.itedus.lottery.rpc.activity.ILotteryActivityDeploy;
import cn.itedus.lottery.rpc.activity.deploy.req.ActivityPageReq;
import cn.itedus.lottery.rpc.activity.deploy.res.ActivityRes;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-05 15:49
 * @description: 活动服务实现类
 */
@Service
public class ActivityServiceImpl implements IActivityService {

    @DubboReference(interfaceClass = ILotteryActivityDeploy.class)
    private ILotteryActivityDeploy activityDeploy;

    @Override
    public EasyResult queryActivityListPage(ActivityListPageReq req) {
        //1. 组装参数
        ActivityPageReq activityPageReq = new ActivityPageReq(req.getPage(), req.getRows());
        activityPageReq.setErpId(req.getErpId());
        activityPageReq.setActivityId(req.getActivityId());
        activityPageReq.setActivityName(req.getActivityName());

        //2. 查询数据
        ActivityRes activityRes = activityDeploy.queryActivityListByPageForErp(activityPageReq);

        //3. 封装结果
        if (Constants.ResponseCode.SUCCESS.getCode().equals(activityRes.getResult().getCode())) {
            return EasyResult.buildEasyResultSuccess(activityRes.getCount(), activityRes.getActivityDTOList());
        } else {
            return EasyResult.buildEasyResultError(activityRes.getResult().getCode());
        }
    }
}
