package me.javaworld.breaker;

import java.util.concurrent.Callable;

/**
 * <br>
 * <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 * 
 *
 * @author suqianwen 2020年10月8日
 */
public class DefaultCircuitBreakerContext<V> implements CircuitBreakerContext {

	private CircuitBreaker<V> circuitBreaker;

	private Callable<V> callable;

	/**
	 * 执行callable.call()的返回结果
	 */
	private V result;

	/**
	 * 执行callable.call()抛出的异常
	 */
	private Exception exception;

	/**
	 *
	 * @author suqianwen 2020年10月8日
	 */
	public DefaultCircuitBreakerContext() {

	}

	/**
	 *
	 * @param circuitBreaker
	 * @param callable
	 * @author suqianwen 2020年10月8日
	 */
	public DefaultCircuitBreakerContext(CircuitBreaker<V> circuitBreaker, Callable<V> callable) {
		this.circuitBreaker = circuitBreaker;
		this.callable = callable;
	}

	/**
	 *
	 * @param circuitBreaker
	 * @param callable
	 * @param result
	 * @param exception
	 * @author suqianwen 2020年10月8日
	 */
	public DefaultCircuitBreakerContext(CircuitBreaker<V> circuitBreaker, Callable<V> callable, V result,
			Exception exception) {
		this(circuitBreaker, callable);
		this.result = result;
		this.exception = exception;
	}

	public CircuitBreaker<V> getCircuitBreaker() {
		return circuitBreaker;
	}

	public void setCircuitBreaker(CircuitBreaker<V> circuitBreaker) {
		this.circuitBreaker = circuitBreaker;
	}

	public Callable<V> getCallable() {
		return callable;
	}

	public void setCallable(Callable<V> callable) {
		this.callable = callable;
	}

	public V getResult() {
		return result;
	}

	public void setResult(V result) {
		this.result = result;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
