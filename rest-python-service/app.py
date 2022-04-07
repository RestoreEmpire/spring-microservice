from distutils.log import debug
from fastapi import FastAPI
import uvicorn

api = FastAPI()

@api.get('/')
async def root():
    return {'fastapi': 'app'}

if __name__ == "__main__":
    uvicorn.run(api, port=8085)