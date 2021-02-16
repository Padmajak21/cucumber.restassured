Feature: Test the Comments
  I want to test comments
  
  Scenario: User can add a comment to a specific post
  	When user commented on a post
  	Then comment is added to the post
  
  Scenario: User wants to see post with all comments embedded
  	When user request post with embedded comments
  	Then post with embedded comments is shown   
