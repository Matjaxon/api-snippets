# Download the Python helper library from twilio.com/docs/python/install
import os
from twilio.rest import Client

# Your Account Sid and Auth Token from twilio.com/user/account
account_sid = "ACCOUNT_SID"
# To set up environmental variables, see http://twil.io/secure
auth_token = os.environ['TWILIO_AUTH_TOKEN']
client = Client(account_sid, auth_token)

# A list of alert objects with the properties described above
alerts = client.monitor.alerts.list()

for alert in alerts:
    print(alert.sid)
