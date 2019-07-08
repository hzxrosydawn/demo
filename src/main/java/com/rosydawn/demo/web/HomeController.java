package com.rosydawn.demo.web;

import com.google.code.kaptcha.Producer;
import com.rosydawn.demo.model.User;
import com.rosydawn.demo.model.dto.GenericResult;
import com.rosydawn.demo.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * {@code @RestController} 相当于SpringMVC中的 @Controller + @ResponseBody。
 *
 * {@code io.swagger.annotations.@Api} 注解将一个 Controller（Class）标注为一个 Swagger “资源”（API），Controller 中的控制器
 * 方法称为“操作”。在默认情况下，Swagger-Core 只会扫描解析具有 @Api 注解的类，而会自动忽略其他类别资源的注解。
 *	属性名称				备注
 * 	value				如果未使用tags属性，则该属性值将被当成是该资源下操作的标签。如果使用了tags属性，则该属性值会被忽略
 * 	tags				可用于对操作进行分组。如果设置这个值，value属性的值会被覆盖
 * 	description			对 API 资源的描述
 * 	produces			对应于资源下操作的produces，多个类型则使用英文逗号分隔。例如："application/json, application/xml"
 * 	consumes			对应于资源下操作的consumes，多个类型则使用英文逗号分隔。例如："application/json, application/xml"
 * 	protocols			指定资源下操作所使用的访问协议：http, https, ws, wss
 * 	authorizations		高级特性认证时配置
 * 	hidden				配置为 true 则将资源在文档中隐藏
 *
 * {@code io.swagger.annotations.@ApiOperation} 定义在方法上，描述方法名、方法解释、返回信息、标记等信息。具有相同路径的操作分到一组
 * 属性名称				备注
 * value				对应于该操作的summary，为操作提供简要的描述。为了恰当地显式在 API 文档中，该属性值不应该多于120个字符
 * notes				对应于该操作的notes，	为操作提供详细的描述
 * tags					非空值会覆盖来自@Api注解的tags或value属性的值
 * response				操作的返回类型。在 JAX-RS 应用中，如果方法的返回类型为 {@code javax.ws.rs.core.Response}，这种情况下无法
 * 						得知返回类型，所以操作的返回类型为“void”，否则会自动使用方法的返回类型。显式指定该属性值会覆盖自动获取的数据
 * 						类型。如果该属性值是代表基本类型（Integer、Long等）的类，则会使用对应的基本类型（JSON无基本类型包装类的概念）
 * responseContainer	声明一个包含响应的容器。只能是“List”、“Set”或“Map”之一，其他值会被忽略
 * responseReference	为返回类型指定一个引用。指定的引用可是本地或远程的，会按原样使用，并会覆盖任何response的返回类型
 * httpMethod			为操作指定 HTTP 访问方式。如果未指定，在 JAX-RS 应用中，则会自动根据{@code @GET}, {@code @POST},
 * 						{@code @PUT}, {@code @DELETE} 等 JAX-RS 注解配置。显式指定该属性值会覆盖从 JAX-RS 注解解析的值。
 * produces				For example, "application/json, application/xml"
 * consumes				For example, "application/json, application/xml"
 * protocols			Possible values: http, https, ws, wss
 * authorizations		高级特性认证时配置
 * hidden				配置为 true 将该操作在文档中隐藏
 * responseHeaders		指定一个响应的header列表
 * code					http 的状态码，默认 200
 * extensions			一个可选扩展属性数组
 * ignoreJsonView		解析操作和类型时是否忽略 JsonView 注解。为了向后兼容而存在
 *
 * {@code io.swagger.annotations.@ApiImplicitParams} 用于描述方法的返回信息，其唯一属性 value 即是一个 @ApiImplicitParam 数组。
 * {@code io.swagger.annotations.@ApiImplicitParam} 用来描述该操作的某一个参数的具体信息，包括参数的名称、类型、限制等信息。
 * 当 {@link ApiParam} 绑定到一个 JAX-RS 参数、方法或字段时，该注解可以允许你以一种微调的方式手动定义一个参数。这是在 Servlets 或其他
 * 非 JAX-RS 环境下唯一定义参数的方式。该注解必须用在 @ApiImplicitParams 中。
 * 属性名称				备注
 * name					接收参数名。当基于 paramType 属性命名参数时应遵循以下规则：如果 paramType 是 path，该属性值应该为路径中对应的部分；
 * 						其他情况下，该属性值应该是应用期望收到的参数名
 * value				接收参数的简要描述
 * defaultValue			描述接收参数的默认值
 * allowableValues		限制该参数的接受值，有三种方式：
 * 						- 逗号分隔的值列表
 * 						- 一对方括号和圆括号表示的范围，方括号表示包含对应的最大值或最小值，圆括号表示不包含对应的最大值或最小值。
 * 						  如[1, 5]表示大于等于1小于等于5，[1, 5)表示大于等于1小于5，(1, 5)表示大于1小于5
 * 						- 设置一个最大值或最小值，另一个值使用“infinity”或“-infinity”。如[1, infinity]表示最小值为1
 * required				参数是否必填，值为 true 或者 false。路径参数应该总是设置为 true
 * access				允许从 API 文档中过滤参数。参考 io.swagger.core.filter.SwaggerSpecFilter
 * allowMultiple		设置参数是否支持接受multiple value，值为 true 或者 false
 * dataType				参数的数据类型。只作为标志说明，并没有实际验证。可以为一个类名或基本类型
 * dataTypeClass		参数的类对象。默认为 Void.class。如果设置了该属性值则会覆盖dataType属性值
 * paramType			参数的参数类型，其值：
 * 						- path：以地址的形式提交数据
 * 						- query： 直接跟参数完成自动映射赋
 * 						- body：以流的形式提交，仅支持 POST
 * 						- header：参数在 request headers 里边提交
 * 						- form：以 form 表单的形式提交 仅支持 POST
 * example				non-body 的类型参数的一个例子
 * examples				参数的例子，仅用于 BodyParameters
 * type					覆盖已检测到的类型
 * format				添加自定义格式
 * allowEmptyValue		是否允许将格式设置为空
 * readOnly				是否指定为只读
 * collectionFormat		使用 array 类型覆盖 collectionFormat
 *
 * {@code io.swagger.annotations.@ApiResponses} 注解主要封装方法的返回信息，用于组合多个 @ApiResponse 注解。
 * {@code io.swagger.annotations.@ApiResponse} 注解定义返回的具体信息包括返回码、返回信息等。该注解必须用在 @ApiResponses 注解
 * 中，即使仅用到一个该注解也必须放在 @ApiResponses 注解中。
 * 属性名称				备注
 * code					标准的 http 的状态码。Restful 接口规范要求响应的code必须为标准的 http 的状态码
 * message				可读性良好的响应描述
 * response				描述有效负载的 Class 对象，默认为 Void.class。对应响应消息对象的 schema 字段
 * reference			指定响应类型的引用，指定的引用可是本地或远程的，会按原样使用，并会覆盖任何response的返回类型
 * responseHeaders		响应的 Header 列表
 * responseContainer	声明一个包含返回的容器。只能是“List”、“Set”或“Map”之一，其他值会被忽略
 *
 */
