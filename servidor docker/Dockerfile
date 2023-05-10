FROM python:3.10

ENV PYTHONUNBUFFERED 1

EXPOSE 9123
WORKDIR /app

COPY . /app

RUN pip install -r requirements.txt

CMD  uvicorn --host=0.0.0.0 app.main:app --port 9123