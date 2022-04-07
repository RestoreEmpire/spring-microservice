import info
import requests

def get_token():
    post = requests.post(url=info.LOGIN_URL, data=info.USER_JSON)
    print(post.text)
    token = post.json()['access_token']
    return token

def get_header():
    return {'Authorization' : f'Bearer {get_token()}'}