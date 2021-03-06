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

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MD Sayem Ahmed
 */
public class ErrorNotification {
  private List<String> errors = new ArrayList<>();

  public void addAll(ErrorNotification errorNotification) {
    this.errors.addAll(errorNotification.errors);
  }

  public boolean hasError() {
    return !errors.isEmpty();
  }

  public String getAllErrors() {
    return errors.stream()
        .collect(joining(", "));
  }

  void addError(String message) {
    this.errors.add(message);
  }
}
