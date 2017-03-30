package org.lolita4j.framework.util;

import java.util.Map;

/**
 * 依赖注入类
 * @author werhero
 */
public final class IocHelper {
    static {
        // 获取所有的Bean类与Bean实例之间的映射关系(简称BeanMap)
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
//        if (Col)
    }
}
