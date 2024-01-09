Feature: WebdriverUniversity.com

  @regression
  Scenario Outline: WebDriver | IFrame tab validation
    Given user navigates to the application
    And verifies the main page title: "<mainPage_Title>"
    When user clicks on "IFRAME" link
    Then new tab with page title: "<newTab_pageTitle>" is opened
    And user verifies the navigation through images

    Examples: 
      | mainPage_Title          | newTab_pageTitle   |
      | WebDriverUniversity.com | WebDriver * IFrame |