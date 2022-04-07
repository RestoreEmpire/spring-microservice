import requests
import info
import auth

get = requests.get(url=info.SERVICE_URL)
# get = requests.get(url=info.SERVICE_URL, headers=auth.get_header())
print(get.text)
