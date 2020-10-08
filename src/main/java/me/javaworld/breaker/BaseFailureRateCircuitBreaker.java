package me.javaworld.breaker;

/**
 * <br>
 * <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 * 
 *
 * @author suqianwen 2020年10月8日
 */
public class BaseFailureRateCircuitBreaker<V> implements CircuitBreaker<V> {

	/**
	 * 断路器闭合后的执行总次数
	 */
	private long totalCount;

	/**
	 * 断路器闭合后的执行失败的次数
	 */
	private long failureCount;

	/**
	 * 断路器打开多久后，断路器自动进入闭合状态。以毫秒为单位。
	 */
	private long openTimeout;

	/**
	 *
	 * @author suqianwen 2020年10月8日
	 */
	public BaseFailureRateCircuitBreaker() {

	}

	/**
	 *
	 * @param totalCount
	 * @param failureCount
	 * @param openTimeout
	 * @author suqianwen 2020年10月8日
	 */
	public BaseFailureRateCircuitBreaker(long totalCount, long failureCount, long openTimeout) {
		this.totalCount = totalCount;
		this.failureCount = failureCount;
		this.openTimeout = openTimeout;
	}

	@Override
	public boolean entry(CircuitBreakerContext context) {

		return false;
	}

	@Override
	public boolean exit(CircuitBreakerContext context) {

		return false;
	}

	@Override
	public V fallback(CircuitBreakerContext context) {

		return null;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(long failureCount) {
		this.failureCount = failureCount;
	}

	public long getOpenTimeout() {
		return openTimeout;
	}

	public void setOpenTimeout(long openTimeout) {
		this.openTimeout = openTimeout;
	}

}
