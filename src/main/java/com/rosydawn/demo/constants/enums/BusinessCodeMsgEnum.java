package com.rosydawn.demo.constants.enums;

/**
 * 返回结果的代码和消息描述的最佳实践是根据根据模块进行编码，约定好业务前缀，做好业务的区分，尽量不要随意定义。
 * 这样根据 code 就知道是哪个模块的异常。
 *
 * 服务端的处理无论成功还是失败，建议响应报文都一律返回 200 状态码，而在响应报文中使用不同业务模块特有的 code 中表示不同的处理结果。
 *
 * 有三种常用的自定义编码规则：
 * 1. 完全照搬标准的 HTTP 状态码。这种方式省事且通用，但是无法划分不够细致，无法详细描述复杂场景
 * 2. 混用标准的 HTTP 状态码和自定义的编码。这种方式
 *
 */
public enum BusinessCodeMsgEnum {
    success(1L,"操作成功"),
    error(0L,"操作失败"),
    sysError(3L,"系统异常"),
    forceLoginOut(1000001L,"您的账号在其他设备登录"),
    hasUserOnline(1000002L,"当前已有用户在登录"),
    tokenInvalid(1000003L,"登录已经过期，请重新登录"),
    tokenIllegal(1000004L,"无效令牌"),
    methodNotSupport(1000005L,"请求的方法不支持"),
    principalIncorrect(1000006L,"用户名或者密码错误"),
    accessDenied(1000007L,"没有操作该功能的权限"),
    paramError(1000009L,"请求参数有误"),
    lack_params(1000000L, "缺少请求参数")
    ;

    private Long code;
    private String msg;

    BusinessCodeMsgEnum(Long code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public BusinessCodeMsgEnum of(Long code){
        for(BusinessCodeMsgEnum em : BusinessCodeMsgEnum.values()){
            if(em.getCode().longValue() == code){
                return em;
            }
        }
        return null;
    }
}
