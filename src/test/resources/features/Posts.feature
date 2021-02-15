@Posts
Feature: Test Posts Rest API
  Users should be able to submit a Post and retrieve the Post also be able to comment on a Post.

  Scenario: User should be  able to create Post
    When user submit a post
    Then the server should create the post

  Scenario: User should be able to get the post by id
    When user request a post using id
    Then the result gets the post

  Scenario: User should be able to list all posts
    When user request all posts
    Then the result contains the newly created post in the system