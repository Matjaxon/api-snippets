// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.rest.video.v1.CompositionHook;
import com.twilio.rest.video.v1.CompositionHook.Format;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AudioMixingHook{

  // Find your credentials at twilio.com/console
  public static final String ACCOUNT_SID = "ACXXXX";
  public static final String API_KEY_SID = "SKXXXX";
  public static final String API_KEY_SECRET = "your_api_key_secret";

  public static void main( String[] args ) throws IOException{
      // Initialize the client
      Twilio.init(API_KEY_SID, API_KEY_SECRET, ACCOUNT_SID);

      final String videoLayout =
                       "{"
                     + "   \"grid\": {"
                     + "       \"video_sources\":[\"*\"]"
                     + "    }"
                     + "}";

      CompositionHook compositionHook = CompositionHook.creator()
        					.setFriendlyName("MixingAllRoomAudiosHook")
        					.setAudioSources("*")
                  .setVideoLayout(new ObjectMapper().readValue(videoLayout, HashMap.class))
        					.setStatusCallback("http://my.server.org/callbacks")
        					.setFormat(Format.MP4)
        					.create();

      System.out.println("Created Composition Hook with SID=" + compositionHook.getSid());
  }
}