@Api
@RestController
@RequestMapping("/user")
@Slf4j
public class HomeController {
	@Resource
	private UserService userService;

	@Resource
    private Producer producer;

	@GetMapping("captcha.jpg")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setHeader("Cache-Control", "no-store, no-cache");
	    response.setContentType("image/jpeg");
	    // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存验证码到Session
        request.getSession().setAttribute(Con);
    }

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/register")
	public String register(){
		return "register";
	}

	@PostMapping("/register")
	public String doRegister(User user){
		// 此处省略校验逻辑
		userService.addUser(user);
		return "redirect:register?success";
	}

	@GetMapping({"/", "/index", "/home"})
	public String home(){
		return "index";
	}

	@ApiOperation(value = "添加消息", notes = "进入欢迎页面")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "消息 ID", required = true, dataType = "Long", paramType = "query"),
			@ApiImplicitParam(name = "text", value = "正文", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "summary", value = "摘要", required = false, dataType = "String", paramType = "query"),
	})
	@ApiResponses({
			@ApiResponse(code = 100, message = "请求参数有误"),
			@ApiResponse(code = 101, message = "未授权"),
			@ApiResponse(code = 103, message = "禁止访问"),
			@ApiResponse(code = 104, message = "请求路径不存在"),
			@ApiResponse(code = 200, message = "服务器内部错误")
	})

	@GetMapping("/{userId}")
	public GenericResult<User> getUser(@PathVariable Long userId){
		log.info("getUser method parameter userId:", userId);
		User user = new User();
		user.setLogicId(userId);
		user.setName("张飞");
		user.setDeptId(1L);
		user.setEmail("shuhan.zhanfei@sanguo.com");

		GenericResult<User> getUserResult = new GenericResult<>();
		getUserResult.setCode(0);
		getUserResult.setMsg("操作成功");
		getUserResult.setData(user);
		return getUserResult;
	}





}
