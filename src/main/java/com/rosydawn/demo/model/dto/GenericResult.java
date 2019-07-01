package com.rosydawn.demo.model.dto;

import lombok.*;

import java.io.Serializable;

/**
 * 用于JSON响应报文的通用DTO。之所以使用HashMap而不是POJO是为了便于添加其他字段。
 *
 * @auther: Vincent Huang
 * Date: 2019/7/1
 * Time: 16:20
 */
// @Data注解包含了@Getter、@Setter、@ToString、@EqualsAndHashCode和@RequiredArgsConstructor的功能。
@Data
// @NoArgsConstructor注解生成一个无参构造器。当类中有未初始化的final字段时，编译器会报错，此时可用@NoArgsConstructor(force=true)，
// 然后就会为没有初始化的final字段设置默认值0/false/null。而对于具有约束的字段（例如@NonNull字段），在正确初始化这些字段之前不会进行
// 对应的约束检查。该注解在与@Data或其他构造器生成注解一起使用时很有用，因为有些框架要求必须要有一个无参构造器才能应用Java反射机制。
@NoArgsConstructor
// @RequiredArgsConstructor注解为生成一个以所有需要特殊处理的非静态字段为参数的构造器。这个构造器中的参数只能是以final修饰的未经
// 初始化的字段，或者是以@NonNull注解修饰的在声明时未经初始化的字段。对于使用了@NonNull注解修饰的字段会进行显式的非空检查，如果任意一个
// 使用了@NonNull注解修饰的字段被set为null，则会抛出NullPointerException。构造器中参数的顺序即为对应需要特殊处理的字段的声明顺序。
// @RequiredArgsConstructor(staticName = "of")会生成一个of()的静态方法，并把构造方法设置为私有的。
@RequiredArgsConstructor(staticName = "of")
// @AllArgsConstructor注解生成一个以所有非静态字段为参数的构造器。使用了@NonNull注解修饰的字段会进行显式的非空检查。
@AllArgsConstructor
// 这些生成构造器的注解都允许另一种形式：生成的构造器是私有的，并生成一个包含该私有构造器的静态工厂方法。通过这些注解的staticName属性来
// 来指定对应静态工厂方法名的同时激活该功能。比如：@RequiredArgsConstructor(staticName="of")。
public class GenericResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int SUCCESS_CODE = 200;
    private static final int SERVER_ERROR_CODE = 500;

    @NonNull
    private int code;
    @NonNull
    private String msg;
    private T data;

    /**
     * 成功的返回
     */
    public static GenericResult ok() {
        return new GenericResult(SUCCESS_CODE, "操作成功");
    }

    /**
     * 成功的返回
     */
    public static GenericResult ok(String msg) {
        return new GenericResult(SUCCESS_CODE, msg);
    }

    /**
     * 服务器失败的返回
     */
    public static GenericResult serverError(String msg) {
        return new GenericResult(SERVER_ERROR_CODE, "操作失败");
    }
}
