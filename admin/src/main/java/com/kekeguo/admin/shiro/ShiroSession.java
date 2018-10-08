package com.kekeguo.admin.shiro;

import com.kekeguo.admin.util.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author zhangyuna
 * @date 2018年10月08日16:30:54
 */
@Component
public class ShiroSession extends AbstractSessionDAO {

    @Autowired
    private RedisUtil redisUtil;
    private static final String  DEFAUKT_KEY="shiro:";

    /**
     * 如DefaultSessionManager在创建完session后会调用该方法；
     * 如保存到关系数据库/文件系统/NoSQL数据库；即可以实现会话的持久化；
     * 返回会话ID；主要此处返回的ID.equals(session.getId())；
     * @param session
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
        String  sessionId = String.valueOf(session.getId());

        return null;
    }

    /**
     * 根据会话ID获取会话
     * @param sessionId
     * @return
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        return null;
    }

    /**
     * 更新会话；如更新会话最后访问时间/停止会话/设置超时时间/设置移除属性等会调用
     * @param session
     * @throws UnknownSessionException
     */
    @Override
    public void update(Session session) throws UnknownSessionException {

    }

    /**
     * 删除会话；当会话过期/会话停止（如用户退出时）会调用
     * @param session
     */
    @Override
    public void delete(Session session) {

    }

    /**
     * 获取当前所有活跃用户，如果用户量多此方法影响性能
     * @return
     */
    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }
}
