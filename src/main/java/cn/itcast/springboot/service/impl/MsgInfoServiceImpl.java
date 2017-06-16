package cn.itcast.springboot.service.impl;

import cn.itcast.springboot.dao.MsgInfoRepository;
import cn.itcast.springboot.model.MessageInfo;
import cn.itcast.springboot.service.MsgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2017/6/16.
 */
@Service("msgInfoService")
public class MsgInfoServiceImpl implements MsgInfoService {
    @Autowired
    private MsgInfoRepository msgInfoRepository;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public void save(String username) {
        MessageInfo entity = new MessageInfo();
        entity.setId("1");
        entity.setMsgInfo(username);
        msgInfoRepository.save(entity);
    }

	@Override
	public MessageInfo queryMessageInfo() {
		return msgInfoRepository.queryMsgInfoByMsgInfo("admin");
	}
}
