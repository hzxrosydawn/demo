package com.rosydawn.demo.web;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Druid 的监控数据可以在开启 StatFilter 后通过 DruidStatManagerFacade 进行获取，获取到监控数据之后你可以将其暴露给你的监控系统进
 * 行使用。Druid 默认的监控系统数据也来源于此。实际使用中你可以根据你的需要自由地对监控数据、暴露方式进行扩展。
 *
 * @auther: Vincent Huang
 * Created on 2019/7/11 17:45
 */
@RestController
public class DruidStatController {
    /**
     * DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade
     * 还提供了一些其他方法，你可以按需选择使用。
     *
     * @return
     */
    @GetMapping("/druid/stat")
    public Object druidStat(){
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}