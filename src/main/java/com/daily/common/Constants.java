package com.daily.common;

/**
 * 常量类
 *
 * @author johnz
 */
public class Constants {

    /**
     * redis 默认aop的key + 参数1
     */
    public static final String REDIS_AOP_KEY = "chuangdongfang:aop:cache:";

    public static final String TOKEN = "X-Token";

    public static final String APP_TOKEN = "appToken";

    public static final String REQUEST_STREM = "requestStream";

    public static final String REDIS_TOKEN_CACHE_NAME = "cvinfo_0";

    public static final String PREFIX_SHIRO_REDIS_SESSION = "shiro_redis_session:";
    public static final String PREFIX_SHIRO_REDIS_CACHE = "shiro_redis_cache:";

    public static final String SUPER_ADMIN = "管理员";
    public static final String SUPER_ROLE = "管理员";

    public static final String HAS_POWER = "1"; // 全权限在user表中标志

    /**
     * 基金类型
     */
    public static final String MSG_FUND_TYPE = "基金动态";
    /**
     * 项目类型
     */
    public static final String MSG_ITEM_TYPE = "项目动态";

    //FTP服务器IP
    public static final String IP = "192.168.15.147";
    //FTP服务器端口号
    public static final int PORT = 21;
    //FTP服务器用户名
    public static final String USERNAME = "renweijie";
    //FTP服务器密码
    public static final String PASSWORD = "ABC123456";
    //拟投资项目基础信息 导出模板路径
    public static final String item_base_info = "/templates/item_base_info.docx";
    //拟投资项目立项信息 导出模板路径
    public static final String item_approva_info = "/templates/item_approva_info.docx";
    /**
     * 默认分页条数
     */
    public static final int PAGE_SIZE = 100000;

    /**
     * 请求成功
     */
    public static final String ERR_CODE_0 = "0";
    /**
     * 认证：未登录或登录超时
     */
    public static final String ERR_CODE_100 = "100";
    /**
     * 认证：账号或密码错误
     */
    public static final String ERR_CODE_101 = "101";
    /**
     * 认证：账号或密码错误
     */
    public static final String ERROR_MESSAGE_101 = "用户名或密码错误";
    /**
     * 授权：访问未授权
     */
    public static final String ERR_CODE_103 = "103";
    /**
     * 输入参数错误
     */
    public static final String ERR_CODE_400 = "400";
    /**
     * 系统内部错误
     */
    public static final String ERR_CODE_500 = "500";
    /**
     * 未知错误
     */
    public static final String ERR_CODE_999 = "999";


    public static final String ERROR_MESSAGE_999 = "用户认证异常";


    public static final String ERR_CODE_998 = "998";
    public static final String ERR_CODE_996 = "996";//上传异常

    public static final String ERROR_MESSAGE_998 = "内部错误";
    public static final String ERR_CODE_8101 = "8101";
    public static final String ERROR_MESSAGE_8101 = "角色管理角色名已经存在";

    public static final String ERR_CODE_9999 = "9999";
    public static final String ERROR_MESSAGE_9999 = "没有首页访问权限";

    public static final String ERR_CODE_10086 = "10086";
    public static final String ERR_CODE_10087 = "10087";
    public static final String ERR_CODE_10088 = "10088";
    public static final String ERR_CODE_10089 = "10089";

    public static final String ERR_CODE_115512 = "115512";//不允许删除
    /**
     * 时间类型：年
     */
    public static final Integer DATE_TYPE_YEAR = 1;
    /**
     * 时间类型：月
     */
    public static final Integer DATE_TYPE_MONTH = 2;
    /**
     * 时间类型：日
     */
    public static final Integer DATE_TYPE_DAY = 3;

    /**
     * 删除状态：正常
     */
    public static final Integer DELETE_STATE_NORMAL = 1;
    /**
     * 删除状态：删除
     */
    public static final Integer DELETE_STATE_DELETE = 0;

    /**
     * 拟投资状态：股权
     */
    public static final Integer ITEM_TYPE_STOCK = 0;

    /**
     * 拟投资状态：债券
     */
    public static final Integer ITEM_TYPE_DEBT = 1;

    /**
     * 股权基金
     */
    public static final String EQUITY_FUND = "0";

    /**
     * 母基金
     */
    public static final String PARENT_FUND = "1";

    /**
     * 以投项目
     */
    public static final String TO_ITEM = "0";

    /**
     * 退出项目
     */
    public static final String EXIT_ITEM = "1";

    /**
     * 重大事项类型 -  基金
     */
    public static final Byte MAJOR_ISSUES_TYPE_FUND = 1;

    /**
     * 重大事项类型 -  客户
     */
    public static final Byte MAJOR_ISSUES_TYPE_GUEST = 2;

}
