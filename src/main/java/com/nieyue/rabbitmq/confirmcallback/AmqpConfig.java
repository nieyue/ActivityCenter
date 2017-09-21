package com.nieyue.rabbitmq.confirmcallback;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
/**
 * 配置
 * @author 聂跃
 * @date 2017年5月31日
 */
@Configuration  
public class AmqpConfig {
	/**
	 * web活动阅读
	 */
	@Value("${myPugin.rabbitmq.ACTIVITYWEBREAD_DIRECT_EXCHANGE}")
	public  String ACTIVITYWEBREAD_DIRECT_EXCHANGE ;  
	@Value("${myPugin.rabbitmq.ACTIVITYWEBREAD_DIRECT_ROUTINGKEY}")
	public String ACTIVITYWEBREAD_DIRECT_ROUTINGKEY; 
	@Value("${myPugin.rabbitmq.ACTIVITYWEBREAD_DIRECT_QUEUE}")
	public  String ACTIVITYWEBREAD_DIRECT_QUEUE; 
	
	
    @Autowired
    ConnectionFactory  connectionFactory ;
    /** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */  
    @Bean  
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  
    public RabbitTemplate rabbitTemplate() {  
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);  
        return rabbitTemplate;  
    } 
    
    /** 
     *活动web阅读
     */  
    /*
     * 设置交换机类型
     */   
    @Bean  
    public DirectExchange activityWebReadDirectExchange() {  
    	DirectExchange de = new DirectExchange(ACTIVITYWEBREAD_DIRECT_EXCHANGE);
    	return de;
    }
    
    // 设置队列
    @Bean  
    public Queue activityWebReadDirectQueue() {  
    	return new Queue(ACTIVITYWEBREAD_DIRECT_QUEUE);  
    }
    
    // 设置绑定
    @Bean  
    public Binding activityWebReadDirectBinding() {  
    	/** 将队列绑定到交换机 */  
    	return BindingBuilder.bind(activityWebReadDirectQueue()).to(activityWebReadDirectExchange()).with(ACTIVITYWEBREAD_DIRECT_ROUTINGKEY);  
    } 

}
