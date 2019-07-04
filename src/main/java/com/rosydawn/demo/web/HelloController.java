package com.rosydawn.demo.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code @RestController} 相当于SpringMVC中的 @Controller + @ResponseBody。
 *
 * {@code io.swagger.annotations.@Api} 注解将一个 Controller（Class）标注为一个 Swagger “资源”（API），Controller 中的控制器
 * 方法称为“操作”。在默认情况下，Swagger-Core 只会扫描解析具有 @Api 注解的类，而会自动忽略其他类别资源的注解。
 *	属性名称			备注
 * 	value			如果未使用tags属性，则该属性值将被当成是该资源下操作的标签。如果使用了tags属性，则该属性值会被忽略
 * 	tags			可用于对操作进行分组。如果设置这个值，value属性的值会被覆盖
 * 	description		对 API 资源的描述
 * 	produces		对应于资源下操作的produces，多个类型则使用英文逗号分隔。例如："application/json, application/xml"
 * 	consumes		对应于资源下操作的consumes，多个类型则使用英文逗号分隔。例如："application/json, application/xml"
 * 	protocols		指定资源下操作所使用的访问协议：http, https, ws, wss
 * 	authorizations	高级特性认证时配置
 * 	hidden			配置为 true 则将资源在文档中隐藏
 *
 * {@code io.swagger.annotations.@ApiOperation} 定义在方法上，描述方法名、方法解释、返回信息、标记等信息。具有相同路径的操作分到一组
 * 属性名称				备注
 * value				对应于该操作的summary，为操作提供简要的描述。为了恰当地显式在 API 文档中，该属性值不应该多于120个字符
 * notes				对应于该操作的notes，	为操作提供详细的描述
 * tags					非空值会覆盖来自@Api注解的tags或value属性的值
 * response				操作的返回类型。在 JAX-RS 应用中，如果方法的返回类型为 {@code javax.ws.rs.core.Response}，这种情况下无法
 * 						得知返回类型，所以操作的返回类型为“void”，否则会自动使用方法的返回类型。显式指定该属性值会覆盖自动获取的数据
 * 						类型。如果该属性值是代表基本类型（Integer、Long等）的类，则会使用对应的基本类型（JSON无基本类型包装类的概念）
 * responseContainer	声明一个包含返回的容器。只能是“List”、“Set”或“Map”之一，其他值会被忽略
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
 */
@Api
@RestController
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	/**
	 * 映射""请求
	 */
	@ApiOperation(value = "欢迎")
	@RequestMapping("/hello")
	public String hello(){
		logger.error("ERROR日志");
		logger.warn("WARN日志");
		logger.info("INFO日志");
		logger.debug("DEBUG日志");
		return "Hello Spring Boot Application!";
	}
}
