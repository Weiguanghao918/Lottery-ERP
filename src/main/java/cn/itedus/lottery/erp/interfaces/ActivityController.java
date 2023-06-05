package cn.itedus.lottery.erp.interfaces;

import cn.itedus.lottery.erp.application.IActivityService;
import cn.itedus.lottery.erp.domain.activity.model.ActivityListPageReq;
import cn.itedus.lottery.erp.infrastructure.common.EasyResult;
import cn.itedus.lottery.rpc.activity.deploy.req.ActivityPageReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-05 15:38
 * @description: 活动管理
 */
@Controller
@RequestMapping("api/activity")
public class ActivityController {

    private Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Resource
    private IActivityService activityService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("queryActivityListPage")
    @ResponseBody
    public EasyResult queryActivityListPage(String page, String rows) {
        try {
            logger.info("查询活动列表数据 page：{} rows：{}", page, rows);
            rows = null == rows ? "10" : rows;
            ActivityListPageReq req = new ActivityListPageReq(page, rows);
            req.setErpId("Komorebi_wgh");
            return activityService.queryActivityListPage(req);
        } catch (Exception e) {
            logger.error("查询活动列表数据失败 page：{} rows：{}", page, rows, e);
            return EasyResult.buildEasyResultError(e);
        }
    }
}
