/*
 * Copyright 2012-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.cli;

import com.facebook.buck.config.CellConfig;
import com.facebook.buck.log.LogConfigSetup;

import java.io.IOException;

public interface Command {

  /**
   * @return the appropriate exit code for the command
   */
  int run(CommandRunnerParams params) throws IOException, InterruptedException;

  /**
   * @return whether the command doesn't modify the state of the filesystem
   */
  boolean isReadOnly();

  /**
   * @return whether we should gather source control stats while executing the command.
   */
  boolean isSourceControlStatsGatheringEnabled();

  String getShortDescription();

  CellConfig getConfigOverrides();

  /**
   * @return how we want logging to be configured for the the command.
   */
  LogConfigSetup getLogConfig();
}
