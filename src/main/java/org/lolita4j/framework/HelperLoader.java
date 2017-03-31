package org.lolita4j.framework;

import org.lolita4j.framework.helper.BeanHelper;
import org.lolita4j.framework.helper.ClassHelper;
import org.lolita4j.framework.helper.ControllerHelper;
import org.lolita4j.framework.helper.IocHelper;
import org.lolita4j.framework.util.ClassUtil;

/**
 * 加载相应的Helper类
 *
 * @author werhero
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
