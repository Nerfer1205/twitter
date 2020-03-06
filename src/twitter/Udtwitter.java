package twitter;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Udtwitter {
	public static void main(String[] args) {
		String moreLikesTweet = null;
		String moreLikesUser = null;
		int likes = 0;

		// Inicialización
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("GVARYRM4rJcBgXx54u7Y11lCO")
				.setOAuthConsumerSecret("n2KT1pgMIWlPCmhl0maKRCo6EQL6G6l2rxKoh611NAFhbzVhMW")
				.setOAuthAccessToken("987880050-VnX6WOQ47amX8JZjsWCbse8nF0EaCM3ODE9E3I9k")
				.setOAuthAccessTokenSecret("TaCDCvegqmL454aRKXL6xwvSGvy8Gi4xtqz3C5DHXR8Li");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		List<Status> statuses;
		try {
			statuses = twitter.getUserTimeline("udistrital", new Paging(1, 40));
			System.out.println("Showing home timeline.");
			for (Status status : statuses) {

				if (status.getRetweetCount() > likes) {
					moreLikesTweet = status.getText();
					moreLikesUser = status.getUser().getName();
					likes = status.getFavoriteCount();
				}
			}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("User: " + moreLikesUser + "\n" + "Tweet: " + moreLikesTweet + "\n" + "Likes: " + likes);
	}

}
