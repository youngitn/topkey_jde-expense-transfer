package com.topkey.jdeexpensetransfer.converter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.topkey.jdeexpensetransfer.entity.travel.expense.Expense;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GsonExpenseListMessageConverter implements MessageConverter {

	private final Gson gson = new Gson();

	@Override
	public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
		log.info("object--------------------->" + object.toString());

		return new Message(gson.toJson(object).getBytes(StandardCharsets.UTF_8));
	}

	@Override
	public ArrayList<Expense> fromMessage(Message message) throws MessageConversionException {
		
		String json = new String(message.getBody()); 
		log.info("Converter fromMessage -------->"+json);
		ArrayList<Expense> list = gson.fromJson(json, new TypeToken<ArrayList<Expense>>(){}.getType());
//		// 根据消息类型进行反序列化
//		return list; // 这里可以根据需要指定具体的类型
		return list;
	}
}
