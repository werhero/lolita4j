package org.lolita4j.framework.util;

import org.lolita4j.framework.anno.Inject;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入类
 *
 * @author werhero
 */
public final class IocHelper {
    static {
        // 获取所有的Bean类与Bean实例之间的映射关系(简称BeanMap)
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            // 遍历BeanMap
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                // 从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                // 获取Bean类定义的所有成员变量(属性)
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {
                        // 判断当前BeanField是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            // 在BeanMap中获取BeanField对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                // 通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
