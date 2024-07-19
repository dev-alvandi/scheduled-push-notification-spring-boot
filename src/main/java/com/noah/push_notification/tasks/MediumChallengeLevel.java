package com.noah.push_notification.tasks;

import com.noah.push_notification.requests.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MediumChallengeLevel {
        @Value("${EASY_SECRET_KEY}")
        private String SECRET_KEY;

        @Value("${CLIENT_URL}")
        private String CLIENT_URL;

        private static final Logger log =
                LoggerFactory.getLogger((com.noah.push_notification.tasks.MediumChallengeLevel.class));

        @Scheduled(cron = "0 0 7 * * *")
        public void atSeven() {
            httpPostRequestToClientEndPoint();
        }

        @Scheduled(cron = "0 0 12 * * *")
        public void atTwelve() {
            httpPostRequestToClientEndPoint();
        }

        @Scheduled(cron = "0 0 17 * * *")
        public void atSeventeen() {
            httpPostRequestToClientEndPoint();
        }

        @Scheduled(cron = "0 0 20 * * *")
        public void atTwenty() {
            httpPostRequestToClientEndPoint();
        }

        private void httpPostRequestToClientEndPoint() {
            HashMap<String, String> requestBody = new HashMap<>();
            requestBody.put("challengeId", "MEDIUM");
            requestBody.put("secret", SECRET_KEY);

            Post newPostRequest = new Post(requestBody, CLIENT_URL);
            try {
                newPostRequest.postRequest();
            } catch (Exception e) {
                System.out.println(e);
            }
        }


}
