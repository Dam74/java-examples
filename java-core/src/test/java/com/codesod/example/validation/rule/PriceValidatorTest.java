/*
 * Copyright 2017 MD Sayem Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codesod.example.validation.rule;

import com.codesod.example.validation.OrderDTO.OrderItem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PriceValidatorTest {

  @Test
  public void validate_priceNull_invalid() {
    PriceValidator validator = new PriceValidator();

    ErrorNotification errorNotification = validator.validate(new OrderItem());

    assertThat(errorNotification.getAllErrors()).isEqualTo(PriceValidator.PRICE_EMPTY_ERROR);
  }

  @Test
  public void validate_priceBlank_invalid() {
    OrderItem orderItem = new OrderItem();
    orderItem.setPrice(" ");
    PriceValidator validator = new PriceValidator();

    ErrorNotification errorNotification = validator.validate(orderItem);

    assertThat(errorNotification.getAllErrors()).isEqualTo(PriceValidator.PRICE_EMPTY_ERROR);
  }

  @Test
  public void validate_priceFormatNotValid_invalid() {
    OrderItem orderItem = new OrderItem();
    String price = "dummy price";
    orderItem.setPrice(price);
    PriceValidator validator = new PriceValidator();

    ErrorNotification errorNotification = validator.validate(orderItem);

    assertThat(errorNotification.getAllErrors()).isEqualTo(
        String.format(PriceValidator.PRICE_INVALID_ERROR_FORMAT, price));
  }

  @Test
  public void validate_priceValid_validated() {
    OrderItem orderItem = new OrderItem();
    orderItem.setPrice("100");
    PriceValidator validator = new PriceValidator();

    ErrorNotification errorNotification = validator.validate(orderItem);

    assertThat(errorNotification.getAllErrors()).isEmpty();
  }
}
