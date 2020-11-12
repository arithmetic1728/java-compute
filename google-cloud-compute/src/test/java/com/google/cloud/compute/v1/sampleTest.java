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
import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.UserCredentials;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class sampleTest {
  static class MyCreds implements CredentialsProvider {

    @Override
    public Credentials getCredentials() throws IOException {
      File file = new File("/usr/local/google/home/sijunliu/wks/creds/shin_user_cred.json");
      InputStream stream = new FileInputStream(file);
      UserCredentials creds = UserCredentials.fromStream(stream);
      return creds;
    }
  }

  @Test
  public void myTest() throws IOException {
    MyCreds provider = new MyCreds();
    InstancesSettings clientSettings = InstancesSettings.newBuilder().setCredentialsProvider(provider).build();
    InstancesClient client = InstancesClient.create(clientSettings);
    String project = "shinfan-mtls-demo";
    String zone = "us-west1-a";
    ListPagedResponse pagedListResponse = client.list(project, zone);
    System.out.println(pagedListResponse);
  }
}
