from flask import Flask, request, jsonify
from flask_restful import Resource, Api
import requests
from sentence_transformers import SentenceTransformer
from sklearn.metrics.pairwise import cosine_similarity
import json
import logging
from datetime import datetime, time
import operator
from flask_cors import CORS, cross_origin
import flask_cors

app = Flask(__name__)
CORS(app, resources={r"*": {"origins": ["http://localhost:3000", "http://127.0.0.1:3000", "https://f6ad-103-6-159-161.ngrok-free.app"]}})
cors = CORS(app)
#flask_cors.cross_origin( 
# origins = '*',  
# methods = ['GET', 'HEAD', 'POST', 'OPTIONS', 'PUT'],  
# headers = None,  
# supports_credentials = False,  
# max_age = None,  
# send_wildcard = True,  
# always_send = True,  
# automatic_options = False
# )
#app.config['CORS_HEADERS'] = 'Content-Type'

import nltk
from nltk.sentiment.vader import SentimentIntensityAnalyzer

def analyze_sentiment(review_text):
    analyzer = SentimentIntensityAnalyzer()
    sentiment_scores = analyzer.polarity_scores(review_text)
    return sentiment_scores

def is_time_between(start_time, end_time, check_time=None):
    check_time = check_time or datetime.utcnow().time()
    if start_time < end_time:
        return start_time <= check_time <= end_time
    else:
        return start_time <= check_time or check_time <= end_time

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

@app.route('/matching-client',methods=['GET'])
@cross_origin()
def matchingProject():
    fid = request.args.get('fid')
    app.logger.info('****************fid',fid)
    app.logger.info('****************url',('https://6358-121-242-242-226.ngrok-free.app/freelance/'+fid))
    payload = requests.get('https://6358-121-242-242-226.ngrok-free.app/freelance/'+fid)
    payload = payload.json()
    app.logger.info('****************payload',payload)
    langNego = not(payload['languageMatch'])  
    #langNego = True               
    lang = json.loads(payload['language'])
    
    r = requests.get('https://6358-121-242-242-226.ngrok-free.app/project')
    dev_domains = json.loads(payload['domain'])
    preferredWorkTimeFrom = payload['preferredWorkTimeFrom']
    preferredWorkTimeTo = payload['preferredWorkTimeTo']
    expSalaryPerHour = payload['expSalaryPerHour']
    technology = json.loads(payload['technology'])
    technology = [x.lower() for x in technology]
    data = r.json()
    project_score = {}
    for i in data:
        app.logger.info('*********i',i)
        domain = i['domain']
        if domain in dev_domains:
            timeNego = i['negotiateTime']
            proj_comfortTimeFrom = i['comfortTimeFrom']
            proj_comfortTimeTo = i['comfortTimeTo']
            start = time(int(proj_comfortTimeFrom[0:2]),int(proj_comfortTimeFrom[3:5]))
            end = time(int(proj_comfortTimeTo[0:2]),int(proj_comfortTimeTo[3:5]))
            comf_from = time(int(preferredWorkTimeFrom[0:2]),int(preferredWorkTimeFrom[3:5]))
            comf_to = time(int(preferredWorkTimeTo[0:2]),int(preferredWorkTimeTo[3:5]))
            if timeNego or (not timeNego and ((is_time_between(start, end, comf_from)) and (is_time_between(start, end, comf_to)))):
                client_details = requests.get('https://6358-121-242-242-226.ngrok-free.app/client/'+i['clientEmail'])
                client_details = client_details.json()
                proj_lang = json.loads(client_details['language'])
                client_lang_nego = not(client_details['languageMatch'])
                client_lang_nego = True
                if (client_lang_nego and langNego) or (any(e in lang for e in proj_lang)):
                    proj_budget_nego = i['negotiateBudget']
                    proj_budget = i['budget']
                    proj_noOfHours = i['noOfHours']
                    if proj_budget_nego or (proj_budget >= expSalaryPerHour*proj_noOfHours):
                        project_tech = json.loads(payload['technology'])
                        project_tech = [x.lower() for x in project_tech]#        
                        tech_match_count = 0
                        for x in technology:
                            if x in project_tech:
                                tech_match_count+=1
                        if (len(technology) > 0) and (tech_match_count>0 or len(project_tech)==0):
                            id = i['id']
                            project_score[id] = proj_budget/1000
    return jsonify(project_score)

