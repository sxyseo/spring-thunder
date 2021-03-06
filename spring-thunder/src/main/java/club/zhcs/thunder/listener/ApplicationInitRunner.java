package club.zhcs.thunder.listener;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Kerbores(kerbores@gmail.com)
 * @project spring-thunder
 * @file Setup.java
 * @description 系统初始化
 * @time 2016年9月8日 下午12:31:36
 */
public class ApplicationInitRunner implements ApplicationListener<ContextRefreshedEvent> {

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.context.ApplicationListener#onApplicationEvent(org.
     * springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        if (context.getParent() == null) {//保险一点儿
            Dao dao = context.getBean(Dao.class);
            Daos.createTablesInPackage(dao, "zlub.zhcs", false);// 初始化一下
            //TODO 这里可以处理一些初始化的事情
        }
    }

}
