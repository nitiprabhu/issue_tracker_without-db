/*
 * Copyright (c) 2019.
 * This  code file/snippet/block, including any other configuration files,
 * is for the sole use of the Evive Health, LLC and may contain business
 * confidential and privileged information.
 * Any unauthorized review, use, disclosure or distribution is prohibited.
 */

package com.radius.issue_tracker.config;

import com.google.common.base.Splitter;
import com.radius.issue_tracker.model.Issue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nitish on 2019-02-06.
 */

public class IssuesConfigUtil {
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
  private static final Splitter PIPE_SPLITTER = Splitter.on("|");
  private static final String ISSUE_TABLE_TXT = "issue_table.txt";
  private static final String OPENED = "OPENED";
  private static final String CLOSED = "CLOSED";
  private static List<Issue> issueList;

  static {

    List<Issue> list = new ArrayList<>();

    Issue issue1 = Issue.builder()
        .issueId("12341")
        .issueDateTime(LocalDateTime.of(2019, 2, 7, 18, 1))
        .description("Ticket issue description 1")
        .status(OPENED)
        .build();

    Issue issue2 = Issue.builder()
        .issueId("12342")
        .issueDateTime(LocalDateTime.of(2019, 2, 7, 18, 1))
        .description("Ticket issue description 2")
        .status(CLOSED)
        .build();

    Issue issue3 = Issue.builder()
        .issueId("12343")
        .issueDateTime(LocalDateTime.of(2019, 2, 6, 18, 1))
        .description("Ticket issue description 3")
        .status(OPENED)
        .build();

    Issue issue4 = Issue.builder()
        .issueId("12344")
        .issueDateTime(LocalDateTime.of(2019, 2, 5, 18, 1))
        .description("Ticket issue description 4")
        .status(OPENED)
        .build();

    Issue issue5 = Issue.builder()
        .issueId("12345")
        .issueDateTime(LocalDateTime.of(2019, 2, 1, 18, 1))
        .description("Ticket issue description 5")
        .status(OPENED)
        .build();

    Issue issue6 = Issue.builder()
        .issueId("12346")
        .issueDateTime(LocalDateTime.of(2019, 1, 5, 18, 1))
        .description("Ticket issue description 5")
        .status(OPENED)
        .build();

    list.add(issue1);
    list.add(issue2);
    list.add(issue3);
    list.add(issue4);
    list.add(issue5);
    list.add(issue6);

    issueList = list;
  }


  public static List<Issue> getIssueList() {
    return issueList;
  }


}
