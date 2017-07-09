package org.jasig.cas.authentication;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsernamePasswordCaptchaCredential extends
		UsernamePasswordCredential {

	private static final long serialVersionUID = -864745145551932618L;

	/**
	 * 验证码
	 */
	@NotNull
	@Size(min=1,message = "required.captcha")
	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	
}
