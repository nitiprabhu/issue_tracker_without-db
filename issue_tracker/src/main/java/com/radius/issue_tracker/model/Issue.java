/*
 * Copyright (c) 2019.
 * This  code file/snippet/block, including any other configuration files,
 * is for the sole use of the Evive Health, LLC and may contain business
 * confidential and privileged information.
 * Any unauthorized review, use, disclosure or distribution is prohibited.
 */

package com.radius.issue_tracker.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nitish on 2019-02-07.
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Issue {
  private String issueId;
  private String description;
  private LocalDateTime issueDateTime;
  private String status;
}
