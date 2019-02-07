package com.radius.issue_tracker.service;

import com.radius.issue_tracker.config.IssuesConfigUtil;
import com.radius.issue_tracker.model.Issue;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 * @author nitish on 2019-02-06.
 */
@Service
public class IssueService {
  private static final String OPEN_STATUS = "OPENED"; //ideally, we should use Enums
  private static final int HOURS = 24;
  private static final int SECOND_ONE = 1;


  public List<Issue> getAllOpenTickets() {
    return getAllOpenTicketsStream().collect(Collectors.toList());
  }

  /**
   * Method to get stream of open tickets.
   *
   * @return list of tickets with OPEN status
   */
  private Stream<Issue> getAllOpenTicketsStream() {
    return IssuesConfigUtil.getIssueList()
        .stream()
        .filter(issue -> OPEN_STATUS.equalsIgnoreCase(issue.getStatus()));
  }

  /**
   * Method to get a list of opened tickets from last N days
   *
   * @param numberOfDays number of previous days data
   * @return list of issues
   */
  public List<Issue> getOpenedTicketsFromLastNDays(int numberOfDays) {

    LocalDateTime pastNTime = LocalDateTime.now().minusHours(HOURS * numberOfDays);

    return getAllOpenTicketsStream()
        .filter(issueDate -> issueDate.getIssueDateTime().isAfter(pastNTime))
        .collect(Collectors.toList());
  }

  /**
   * Method to get a list of opened tickets from last N days
   *
   * @param numberOfDays number of previous days data
   * @return list of issues
   */
  public List<Issue> getOpenedTicketsAfterNDays(int numberOfDays) {

    LocalDateTime pastNTime = LocalDateTime.now().minusHours(HOURS * numberOfDays);

    return getAllOpenTicketsStream()
        .filter(issueDate -> issueDate.getIssueDateTime().isBefore(pastNTime.plusDays(SECOND_ONE)))
        .collect(Collectors.toList());
  }

  public List<Issue> getOpenedTicketsBetweenDays(int toDay, int fromDay) {

    LocalDateTime now = LocalDateTime.now();

    LocalDateTime fromPastDay = now.minusDays(fromDay);
    LocalDateTime toPastDay = now.minusDays(toDay);

    return getAllOpenTicketsStream()
        .filter(issueInstant -> issueInstant.getIssueDateTime()
            .isBefore(toPastDay.plusDays(SECOND_ONE))
            &&
            issueInstant.getIssueDateTime().isAfter(fromPastDay.minusDays(SECOND_ONE)))
        .collect(Collectors.toList());

  }


}
