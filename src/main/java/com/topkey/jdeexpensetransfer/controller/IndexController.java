package com.topkey.jdeexpensetransfer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.stat.DruidStatManagerFacade;

@RestController
@RequestMapping("/index")
public class IndexController {
  @GetMapping("/druid-status")
  public Object druidStat(){
      return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
  }
}