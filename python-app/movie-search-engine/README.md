# Movie Search Engine

This is a demo of a movie search engine.

## Project Architecture
This project is built on three primary components:

- Weaviate Database: You have the option to host on Weaviate Cloud Service (WCS) or run it locally.
- Frontend: HTML,CSS,Js
- Backend: NodeJs

## Prerequisites
* Docker
* Python
* Set the environment variables for your $OPENAI_API_KEY, $WEAVIATE_API_KEY, and $WEAVIATE_URL. If you are running Weaviate via Docker, the WEAVIATE_URL is "http://localhost:8080" and no WEAVIATE_API_KEY is needed.

## Setup instructions

Follow the following steps to reproduce the example
1. Setup a virtual environment
```bash
python -m venv .venv             
source .venv/bin/activate
``` 

2. Set your OPENAI_API_KEY in the docker-compose.yml file and  run the following command to run the weaviate docker file
```bash
docker compose up -d
``` 

3. Run the following command in directory to install all required dependencies
```bash
pip install -r requirements.txt
``` 

4. Run the following command to add all the data objects,you can change path of dataset at line 115 if necessary. You can also decrease the number of data objects at line 119 so that it takes less time.
```bash
python add_data.py
``` 
5. After adding data run the following command to install all required node modules.
```bash
npm install
``` 
6. After adding data and installing modules run the following command and navigate to http://localhost:3000/ to perform searching
```bash
npm run start
```

## Dataset

* [48,000+ movies dataset](https://www.kaggle.com/datasets/yashgupta24/48000-movies-dataset) (License: CC0: Public Domain) for the columns: 'Id', 'Name', 'PosterLink', 'Genres', 'Actors', 'Director', 'Description', 'DatePublished', and 'Keywords'
* [Wikipedia Movie Plots](https://www.kaggle.com/datasets/jrobischon/wikipedia-movie-plots) (License: CC BY-SA 4.0), for the column 'Plot'