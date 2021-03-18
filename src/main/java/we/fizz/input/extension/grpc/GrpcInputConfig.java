/*
 *  Copyright (C) 2021 the original author or authors.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package we.fizz.input.extension.grpc;

import we.fizz.exception.FizzRuntimeException;
import we.fizz.input.InputConfig;

import java.util.Map;

import org.springframework.util.StringUtils;

/**
 *
 * @author linwaiwai
 * @author Francis Dong
 *
 */
public class GrpcInputConfig extends InputConfig {

	private int timeout;
	private String serviceName;
	private String method;

	public GrpcInputConfig(Map configMap) {
		super(configMap);
	}

	public void parse() {
		String serviceName = (String) configMap.get("serviceName");
		if (StringUtils.isEmpty(serviceName)) {
			throw new FizzRuntimeException("service name can not be blank");
		}
		setServiceName(serviceName);

		String method = (String) configMap.get("method");
		if (StringUtils.isEmpty(method)) {
			throw new FizzRuntimeException("method can not be blank");
		}
		setMethod(method);

		if (configMap.get("timeout") != null) {
			setTimeout(Integer.valueOf(configMap.get("timeout").toString()));
		}
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
