package cn.itcast.springboot.dao;

import cn.itcast.springboot.model.MessageInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/16.
 */
@Repository("msgInfoRepository")
public interface MsgInfoRepository extends MongoRepository<MessageInfo,String> {
    MessageInfo queryMsgInfoByMsgInfo(String msgInfo);
}
