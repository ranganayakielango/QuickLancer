from flask import Flask, request, jsonify
from flask_restful import Resource, Api

import requests
from sentence_transformers import SentenceTransformer
from sklearn.metrics.pairwise import cosine_similarity
import json

import logging

app = Flask(__name__)
logging.basicConfig(level=logging.DEBUG)

#text_sim_model = SentenceTransformer("DrishtiSharma/sentence-t5-large-quora-text-similarity")
text_sim_model = SentenceTransformer("paraphrase-MiniLM-L6-v2")

@app.route('/clients',methods=['GET'])
def get_clients():
    r = requests.get('https://6358-121-242-242-226.ngrok-free.app/client')
    return r.json()

@app.route('/freelance',methods=['GET'])
def get_freelance():
    r = requests.get('https://6358-121-242-242-226.ngrok-free.app/freelance')
    r = r.json()
    for i in r:
        i['photo'] = ''
    return r

@app.route('/matching-freelancers',methods=['POST'])
def matchingFreelancers():
    try:
        payload = request.json
        #project_desc = "Develop a predictive maintenance system using machine learning to forecast equipment failures before they occur. Utilize historical sensor data from machinery to train models that can identify patterns indicative of potential breakdowns, enabling proactive maintenance and reducing downtime."
        project_desc = payload['description']
        project_tech = payload['technology']
        project_domain = payload['domain']
        query_embedding = text_sim_model.encode(project_desc, convert_to_tensor=True)
        query_embedding = query_embedding.reshape(1, -1)
        r = requests.get('https://6358-121-242-242-226.ngrok-free.app/freelance')
        data =  r.json()
        freelancer_score = {}
        for i in data:
            domain = i['domain'].split(',')
            if project_domain in domain:
                email = i['emailId']
                experience = i['experience']/10
                projects = i['projects'].split(',')            
                sentence_embeddings = text_sim_model.encode(projects, convert_to_tensor=True)
                similarities = cosine_similarity(query_embedding, sentence_embeddings)
                tot_sum = 0
                for i in range(len(projects)):
                    tot_sum += similarities[0][i]
                avg_score = tot_sum/len(projects)
                freelancer_score[email] = avg_score + experience
        return jsonify(freelancer_score)
    except Exception as e:
        error_message = str(e)
        return jsonify({'error': error_message}), 500

if __name__ == "__main__":
    app.run(debug=True)