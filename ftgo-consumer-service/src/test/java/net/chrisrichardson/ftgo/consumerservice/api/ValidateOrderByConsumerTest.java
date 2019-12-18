package net.chrisrichardson.ftgo.consumerservice.api;

import net.chrisrichardson.ftgo.common.CommonJsonMapperInitializer;
import net.chrisrichardson.ftgo.common.Money;
import org.junit.Test;

import org.json.JSONObject;

import static org.junit.Assert.*;

public class ValidateOrderByConsumerTest {

  static {
    CommonJsonMapperInitializer.registerMoneyModule();
  }

  @Test
  public void shouldDeserialize() {

    ValidatingJSONMapper mapper = ValidatingJSONMapper.forSchema("/ValidateOrderByConsumer.json");

    JSONObject jsonObject = new JSONObject().put("consumerId", 1).put("orderId", 2).put("orderTotal", "12.34");

    ValidateOrderByConsumer cmd = mapper.fromJSON(jsonObject, ValidateOrderByConsumer.class);

    assertEquals(1, cmd.getConsumerId());
    assertEquals(2, cmd.getOrderId());
    assertEquals(new Money("12.34"), cmd.getOrderTotal());
  }


}