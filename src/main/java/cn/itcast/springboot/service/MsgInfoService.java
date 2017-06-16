package cn.itcast.springboot.service;

import cn.itcast.springboot.model.MessageInfo;

/**
 * Created by Administrator on 2017/6/16.
 */
public interface MsgInfoService {
    void save(String username);

	MessageInfo queryMessageInfo();
}
