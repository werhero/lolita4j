package org.lolita4j.framework.helper;

import org.lolita4j.framework.ConfigConstant;
import org.lolita4j.framework.util.PropsUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 * @author werhero
 * @since 1.0.09
 */
public final class ConfigHelper {

    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取应用基础包名
     */
    public static String getAppBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取应用JSP路径
     */
    public static String getAppJspPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH);
    }

    /**
     * 获取应用静态资源路径
     */
    public static String getAppAssetPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH);
    }
}
