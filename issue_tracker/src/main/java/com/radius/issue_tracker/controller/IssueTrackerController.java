package com.radius.issue_tracker.controller;

import com.radius.issue_tracker.config.IssuesConfigUtil;
import com.radius.issue_tracker.model.Issue;
import com.radius.issue_tracker.service.IssueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nitish on 2019-02-06.
 */
@Api(description = "Controller for Tracking Issues")
@RestController
public class IssueTrackerController {
  private final IssueService issueService;

  @Autowired
  public IssueTrackerController(IssueService issueService) {
    this.issueService = issueService;
  }

  @ApiOperation(value = "fetch all opened issues",
                response = IssuesConfigUtil.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200,
                   message = "retrieved all opened issues",
                   response = IssuesConfigUtil.class),
  })
  @GetMapping("/get-all-open-tickets")
  public List<Issue> getAllOpenTickets() {
    return issueService.getAllOpenTickets();
  }


  @ApiOperation(value = "fetch all opened issues before N days",
                response = IssuesConfigUtil.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200,
                   message = "list out all opened issues from last N days",
                   response = IssuesConfigUtil.class),
  })
  @GetMapping("/get-last-open-tickets/{numberOfDays}")
  public List<Issue> getLastNOpenedTickets(@PathVariable int numberOfDays) {
    return issueService.getOpenedTicketsFromLastNDays(numberOfDays);
  }

  @ApiOperation(value = "fetch all opened issues opened from n1 to n2 days",
                response = IssuesConfigUtil.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200,
                   message = "list out all opened issues from n1 to n2 days",
                   response = IssuesConfigUtil.class),
  })
  @GetMapping("/get-last-open-between-dates/{startDay}/{endDay}")
  public List<Issue> getLastBetweenOpenedTickets(@PathVariable int startDay,
                                                 @PathVariable int endDay) {
    return issueService.getOpenedTicketsBetweenDays(startDay, endDay);

  }

  @ApiOperation(value = "fetch all opened issues opened after N days",
                response = IssuesConfigUtil.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200,
                   message = "list out all opened issues from n1 to n2 days",
                   response = IssuesConfigUtil.class),
  })
  @GetMapping("/get-opened-after-n-days/{numberOfDays}")
  public List<Issue> getLastBetweenOpenedTickets(@PathVariable int numberOfDays) {
    return issueService.getOpenedTicketsAfterNDays(numberOfDays);

  }
}
