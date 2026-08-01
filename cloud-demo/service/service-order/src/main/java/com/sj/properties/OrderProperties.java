package com.sj.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: Orderproerties
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/26 11:09
 * @Version 1.0
 */

@Data
@Component
@ConfigurationProperties(prefix = "order") // 配置绑定，在nacos环境下，无需 @RefreshScope，就能自动刷新
public class OrderProperties {
	
	
	String timeout;
	
	String autoConfirm;
}
