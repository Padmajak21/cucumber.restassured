package utils;

import com.github.javafaker.Faker;

import pojo.Post;

public class TestUtils {

	public static Post createADummyPost() {
		Post post = new Post();
		Faker faker = new Faker();
		post.setAuthor(faker.name().username());
		post.setTitle(faker.book().title());
		post.setDescription(faker.lorem().sentence(40));
		return post;
	}
}
