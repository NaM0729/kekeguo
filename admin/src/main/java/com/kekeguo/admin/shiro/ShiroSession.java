package com.kekeguo.admin.shiro;

import com.kekeguo.admin.util.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author zhangyuna
 * @date 2018年10月08日16:30:54
 */
@Component
public class ShiroSession extends EnterpriseCacheSessionDAO {

    private Logger logger = LoggerFactory.getLogger(ShiroSession.class);

    @Autowired
    private RedisUtil redisUtil ;

    /**
     * 如DefaultSessionManager在创建完session后会调用该方法；
     * 如保存到关系数据库/文件系统/NoSQL数据库；即可以实现会话的持久化；
     * 返回会话ID；主要此处返回的ID.equals(session.getId())；
     *
     * @param session
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
        logger.info("create session");
        Serializable sessionId = super.doCreate(session);
        redisUtil.saveSession(sessionId.toString(), session);
        return sessionId;
    }

    /**
     * 根据会话ID获取会话
     *
     * @param sessionId
     * @return
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.info("get session id");
        Session session = super.doReadSession(sessionId);
        if (session == null) {
            session = redisUtil.getSessionBySessionId(sessionId.toString());
        }
        return session;
    }

    /**
     * 更新会话；如更新会话最后访问时间/停止会话/设置超时时间/设置移除属性等会调用
     *
     * @param session
     * @throws UnknownSessionException
     */
    @Override
    protected void doUpdate(Session session) {
        logger.info("update session");
        super.doUpdate(session);
        redisUtil.saveSession(session.getId().toString(), session);
    }

    /**
     * 删除会话；当会话过期/会话停止（如用户退出时）会调用
     *
     * @param session
     */
    @Override
    protected void doDelete(Session session) {
        logger.info(("delete session"));
        super.doDelete(session);
        redisUtil.deleteSessionBySessionId(session.getId().toString());
    }

    /**
     * 获取当前所有活跃用户，如果用户量多此方法影响性能
     *
     * @return
     */
    @Override
    public Collection<Session> getActiveSessions() {
        return super.getActiveSessions();
    }

}
