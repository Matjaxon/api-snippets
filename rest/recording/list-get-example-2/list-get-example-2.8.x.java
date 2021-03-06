// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Recording;

import java.time.ZonedDateTime;

public class Example {
  /// Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    ResourceSet<Recording> recordings = Recording.reader()
        .setDateCreated(ZonedDateTime.of(2016, 10, 18, 0, 0, 0, 0, ZoneId.of("UTC")))
        .read();

    // Loop over recordings and print out a property for each one.
    for (Recording recording : recordings) {
      System.out.println(recording.getDuration());
    }
  }
}
