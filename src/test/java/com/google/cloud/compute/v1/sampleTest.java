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

import java.io.IOException;

import com.google.cloud.compute.v1.InstanceClient.ListInstancesPagedResponse;

import org.junit.Test;

public class sampleTest {
  @Test
  public void myTest() throws IOException {
    InstanceSettings clientSettings = InstanceSettings.newBuilder().build();
    InstanceClient client = InstanceClient.create(clientSettings);
    String project = "sijunliu-dca-test";
    String zone = "us-west1-a";
    ProjectZoneName projectZone = ProjectZoneName.newBuilder().setProject(project).setZone(zone).build();
    ListInstancesPagedResponse pagedListResponse = client.listInstances(projectZone);
    System.out.println(pagedListResponse);
  }
}
