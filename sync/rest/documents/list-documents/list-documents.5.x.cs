// Download the twilio-csharp library from twilio.com/docs/libraries/csharp
using System;
using Twilio;
using Twilio.Rest.Sync.V1.Service;

public class Example
{
    public static void Main(string[] args)
    {
        // Find your Account SID and Auth Token at twilio.com/console
        // To set up environmental variables, see http://twil.io/secure
        const string accountSid = Environment.GetEnvironmentVariable("TWILIO_ACCOUNT_SID");
        const string authToken = Environment.GetEnvironmentVariable("TWILIO_AUTH_TOKEN");
        const string serviceSid = Environment.GetEnvironmentVariable("TWILIO_SERVICE_SID");

        TwilioClient.Init(accountSid, authToken);

        var docs = DocumentResource.Read(serviceSid);

        foreach (var doc in docs)
        {
            Console.WriteLine(doc.UniqueName);
        }
    }
}
