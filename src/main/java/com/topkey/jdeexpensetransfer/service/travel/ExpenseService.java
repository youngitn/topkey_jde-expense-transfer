package com.topkey.jdeexpensetransfer.service.travel;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.topkey.jdeexpensetransfer.dto.StandardResponse;
import com.topkey.jdeexpensetransfer.entity.travel.expense.Expense;
import com.topkey.jdeexpensetransfer.repo.travel.ExpenseRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RabbitListener(queues = "travel-expense-queue" )
public class ExpenseService {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	@Autowired
    private ExpenseRepository expenseRepository;

    @Value("${jde-id}")
    private String jdeId;
	
	@RabbitListener(queues = "travel-expense-queue" , containerFactory = "rabbitListenerContainerFactory")
	@SendTo("callbackRoutingKey")//這個que和回傳生產者無關,有需要的話可以監聽這個que做其他處理
	public StandardResponse handleMessage(ArrayList<Expense> message,Channel channel,Message msg) throws IOException {
		
		
		
		StandardResponse res = new StandardResponse();
		Expense al =null;
		try {
			//先取得傳票日期,做行號查詢
			Expense expense = message.get(0);
			String dbt = expense.getVnedbt();
			//JDE查詢時要先補足空白否則查不到符合條件
			dbt = String.format("%-15s", dbt);
			int newLineNum=expenseRepository.findMaxVnedlnByVnedbt(dbt).orElse(0)+1000;
			log.info("新行號Vnedl=>newLineNum------------------>"+newLineNum);

			expense.setVnedln(newLineNum);
			//暫先用SIMON帳號
			expense.setVnedus(this.jdeId);
			expense.setVnuser(this.jdeId);
			//expense.setVnedtc("A");
			
			expense.setVnexa("旅費對接批號_"+dbt);
			//進行儲存
			al = expenseRepository.save(expense);
//			log.info("ConsumerService>>>>>>>>>Received message from topic queue: {}", message);

			//jdbcTemplate用法
//			List<Map<String, Object>> list = jdbcTemplate
//					.queryForList("SELECT HXLITM FROM proddta.F554106H WHERE HXEDBT = 'SPCT2326'");

//			log.info("ConsumerService>>>>>>>>>Received message from topic queue: {}", list.size());
			res.setCode("OK");
			res.setMessage("save sucess");
			res.setData(al);
			
		} catch (DataIntegrityViolationException e) {
			// 处理失败
			res.setCode("ERROR");
			res.setMessage(e.getMessage());
			channel.basicReject(msg.getMessageProperties().getDeliveryTag(),false);
			log.error(e.getMessage());
		}catch (ListenerExecutionFailedException e) {
			res.setCode("ListenerExecutionFailedException");
			res.setMessage(e.getMessage());
			channel.basicReject(msg.getMessageProperties().getDeliveryTag(),false);
			log.error(e.getMessage());
		}catch (Exception e) {
			res.setCode("Exception");
			res.setMessage(e.getMessage());
			channel.basicReject(msg.getMessageProperties().getDeliveryTag(),false);
			log.error(e.getMessage());
		}
		
		// 直接返回结果
		return res;

	}

	@RabbitListener(queues = "direct-queue")
	public void handleDirectMessage(String message) {
		log.info("ConsumerService>>>>>>>>>Received message from direct queue: {}", message);
	}
	


	


}
