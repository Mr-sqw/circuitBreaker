package me.javaworld.breaker;

import java.util.concurrent.Callable;

/**
 * <br>
 * <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: <br>
 * 
 *
 * @author suqianwen 2020年10月8日
 */
public class CircuitBreakerRunner<V> {

	public V run(CircuitBreaker<V> circuitBreaker, Callable<V> callable) {

		CircuitBreakerContext entryContext = build(circuitBreaker, callable);
		if (circuitBreaker.entry(entryContext)) {
			return circuitBreaker.fallback(entryContext);
		}

		V result = null;
		Exception exception = null;
		try {
			result = callable.call();
		} catch (Exception e) {
			exception = e;
		}

		CircuitBreakerContext exitContext = build(circuitBreaker, callable, result, exception);
		circuitBreaker.exit(exitContext);

		return result;
	}

	protected CircuitBreakerContext build(CircuitBreaker<V> circuitBreaker, Callable<V> callable) {
		return new DefaultCircuitBreakerContext<V>(circuitBreaker, callable);
	}

	protected CircuitBreakerContext build(CircuitBreaker<V> circuitBreaker, Callable<V> callable, V result,
			Exception exception) {
		return new DefaultCircuitBreakerContext<V>(circuitBreaker, callable, result, exception);
	}

}
