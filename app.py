from flask import Flask, request, render_template
from flask_restful import Resource, Api
app = Flask(__name__)
import requests
from sentence_transformers import SentenceTransformer
from sklearn.metrics.pairwise import cosine_similarity

from sentence_transformers import SentenceTransformer
text_sim_model = SentenceTransformer("DrishtiSharma/sentence-t5-large-quora-text-similarity")
#text_sim_model = SentenceTransformer("paraphrase-MiniLM-L6-v2")

@app.route('/clients',methods=['GET'])
def get_clients():
    r = requests.get('https://6358-121-242-242-226.ngrok-free.app/client')
    return r.json()

@app.route('/matching-freelancers',methods=['POST'])
def matchingFreelancers():
    payload = request.json
    #query_sentence = "Develop a predictive maintenance system using machine learning to forecast equipment failures before they occur. Utilize historical sensor data from machinery to train models that can identify patterns indicative of potential breakdowns, enabling proactive maintenance and reducing downtime."
    query_sentence = payload.description
    sentences_to_compare = [
        "Develop a fraud detection system for financial transactions using machine learning algorithms. Analyze transactional data to detect patterns indicative of fraudulent activity, such as unusual spending patterns or unauthorized access, enabling timely intervention and prevention of financial losses.",
        "Build a web-based code editor that supports multiple programming languages and features like syntax highlighting, auto-completion, and version control integration. Allow users to collaborate in real-time and share code snippets with others.",
        "Develop a platform for organizing and managing events, such as conferences, workshops, and social gatherings. Provide features like event registration, ticketing, scheduling, and attendee engagement tools to streamline the planning process and enhance attendee experience.",
        "Create a recommendation system that suggests personalized products to users based on their preferences and past behavior. Use collaborative filtering or content-based approaches to analyze user interactions and product attributes, enhancing user engagement and sales."
    ]
    query_embedding = model.encode(query_sentence, convert_to_tensor=True)
    query_embedding = query_embedding.reshape(1, -1)
    sentence_embeddings = model.encode(sentences_to_compare, convert_to_tensor=True)
    similarities = cosine_similarity(query_embedding, sentence_embeddings)
    sorted_devs = {}
    for i, sentence in enumerate(sentences_to_compare):
        sorted_devs[sentence] = similarities[0][i]
    return sorted_devs
        #print(sentence': {similarities[0][i]}")

if __name__ == "__main__":
    app.run(debug=True)