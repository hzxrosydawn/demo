package com.rosydawn.demo.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * 用于JSON响应报文的通用DTO。之所以使用HashMap而不是POJO是为了便于添加其他字段。
 *
 * {@code @Data} 注解包含了 @Getter、@Setter、@ToString、@EqualsAndHashCode 和 @RequiredArgsConstructor 的功能。
 *
 * {@code @NoArgsConstructor} 注解生成一个无参构造器。当类中有未初始化的final字段时，编译器会报错，此时可用 @NoArgsConstructor(force=true)，
 * 然后就会为没有初始化的 final 字段设置默认值 0/false/null。而对于具有约束的字段（例如 @NonNull 字段），在正确初始化这些字段之前不会进行
 * 对应的约束检查。该注解在与 @Data 或其他构造器生成注解一起使用时很有用，因为有些框架要求必须要有一个无参构造器才能应用 Java 反射机制。
 *
 * {@code @RequiredArgsConstructor}注解为生成一个以所有需要特殊处理的非静态字段为参数的构造器。这个构造器中的参数只能是以final修饰的未经
 * 初始化的字段，或者是以@NonNull注解修饰的在声明时未经初始化的字段。对于使用了@NonNull注解修饰的字段会进行显式的非空检查，如果任意一个
 * 使用了@NonNull注解修饰的字段被set为null，则会抛出NullPointerException。构造器中参数的顺序即为对应需要特殊处理的字段的声明顺序。
 * “@RequiredArgsConstructor(staticName = "of")”会生成一个of()的静态方法，并把构造方法设置为私有的。
 *
 * {@code @AllArgsConstructor} 注解生成一个以所有非静态字段为参数的构造器。使用了@NonNull注解修饰的字段会进行显式的非空检查。
 *
 * 这些生成构造器的注解都允许另一种形式：生成的构造器是私有的，并生成一个包含该私有构造器的静态工厂方法。通过这些注解的staticName属性来
 * 来指定对应静态工厂方法名的同时激活该功能。比如：@RequiredArgsConstructor(staticName="of")。
 *
 * {@code @ApiModel} 注解负责描述封装响应数据的对象信息。
 * 属性名称	        备注
 * value	        为返回的模型对象指定一个名称。默认为一个类名
 * description	    为返回的模型对象提供一段详细描述
 * parent           为返回的模型对象指定一个父类，用于描述继承信息
 * discriminator    用作鉴别器的字段名称，支持继承和泛型。根据该字段决定选用哪个子类
 * subTypes         指定一个从该模型对象继承的子类列表
 * reference        为对应的类型定义指定一个引用，会覆盖其他任何元数据所制定的类型
 *
 * {@code @ApiModelProperty} 注解负责描述对象中属性的相关内容。
 * 属性名称	        备注
 * value	        字段的简要描述
 * name	            覆盖字段名称
 * allowableValues	限制该参数的接受值，有三种方式：
 *  * 					- 逗号分隔的值列表
 *  * 					- 一对方括号和圆括号表示的范围，方括号表示包含对应的最大值或最小值，圆括号表示不包含对应的最大值或最小值。
 *  * 					  如[1, 5]表示大于等于1小于等于5，[1, 5)表示大于等于1小于5，(1, 5)表示大于1小于5
 *  * 					- 设置一个最大值或最小值，另一个值使用“infinity”或“-infinity”。如[1, infinity]表示最小值为1
 * access			允许从 API 文档中过滤参数。参考 io.swagger.core.filter.SwaggerSpecFilter
 * notes	        当前未使用
 * dataType			参数的数据类型。只作为标志说明，并没有实际验证。可以为一个类名或基本类型
 * required	        是否为必传参数
 * position	        指定字段显示的顺序位置
 * hidden	        是否在文档中隐藏
 * example	        举例
 * accessMode	    指定访问模式 AccessMode.READ_ONLY，READ_WRITE
 * reference	    为对应的类型定义指定一个引用，会覆盖其他任何元数据所制定的类型
 * allowEmptyValue  是否允许空值
 * extensions       可选的扩展数组
 *
 * @auther: Vincent Huang
 * Date: 2019/7/1
 * Time: 16:20
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
@ApiModel(description = "响应对象")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @NonNull
    @ApiModelProperty(value = "响应码", name = "code", required = true, example = "200")
    private long code;

    @NonNull
    @ApiModelProperty(value = "响应消息", name = "msg", required = true, example = "登录成功")
    private String msg;

    /**
     * 可以分页数据或其他数据
     */
    @ApiModelProperty(value = "响应数据", name = "data")
    private T data;

    /**
     * 成功的返回
     */
    public static Result ok() {
        return new Result(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    /**
     * 成功的返回
     */
    public static Result ok(String msg) {
        return new Result(SUCCESS_CODE, msg);
    }

    /**
     * 服务器失败的返回
     */
    public static Result serverError(String msg) {
        return new Result(ERROR_CODE, ERROR_MESSAGE);
    }
}
