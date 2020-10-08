package me.javaworld.breaker;

/**
 * <br>
 * <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: <br>
 * 
 *
 * @author suqianwen 2020年10月8日
 */
public interface CircuitBreaker<V> {

	/**
	 * 
	 *
	 * @param context
	 * @return
	 * @author suqianwen 2020年10月8日
	 */
	boolean entry(CircuitBreakerContext context);

	/**
	 * 
	 *
	 * @param context
	 * @return
	 * @author suqianwen 2020年10月8日
	 */
	boolean exit(CircuitBreakerContext context);

	/**
	 * 
	 *
	 * @param context
	 * @return
	 * @author suqianwen 2020年10月8日
	 */
	V fallback(CircuitBreakerContext context);

}
