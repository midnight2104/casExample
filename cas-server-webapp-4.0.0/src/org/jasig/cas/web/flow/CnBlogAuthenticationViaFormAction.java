package org.jasig.cas.web.flow;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.UsernamePasswordCaptchaCredential;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.util.StringUtils;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

/**
 * cas 对表单进行校验的类
 * @author midnight
 *
 */
public class CnBlogAuthenticationViaFormAction extends AuthenticationViaFormAction{

	/**
	 * 校验验证码
	 * @param context
	 * @param credential 用户登录时的凭证
	 * @param messageContext
	 * @return
	 */
    public final Event validatorCaptcha(final RequestContext context, final Credential credential,
            final MessageContext messageContext){
    	
    		final HttpServletRequest request = WebUtils.getHttpServletRequest(context);  
    		HttpSession session = request.getSession();  
    		String captcha = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
    		session.removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
    	
    		UsernamePasswordCaptchaCredential upc = (UsernamePasswordCaptchaCredential)credential;  
    		String submitAuthcodeCaptcha =upc.getCaptcha(); 
    		
    		
    		if(!StringUtils.hasText(submitAuthcodeCaptcha) ){
    			messageContext.addMessage(new MessageBuilder().error().code("required.captcha").build()); 
    			return new Event(this,ERROR);
    		}  
    		if(submitAuthcodeCaptcha.equals(captcha)){    
    			return new Event(this,SUCCESS);
    		}  
    		/*messageContext.addMessage(new MessageBuilder().code("error.authentication.captcha.bad").build());
    		return "error"; */
    		messageContext.addMessage(new MessageBuilder().error().code("error.authentication.captcha.bad").build());
    		return new Event(this,ERROR);
    }
}