@app.route('/matching-freelancers',methods=['GET'])
@cross_origin()
def matchingFreelancers():
    try:
        pid = request.args.get('pid')
        payload = requests.get('https://6358-121-242-242-226.ngrok-free.app/project/'+pid)
        app.logger.info('****************payload',payload)
        payload = payload.json()
        app.logger.info(payload)
        #project_desc = "Develop a predictive maintenance system using machine learning to forecast equipment failures before they occur. Utilize historical sensor data from machinery to train models that can identify patterns indicative of potential breakdowns, enabling proactive maintenance and reducing downtime."
        project_desc = payload['description']
        project_tech = json.loads(payload['technology'])
        project_tech = [x.lower() for x in project_tech]#
        client_email = payload['clientEmail']
        project_domain = payload['domain']
        proj_comfortTimeFrom = payload['comfortTimeFrom']
        proj_comfortTimeTo = payload['comfortTimeTo']
        proj_noOfHours = payload['noOfHours']
        query_embedding = text_sim_model.encode(project_desc, convert_to_tensor=True)
        query_embedding = query_embedding.reshape(1, -1)
        proj_budget_nego = payload['negotiateBudget']
        proj_budget = payload['budget']
        proj_noOfHours = payload['noOfHours']
        r = requests.get('https://6358-121-242-242-226.ngrok-free.app/freelance')
        data =  r.json()
        freelancer_score = {}
        #app.logger.info(data)
        app.logger.info('****************Entered here0')
        for i in data:
            app.logger.info('****************Entered here0.5')
            #domain = i['domain'].split(',')
            domain = json.loads(i['domain'])
            app.logger.info(domain)
            app.logger.info(project_domain)
            if project_domain in domain:
                app.logger.info("entered if 1")
                timeNego = i['negotiableTime']
                start = time(int(proj_comfortTimeFrom[0:2]),int(proj_comfortTimeFrom[3:5]))
                end = time(int(proj_comfortTimeTo[0:2]),int(proj_comfortTimeTo[3:5]))
                preferredWorkTimeFrom = i['preferredWorkTimeFrom']
                preferredWorkTimeTo = i['preferredWorkTimeTo']
                langNego = not(i['languageMatch'])                
                #lang = i['language'].split(',')
                lang = json.loads(i['language'])
                comf_from = time(int(preferredWorkTimeFrom[0:2]),int(preferredWorkTimeFrom[3:5]))
                comf_to = time(int(preferredWorkTimeTo[0:2]),int(preferredWorkTimeTo[3:5]))
                
                if timeNego or (not timeNego and ((is_time_between(start, end, comf_from)) and (is_time_between(start, end, comf_to)))):
                    client_details = requests.get('https://6358-121-242-242-226.ngrok-free.app/client/'+client_email)
                    client_details = client_details.json()
                    app.logger.info('********client_details',client_details)
                    client_lang_nego = not(client_details['languageMatch'])
                    #proj_lang = client_details['language'].split(',')
                    proj_lang = json.loads(client_details['language'])
                    app.logger.info('****************Entered here1')
                    if (client_lang_nego and langNego) or (any(e in lang for e in proj_lang)):
                        app.logger.info('****************Entered here2')
                        expSalaryPerHour = i['expSalaryPerHour']
                        if proj_budget_nego or (proj_budget >= expSalaryPerHour*proj_noOfHours):
                            app.logger.info('****************Entered here3')
                            #technology = i['technology'].split(',')
                            technology = json.loads(i['technology'])
                            technology = [x.lower() for x in technology]
                            tech_match_count = 0
                            for x in technology:
                                if x in project_tech:
                                    tech_match_count+=1
                            app.logger.info('tech_match_count',tech_match_count)
                            if (len(technology) > 0) and (tech_match_count>0 or len(project_tech)==0):
                                app.logger.info('****************Entered here4')
                                email = i['emailId']
                                experience = i['experience']/10
                                #projects = i['projects'].split(',') 
                                projects = json.loads(i['projects'])          
                                sentence_embeddings = text_sim_model.encode(projects, convert_to_tensor=True)
                                similarities = cosine_similarity(query_embedding, sentence_embeddings)
                                tot_sum = 0
                                for i in range(len(projects)):
                                    tot_sum += similarities[0][i]
                                avg_score = tot_sum/len(projects)
                                feedback_data = requests.get('https://6358-121-242-242-226.ngrok-free.app/completed-project/rating-and-review/freelancer/'+email)
                                feedback_data = feedback_data.json()
                                rating_sum = 0
                                review_score_sum = 0
                                for i in feedback_data:
                                    rating_sum + i['rating']
                                    review_score_sum += analyze_sentiment(i['freelancerfeedback'])
                                if rating_sum > 0:
                                    rating_avg = rating_sum / len(feedback_data)
                                    review_score_avg = review_score_sum / len(feedback_data)
                                else:
                                    rating_avg = 0
                                    review_score_avg = 0
                                freelancer_score[email] = avg_score + experience + (tech_match_count/10) + rating_avg/10 + review_score_avg
        sorted_dict = dict(sorted(freelancer_score.items(), key=operator.itemgetter(1)))
        return jsonify(sorted_dict)
    except Exception as e:
        error_message = str(e)
        app.logger.error('An error occurred: %s', e, exc_info=True)
        return jsonify({'error': error_message}), 500

if __name__ == "__main__":
    app.run(debug=True)