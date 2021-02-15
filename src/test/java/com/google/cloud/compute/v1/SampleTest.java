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

import static com.google.cloud.compute.v1.InstanceClient.ListInstancesPagedResponse;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;

public class SampleTest {
  public InstanceSettings createADCSettings() throws IOException {
    return InstanceSettings.newBuilder().build();
  }

  public InstanceSettings createCustomScopeSettings() throws IOException {
    List<String> scopes = new ArrayList<String>();
    scopes.add("https://www.googleapis.com/auth/compute");
    ImmutableList<String> DEFAULT_SERVICE_SCOPES =
        ImmutableList.<String>builder()
            .add("https://www.googleapis.com/auth/cloud-platform")
            .add("https://www.googleapis.com/auth/compute")
            .add("https://www.googleapis.com/auth/compute.readonly")
            .add("https://www.googleapis.com/auth/devstorage.full_control")
            .add("https://www.googleapis.com/auth/devstorage.read_only")
            .add("https://www.googleapis.com/auth/devstorage.read_write")
            .build();
    CredentialsProvider provider = GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES).build();
    return InstanceSettings.newBuilder().setCredentialsProvider(provider).build();
  }

  @Test
  public void myTest() throws IOException {
    // InstanceSettings clientSettings = createADCSettings();
    InstanceSettings clientSettings = createCustomScopeSettings();

    InstanceClient client = InstanceClient.create(clientSettings);
    String project = "dcatest-281318";
    String zone = "us-west1-a";
    ProjectZoneName projectZone = ProjectZoneName.newBuilder().setProject(project).setZone(zone).build();
    ListInstancesPagedResponse pagedListResponse = client.listInstances(projectZone);
    System.out.println(pagedListResponse);
  }
}