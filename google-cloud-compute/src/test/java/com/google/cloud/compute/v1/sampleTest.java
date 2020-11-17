/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.InstancesClient.ListPagedResponse;
import java.io.IOException;
import org.junit.Test;

public class sampleTest {
  @Test
  public void myTest() throws IOException {
    InstancesSettings clientSettings = InstancesSettings.newBuilder().build();
    InstancesClient client = InstancesClient.create(clientSettings);
    String project = "shinfan-mtls-demo";
    String zone = "us-west1-a";
    ListPagedResponse pagedListResponse = client.list(project, zone);
    System.out.println(pagedListResponse);
  }
}
