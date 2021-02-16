package stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import com.rits.cloning.Cloner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Post;
import utils.ContextHolder;
import utils.TestUtils;

public class PostsSteps {

	Response response;
	
	@When("user submit a post")
	public void users_submit_a_post() {
		Post newPost = TestUtils.createADummyPost(); 
		 response = RestAssured.given()
				 .contentType(ContentType.JSON) 
				 .body(newPost)
		 .post("/posts");
	}

	@Then("the server should create the post")
	public void the_server_should_create_the_post() {
		response
		.then()
		.assertThat().statusCode(201);
		
		Post createdPost = response.as(Post.class);
		
		Cloner cloner=new Cloner();
		Post clonedPost=cloner.deepClone(createdPost);
		ContextHolder.createdPost = clonedPost;
	}

	@When("user request a post using id")
	public void user_request_a_post_using_id() {
	  //Get the Post by id
		response = RestAssured.given().contentType(ContentType.JSON)
				.get("/posts/"+ContextHolder.createdPost.getId());
	}

	@Then("the result gets the post")
	public void the_result_gets_the_post() {
		Post resultPost = response.as(Post.class);
		//now compare if the resultPost title and description are matching 
		 assertThat(ContextHolder.createdPost).usingRecursiveComparison().isEqualTo(resultPost);
	}

	@When("user request all posts")
	public void user_request_all_posts() {
		response = RestAssured.given().contentType(ContentType.JSON)
		.get("/posts");
	}

	@Then("the result contains all posts including the newly created post")
	public void the_result_contains_all_the_posts_in_the_system() {
		var posts = response.body().jsonPath().getList("", Post.class);
		assertThat(posts.get(posts.size()-1)).usingRecursiveComparison().isEqualTo(ContextHolder.createdPost);
	}

}
