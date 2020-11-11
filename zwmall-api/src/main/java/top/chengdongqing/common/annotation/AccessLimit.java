package top.chengdongqing.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接口请求限制注解
 * 
 * @author Luyao
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {

	// 访问限制的过期时间
	int expireTime() default 5;

	// 允许访问的次数
	int times() default 1;

	// 作为限制访问的键
	String limitKey() default "";

	// 返回的错误信息
	String msg() default "频率过高，请稍后再试";
}
